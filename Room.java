public class Room {
    String roomId;
    String roomType;
    float monthlyRent;
    String description;
    String status;
    String startDate;
    String endDate;

    public Room(String roomId, String roomType, float monthlyRent, String description, String status, String startDate,
            String endDate) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.monthlyRent = monthlyRent;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getRoomType() {
        return roomType;
    }

    public float getMonthlyRent() {
        return monthlyRent;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
