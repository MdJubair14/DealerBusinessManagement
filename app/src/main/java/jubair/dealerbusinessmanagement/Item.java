package jubair.dealerbusinessmanagement;

/**
 * Created by hp on 6/14/2015.
 */
public class Item {
    private int id;
    private String name;
    private double price;
    private double quantity;
    private double percentage;
    private int dealerId;

    public Item(String name, double price, double quantity, double percentage, int dealerId) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.percentage = percentage;
        this.dealerId = dealerId;
    }

    public Item(int id, String name, double price, double quantity, double percentage, int dealerId) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.percentage = percentage;
        this.dealerId = dealerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getDealerId() {
        return dealerId;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    @Override
    public String toString() {
        return id + "\n" + name  + "\n" + price  + "\n" + quantity  + "\n" + percentage + "\n" + dealerId;
    }
}
