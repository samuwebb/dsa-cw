public class Administrator extends User {
    private int accessLevel;

    public Administrator(String name, String email, String passHash, int accessLevel) {
        super(name, email, passHash);
        this.accessLevel = accessLevel;
    }

    public int getAccessLevel() {
        return accessLevel;
    }
}
