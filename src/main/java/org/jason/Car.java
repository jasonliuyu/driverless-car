package org.jason;

public interface Car {

    void move(String command) throws Exception;

    void turnsClockwise();

    int getPositionX();

    int getPositionY();

    Orientation getOrientation();

    Park getPark();

    void showInPark();

    void initPosition(Park park);

}
