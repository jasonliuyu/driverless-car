package org.jason;

public class Orientation {

    public static final Orientation WEAT;

    public static final Orientation EAST;

    public static final Orientation NORTH;

    public static final Orientation SOUTH;

    private String value;

    static {
        WEAT = new Orientation("weat");
        EAST = new Orientation("east");
        NORTH = new Orientation("north");
        SOUTH = new Orientation("south");
    }

    private Orientation(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
