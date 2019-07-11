package org.jason;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please configure the parking xlength:");
        Integer xlength = Integer.parseInt(scanner.nextLine());
        System.out.println("Please configure the parking ylength:");
        Integer ylength = Integer.parseInt(scanner.nextLine());
        Park park = new Park(xlength, ylength);
        Car car = new Auto();
        car.initPosition(park);
        while(true){
            try {
                System.out.println("Enter w forward, t clockwise: ");
                String command = scanner.nextLine();
                car.move(command);
            }catch (Exception e){
                e.printStackTrace();
                continue;
            }

        }

    }


}
