package codealpha;

import java.io.*;
import java.util.*;

public class HotelSystem {
    private List<Room> rooms;
    private List<Booking> bookings;

    public HotelSystem() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        loadRooms();
        loadBookings();
    }

    private void loadRooms() {
        // Create some sample rooms
        for (int i = 1; i <= 5; i++) rooms.add(new Room(i, "Standard"));
        for (int i = 6; i <= 8; i++) rooms.add(new Room(i, "Deluxe"));
        for (int i = 9; i <= 10; i++) rooms.add(new Room(i, "Suite"));
    }

    private void loadBookings() {
        File file = new File("bookings.txt");
        if (!file.exists()) return;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    int roomNumber = Integer.parseInt(parts[1]);
                    String category = parts[2];
                    bookings.add(new Booking(name, roomNumber, category));
                    Room room = findRoomByNumber(roomNumber);
                    if (room != null) room.setBooked(true);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading bookings.");
        }
    }

    private void saveBookings() {
        try (PrintWriter writer = new PrintWriter("bookings.txt")) {
            for (Booking b : bookings) {
                writer.println(b.getCustomerName() + "," + b.getRoomNumber() + "," + b.getCategory());
            }
        } catch (IOException e) {
            System.out.println("Error saving bookings.");
        }
    }

    private Room findRoomByNumber(int roomNumber) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) return r;
        }
        return null;
    }

    public void viewAvailableRooms() {
        for (Room r : rooms) {
            if (!r.isBooked()) {
                System.out.println(r);
            }
        }
    }

    public void bookRoom(String name, String category) {
        for (Room r : rooms) {
            if (!r.isBooked() && r.getCategory().equalsIgnoreCase(category)) {
                r.setBooked(true);
                Booking booking = new Booking(name, r.getRoomNumber(), r.getCategory());
                bookings.add(booking);
                saveBookings();
                System.out.println("Booking confirmed: " + booking);
                simulatePayment(name, category);
                return;
            }
        }
        System.out.println("No available rooms in that category.");
    }

    public void cancelBooking(String name) {
        Booking target = null;
        for (Booking b : bookings) {
            if (b.getCustomerName().equalsIgnoreCase(name)) {
                target = b;
                break;
            }
        }

        if (target != null) {
            Room r = findRoomByNumber(target.getRoomNumber());
            if (r != null) r.setBooked(false);
            bookings.remove(target);
            saveBookings();
            System.out.println("Booking cancelled for: " + name);
        } else {
            System.out.println("No booking found under that name.");
        }
    }

    public void viewAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
        } else {
            for (Booking b : bookings) {
                System.out.println(b);
            }
        }
    }

    private void simulatePayment(String name, String category) {
        System.out.println("Processing payment for " + name + " [" + category + " Room]...");
        System.out.println("Payment successful.\n");
    }
}
