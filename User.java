public class User {
    private String userId;
    private String name;
    private String email;
    private String passHash;

    public User(String userId, String name, String email, String passHash) {
        this.userId = userId;
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
