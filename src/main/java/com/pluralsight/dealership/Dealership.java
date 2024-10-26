package com.pluralsight.dealership;

import java.io.IOException;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private static List<Vehicle> inventory;


    public Dealership(String name, String address, String phone) throws IOException {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public static List<Vehicle> getVehicleByPrice(double min, double max) {
        // filtering and returned filtered

        return inventory ;
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model) {

        return inventory;
    }

    public List<Vehicle> getVehicleByYear(int min, int max) {

        return inventory ;
    }

    public List<Vehicle> getVehicleByColor(String color) {

        return inventory;
    }

    public List<Vehicle> getVehicleByMileage(double min, double max) {

        return inventory;
    }

    public List<Vehicle> getVehicleByType(String vehicleType) {

        return inventory;
    }

    public static List<Vehicle> getAllVehicles() throws IOException {

        List<Vehicle> allVehicle = DealershipFileManager.getCarInventory();
        int counter = 1;
        for (int i = 0; i < allVehicle.size(); i++){
            Vehicle vehicle = allVehicle.get(i);
            //UserInterface.displayVehicle(counter, vehicle);
            counter++;
        }

        return allVehicle;
    }

    public  List<Vehicle> addVehicle(Vehicle vehicle){

        return inventory;
    }

    public  List<Vehicle> removeVehicle(Vehicle vehicle){

        return inventory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
