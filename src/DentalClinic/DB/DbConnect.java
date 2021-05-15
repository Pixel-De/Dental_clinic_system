package DentalClinic.DB;
import DentalClinic.Doctor.Doctor;
import DentalClinic.Patient.Patient;
import DentalClinic.Pharmacy.Sale.Invoice_item;
import DentalClinic.Pharmacy.productInformation.Category;
import DentalClinic.Pharmacy.productInformation.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class DbConnect {

    private final Connection db;

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
    }

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
            ResultSet result = statement.executeQuery("select id, name from category");
            while(result.next()){
                String name = result.getString("name");
                Integer id = result.getInt("id");
                a.add(new Category(name,id));
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

    public Boolean AddDoctor(Integer id, String name,String  speciality, String qualification, String address, Integer contact,  java.util.Date date){
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("INSERT INTO `doctor` (`id`, `name`, `speciality`, `qualification`, `address`, `contact`, `date`) " +
                                                                            "VALUES ('"+id+"', '"+name+"', '"+speciality+"', '"+qualification+"', '"+address+"', '"+contact+"', '"+date+"')");
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

    public Boolean AddProduct(Integer id, String p_name,String g_name,String  category,java.util.Date m_date,java.util.Date e_date, Integer barcode, String UOM, Integer quantity,Integer p_price,Integer s_price){
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("INSERT INTO `product` (`id`, `p_name`, `g_name`, `category`, `m_date`, `e_date`, `barcode`, `UOM`, `quantity`, `p_price`, `s_price`) " +
                    "VALUES ('"+id+"', '"+p_name+"', '"+g_name+"', '"+category+"', '"+m_date+"', '"+e_date+"', '"+barcode+"', '"+UOM+"', '"+quantity+"', '"+p_price+"', '"+s_price+"')");
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
    public Boolean AddCategory(String name){
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("INSERT INTO `category` (`id`, `name`) VALUES (NULL , '"+name+"')");
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

    public Boolean UpdatePatient(Integer id, String name, String parent, String gender, Integer age, String occupation, String address, Integer contact, java.util.Date reference, java.util.Date date){
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("UPDATE `patient` SET " +
                    "`name` = '"+name+"', " +
                    "`parent` = '"+parent+"', " +
                    "`gender` = '"+gender+"', " +
                    "`age` = '"+age+"', " +
                    "`occupation` = '"+occupation+"', " +
                    "`address` = '"+address+"', " +
                    "`contact` = '"+contact+"', " +
                    "`reference` = '"+reference+"', " +
                    "`date` = '"+date+"' " +
                    "WHERE `patient`.`id` = "+id);
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

    public Boolean UpdateDoctor(Integer id, String name,String  speciality, String qualification, String address, Integer contact,  java.util.Date date){
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("UPDATE `doctor` SET " +
                    "`name` = '"+name+"', " +
                    "`speciality` = '"+speciality+"', " +
                    "`qualification` = '"+qualification+"', " +
                    "`address` = '"+address+"', " +
                    "`contact` = '"+contact+"', " +
                    "`date` = '"+date+"'" +
                    "WHERE `doctor`.`id` = "+id);
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

    public Boolean UpdateProduct(Integer id, String p_name,String g_name,String  category,java.util.Date m_date,java.util.Date e_date, Integer barcode, String UOM, Integer quantity,Integer p_price,Integer s_price){
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("UPDATE `product` SET " +
                    "`p_name` = '"+p_name+"', " +
                    "`g_name` = '"+g_name+"', " +
                    "`category` = '"+category+"', " +
                    "`m_date` = '"+m_date+"', " +
                    "`e_date` = '"+e_date+"', " +
                    "`barcode` = '"+barcode+"', " +
                    "`UOM` = '"+UOM+"', " +
                    "`quantity` = '"+quantity+"', " +
                    "`p_price` = '"+p_price+"', " +
                    "`s_price` = '"+s_price+"' " +
                    "WHERE `product`.`id` = "+id);
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

    public Boolean UpdateCategory(Integer id, String name){
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("UPDATE `category` SET `name` = '"+name+"' WHERE `category`.`id` = "+id);
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

    public Boolean DeletePatient(Integer id){
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("DELETE FROM `patient` WHERE `patient`.`id` = "+id);
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

    public Boolean DeleteDoctor(Integer id){
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("DELETE FROM `doctor` WHERE `doctor`.`id` = "+id);
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

    public Boolean DeleteProduct(Integer id){
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("DELETE FROM `product` WHERE `product`.`id` = "+id);
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

    public Boolean DeleteCategory(Integer id){
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("DELETE FROM `category` WHERE `category`.`id` = "+id);
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

    public boolean CreateInvoice(Integer id, Integer user_id, Double total, Double paid, String method, Double change_due, ObservableList<Invoice_item> products){
        String query = "";
        products.forEach(product->{

        });
        for (int i = 0; i < products.size(); i++) {
            if( i == products.size()-1){
                query += "('"+id+"','"+products.get(i).getProduct_id()+"','"+products.get(i).getQty()+"','"+products.get(i).getTotal()+"')";
            }else{
                query += "('"+id+"','"+products.get(i).getProduct_id()+"','"+products.get(i).getQty()+"','"+products.get(i).getTotal()+"'),";
            }
        }
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("INSERT INTO `invoice_item` (`invoice_id`, `product_id`, `qty`, `total) " +
                    "VALUES "+query);
            if(cnt==products.size()){
                Integer cnt1 = statement.executeUpdate("INSERT INTO `invoice` (`id`, `user_id`, `total`, `paid`, `method`, `change_due`) " +
                        "VALUES ('"+id+"', '"+user_id+"', '"+total+"', '"+paid+"', '"+method+"', '"+change_due+"')");
                if(cnt1==1) {
                    return true;
                } else {
                    statement.executeUpdate("DELETE FROM `invoice_item` WHERE `invoice_item`.`invoice_id` = "+id);
                }
            }else{
                statement.executeUpdate("DELETE FROM `invoice_item` WHERE `invoice_item`.`invoice_id` = "+id);
                return false;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}

