package DentalClinic.Pharmacy.productList;

import DentalClinic.DB.DbConnect;
import DentalClinic.Pharmacy.productInformation.Category;
import DentalClinic.Pharmacy.productInformation.Product;
import javafx.collections.ObservableList;

public class ProductListController {

    public void initialize(){
        System.out.println("sucks java");
        DbConnect data = new DbConnect();
        if(data.getStatus()!=null){
            System.out.println("db got here");
            ObservableList<Product> doctors = data.ProductList();
            doctors.forEach(product -> {
                System.out.println(product.getId()+" "+product.getpPrice());
            });
            ObservableList<Category> category = data.CategoryList();
            category.forEach(product -> {
                System.out.println(product.getCategory());
            });
        }
    }
}
