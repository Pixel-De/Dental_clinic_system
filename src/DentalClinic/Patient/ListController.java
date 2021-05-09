package DentalClinic.Patient;

import DentalClinic.DB.DbConnect;

public class ListController {
    public void initialize(){
        System.out.println("sucks java");
        DbConnect a = new DbConnect();
        if(a.getStatus()!=null){
            System.out.println("db got here");
        }
    }
}
