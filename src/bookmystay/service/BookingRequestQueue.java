package bookmystay.service;

import bookmystay.model.Reservation;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Use Case 5: Booking Request (First-Come-First-Served)
 *
 * Manages booking requests using a queue to ensure fair allocation.
 * Requests are processed strictly in the order they are received.
 *
 * @author Harshal
 * @version 5.0
 */
public class BookingRequestQueue {
    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    /** Adds a booking request to the queue. */
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    /** Retrieves and removes the next booking request from the queue. */
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    /** Checks whether there are pending booking requests. */
    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}
