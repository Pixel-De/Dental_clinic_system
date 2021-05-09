package DentalClinic.Pharmacy.productInformation;

import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.time.LocalDate;
import java.util.Date;
import java.util.EventListener;

public class Product {
    private String id, name, gName, category,  barCode, UOM, quantity , pPrice, sPrice ;
    private Date manuDate, expireDate;
    private Button edit, delete ;

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public Product(String id, String name, String gName, String category, Date manuDate, Date expireDate, String barCode, String UOM, String quantity, String pPrice, String sPrice) {
        this.id = id;
        this.name = name;
        this.gName = gName;
        this.category = category;
        this.manuDate = manuDate;
        this.expireDate = expireDate;
        this.barCode = barCode;
        this.UOM = UOM;
        this.quantity = quantity;
        this.pPrice = pPrice;
        this.sPrice = sPrice;

        this.delete = new Button();
        ImageView imgView = new ImageView(getClass().getResource("../../assets/delete.png").toExternalForm());
        imgView.setFitHeight(10);
        imgView.setPreserveRatio(true);
        this.delete.setPrefSize(10,10);
        this.delete.setGraphic(imgView);

        this.edit = new Button();
        ImageView imgView2 = new ImageView(getClass().getResource("../../assets/draw.png").toExternalForm());
        imgView2.setFitHeight(10);
        imgView2.setPreserveRatio(true);
        this.edit.setPrefSize(10,10);
        this.edit.setGraphic(imgView2);

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

    public String getGName() {
        return gName;
    }

    public void setGName(String gName) {
        this.gName = gName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getUOM() {
        return UOM;
    }

    public void setUOM(String UOM) {
        this.UOM = UOM;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPPrice() {
        return pPrice;
    }

    public void setPPrice(String pPrice) {
        this.pPrice = pPrice;
    }

    public String getSPrice() {
        return sPrice;
    }

    public void setSPrice(String sPrice) {
        this.sPrice = sPrice;
    }

    public Date getManuDate() {
        return manuDate;
    }

    public void setManuDate(Date manuDate) {
        this.manuDate = manuDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
