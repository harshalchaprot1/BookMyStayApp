package bookmystay.app;

import bookmystay.exception.InvalidBookingException;
import bookmystay.model.RoomInventory;
import bookmystay.service.ReservationValidator;
import bookmystay.service.BookingRequestQueue;
import bookmystay.model.Reservation;

import java.util.Scanner;

/**
 * Use Case 9: Error Handling & Validation
 *
 * Demonstrates how user input is validated before booking is processed.
 * Accepts input, validates centrally, and handles errors gracefully.
 *
 * @author Harshal
 * @version 9.0
 */
public class UseCase9ErrorHandlingValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        try {
            System.out.println("Booking Validation");
            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter room type (SingleRoom/DoubleRoom/SuiteRoom): ");
            String roomType = scanner.nextLine();

            // Validate input
            validator.validate(guestName, roomType, inventory);

            // If valid, add to queue
            bookingQueue.addRequest(new Reservation(guestName, roomType));
            System.out.println("Booking request accepted for " + guestName + " (" + roomType + ")");
        } catch (InvalidBookingException e) {
            System.out.println("Booking failed: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
