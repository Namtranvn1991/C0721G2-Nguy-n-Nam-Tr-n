package _16_io_text_file.exercise.copyFileText;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFileText {
    public List<String> readFile(String pathFile) {
        List<String> numbers = new ArrayList<>();

        try {
            File file = new File(pathFile);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                numbers.add(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("File isnt exist");
        }
        return numbers;
    }

    public List<Integer> readFileInt(String pathFile) {
        List<Integer> numbersInt = new ArrayList<>();

        try {
            File file = new File(pathFile);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (isStringInt(line)){
                    int number = Integer.parseInt(line);
                    numbersInt.add(number);
                } else {
                    continue;
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("File isnt exist");
        }
        return numbersInt;
    }


    public void writeFileAll(String pathFile, List<String> lists) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathFile,false));
//            bufferedWriter.write("");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathFile, true));
            for (String number : lists) {
                bufferedWriter.write(number);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeFileInt(String pathFile, List<Integer> lists) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathFile));
            bufferedWriter.write("");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathFile, true));
            for (int number : lists) {
                String n = number+"";
                bufferedWriter.write(n);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    static public boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
