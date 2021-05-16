package DentalClinic.Prescription;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.sql.Date;

public class PrescriptionFull {
    String id, patient_id, name, age, gender;
    Date date;
    Button edit , delete;

    public PrescriptionFull(String id, String patient_id, Date date, String age, String name, String gender) {
        this.id = id;
        this.patient_id = patient_id;
        this.date = date;
        this.name = name;
        this.age = age;
        this.gender = gender;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
