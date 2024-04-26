package elevator_design;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Elevator {
    private int currentFloor;
    private Direction direction;
    private List<Floor> destinationFloors;

    public Elevator() {
        currentFloor = 0;
        direction = Direction.UP;
        destinationFloors = new ArrayList<>();
    }

    public void addDestinationFloor(Floor floor) {
        destinationFloors.add(floor);
    }

    public void move() {
    	try(Scanner sc = new Scanner(System.in)) {  
        while (!destinationFloors.isEmpty()) {
            Floor nextFloor = getNextFloor();
            if (nextFloor != null) {
            	System.out.println("Enter the floor number to move");
            	int floor  = sc.nextInt(); // TO get the floor the  number  to move from the user
            	if(floor >= 0 && floor <= 9 ) { // min[0] max[9]
            	 System.out.println("Elevator is at floor " + currentFloor);
                 currentFloor = nextFloor.getFloorNumber();	
                System.out.println("Elevator is moving from " + currentFloor);
                    // Move the elevator to the desired floor
                     while (currentFloor != floor) {
                        if (currentFloor < floor) {
                            currentFloor++;
                        } else {
                            currentFloor--;
                       }
          
                try {
                    Thread.sleep(500); // 0.5 second stoppage at each floor
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Elevator has arrived at floor " + currentFloor);
                destinationFloors.remove(nextFloor);
            }
        }
                else {
                	System.out.println("invalid floor number");
                 }
              }
            }
         }
    }

    private Floor getNextFloor() {
        if (destinationFloors.isEmpty()) {
            return null;
        }

        Floor nextFloor = null;
        if (direction == Direction.UP) {
            for (Floor floor : destinationFloors) {
                if (floor.getFloorNumber() >= currentFloor) {
                    nextFloor = floor;
                    break;
                }
            }
        } else if (direction == Direction.DOWN) {
            for (Floor floor : destinationFloors) {
                if (floor.getFloorNumber() <= currentFloor) {
                    nextFloor = floor;
                    break;
                }
            }
        }

        if (nextFloor == null) {
            // Change direction if no floors in the current direction
            direction = (direction == Direction.UP) ? Direction.DOWN : Direction.UP;
            nextFloor = getNextFloor();
        }

        return nextFloor;
    }
}


