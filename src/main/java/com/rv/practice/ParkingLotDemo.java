package com.rv.practice;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

// ================= ENUMS =================

enum VehicleType {
    BIKE, LMV, HMV
}

// ================= VEHICLES =================

abstract class Vehicle {
    private final String vehicleNumber;
    private final VehicleType vehicleType;

    protected Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}

class Bike extends Vehicle {
    public Bike(String number) {
        super(number, VehicleType.BIKE);
    }
}

class LMV extends Vehicle {
    public LMV(String number) {
        super(number, VehicleType.LMV);
    }
}

class HMV extends Vehicle {
    public HMV(String number) {
        super(number, VehicleType.HMV);
    }
}

// ================= PARKING SPOT =================

class ParkingSpot {
    private final String spotId;
    private final VehicleType vehicleType;
    private Vehicle vehicle;

    public ParkingSpot(String spotId, VehicleType vehicleType) {
        this.spotId = spotId;
        this.vehicleType = vehicleType;
    }

    public String getSpotId() {
        return spotId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public void occupy(Vehicle vehicle) {
        if (!isAvailable()) {
            throw new IllegalStateException("Spot already occupied");
        }
        this.vehicle = vehicle;
    }

    public void release() {
        this.vehicle = null;
    }
}

// ================= PARKING FLOOR =================

class ParkingFloor {
    private final int floorId;

    private final Map<VehicleType, Queue<ParkingSpot>> availableSpots
            = new HashMap<>();

    public ParkingFloor(int floorId) {
        this.floorId = floorId;

        for (VehicleType type : VehicleType.values()) {
            availableSpots.put(type, new LinkedList<>());
        }
    }

    public int getFloorId() {
        return floorId;
    }

    public void addSpot(ParkingSpot spot) {
        availableSpots.get(spot.getVehicleType()).offer(spot);
    }

    public ParkingSpot getAvailableSpot(VehicleType type) {
        return availableSpots.get(type).poll();
    }

    public void releaseSpot(ParkingSpot spot) {
        spot.release();
        availableSpots.get(spot.getVehicleType()).offer(spot);
    }
}

// ================= PARKING SPOT MANAGER =================

class ParkingSpotManager {

    private final List<ParkingFloor> floors = new ArrayList<>();

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    // Allocate a compatible spot
    public synchronized ParkingSpot allocateSpot(Vehicle vehicle) {

        for (ParkingFloor floor : floors) {

            ParkingSpot spot =
                    floor.getAvailableSpot(vehicle.getVehicleType());

            if (spot != null) {
                spot.occupy(vehicle);
                return spot;
            }
        }

        throw new IllegalStateException(
                "No parking spot available for " + vehicle.getVehicleType()
        );
    }

    // Release the spot after vehicle exit
    public synchronized void releaseSpot(
            ParkingSpot spot, Vehicle vehicle) {

        if (!spot.getVehicleType().equals(vehicle.getVehicleType())) {
            throw new IllegalArgumentException("Invalid vehicle for spot");
        }

        for (ParkingFloor floor : floors) {
            if (spot.getSpotId().startsWith(floor.getFloorId() + "-")) {
                floor.releaseSpot(spot);
                return;
            }
        }

        throw new IllegalArgumentException("Parking floor not found");
    }
}

// ================= TICKET =================

class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final LocalDateTime entryTime;

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = LocalDateTime.now();
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}

// ================= FARE CALCULATOR =================

interface FareCalculator {
    int calculateFare(Ticket ticket, LocalDateTime exitTime);
}

class DefaultFareCalculator implements FareCalculator {

    private final Map<VehicleType, Integer> hourlyRates = Map.of(
            VehicleType.BIKE, 10,
            VehicleType.HMV, 20,
            VehicleType.LMV, 50
    );

    @Override
    public int calculateFare(Ticket ticket, LocalDateTime exitTime) {

        long minutes = Duration.between(
                ticket.getEntryTime(), exitTime
        ).toMinutes();

        // Minimum one hour; every started hour is chargeable.
        long hours = Math.max(1, (minutes + 59) / 60);

        int rate = hourlyRates.get(ticket.getVehicle().getVehicleType());

        return Math.toIntExact(hours * rate);
    }
}

// ================= PARKING RECEIPT =================

class ParkingReceipt {
    private final String ticketId;
    private final String vehicleNumber;
    private final String spotId;
    private final int amount;

    public ParkingReceipt(Ticket ticket, int amount) {
        this.ticketId = ticket.getTicketId();
        this.vehicleNumber = ticket.getVehicle().getVehicleNumber();
        this.spotId = ticket.getParkingSpot().getSpotId();
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ParkingReceipt{" +
                "ticketId='" + ticketId + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", spotId='" + spotId + '\'' +
                ", amount=" + amount +
                '}';
    }
}

// ================= PARKING LOT =================

class ParkingLot {

    private final ParkingSpotManager spotManager;
    private final FareCalculator fareCalculator;

    private final Map<String, Ticket> activeTickets = new HashMap<>();

    private final Map<String, String> vehicleToTicket = new HashMap<>();

    public ParkingLot(
            ParkingSpotManager spotManager,
            FareCalculator fareCalculator) {

        this.spotManager = spotManager;
        this.fareCalculator = fareCalculator;
    }

    // Vehicle entry
    public synchronized Ticket parkVehicle(Vehicle vehicle) {

        String vehicleNumber = vehicle.getVehicleNumber();

        if (vehicleToTicket.containsKey(vehicleNumber)) {
            throw new IllegalStateException(
                    "Vehicle is already parked"
            );
        }

        ParkingSpot spot = spotManager.allocateSpot(vehicle);

        try {
            Ticket ticket = new Ticket(vehicle, spot);

            activeTickets.put(ticket.getTicketId(), ticket);
            vehicleToTicket.put(vehicleNumber, ticket.getTicketId());

            return ticket;

        } catch (RuntimeException e) {
            spotManager.releaseSpot(spot, vehicle);
            throw e;
        }
    }

    // Vehicle exit
    public synchronized ParkingReceipt unparkVehicle(String ticketId) {

        Ticket ticket = activeTickets.get(ticketId);

        if (ticket == null) {
            throw new IllegalArgumentException(
                    "Invalid or already closed ticket"
            );
        }

        LocalDateTime exitTime = LocalDateTime.now();

        int fare = fareCalculator.calculateFare(ticket, exitTime);

        // Release spot only after fare calculation succeeds.
        spotManager.releaseSpot(
                ticket.getParkingSpot(),
                ticket.getVehicle()
        );

        activeTickets.remove(ticketId);
        vehicleToTicket.remove(
                ticket.getVehicle().getVehicleNumber()
        );

        return new ParkingReceipt(ticket, fare);
    }
}

// ================= MAIN =================

public class ParkingLotDemo {

    public static void main(String[] args) {

        // Create floors
        ParkingFloor floor1 = new ParkingFloor(1);
        ParkingFloor floor2 = new ParkingFloor(2);

        // Add spots to floor 1
        floor1.addSpot(new ParkingSpot("1-B1", VehicleType.BIKE));
        floor1.addSpot(new ParkingSpot("1-B2", VehicleType.BIKE));
        floor1.addSpot(new ParkingSpot("1-L1", VehicleType.LMV));
        floor1.addSpot(new ParkingSpot("1-H1", VehicleType.HMV));

        // Add spots to floor 2
        floor2.addSpot(new ParkingSpot("2-B1", VehicleType.BIKE));
        floor2.addSpot(new ParkingSpot("2-L1", VehicleType.LMV));

        // Initialize parking lot
        ParkingSpotManager manager = new ParkingSpotManager();
        manager.addFloor(floor1);
        manager.addFloor(floor2);

        FareCalculator fareCalculator =
                new DefaultFareCalculator();

        ParkingLot parkingLot =
                new ParkingLot(manager, fareCalculator);

        // Vehicle entry
        Vehicle bike = new Bike("UP44AB1234");

        Ticket ticket = parkingLot.parkVehicle(bike);

        System.out.println("Vehicle parked successfully");
        System.out.println("Ticket ID: " + ticket.getTicketId());
        System.out.println("Spot: " +
                ticket.getParkingSpot().getSpotId());

        // Vehicle exit
        ParkingReceipt receipt =
                parkingLot.unparkVehicle(ticket.getTicketId());

        System.out.println(receipt);
    }
}
