package DentalClinic.Pharmacy.Sale;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class SaleModel {

    private Integer id, quantity;
    private String name;
    private Float total, unit;
    private Button delete;

    public SaleModel(Integer id, Integer quantity, String name, Float unit, Float total) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.unit = unit;
        this.total = total;

        this.delete = new Button();
        ImageView imgView = new ImageView(getClass().getResource("../../assets/delete.png").toExternalForm());
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getUnit() {
        return unit;
    }

    public void setUnit(Float unit) {
        this.unit = unit;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
