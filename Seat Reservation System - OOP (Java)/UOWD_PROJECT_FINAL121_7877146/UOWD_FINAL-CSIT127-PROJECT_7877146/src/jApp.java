import java.util.Scanner;

public class jApp extends BookingSys {

    private static final int MAX_SEATS = 3;

    private BookingSys seatSystem;
    private Scanner scanner;

    public jApp() {
        seatSystem = new BookingSys();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean done = false;
        while (!done) {
            System.out.println("Please select an option:");
            System.out.println("1. Reserve a seat");
            System.out.println("2. Cancel a reservation");
            System.out.println("3. View seat grid");
            System.out.println("4. View reserved seats");
            System.out.println("5. Exit");
            System.out.println("6. Save to File");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    reserveSeat();
                    break;
                case 2:
                    cancelReservation();
                    break;
                case 3:
                    seatSystem.displaySeatGrid();
                    break;
                case 4:
                    seatSystem.displayReservedSeats();
                    break;
                case 5:
                    done = true;
                    break;
                case 6:
                    saveReservedSeatsToFile();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        }
    }

    private void saveReservedSeatsToFile() {
        System.out.println("Enter the file name:");
        String fileName = scanner.next();

        seatSystem.saveReservedSeatsToFile(fileName);
    }

    private void reserveSeat() {
        System.out.println("Enter the row number (1-9):");
        int row = scanner.nextInt() - 1;

        System.out.println("Enter the column letter (A-D):");
        String colStr = scanner.next();
        int col = colStr.charAt(0) - 'A';

        if (!seatSystem.reserveSeat(row, col)) {
            System.out.println("Reservation failed. Please try again.");
            return;
        }

        int reservedCount = seatSystem.getReservedSeatCount();
        if (reservedCount > MAX_SEATS) {
            System.out.println("You have already reserved the maximum number of seats (" + MAX_SEATS + ").");
            System.out.println("Please cancel a reservation before reserving another seat.");
            seatSystem.cancelSeat(row, col);
            return;
        }

        System.out.println("Seat reserved successfully.");
        System.out.println("You have reserved " + reservedCount + " out of " + MAX_SEATS + " seats.");
    }

    private void cancelReservation() {
        System.out.println("Enter the row number (1-9):");
        int row = scanner.nextInt() - 1;

        System.out.println("Enter the column letter (A-D):");
        String colStr = scanner.next();
        int col = colStr.charAt(0) - 'A';

        if (!seatSystem.cancelSeat(row, col)) {
            System.out.println("Cancellation failed. Please try again.");
        } else {
            System.out.println("Seat reservation cancelled successfully.");
        }
    }

    public static void main(String[] args) {
        jApp app = new jApp();
        app.run();
    }
}
