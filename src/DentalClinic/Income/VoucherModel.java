package DentalClinic.Income;

import java.sql.Date;

public class VoucherModel {
    String id,account_name,type,amount,reference,payment_method,remark;
    Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public VoucherModel(String id, String account_name, String type, String amount, String reference, String payment_method, String remark, Date date) {
        this.id = id;
        this.account_name = account_name;
        this.type = type;
        this.amount = amount;
        this.reference = reference;
        this.payment_method = payment_method;
        this.remark = remark;
        this.date = date;
    }
}
