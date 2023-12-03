package Tutorium6;
/*

 Übernommen von meinem Kommilitonen Mark

 */
public abstract class Room {
    protected Room nextRoom1;
    protected Room nextRoom2;
    protected Room nextRoom3;

    public void setNextRooms(Room nextRoom1, Room nextRoom2, Room nextRoom3) {
        this.nextRoom1 = nextRoom1;
        this.nextRoom2 = nextRoom2;
        this.nextRoom3 = nextRoom3;
    }
    public void setNextRooms(Room nextRoom1, Room nextRoom2) {
        this.nextRoom1 = nextRoom1;
        this.nextRoom2 = nextRoom2;
    }
    public void setNextRoom(Room nextRoom1) { this.nextRoom1 = nextRoom1; }

    public abstract void enter();
}