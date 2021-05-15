package DentalClinic.Pharmacy.Sale;

public class SaleModel {

    private Integer id, quantity;
    private String name;
    private Float total, unit;

    public SaleModel(Integer id, Integer quantity, String name, Float unit, Float total) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.unit = unit;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getUnit() {
        return unit;
    }

    public void setUnit(Float unit) {
        this.unit = unit;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
