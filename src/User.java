public class User {

    private String mail;
    private String passw;

    public User() {}

    public User(String mail, String passw) {
        this.mail = mail;
        this.passw = passw;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getMail() {
        return mail;
    }

    public String getPassw() {
        return passw;
    }
}
