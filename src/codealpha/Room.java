package codealpha;

public class Room {
	private int roomNumber;
    private String category; // Standard, Deluxe, Suite
    private boolean isBooked;

    public Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isBooked = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public String toString() {
        return "Room #" + roomNumber + " [" + category + "] - " + (isBooked ? "Booked" : "Available");
    }

}
