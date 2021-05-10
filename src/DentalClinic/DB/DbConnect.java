package DentalClinic.DB;
import DentalClinic.Doctor.Doctor;
import DentalClinic.Patient.Patient;
import DentalClinic.Pharmacy.productInformation.Category;
import DentalClinic.Pharmacy.productInformation.Product;
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

    private ObservableList<Product> GetAllProduct(){
        ObservableList<Product> a = FXCollections.observableArrayList(new ArrayList<Product>());
        try (Statement statement = this.db.createStatement()) {
            ResultSet result = statement.executeQuery("select * from product");
            while(result.next()){
                String id = result.getString("id");
                String name = result.getString("p_name");
                String gName = result.getString("g_name");
                String category = result.getString("category");
                Date manuDate = result.getDate("m_date");
                Date expireDate = result.getDate("e_date");
                String barcode = result.getString("barcode");
                String UOM = result.getString("UOM");
                String quantity = result.getString("quantity");
                String pPrice = result.getString("p_price");
                String sPrcie = result.getString("s_price");
                a.add(new Product(id,name,gName,category,manuDate,expireDate,barcode,UOM,quantity,pPrice,sPrcie));
            }
            return a;
        } catch (SQLException e){
            e.printStackTrace();
            return a;
        }
    }

    private ObservableList<Category> GetAllCategory(){
        ObservableList<Category> a = FXCollections.observableArrayList(new ArrayList<Category>());
        try (Statement statement = this.db.createStatement()) {
            ResultSet result = statement.executeQuery("select name from category");
            while(result.next()){
                String name = result.getString("name");
                a.add(new Category(name));
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
    public ObservableList<Product> ProductList(){
        return  this.GetAllProduct();
    }
    public ObservableList<Category> CategoryList(){
        return  this.GetAllCategory();
    }

    public Boolean AddPatient(Integer id, String name, String parent, String gender, Integer age, String occupation, String address, Integer contact, java.util.Date reference, java.util.Date date){
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("INSERT INTO `patient` (`id`, `name`, `parent`, `gender`, `age`, `occupation`, `address`, `contact`, `reference`, `date`) " +
                    "VALUES ('"+id+"', '"+name+"', '"+parent+"', '"+gender+"', '"+age+"', '"+occupation+"', '"+address+"', '"+contact+"', '"+reference+"', '"+date+"')");
            if(cnt == 1){
                return  true;
            } else {
                return  false;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}

