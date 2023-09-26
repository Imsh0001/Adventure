public class Adventure {
    private Room currentRoom;

    public Adventure() {
        Room room1 = new Room("Room 1", "A room with no distinct features, except two doors.");
        Room room2 = new Room("Room 2", "A room with a large painting on the wall.");
        // ... (opret de andre rum)

        room1.setEast(room1);
        room2.setWest(room2);
        // ... (forbind de andre rum)

        currentRoom = room1;
    }

    public void move(String direction) {
        Room nextRoom = null;
        switch (direction) {
            case "north", "n":
                nextRoom = currentRoom.getNorth();
                break;
            case "east", "e":
                nextRoom = currentRoom.getEast();
                break;
            case "south", "s":
                nextRoom = currentRoom.getSouth();
                break;
            case "west", "w":
                nextRoom = currentRoom.getWest();
                break;
            default:
                System.out.println("Invalid direction!");
                break;
        }

        if (nextRoom != null) {
            currentRoom = nextRoom;
            System.out.println("You are now in " + currentRoom.getName() + "\n" + currentRoom.getDescription());
        } else {
            System.out.println("You cannot go that way.");
        }
    }

    public void lookAround() {
        System.out.println("You are in " + currentRoom.getName() + "\n" + currentRoom.getDescription());
    }
}


