package com.pluralsight.dealership;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static int counter = 1;
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean isInFile = true;

    public static void displayVehicle(int counter, Vehicle vehicle){
        System.out.print("\n\n----- Vehicle " + counter + " -----" +
                "\n vin: " + vehicle.getVin() +
                "\n year: " + vehicle.getYear() +
                "\n make: " +  vehicle.getMake() +
                "\n model: " + vehicle.getModel() +
                "\n vehicle type: " + vehicle.getVehicleType() +
                "\n color: " + vehicle.getColor() +
                "\n odometer: " + vehicle.getOdometer() +
                "\n price: " + vehicle.getPrice() );
    }

    public static void removeVehicle() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("inventory.txt"));
        List<Vehicle> vehiclesInventory = Dealership.getAllVehicles();
        List<Vehicle> newCarInventory = new ArrayList<>();
        System.out.print("Please enter vin # of vehicle to delete: ");
        String vin = scanner.nextLine().trim();
//        if(vehiclesInventory.get(0).getVin().equalsIgnoreCase(vin)){
//            System.out.println("Vin #" + vehiclesInventory.getFirst().getVin() + " has been deleted");
//        }else {
//            System.out.println("Vin #" + vin + " is not in the data base");
//        }

        for (Vehicle vehicle : vehiclesInventory){
            if (!vehicle.getVin().equals(vin)) {
//                System.out.println("Vehicle with vin #" + vin + " does not exist in database");
                isInFile = false;

            }else {
                isInFile = true;
            }
        }

        if (!isInFile){
            System.out.println("Vehicle with vin #" + vin + " not found in database");
        }

        if(isInFile){ // check vin # match
            for (Vehicle vehicle : vehiclesInventory){
                if(!vehicle.getVin().equalsIgnoreCase(vin)){
                    newCarInventory.add(vehicle);
                }
            }

            bufferedWriter.write("D & B Used Cars|111 Old Benbrook Rd|817-555-5555");
            for(Vehicle vehicle : newCarInventory){
                Vehicle car = new Vehicle(vehicle.getVin(),vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                        vehicle.getVehicleType() ,vehicle.getColor() , vehicle.getOdometer(), vehicle.getPrice() );

                bufferedWriter.write("\n" + car.getVin() + "|" + car.getYear() + "|" + car.getMake() + "|" +
                        car.getModel() + "|" + car.getVehicleType() + "|" + car.getColor() + "|" + car.getOdometer() + "|" +
                        car.getPrice());
            }
            System.out.println("Vehicle with vin #" + vin + " has been deleted from database");
            bufferedWriter.close();

        }
        /*
            // Testing if it is not adding the unwanted vehicle to our new array
            for (int i = 0; i < newCarInventory.size(); i++) {
            System.out.println(newCarInventory.get(i).toString());
            }
        */

    }

    public static void addVehicle() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("cars_inventory.txt", true));
        System.out.println("\nEnter the following below ⬇️");
        System.out.print("\nvin: ");
        String vin = scanner.nextLine();
        System.out.print("year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("make: ");
        String make = scanner.nextLine();
        System.out.print("model: ");
        String model = scanner.nextLine();
        System.out.print("type: ");
        String vehicleType = scanner.nextLine();
        System.out.print("color: ");
        String color = scanner.nextLine();
        System.out.print("odometer: ");
        int odometer = scanner.nextInt();
        System.out.print("price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        bufferedWriter.write("\n" + vin + "|"+ year + "|"+ make + "|"+ model + "|"+ vehicleType + "|" + color + "|" + odometer + "|"+ price);
        bufferedWriter.close();
        System.out.println("\n* You added a new vehicle successfully *");

    }

    public static void listAll() throws IOException {
        List<Vehicle> vehicles = Dealership.getAllVehicles();
        for (Vehicle value : vehicles) {
            displayVehicle(counter, value);
            counter++;
        }
    }

    public static void findType() throws IOException {
        List<Vehicle> vehicles = Dealership.getAllVehicles();
        System.out.print("\nWhat type: ");
        String type = scanner.nextLine();
        for (Vehicle car : vehicles) {
            if(car.getVehicleType().equalsIgnoreCase(type)){
                displayVehicle(counter, car);
                counter++;
            }
        }
    }

    public static void findMileageRange() throws IOException {
        List<Vehicle> vehicles = Dealership.getAllVehicles();
        System.out.print("\nMinimum miles: ");
        double minYear = scanner.nextDouble();
        System.out.print("Maximum miles: ");
        double maxYear = scanner.nextDouble();

        for (Vehicle car : vehicles) {
            if(car.getOdometer() >= minYear && car.getOdometer() <= maxYear){
                displayVehicle(counter, car);
                counter++;
            }
        }

    }

    public static void findColor() throws IOException {
        List<Vehicle> vehicles = Dealership.getAllVehicles();
        System.out.print("\nColor of choice: ");
        String color = scanner.nextLine();
        for (Vehicle car : vehicles) {
            if(car.getColor().equalsIgnoreCase(color)){
                displayVehicle(counter, car);
                counter++;
            }
        }
    }

    public static void findYearRange() throws IOException {
        List<Vehicle> vehicles = Dealership.getAllVehicles();
        System.out.print("\nMinimum year: ");
        double minYear = scanner.nextDouble();
        System.out.print("Maximum year: ");
        double maxYear = scanner.nextDouble();

        for (Vehicle car : vehicles) {
            if(car.getYear() >= minYear && car.getYear() <= maxYear){
                displayVehicle(counter, car);
                counter++;
            }
        }
    }

    public static boolean quit() {
        return false;
    }

    public static void findPriceRange() throws IOException {
        List<Vehicle> vehicles = Dealership.getAllVehicles();
        System.out.print("\nMinimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Maximum price: ");
        double maxPrice = scanner.nextDouble();

        for (Vehicle car : vehicles) {
            if(car.getPrice() >= minPrice && car.getPrice() <= maxPrice){
                displayVehicle(counter, car);
                counter++;
            }
        }

    }

    public static void findMakeModel() throws IOException {
        List<Vehicle> vehicles = Dealership.getAllVehicles();
        System.out.print("\nMake: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        for (Vehicle car : vehicles) {
            if(car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model)){
                displayVehicle(counter, car);
                counter++;
            }
        }
    }
}
