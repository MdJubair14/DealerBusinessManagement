package jubair.dealerbusinessmanagement;

/**
 * Created by hp on 6/12/2015.
 */
public class Company {
    private String name;
    private int id;
    private int correspondingDealerId ;

    public Company(int id, String name, int correspondingDealerId) {

        this.name = name;
        this.id = id;
        this.correspondingDealerId = correspondingDealerId;
    }


    public Company(String name, int correspondingDealerId) {

        this.name = name;
        this.correspondingDealerId = correspondingDealerId;
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
        return id + "\n" + name + "\n" + correspondingDealerId;
    }
}
