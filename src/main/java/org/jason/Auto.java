package org.jason;


public class Auto implements Car {

    private Park park;

    private int positionX;

    private int positionY;

    private Orientation orientation;


    @Override
    public synchronized void move(String command) throws Exception {
        if ("w".equals(command)) {
            this.moveForward();
        } else if ("t".equals(command)) {
            this.turnsClockwise();
        }
        this.showInPark();
    }

    @Override
    public synchronized void turnsClockwise() {
        if (this.orientation == Orientation.EAST) {
            this.orientation = Orientation.SOUTH;
        } else if (this.orientation == Orientation.SOUTH) {
            this.orientation = Orientation.WEAT;
        } else if (this.orientation == Orientation.WEAT) {
            this.orientation = Orientation.NORTH;
        } else if (this.orientation == Orientation.NORTH) {
            this.orientation = Orientation.EAST;
        }
    }


    public synchronized void moveForward() throws Exception {
        if (this.orientation == Orientation.EAST) {
            if (this.positionX + 1 > this.park.getXlength()) {
                throw new Exception("can not move forward!");
            }
            this.positionX++;
        } else if (this.orientation == Orientation.SOUTH) {
            if (this.positionY - 1 < 1) {
                throw new Exception("can not move forward!");
            }
            this.positionY--;
        } else if (this.orientation == Orientation.WEAT) {
            if (this.positionX - 1 < 1) {
                throw new Exception("can not move forward!");
            }
            this.positionX--;
        } else if (this.orientation == Orientation.NORTH) {
            if (this.positionY + 1 > this.park.getYlength()) {
                throw new Exception("can not move forward!");
            }
            this.positionY++;
        }
    }


    @Override
    public int getPositionX() {
        return this.positionX;
    }

    @Override
    public int getPositionY() {
        return this.positionY;
    }

    @Override
    public Orientation getOrientation() {
        return this.orientation;
    }

    @Override
    public void showInPark() {
        System.out.println("==========================================================");
        System.out.println("(Y)");
        for (int x = 1; x <= this.park.getXlength(); x++) {
            if (x == 1) {
                System.out.print(" ");
            }
            System.out.print("+---");
        }
        System.out.println("+");//←↑→↓
        for (int i = this.park.getYlength(); i > 0; i--) {
            System.out.print(i);
            for (int j = 1; j <= this.park.getXlength(); j++) {
                if (this.positionX == j && this.positionY == i) {
                    if (this.orientation == Orientation.EAST) {
                        System.out.print("| → ");
                    } else if (this.orientation == Orientation.WEAT) {
                        System.out.print("| ← ");
                    } else if (this.orientation == Orientation.NORTH) {
                        System.out.print("| ↑ ");
                    } else if (this.orientation == Orientation.SOUTH) {
                        System.out.print("| ↓ ");
                    }
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
            for (int x = 1; x <= this.park.getXlength(); x++) {
                if (x == 1) {
                    System.out.print(" ");
                }
                System.out.print("+---");
            }
            System.out.println("+");
        }
        for (int x = 1; x <= this.park.getXlength(); x++) {
            System.out.print("   " + x);
        }
        System.out.println("   (X)");
    }

    @Override
    public Park getPark() {
        return this.park;
    }

    @Override
    public void initPosition(Park park) {
        this.park = park;
        this.orientation = Orientation.NORTH;
        this.positionX = 1;
        this.positionY = 1;
        this.showInPark();
    }
}
