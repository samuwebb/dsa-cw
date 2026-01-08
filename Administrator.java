// Redundant class not used in final solution but remains to show intent

public class Administrator extends User {
    private int accessLevel; // Used for permissions, multiple layers of permissions for levels of admins

    public Administrator(String name, String email, String passHash, int accessLevel) {
        super(name, email, passHash); // Inheriting the user attributes
        this.accessLevel = accessLevel;
    }

    public int getAccessLevel() {
        return accessLevel;
    }
}
