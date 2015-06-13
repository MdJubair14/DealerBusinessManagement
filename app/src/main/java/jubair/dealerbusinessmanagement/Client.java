package jubair.dealerbusinessmanagement;

/**
 * Created by hp on 6/11/2015.
 */
public class Client {
    private  int id;
    private String name;
    private String address;
    private String contactInfo;
    private int dealersId;

    public Client(int id,String name , String address, String  contactInfo,int dealersId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
        this.dealersId = dealersId;
    }

    public Client(String name, String address, String contactInfo, int dealersId) {
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
        this.dealersId = dealersId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDealersId() {
        return dealersId;
    }

    public void setDealersId(int dealersId) {
        this.dealersId = dealersId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
