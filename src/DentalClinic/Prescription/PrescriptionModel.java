package DentalClinic.Prescription;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class PrescriptionModel {
    private int  quantity;
    private String name, dodge, duration, remark;
    private Button delete;

    public PrescriptionModel( int quantity, String name, String dodge, String duration, String remark) {

        this.quantity = quantity;
        this.name = name;
        this.dodge = dodge;
        this.duration = duration;
        this.remark = remark;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDodge() {
        return dodge;
    }

    public void setDodge(String dodge) {
        this.dodge = dodge;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
