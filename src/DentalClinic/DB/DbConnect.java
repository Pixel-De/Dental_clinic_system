package DentalClinic.DB;
import DentalClinic.Doctor.Doctor;
import DentalClinic.Patient.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.print.Doc;
import java.sql.*;
import java.util.ArrayList;

public class DbConnect {

    private Connection db;

    private Connection Connect(){

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com:3306/sql6411222","sql6411222","m6Z57Fl9LD");
            System.out.println("connection success");
            return connection;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    };

    private ObservableList<Patient> GetAllPatien(){
        ObservableList<Patient> a = FXCollections.observableArrayList(new ArrayList<Patient>());
        try (Statement statement = this.db.createStatement()) {
            ResultSet result = statement.executeQuery("select * from patient");
            while(result.next()){
                Integer id = result.getInt("id");
                String name = result.getString("name");
                String parent = result.getString("parent");
                String gender = result.getString("gender");
                Integer age =  result.getInt("age");
                String occupation = result.getString("occupation");
                String address = result.getString("address");
                Integer contact = result.getInt("contact");
                Date reference = result.getDate("reference");
                Date date = result.getDate("date");
                a.add(new Patient(name,parent,gender,occupation,address,id,age,contact,reference,date));
            }
            return a;
        } catch (SQLException e){
            e.printStackTrace();
            return a;
        }
    }

    private ObservableList<Doctor> GetAllDoctor(){
        ObservableList<Doctor> a = FXCollections.observableArrayList(new ArrayList<Doctor>());
        try (Statement statement = this.db.createStatement()) {
            ResultSet result = statement.executeQuery("select * from doctor");
            while(result.next()){
                Integer id = result.getInt("id");
                String name = result.getString("name");
                String speciality = result.getString("speciality");
                String address = result.getString("address");
                String qualification = result.getString("qualification");
                Integer contact = result.getInt("contact");
                Date date = result.getDate("date");
                a.add(new Doctor(name,speciality,qualification,address,id,contact,date));
            }
            return a;
        } catch (SQLException e){
            e.printStackTrace();
            return a;
        }
    }

    public DbConnect(){
        this.db = this.Connect();
    }

    public Connection getStatus(){
        return this.db;
    }

    public ObservableList<Patient> PatientList(){
        return  this.GetAllPatien();
    }
    public ObservableList<Doctor> DoctorList(){
        return  this.GetAllDoctor();
    }
}

