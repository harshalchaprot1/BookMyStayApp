package bookmystay.model;

/**
 * Use Case 5: Booking Request (First-Come-First-Served)
 *
 * Represents a booking request made by a guest.
 * At this stage, a reservation only captures intent,
 * not confirmation or room allocation.
 *
 * @author Harshal
 * @version 5.0
 */
public class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}
