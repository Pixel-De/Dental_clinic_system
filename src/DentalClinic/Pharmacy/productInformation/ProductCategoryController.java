package DentalClinic.Pharmacy.productInformation;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.w3c.dom.Text;

public class ProductCategoryController {

    @FXML
    TableView<Category> categoryTable;
    @FXML
    TextField categoryName;

    String arr[] = {"cat1", "cate2", "cat3"};
    ObservableList<Category> catList = FXCollections.observableArrayList();
    @FXML
    public void initialize(){
        for(int i=0; i<arr.length; i++){
            Category c = new Category(arr[i]);
            catList.add(c);
        }
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
                System.out.println(c.getCategory());
            }
        });

//        del.setCellFactory(tableColumn -> {
//            TableCell<Category, Button> cell = new TableCell<Category, Button>(){
//                @Override
//                protected void updateItem(Button button, boolean b) {
//                    super.updateItem(button, b);
//                }
//            };
////            cell.setOnMouseClicked(e -> {
////                if (! cell.isEmpty()) {
////
////                }
////            };
//            return cell ;
//        });

        categoryTable.setItems(catList);
        categoryTable.getColumns().addAll(del, category);


    }
    public void addCategory(){
        String name = categoryName.getText();
        Category c = new Category(name);
        catList.add(c);
    }


}
