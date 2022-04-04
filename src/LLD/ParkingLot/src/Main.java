package LLD.ParkingLot.src;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot parkingLot = new ParkingLot("p1", "add1", new ParkingRate(), new ParkingDisplayBoard(), new ParkingFloor(0));

        parkingLot.addParkingSlots(1, SlotType.SMALL, 10);
        parkingLot.addParkingSlots(1, SlotType.MEDIUM, 10);
        parkingLot.addParkingSlots(1, SlotType.LARGE, 10);

        Vehicle vehicle = new Vehicle("MH-12-1234", VehicleType.CAR);
        Ticket ticket = parkingLot.parkVehicle(vehicle, 1);
        System.out.println(ticket);
        Thread.sleep(1000);
        Double charges = parkingLot.calculateCharge(ticket);
        System.out.println(charges/1000);
        parkingLot.exitVehicle(ticket,1 );
        parkingLot.pay(ticket, 10000L);
        Vehicle vehicle1 = parkingLot.exitVehicle(ticket,1 );
        System.out.println(vehicle1);
    }
}
