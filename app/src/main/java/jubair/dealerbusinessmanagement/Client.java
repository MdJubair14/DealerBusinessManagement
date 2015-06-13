package jubair.dealerbusinessmanagement;

/**
 * Created by hp on 6/11/2015.
 */
public class Client {
    private  int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private int dealersId;

    /**
     *
     * @param name
     * @param email
     * @param address
     * @param phoneNumber
     */
    public Client(int id,String name , String email, String address, String  phoneNumber,int dealersId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dealersId = dealersId;
    }

    public Client(String name, String email, String address, String phoneNumber, int dealersId) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String  getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
