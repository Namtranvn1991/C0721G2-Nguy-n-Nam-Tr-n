package case_study.practice.util;


import case_study.homework2.model.CustomerType;
import case_study.practice.model.Film;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFilmListFromCSV {
    private final static String BRAND_PATH = "src\\case_study\\practice\\data\\FilmList.csv";
    private static ArrayList<Film> films = getFilmsFromCSV();

    public static ArrayList<Film> getFilms() {
        return films;
    }

    public static ArrayList<Film> getFilmsFromCSV() {
        ArrayList<Film> films = new ArrayList<>();
        File file = new File(BRAND_PATH);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";
            String[] array = null;
            String[] arrayDate = null;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                String name = array[0];
                Film film = new Film(name);
                films.add(film);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        } catch (Exception e) {
            //do nothing
        }
        return films;
    }
}
