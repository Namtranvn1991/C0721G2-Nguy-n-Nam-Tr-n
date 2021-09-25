package _16_io_text_file.exercise.read_file_csv;

import java.io.*;
import java.util.*;

public class ReadFileCsv {
    public static void main(String[] args) {
        File file = new File("src\\_16_io_text_file\\exercise\\readFileCsv\\file.csv");
        Set<Country> countries = new LinkedHashSet<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string = "";
            while ((string = bufferedReader.readLine())!=null){
                String[] strings = string.split(",");
                Country country = new Country(strings[1],strings[2]);
                countries.add(country);
                System.out.println(country);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
