package DentalClinic.Administration.ListOfUser;

import DentalClinic.DB.DbConnect;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.sql.Date;

public class User {
    private String fullname,usertype,designation,username;
    private Integer id, contact;
    private Date join_date;
    private Button edit, delete , check;
    private Checkbox select ;


    public User(String fullname, String usertype, String designation, String username, Integer id, Integer contact, Date join_date){
        this.fullname = fullname;
        this.usertype = usertype;
        this.designation = designation;
        this.username = username;
        this.id = id;
        this.contact = contact;
        this.join_date = join_date;
        this.delete = new Button();
        this.select = new Checkbox();

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

    public String getFullname() {return fullname; }

    public void setFullname(String fullname) { this.fullname = fullname; }

    public String getUsertype() { return usertype; }

    public void setUsertype(String usertype) { this.usertype = usertype; }

    public String getDesignation() { return designation; }

    public void setDesignation(String designation) { this.designation = designation; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public Integer getContact() { return contact; }

    public void setContact(Integer contact) { this.contact = contact; }

    public Date getJoin_date() { return join_date; }

    public void setJoin_date(Date join_date) { this.join_date = join_date; }



    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }


    public Checkbox getSelect() {return select; }

    public void setSelect(Checkbox select) { this.select = select; }
}
