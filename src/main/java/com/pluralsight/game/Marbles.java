package com.pluralsight.game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Marbles {

    static Random generator = new Random();
    private static int n = 13;
    private static int arraySize= 80;
    private static Scanner scanner = new Scanner(System.in);
    private static String marbles = " marbles";
    private static int aimove = 0;
    private static int playerMove;
    private static String playerName;
    private static BufferedWriter bufferedWriter;
    private static int[] aiMoveAt = new int[arraySize];
    private static int[] playerMoveAt = new int[arraySize];
    private static int aiMoveIndex = 0;
    private static int playerMoveIndex = 0;
    private static int aiMovesAmount = 0;
    private static int playerMovesAmount = 0;

    // TODO: track how many times a played
    // TODO: track ai wins
    // TODO: maybe add some art
    // TODO: second level, make amount of marbles 26

    public static int aiMove(int n){
        for(int i = 1; i<=3 ; i++){
            if((n - i) % 4 == 0){
                return i; //  m % x  = 0 , whataver m is do m - available marbl, then thats how much to substract
            }
        }
        return generator.nextInt(1, 3);
    }

    public static boolean checkValidInPut(int move){
        if (move > 0 && move <= 3){
            return true;
        }else {
            return false;
        }
    }

    public static int askInput(){
        System.out.print("You: ");
        playerMove = scanner.nextInt();// input is 1
        scanner.nextLine();
        return playerMove;
    }

    public static void playMarbles() throws IOException {
        System.out.println("\n        - Marbles game - " +
                "\nThere are 13 marbles at start on (easy mode), " +
                "\nyou can take 1 to 3 marbles per turn," +
                "\nwhoever takes the last marbles wins!");

        System.out.print("\nLevels: \n  1. Easy \n  2. Intermediate \n  3. Hard \n  4. You're insane \nYou: ");
        String level = scanner.nextLine();
        switch (level){
            case "1":

                break;
            case "2":
                n = 26;

                break;
            case "3":
                n = 52;

                break;
            case "4":
                n = 104;

                break;
            default:
                System.out.println("\n you start with  the wrong food, let's start easy mode");
                n = 13;
                break;
        }
        System.out.print("\nYour name: ");
        playerName = scanner.nextLine();



        while (n > 0 ){

            System.out.println("\nAvailable: " + n);

            do {
                playerMove = askInput();
            }while (checkValidInPut(playerMove) == false);
            //playerMove = askInput();
            playerMoveAt[playerMoveIndex] = playerMove;
            playerMoveIndex++;
            playerMovesAmount++;

            if(n - playerMove == 0){
                System.out.println( playerName + " you win!");
                n = 13;
                bufferedWriter = new BufferedWriter(new FileWriter("winners_list.txt", true));
                bufferedWriter.write("\n" + playerName + ", " + LocalDate.now() + ", " + playerMovesAmount +  ", [ " );
                for (int i = 0; i < playerMoveAt.length; i++){
                    if (aiMoveAt[i] != 0) {
                        bufferedWriter.write(playerMoveAt[i] + " ");
                    }
                }
                bufferedWriter.write("]");
                bufferedWriter.close();
                break;
            }


            n -= playerMove; // n = 12

            System.out.println("\nAvailable: " + n);

            aimove = aiMove(n);
            aiMoveAt[aiMoveIndex] = aimove;
            aiMoveIndex++;
            aiMovesAmount++;

            if(n - aimove == 0){
                System.out.println("Dex ex machina wins!");
                bufferedWriter = new BufferedWriter(new FileWriter("ai_wins.txt", true));
                bufferedWriter.write( "\n" + "ai wins over " + playerName + ", "+ LocalDate.now() + ", " + aiMovesAmount +  ", [" );
                for (int i = 0; i < aiMoveAt.length; i++){
                    if (aiMoveAt[i] != 0) {
                        bufferedWriter.write(aiMoveAt[i] + " ");
                    }
                }
                bufferedWriter.write("]");
                bufferedWriter.close();
                n = 13;
                break;
            }

            n -= aimove;
            if(aimove < 2) { marbles = " marble"; }
            // ai returns -1 n -> 11
            System.out.println("Dex ex machina: " + aimove);

        }
    }

    public static void main(String[] args) throws IOException {
        // int x = aiMove(11);
        // System.out.println(x);
        // print game rules
        // blablabla
        do {
            playMarbles();
            System.out.print("\nWanna play again? (y/n) ");
            String answer = scanner.nextLine();
            if(answer.equalsIgnoreCase("n")){
                System.out.println("\nYou suck!");
                break;
            }
        }while (true);
    }
}
