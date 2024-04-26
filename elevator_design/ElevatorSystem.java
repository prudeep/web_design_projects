package elevator_design;

public class ElevatorSystem {
    public static void main(String[] args) {
    	
        Elevator elevator = new Elevator();

        // Adding destination floors
        elevator.addDestinationFloor(new Floor(0));
        elevator.addDestinationFloor(new Floor(1));
        elevator.addDestinationFloor(new Floor(2));
        elevator.addDestinationFloor(new Floor(3));
        elevator.addDestinationFloor(new Floor(4));
        elevator.addDestinationFloor(new Floor(5));
        elevator.addDestinationFloor(new Floor(6));
        elevator.addDestinationFloor(new Floor(7));
        elevator.addDestinationFloor(new Floor(8));
        elevator.addDestinationFloor(new Floor(9));
        

        elevator.move();
    }
}