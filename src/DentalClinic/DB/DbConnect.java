package DentalClinic.DB;
import DentalClinic.Doctor.Doctor;
import DentalClinic.Income.AccountModel;
import DentalClinic.Income.VoucherModel;
import DentalClinic.Patient.Patient;
import DentalClinic.Pharmacy.Sale.Invoice_item;
import DentalClinic.Pharmacy.productInformation.Category;
import DentalClinic.Pharmacy.productInformation.Product;
import DentalClinic.Prescription.PresCriptionMain;
import DentalClinic.Prescription.PrescriptionFull;
import DentalClinic.Prescription.PrescriptionModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DbConnect {

    private final Connection db;

    private Connection Connect(){

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://103.50.205.77:5432/clinic_kheb","kheb","@@ludo@@");
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
                String UOM = result.getString("uom");
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
                a.add(new Category(name));
            }
            return a;
        } catch (SQLException e){
            e.printStackTrace();
            return a;
        }
    }

    private ObservableList<PrescriptionFull> GetAllPrescription(){
        ObservableList<PrescriptionFull> a = FXCollections.observableArrayList(new ArrayList<PrescriptionFull>());
        try (Statement statement = this.db.createStatement()) {
            ResultSet result = statement.executeQuery("select prescription.id as id, prescription.date as date, patient_id, patient.name as name, patient.age as age, gender from prescription ,patient WHERE prescription.patient_id=patient.id");
            while(result.next()){
                String id = result.getString("id");
                String patient_id = result.getString("patient_id");
                Date date = result.getDate("date");
                String name = result.getString("name");
                String age = result.getString("age");
                String gender = result.getString("gender");
                a.add(new PrescriptionFull(id, patient_id, date, age,name, gender));
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
    public ObservableList<PrescriptionFull> PrescriptionList(){
        return  this.GetAllPrescription();
    }

    public Boolean AddPatient(Integer id, String name, String parent, String gender, Integer age, String occupation, String address, Integer contact, java.util.Date reference, java.util.Date date){
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("INSERT INTO patient (id, name, parent, gender, age, occupation, address, contact, reference, date) " +
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
            Integer cnt = statement.executeUpdate("INSERT INTO doctor (id, name, speciality, qualification, address, contact, date) " +
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
            Integer cnt = statement.executeUpdate("INSERT INTO product (id, p_name, g_name, category, m_date, e_date, barcode, uom, quantity, p_price, s_price) " +
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
            Integer cnt = statement.executeUpdate("INSERT INTO category ( name) VALUES ( '"+name+"')");
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
            Integer cnt = statement.executeUpdate("UPDATE patient SET " +
                    "name = '"+name+"', " +
                    "parent = '"+parent+"', " +
                    "gender = '"+gender+"', " +
                    "age = '"+age+"', " +
                    "occupation = '"+occupation+"', " +
                    "address = '"+address+"', " +
                    "contact = '"+contact+"', " +
                    "reference = '"+reference+"', " +
                    "date = '"+date+"' " +
                    "WHERE id = "+id);
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
            Integer cnt = statement.executeUpdate("UPDATE doctor SET " +
                    "name = '"+name+"', " +
                    "speciality = '"+speciality+"', " +
                    "qualification = '"+qualification+"', " +
                    "address = '"+address+"', " +
                    "contact = '"+contact+"', " +
                    "date = '"+date+"'" +
                    "WHERE id = "+id);
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
            Integer cnt = statement.executeUpdate("UPDATE product SET " +
                    "p_name = '"+p_name+"', " +
                    "g_name = '"+g_name+"', " +
                    "category = '"+category+"', " +
                    "m_date = '"+m_date+"', " +
                    "e_date = '"+e_date+"', " +
                    "barcode = '"+barcode+"', " +
                    "uom = '"+UOM+"', " +
                    "quantity` = '"+quantity+"', " +
                    "p_price = '"+p_price+"', " +
                    "s_price = '"+s_price+"' " +
                    "WHERE id = "+id);
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
            Integer cnt = statement.executeUpdate("UPDATE category SET name = '"+name+"' WHERE id = "+id);
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
            Integer cnt = statement.executeUpdate("DELETE FROM patient WHERE id = "+id);
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
            Integer cnt = statement.executeUpdate("DELETE FROM doctor WHERE id = "+id);
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
            Integer cnt = statement.executeUpdate("DELETE FROM product WHERE id = "+id);
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

    public Boolean DeleteCategory(String id){
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("DELETE FROM category WHERE name = "+id);
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
        for (int i = 0; i < products.size(); i++) {
            if( i == products.size()-1){
                query += "('"+id+"','"+products.get(i).getProduct_id()+"','"+products.get(i).getQty()+"','"+products.get(i).getTotal()+"')";
            }else{
                query += "('"+id+"','"+products.get(i).getProduct_id()+"','"+products.get(i).getQty()+"','"+products.get(i).getTotal()+"'),";
            }
        }
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("INSERT INTO invoice_item (invoice_id, product_id, qty, total) " +
                    "VALUES "+query);
            if(cnt==products.size()){
                Integer cnt1 = statement.executeUpdate("INSERT INTO invoice (id, user_id, total, paid, method, change_due) " +
                        "VALUES ('"+id+"', '"+user_id+"', '"+total+"', '"+paid+"', '"+method+"', '"+change_due+"')");
                if(cnt1==1) {
                    return true;
                } else {
                    statement.executeUpdate("DELETE FROM invoice_item WHERE invoice_id = "+id);
                    return  false;
                }
            }else{
                statement.executeUpdate("DELETE FROM invoice_item WHERE invoice_id = "+id);
                return false;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public  Integer getIdInvoice(){
        try (Statement statement = this.db.createStatement()){
            ResultSet result = statement.executeQuery("SELECT id FROM invoice ORDER BY id DESC LIMIT 1");
            if(result.next()){
                return  result.getInt("id") + 1;

            } else {
                return  1;

            }
        } catch (SQLException e){
            e.printStackTrace();
            return  -1;
        }
    }

    public PresCriptionMain CreatePrescription(){
        try (Statement statement = this.db.createStatement()){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            Integer cnt = statement.executeUpdate("INSERT INTO prescription (date, patient_id, created_at) VALUES ('"+dtf.format(now)+"', 0, CURRENT_TIMESTAMP)");
            if(cnt == 1){
                ResultSet result = statement.executeQuery("SELECT * FROM prescription ORDER BY created_at DESC LIMIT 1");
                if(result.next()){
                    PresCriptionMain presCriptionMain = new PresCriptionMain(result.getString("id"),result.getString("patient_id"),result.getDate("date"));
                    return presCriptionMain;
                } else {
                    return null;
                }
            } else {
                return  null;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<PrescriptionModel> getPrescriptionItem(String id){
        ObservableList<PrescriptionModel> a = FXCollections.observableArrayList(new ArrayList<PrescriptionModel>());
        try (Statement statement = this.db.createStatement()) {
            ResultSet result = statement.executeQuery("select * from prescription_item WHERE prescription_id = "+id);
            while(result.next()){
                String _id = result.getString("id");
                String name = result.getString("m_name");
                String dodge = result.getString("dodge");
                String duration = result.getString("duration");
                Integer qty = result.getInt("qty");
                String remark = result.getString("remark");
                a.add(new PrescriptionModel(qty,name,dodge,duration,remark));
            }
            return a;
        } catch (SQLException e){
            e.printStackTrace();
            return a;
        }
    }


    public Boolean UpdatePrescription(PresCriptionMain prescription, ObservableList<PrescriptionModel> prescription_items){
        String query = "";
        for (int i = 0; i < prescription_items.size(); i++) {
            if( i == prescription_items.size()-1){
                query += "('"+prescription.getId()+"','"+prescription_items.get(i).getName()+"','"+prescription_items.get(i).getDodge()+"','"+prescription_items.get(i).getQuantity()+"','"+prescription_items.get(i).getDuration()+"','"+prescription_items.get(i).getRemark()+"')";
            }else{
                query += "('"+prescription.getId()+"','"+prescription_items.get(i).getName()+"','"+prescription_items.get(i).getDodge()+"','"+prescription_items.get(i).getQuantity()+"','"+prescription_items.get(i).getDuration()+"','"+prescription_items.get(i).getRemark()+"'),";
            }
        }
        try (Statement statement = this.db.createStatement()){
            statement.executeUpdate("DELETE FROM invoice_item WHERE invoice_id = "+prescription.getId());
                Integer cnt = statement.executeUpdate("INSERT INTO prescription_item (prescription_id, m_name, dodge, qty, duration, remark) VALUES "+query);
            if(cnt==prescription_items.size()){
                Integer cnt1 = statement.executeUpdate("UPDATE prescription SET " +
                        "patient_id = '"+prescription.getPatient_id()+"',"+
                        "date = '"+prescription.getDate()+"' "+
                        "WHERE id = "+prescription.getId());
                if(cnt1==1) {
                    return true;
                } else {
                    statement.executeUpdate("DELETE FROM invoice_item WHERE invoice_id = "+prescription.getId());
                }
            }else{
                statement.executeUpdate("DELETE FROM invoice_item WHERE invoice_id = "+prescription.getId());
                return false;
            }
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean AddAccount(String name,String type, String status){
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("INSERT INTO account ( name, type, status) VALUES ( '"+name+"','"+type+"','"+status+"')");
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

    public Boolean UpdateAccount(String id, String name,String type, String status){
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("UPDATE account SET " +
                    "name = '"+name+"', type = '"+type+"', status = '"+status+"' WHERE id = "+id);
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

    public Boolean DeleteAccount(String id){
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("DELETE FROM account WHERE id = "+id);
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

    public ObservableList<AccountModel> GetAllAccount(){
        ObservableList<AccountModel> a = FXCollections.observableArrayList(new ArrayList<AccountModel>());
        try (Statement statement = this.db.createStatement()) {
            ResultSet result = statement.executeQuery("select * from account");
            while(result.next()){
                String name = result.getString("name");
                String id = result.getString("id");
                String type = result.getString("type");
                String status = result.getString("status");
                a.add(new AccountModel(id,name,type,status));
            }
            return a;
        } catch (SQLException e){
            e.printStackTrace();
            return a;
        }
    }

    public Boolean AddVoucher(String account_id,String type, Date date, String reference, String amount, String payment_method, String remark){
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("INSERT INTO voucher ( account_id, type, date, reference, amount, payment, mark) VALUES ( '"+account_id+"','"+type+"','"+date+"','"+reference+"','"+amount+"','"+payment_method+"','"+remark+"')");
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

    public Boolean UpdateVoucher(String id,String account_id,String type, Date date, String reference, String amount, String payment_method, String remark){
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("UPDATE voucher SET " +
                    "account_id = '"+account_id+"', " +
                    "type = '"+type+"', " +
                    "date = '"+date+"', " +
                    "reference = '"+reference+"', " +
                    "amount = '"+amount+"', " +
                    "payment = '"+payment_method+"', " +
                    "mark = '"+remark+"' " +
                    "WHERE id = "+id);
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

    public ObservableList<VoucherModel> GetAllVoucher(){
        ObservableList<VoucherModel> a = FXCollections.observableArrayList(new ArrayList<VoucherModel>());
        try (Statement statement = this.db.createStatement()) {
            ResultSet result = statement.executeQuery("select voucher.id as id, account.name as name, voucher.type as type, date, reference, amount, payment, mark from account, voucher WHERE voucher.account_id = account.id");
            while(result.next()){
                String name = result.getString("name");
                String id = result.getString("id");
                String type = result.getString("type");
                Date date = result.getDate("date");
                String reference = result.getString("reference");
                String amount = result.getString("amount");
                String payment = result.getString("payment");
                String mark = result.getString("mark");
                a.add(new VoucherModel(id,name,type,amount,reference,payment,mark,date));
            }
            return a;
        } catch (SQLException e){
            e.printStackTrace();
            return a;
        }
    }

    public Boolean DeleteVoucher(String id){
        try (Statement statement = this.db.createStatement()){
            Integer cnt = statement.executeUpdate("DELETE FROM voucher WHERE id = "+id);
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

