package DentalClinic.Pharmacy.productInformation;

import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Category {
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Button getDel() {
        return del;
    }

    public void setDel(Button del) {
        this.del = del;
    }

    private Button del ;

    public Category(String category) {
        this.del = new Button();
        ImageView imgView = new ImageView(getClass().getResource("../../assets/delete.png").toExternalForm());
        imgView.setFitHeight(10);
        imgView.setPreserveRatio(true);
        this.del.setPrefSize(10,10);
        this.del.setGraphic(imgView);
        this.category = category;
    }
}
