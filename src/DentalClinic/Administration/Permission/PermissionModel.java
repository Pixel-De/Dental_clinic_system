package DentalClinic.Administration.Permission;

public class PermissionModel {
    Integer id,user_id;
    Boolean patient_info,patient_list,doctor_info,doctor_list,pharmacy_info,pharmacy_list,pharmacy_report,prescription,prescription_list,voucher,voucher_list,voucher_report,admin,sales;

    public PermissionModel(Integer id, Integer user_id, Boolean patient_info, Boolean patient_list, Boolean doctor_info, Boolean doctor_list, Boolean pharmacy_info, Boolean pharmacy_list, Boolean pharmacy_report, Boolean prescription, Boolean prescription_list, Boolean voucher, Boolean voucher_list, Boolean voucher_report, Boolean admin, Boolean sales) {
        this.id = id;
        this.user_id = user_id;
        this.patient_info = patient_info;
        this.patient_list = patient_list;
        this.doctor_info = doctor_info;
        this.doctor_list = doctor_list;
        this.pharmacy_info = pharmacy_info;
        this.pharmacy_list = pharmacy_list;
        this.pharmacy_report = pharmacy_report;
        this.prescription = prescription;
        this.prescription_list = prescription_list;
        this.voucher = voucher;
        this.voucher_list = voucher_list;
        this.voucher_report = voucher_report;
        this.admin = admin;
        this.sales = sales;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Boolean getPatient_info() {
        return patient_info;
    }

    public void setPatient_info(Boolean patient_info) {
        this.patient_info = patient_info;
    }

    public Boolean getPatient_list() {
        return patient_list;
    }

    public void setPatient_list(Boolean patient_list) {
        this.patient_list = patient_list;
    }

    public Boolean getDoctor_info() {
        return doctor_info;
    }

    public void setDoctor_info(Boolean doctor_info) {
        this.doctor_info = doctor_info;
    }

    public Boolean getDoctor_list() {
        return doctor_list;
    }

    public void setDoctor_list(Boolean doctor_list) {
        this.doctor_list = doctor_list;
    }

    public Boolean getPharmacy_info() {
        return pharmacy_info;
    }

    public void setPharmacy_info(Boolean pharmacy_info) {
        this.pharmacy_info = pharmacy_info;
    }

    public Boolean getPharmacy_list() {
        return pharmacy_list;
    }

    public void setPharmacy_list(Boolean pharmacy_list) {
        this.pharmacy_list = pharmacy_list;
    }

    public Boolean getPharmacy_report() {
        return pharmacy_report;
    }

    public void setPharmacy_report(Boolean pharmacy_report) {
        this.pharmacy_report = pharmacy_report;
    }

    public Boolean getPrescription() {
        return prescription;
    }

    public void setPrescription(Boolean prescription) {
        this.prescription = prescription;
    }

    public Boolean getPrescription_list() {
        return prescription_list;
    }

    public void setPrescription_list(Boolean prescription_list) {
        this.prescription_list = prescription_list;
    }

    public Boolean getVoucher() {
        return voucher;
    }

    public void setVoucher(Boolean voucher) {
        this.voucher = voucher;
    }

    public Boolean getVoucher_list() {
        return voucher_list;
    }

    public void setVoucher_list(Boolean voucher_list) {
        this.voucher_list = voucher_list;
    }

    public Boolean getVoucher_report() {
        return voucher_report;
    }

    public void setVoucher_report(Boolean voucher_report) {
        this.voucher_report = voucher_report;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getSales() {
        return sales;
    }

    public void setSales(Boolean sales) {
        this.sales = sales;
    }
}
