package jubair.dealerbusinessmanagement;

/**
 * Created by hp on 6/11/2015.
 */
public class Dealer {
    private int id;
    private String name;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dealer(int id, String name, String password){
        this.id =id;
        this.name = name;
        this.password = password;
    }

    public Dealer(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + "\n" + name + "\n" + password;
    }
}
