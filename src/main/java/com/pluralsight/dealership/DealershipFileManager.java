package com.pluralsight.dealership;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class DealershipFileManager {

    public static List<Vehicle> getCarInventory() throws IOException {
        List<Vehicle> inventory = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("cars_inventory.txt"));
        bufferedReader.readLine();
        String line;
        while ((line = bufferedReader.readLine()) != null){
            String[] car = line.split(Pattern.quote("|"));
            Vehicle vehicle = new Vehicle(car[0], Integer.parseInt(car[1]), car[2], car[3], car[4], car[5], Integer.parseInt(car[6]), Double.parseDouble(car[7]));
            inventory.add(vehicle);
        }
     return inventory;
    }

    public static Dealership getDealership() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("cars_inventory.txt"));

        String line = bufferedReader.readLine();

        String[] dealer = line.split(Pattern.quote("|"));

        return new Dealership(dealer[0], dealer[1],dealer[2] );
    }
}
