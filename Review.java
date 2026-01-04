public class Review {
    private Property property;
    private int rating;
    private String comment;

    public Review(Property property, int rating, String comment) {
        this.property = property;
        this.rating = rating;
        this.comment = comment;
    }
}
