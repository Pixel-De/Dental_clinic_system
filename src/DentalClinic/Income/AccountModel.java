package DentalClinic.Income;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class AccountModel {
    String id,name,type,status;
    Button delete;

    public AccountModel(String id, String name, String type, String status) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;


        this.delete = new Button();
        ImageView imgView = new ImageView(getClass().getResource("../assets/delete.png").toExternalForm());
        imgView.setFitHeight(10);
        imgView.setPreserveRatio(true);
        this.delete.setPrefSize(10,10);
        this.delete.setGraphic(imgView);

    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
