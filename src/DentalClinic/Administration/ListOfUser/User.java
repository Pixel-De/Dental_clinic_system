package DentalClinic.Administration.ListOfUser;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.sql.Date;

public class User {
    private String full_name,user_job,fieldOfArea,user_name;
    private Integer id, contact_no;
    private Date joining_date;
    private Button edit, delete , check;

    public User(String full_name, String user_job, String fieldOfArea, String user_name, Integer id, Integer contact_no, Date joining_date){
        this.full_name = full_name;
        this.user_job = user_job;
        this.fieldOfArea = fieldOfArea;
        this.user_name = user_name;
        this.id = id;
        this.contact_no = contact_no;
        this.joining_date = joining_date;
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

        this.check = new Button();
        ImageView imgView3 = new ImageView(getClass().getResource("../assets/check.png").toExternalForm());
        imgView3.setFitHeight(10);
        imgView3.setPreserveRatio(true);
        this.check.setPrefSize(10,10);
        this.check.setGraphic(imgView3);
    }

    public Button getEdit() {return edit; }

    public void setEdit(Button edit) {this.edit = edit; }

    public Button getDelete() {return delete; }

    public void setDelete(Button delete) { this.delete = delete; }

    public Button getCheck() { return check; }

    public void setCheck(Button check) { this.check = check; }

    public String getFull_name() { return full_name; }

    public void setFull_name(String full_name) { this.full_name = full_name; }

    public String getUser_job() { return user_job; }

    public void setUser_job(String user_job) { this.user_job = user_job; }

    public String getFieldOfArea() { return fieldOfArea; }

    public void setFieldOfArea(String fieldOfArea) { this.fieldOfArea = fieldOfArea; }

    public String getUser_name() { return user_name; }

    public void setUser_name(String user_name) { this.user_name = user_name; }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getContact_no() { return contact_no; }

    public void setContact_no(Integer contact_no) { this.contact_no = contact_no; }

    public Date getJoining_date() { return joining_date; }

    public void setJoining_date(Date joining_date) { this.joining_date = joining_date; }
}
