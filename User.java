public class User {
    protected String name;
    protected String email;
    protected String passHash;
    protected String role;

    public User(String name, String email, String passHash, String role) {
        this.name = name;
        this.email = email;
        this.passHash = passHash;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
