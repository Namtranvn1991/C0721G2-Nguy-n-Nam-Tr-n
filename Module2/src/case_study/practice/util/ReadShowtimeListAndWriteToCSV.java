package case_study.practice.util;


import case_study.homework2.model.Customer;
import case_study.homework2.model.Receipt;
import case_study.homework2.util.ReadCustomerListAndWriteToCSV;
import case_study.practice.model.Film;
import case_study.practice.model.Showtime;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class ReadShowtimeListAndWriteToCSV {
    static final String RECEIPT_PATH = "src\\case_study\\practice\\data\\ShowtimeList.csv";
    static ArrayList<Film> films = ReadFilmListFromCSV.getFilmsFromCSV();

    public static void writeToCSV(ArrayList<Showtime> showtimeList){
        File file = new File(RECEIPT_PATH);
        try {
            FileWriter fileWriter = new FileWriter(file,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Showtime showtime : showtimeList){
                bufferedWriter.write(showtime.toStringToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Showtime> getShowtimeListFromCSV(){
        ArrayList<Showtime> showtimeList = new ArrayList<>();
        File file = new File(RECEIPT_PATH);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line="";
            String[] array =null;
            String[] arrayDate =null;
            Film film = null;
            while ((line=bufferedReader.readLine())!=null){
                array = line.split(",");
                String id = array[0];
                String filmName = array[1];
                for (Film f:films) {
                    if(f.getName().equals(filmName)){
                        film = f;
                    }
                }
                arrayDate = array[2].split("/");
                Date date = new Date(Integer.parseInt(arrayDate[2])-1990,Integer.parseInt(arrayDate[1])-1,Integer.parseInt(arrayDate[0]));
                int quantity = Integer.parseInt(array[3]);
                Showtime showtime = new Showtime(id,film,date,quantity);
                showtimeList.add(showtime);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        } catch (Exception e){
            //do nothing
        }
        return showtimeList;
    }
}
