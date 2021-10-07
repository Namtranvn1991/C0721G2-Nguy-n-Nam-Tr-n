package case_study.practice.service;

import case_study.practice.model.Film;
import case_study.practice.model.Showtime;
import case_study.practice.util.Input;
import case_study.practice.util.ReadShowtimeListAndWriteToCSV;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Service {
    private static ArrayList<Showtime> showtimeArrayList = ReadShowtimeListAndWriteToCSV.getShowtimeListFromCSV();
    static Scanner scanner = new Scanner(System.in);

    public static void add() {
        String id = Input.inputId();
        Film film = Input.inputFilm();
        Date release = Input.inputReleaseDate();
        int quantity = Input.inputQuantity();
        Showtime showtime = new Showtime(id, film, release, quantity);
        showtimeArrayList.add(showtime);
        ReadShowtimeListAndWriteToCSV.writeToCSV(showtimeArrayList);
    }

    public static void display() {

        for (Showtime showtime : showtimeArrayList) {
            System.out.println(showtime);
        }
    }

    public static void remove() {
        while (true) {
            display();
            System.out.println("Enter id to Remove 0. Return");
            String id = scanner.nextLine();
            if (id.equals("0")) {
                return;
            }
            for (Showtime showtime : showtimeArrayList) {
                if (showtime.getId().equals(id)) {
                    System.out.println(showtime);
                    System.out.println("Do U want to remove this Y/N");
                    String choice = scanner.nextLine();
                    switch (choice) {
                        case "Y":
                        case "y":
                            showtimeArrayList.remove(showtime);
                            ReadShowtimeListAndWriteToCSV.writeToCSV(showtimeArrayList);
                            return;
                        default:
                            return;
                    }
                }
            }
            System.out.println(id + " doest exist");
        }
    }
}
