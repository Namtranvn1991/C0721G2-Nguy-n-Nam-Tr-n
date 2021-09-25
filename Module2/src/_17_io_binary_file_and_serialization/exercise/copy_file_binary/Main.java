package _17_io_binary_file_and_serialization.exercise.copy_file_binary;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        src\_17_io_binary_file_and_serialization\exercise\copyFileBinary\sourceFile.dat
//        src\_17_io_binary_file_and_serialization\exercise\copyFileBinary\targetFile.dat
        Scanner scanner = new Scanner(System.in);
        System.out.println("input source File");
        String sourceFile = scanner.nextLine();
        System.out.println("input target File");
        String targetFile = scanner.nextLine();
        CopyFile.writeToFile(sourceFile,targetFile);
    }
}
