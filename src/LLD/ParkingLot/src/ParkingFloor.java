package LLD.ParkingLot.src;

import java.util.*;

public class ParkingFloor {
    private int floorNumber;
    private Map<String , ParkingSlot> vehicleParkingSlotMap;
    private Map<SlotType, List<ParkingSlot>> parkingSlotMap;

    public ParkingFloor(int floornumber) {
        this.floorNumber = floornumber;
        parkingSlotMap = new HashMap<>();
        this.vehicleParkingSlotMap = new HashMap<>();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void addSlot(SlotType slotType, int numberOfSlots) {
        List<ParkingSlot> parkingSlots= parkingSlotMap.getOrDefault(slotType, new ArrayList<>());
        for (int i = 0; i < numberOfSlots; i++) {
            parkingSlots.add(new ParkingSlot(UUID.randomUUID().toString(), slotType));
        }
        parkingSlotMap.put(slotType, parkingSlots);
    }
    //TODO: Add method to remove slot
//    public void removeSlot(SlotType slotType, int numberOfSlots) {
//        List<ParkingSlot> parkingSlots = parkingSlotMap.getOrDefault(slotType, new ArrayList<>());
//    }


   public Ticket parkVehicle(Vehicle vehicle){
       ParkingSlot parkingSlot = getSlot(vehicle);
       if(parkingSlot == null){
           return null;
       }
       parkingSlot.setOccupied(true);
       vehicleParkingSlotMap.put(vehicle.getVehicleNumber(), parkingSlot);
       Ticket ticket = Ticket.generateTicket(vehicle);
       return ticket;
   }

    public Vehicle exitVehicle(Ticket ticket){
        ParkingSlot parkingSlot = vehicleParkingSlotMap.get(ticket.getVehicle().getVehicleNumber());
        if(parkingSlot == null){
            System.out.println("Invalid ticket");
        }
        parkingSlot.setOccupied(false);
        return ticket.getVehicle();
    }
    private ParkingSlot getSlot(Vehicle vehicle) {
        return parkingSlotMap.get(SlotType.SMALL).get(0);
//        //TODO: imeplement logic to get slot
//        for(SlotType slotType: parkingSlotMap.keySet()){
//            if(slotType.ordinal() < vehicle.getVehicleType().ordinal()){
//
//            }
//       }
    }
}
