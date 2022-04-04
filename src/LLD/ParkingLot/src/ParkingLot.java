package LLD.ParkingLot.src;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private String name;
    private int capacity;
    private String address;



    private ParkingRate parkingRate;
    private ParkingDisplayBoard parkingDisplayBoard;
    private ParkingFloor parkingFloor;
    private Map<Integer, ParkingFloor> parkingFloorMap;
    private Map<String, Payment> ticketPaymentMap;
    public ParkingLot(String name,  String address, ParkingRate parkingRate, ParkingDisplayBoard parkingDisplayBoard, ParkingFloor parkingFloor) {
        this.name = name;
        this.capacity = capacity;
        this.address = address;
        this.parkingRate = parkingRate;
        this.parkingDisplayBoard = parkingDisplayBoard;
        this.parkingFloor = parkingFloor;
        this.parkingFloorMap = new HashMap<>();
        this.ticketPaymentMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ParkingRate getParkingRate() {
        return parkingRate;
    }

    public void setParkingRate(ParkingRate parkingRate) {
        this.parkingRate = parkingRate;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public void addParkingSlots(int floornumber, SlotType slotType, int numberOfSlots){
        ParkingFloor parkingFloor = parkingFloorMap.getOrDefault(floornumber, new ParkingFloor(floornumber));
        parkingFloor.addSlot(slotType, numberOfSlots);
        parkingFloorMap.put(floornumber, parkingFloor);
    }

    public Ticket parkVehicle(Vehicle vehicle, int floorNumber){
        //TODO: implement logic to choose the floor
        ParkingFloor parkingFloor = parkingFloorMap.get(floorNumber);
        return parkingFloor.parkVehicle(vehicle);
    }

    public Double calculateCharge(Ticket ticket){
        return ((System.currentTimeMillis() - ticket.getStartTime()) * 1000) * 0.025;
    }

    public void pay(Ticket ticket, Long amount){
        Payment payment = new Payment("cash", System.currentTimeMillis(), PaymentStatus.PAID, 1000L);
        ticket.setPaymentStatus(PaymentStatus.PAID);
        ticketPaymentMap.put(ticket.getTicketId(), payment);
        return;
    }

    public Vehicle exitVehicle(Ticket ticket, int floorNumber){
        if(ticket == null || ticket.getPaymentStatus() != PaymentStatus.PAID){
            System.out.println("Invalid ticket or not paid");
            return null;
        }
        ticket.setEndTime(System.currentTimeMillis());
        ParkingFloor parkingFloor = parkingFloorMap.get(floorNumber);
        return parkingFloor.exitVehicle(ticket);
    }
}
