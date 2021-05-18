package DentalClinic.Pharmacy.productInformation;

import DentalClinic.DB.DbConnect;
import DentalClinic.Patient.InformationController;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.w3c.dom.Text;
import DentalClinic.Pharmacy.productInformation.Category;

import java.util.Optional;

public class ProductCategoryController {

    @FXML
    TableView<Category> categoryTable;
    @FXML
    TextField categoryName;
    @FXML
    Button closeButton;

    String arr[] = {"cat1", "cate2", "cat3"};
    ObservableList<Category> catList = FXCollections.observableArrayList();
    DbConnect db ;
    Alert alert;
    @FXML
    public void initialize(){
        db = new DbConnect();
        catList = db.CategoryList();

        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Category");
        alert.setContentText("Are you sure you want to delete this category?");

        catList.forEach(category -> {
            Button d = category.getDel();
            d.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    Optional<ButtonType> result = alert.showAndWait();
                    if(result.get()==ButtonType.OK){
                        boolean f = db.DeleteCategory(category.getCategory());
                        if(f){
                            catList.remove(category);

                        }
                    }

                }
            });
        });
        categoryTable.setEditable(true);

        TableColumn del = new TableColumn("");
        TableColumn category = new TableColumn("Category");

        del.setCellValueFactory(new PropertyValueFactory<Category, Button>("del"));
        category.setCellValueFactory(new PropertyValueFactory<Category, String>("category"));

        category.setCellFactory(TextFieldTableCell.forTableColumn());
        category.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>() {
            @Override
            public void handle(TableColumn.CellEditEvent cellEditEvent) {
                Category c = (Category) cellEditEvent.getTableView().getItems().get(cellEditEvent.getTablePosition().getRow());
                c.setCategory(cellEditEvent.getNewValue().toString());
//                System.out.println(cellEditEvent.getOldValue());
                int r = cellEditEvent.getTablePosition().getRow();
                System.out.println(catList.get(r).getCategory());
//                boolean f = db.UpdateCategory()
//                System.out.println(c.getCategory());
            }
        });

        categoryTable.setItems(catList);
        categoryTable.getColumns().addAll(del, category);
    }
    public void addCategory(){

        String name = categoryName.getText();
        Category c = new Category(name);
        boolean f = db.AddCategory(name);
        if(f){
            catList.add(c);
            Button btn = c.getDel();
            btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    Optional<ButtonType> result = alert.showAndWait();
                    if(result.get()==ButtonType.OK){
                        boolean f = db.DeleteCategory(c.getCategory());
                        if(f){
                            catList.remove(c);
                        }
                    }
                }
            });
        }
    }
    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void reset(){
        categoryName.setText("");
    }

}
