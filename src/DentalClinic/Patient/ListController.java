package DentalClinic.Patient;

import DentalClinic.DB.DbConnect;
import javafx.collections.ObservableList;

public class ListController {
    public void initialize(){
        System.out.println("sucks java");
        DbConnect data = new DbConnect();
        if(data.getStatus()!=null){
            System.out.println("db got here");
            ObservableList<Patient> patients = data.PatientList();
            patients.forEach(patient -> {
                System.out.println(patient.getId()+" "+patient.getName());
            });
        }
    }
}
