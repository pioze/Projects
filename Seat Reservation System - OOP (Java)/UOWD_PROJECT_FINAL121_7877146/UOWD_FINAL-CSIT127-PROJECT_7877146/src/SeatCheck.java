public class SeatCheck {
    private boolean isReserved;

    public SeatCheck() {
        this.isReserved = false;
    }
    
    public void reserve() {
        this.isReserved = true;
    }

    public void unreserve() {
        this.isReserved = false;
    }

    public boolean isReserved() {
        return this.isReserved;
    }
}
