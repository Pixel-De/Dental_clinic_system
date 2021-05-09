package DentalClinic.Patient;

import java.time.LocalDate;
import java.util.Date;

public class Patient {
    private String name,parent,gender,occupation,address;
    private Integer id,age,contact;
    private Date reference,date;

    public Patient(String name, String parent, String gender, String occupation, String address, Integer id, Integer age, Integer contact, Date reference, Date date) {
        this.name = name;
        this.parent = parent;
        this.gender = gender;
        this.occupation = occupation;
        this.address = address;
        this.id = id;
        this.age = age;
        this.contact = contact;
        this.reference = reference;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getParent() {
        return parent;
    }

    public String getGender() {
        return gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getAddress() {
        return address;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getContact() {
        return contact;
    }

    public Date getReference() {
        return reference;
    }

    public Date getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public void setReference(Date reference) {
        this.reference = reference;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
