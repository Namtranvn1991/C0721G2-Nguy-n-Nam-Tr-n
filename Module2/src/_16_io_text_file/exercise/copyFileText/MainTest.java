package _16_io_text_file.exercise.copyFileText;

import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        CopyFileText copyFileText = new CopyFileText();
        List<String> list = copyFileText.readFile("src\\_16_io_text_file\\exercise\\copyFileText\\sourceFile.dat");
        copyFileText.writeFileAll("src\\_16_io_text_file\\exercise\\copyFileText\\targetFile.dat",list);

        List<Integer> list1 = copyFileText.readFileInt("src\\_16_io_text_file\\exercise\\copyFileText\\sourceFile.dat");
        copyFileText.writeFileInt("src\\_16_io_text_file\\exercise\\copyFileText\\intFile.text",list1);

        System.out.println(list1);
    }
}
