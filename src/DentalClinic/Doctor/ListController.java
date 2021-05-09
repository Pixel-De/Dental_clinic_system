package DentalClinic.Doctor;

import DentalClinic.DB.DbConnect;
import DentalClinic.Patient.Patient;
import javafx.collections.ObservableList;

public class ListController {
    public void initialize(){
        System.out.println("sucks java");
        DbConnect data = new DbConnect();
        if(data.getStatus()!=null){
            System.out.println("db got here");
            ObservableList<Doctor> doctors = data.DoctorList();
            doctors.forEach(doctor -> {
                System.out.println(doctor.getId()+" "+doctor.getName());
            });
        }
    }
}
