package case_study.practice.util;

import case_study.homework2.model.Customer;
import case_study.practice.model.Film;
import case_study.practice.model.Showtime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Film> films = ReadFilmListFromCSV.getFilmsFromCSV();
    private static ArrayList<Showtime> showtimeArrayList = ReadShowtimeListAndWriteToCSV.getShowtimeListFromCSV();

    public static String inputId() {
        while (true) {
            System.out.println("Enter ID");
            String id = scanner.nextLine();
            boolean flag = true;
            if (validateId(id)) {
                for (Showtime showtime : showtimeArrayList) {
                    if (showtime.getId().equals(id)) {
                        flag = false;
                    }
                }
                if (flag) {
                    return id;
                } else {
                    System.out.println("Id does exist. Enter again");
                }
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static Film inputFilm() {
        while (true) {
            for (Film f : films) {
                System.out.println(f);
            }
            System.out.println("Enter film");
            String filmName = scanner.nextLine();
            for (Film f : films) {
                if (f.getName().equals(filmName)) {
                    return f;
                }
            }
            System.out.println("Film: " + filmName + "doest exist. Enter again");
        }
    }

    public static Date inputReleaseDate() {
        while (true) {
            System.out.println("Enter Release Date (dd/MM/yyyy) ");
            String releaseDate = scanner.nextLine();
            if (validateJavaDate(releaseDate)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    return simpleDateFormat.parse(releaseDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Please enter release Date again");
            }
        }
    }

    public static int inputQuantity() {
        while (true) {
            System.out.println("Enter Quantity");
            String quantity = scanner.nextLine();
            if (isStringIntPositiveNumbers(quantity)) {
                return Integer.parseInt(quantity);
            } else {
                System.out.println("Enter again");
            }
        }
    }


    public static boolean validateId(String id) {
        String regex = "CI-\\d{4}";
        return id.matches(regex);
    }

    static public boolean isStringIntPositiveNumbers(String s) {
        try {
            if (Integer.parseInt(s) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean validateJavaDate(String strDate) {
        if (strDate.trim().equals("")) {
            return false;
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            simpleDateFormat.setLenient(false);
            try {
                Date javaDate = simpleDateFormat.parse(strDate);
                LocalDate localDate = LocalDate.now();
                Date now = java.sql.Date.valueOf(localDate);
                if (javaDate.compareTo(now) < 0) {
                    System.out.println("today: " + localDate);
                    return false;
                }
                System.out.println(strDate + " is valid date format");
            } catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
                return false;
            }
            return true;
        }
    }

}
