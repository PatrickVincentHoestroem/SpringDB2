package grp.work.services.UserControl;

public class User {

    private int id;
    private String firstname;
    private String lastname;
    private String phone;

    public User(String firstName, String lastName, String phone, int id) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.phone = phone;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
