package codealpha;

public class Booking {
	private String customerName;
    private int roomNumber;
    private String category;

    public Booking(String customerName, int roomNumber, String category) {
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.category = category;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Booking: " + customerName + " -> Room #" + roomNumber + " [" + category + "]";
    }
}
