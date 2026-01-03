public class Administrator extends User {
    private int accessLevel;

    public Administrator(String userId, String name, String email, String passHash, int accessLevel) {
        super(userId, name, email, passHash);
        this.accessLevel = accessLevel;
    }

    public int getAccessLevel() {
        return accessLevel;
    }
}
