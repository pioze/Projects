import java.io.FileWriter;
import java.io.IOException;

public class BookingSys {
    private final int ROWS = 9;
    private final int COLUMNS = 4;
    private char[][] seatGrid;

    public BookingSys() {
        seatGrid = new char[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                seatGrid[i][j] = 'O';
            }
        }
    }

    public boolean reserveSeat(int row, int col) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLUMNS) {
            return false;
        }

        if (seatGrid[row][col] == 'X') {
            return false;
        }

        seatGrid[row][col] = 'X';
        return true;
    }

    public boolean cancelSeat(int row, int col) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLUMNS) {
            return false;
        }

        if (seatGrid[row][col] == 'O') {
            return false;
        }

        seatGrid[row][col] = 'O';
        return true;
    }

    public int getReservedSeatCount() {
        int count = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (seatGrid[i][j] == 'X') {
                    count++;
                }
            }
        }
        return count;
    }

    public void displaySeatGrid() {
        System.out.println("  A B C D");
        for (int i = 0; i < ROWS; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(seatGrid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void displayReservedSeats() {
        System.out.println("Reserved Seats:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (seatGrid[i][j] == 'X') {
                    System.out.println((i + 1) + "" + (char) ('A' + j));
                }
            }
        }
    }

    public void saveReservedSeatsToFile(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);

            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLUMNS; j++) {
                    if (seatGrid[i][j] == 'X') {
                        writer.write((i + 1) + "" + (char) ('A' + j) + "\n");
                    }
                }
            }

            writer.close();
            System.out.println("Reserved seats saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

