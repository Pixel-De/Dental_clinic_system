package DentalClinic.Doctor;

import java.util.Date;

public class Doctor {
    String name,speciality,qualification,address;
    Integer id,contact;
    Date date;

    public Doctor(String name, String speciality, String qualification, String address, Integer id, Integer contact, Date date) {
        this.name = name;
        this.speciality = speciality;
        this.qualification = qualification;
        this.address = address;
        this.id = id;
        this.contact = contact;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
