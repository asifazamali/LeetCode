package LLD.ParkingLot.src;

import java.util.UUID;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private long startTime;
    private long endTime;
    private double totalCost;
    private PaymentStatus paymentStatus;
    private Ticket(String ticketId, Vehicle vehicle, Long startTime,
                   PaymentStatus paymentStatus) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.startTime = startTime;
        this.paymentStatus = paymentStatus;
    }

    public static Ticket generateTicket(Vehicle vehicle){
        Ticket ticket = new Ticket(UUID.randomUUID().toString(), vehicle, System.currentTimeMillis(), PaymentStatus.NOT_PAID);
        return ticket;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", vehicle=" + vehicle +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", totalCost=" + totalCost +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}
