public class User {
    protected String name;
    protected String email;
    protected String passHash;
    protected String role;

    public User(String name, String email, String passHash) {
        this.name = name;
        this.email = email;
        this.passHash = passHash;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
