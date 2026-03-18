package bookmystay.model;

/**
 * Abstract representation of a hotel room.
 * Defines common attributes shared by all room types.
 *
 * @author Harshal
 * @version 2.0
 */
public abstract class Room {
    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    /**
     * Displays details of the room.
     */
    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sqft");
        System.out.println("Price per night: ₹" + pricePerNight);
    }
}
