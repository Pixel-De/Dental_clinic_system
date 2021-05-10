package DentalClinic.Doctor;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.sql.Date;

public class Doctor {
    String name,speciality,qualification,address;
    Integer id,contact;
    Date date;
    Button delete, edit;

    public Doctor(String name, String speciality, String qualification, String address, Integer id, Integer contact, Date date) {
        this.name = name;
        this.speciality = speciality;
        this.qualification = qualification;
        this.address = address;
        this.id = id;
        this.contact = contact;
        this.date = date;

        this.delete = new Button();
        ImageView imgView = new ImageView(getClass().getResource("../assets/delete.png").toExternalForm());
        imgView.setFitHeight(10);
        imgView.setPreserveRatio(true);
        this.delete.setPrefSize(10,10);
        this.delete.setGraphic(imgView);

        this.edit = new Button();
        ImageView imgView2 = new ImageView(getClass().getResource("../assets/draw.png").toExternalForm());
        imgView2.setFitHeight(10);
        imgView2.setPreserveRatio(true);
        this.edit.setPrefSize(10,10);
        this.edit.setGraphic(imgView2);
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
