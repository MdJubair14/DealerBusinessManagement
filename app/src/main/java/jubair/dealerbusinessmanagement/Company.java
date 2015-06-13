package jubair.dealerbusinessmanagement;

/**
 * Created by hp on 6/12/2015.
 */
public class Company {
    private int id;
    private String name;
    private String address;
    private String contactInfo;
    private int correspondingDealerId;

    public Company(int id, String name, String address, String contactInfo, int correspondingDealerId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
        this.correspondingDealerId = correspondingDealerId;
    }


    public Company(String name, String address, String contactInfo, int correspondingDealerId) {
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
        this.correspondingDealerId = correspondingDealerId;
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

    public int getCorrespondingDealerId() {
        return correspondingDealerId;
    }

    public void setCorrespondingDealerId(int correspondingDealerId) {
        this.correspondingDealerId = correspondingDealerId;
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

    public Company(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return id + "\n" + name + "\n" + address + "\n" + contactInfo + "\n" + correspondingDealerId ;
    }
}
