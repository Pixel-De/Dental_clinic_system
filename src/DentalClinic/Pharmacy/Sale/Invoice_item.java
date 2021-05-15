package DentalClinic.Pharmacy.Sale;

public class Invoice_item {
    private String invoice_id;
    private String product_id;
    private Integer qty;
    private Double total;

    public Invoice_item(String invoice_id, String product_id, Integer qty, Double total) {
        this.invoice_id = invoice_id;
        this.product_id = product_id;
        this.qty = qty;
        this.total = total;
    }

    public String getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(String invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
