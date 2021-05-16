package DentalClinic.Prescription;

import java.sql.Date;

public class PresCriptionMain {
    String id, patient_id;
    Date date;

    public PresCriptionMain(String id, String patient_id, Date date) {
        this.id = id;
        this.patient_id = patient_id;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
