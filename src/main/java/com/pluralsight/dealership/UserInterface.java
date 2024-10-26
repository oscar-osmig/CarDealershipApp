package com.pluralsight.dealership;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static int counter = 1;
    private static final Scanner scanner = new Scanner(System.in);

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

    public static void removeVehicle() {
       //List<Vehicle> vehicles = Dealership.getVehicleByPrice();
    }

    public static void addVehicle() {
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
