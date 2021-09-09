package test;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Scanner;

public class Spiral {
    final static int GO_RIGHT = 0;
    final static int GO_DOWN = 1;
    final static int GO_LEFT = 2;
    final static int GO_UP = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] spiralMatrix = new int[n][n];

        int input = 1;
        int i = 0, j = 0;
        int go = GO_RIGHT;

        do {
            spiralMatrix[i][j] = input;
//            System.out.printf("(%s-%s,%s) %s \n", input, i, j, number);
            input++;
            if (go == GO_RIGHT && (i + j) == (n - 1)) {
                go = GO_DOWN;
            } else if (go == GO_DOWN && i == j) {
                go = GO_LEFT;
            } else if (go == GO_LEFT && (i + j) == (n - 1)) {
                go = GO_UP;
            } else if (go == GO_UP && i - j == 1) {
                go = GO_RIGHT;
            }
            switch (go) {
                case GO_RIGHT:
                    j++;
                    break;
                case GO_DOWN:
                    i++;
                    break;
                case GO_LEFT:
                    j--;
                    break;
                case GO_UP:
                    i--;
                    break;
            }
        } while (input <= (Math.pow(n, 2)));
        for (int a = 0; a < spiralMatrix.length; a++) {
            for (int b = 0; b < spiralMatrix[a].length; b++) {
                System.out.printf("%-4s", spiralMatrix[a][b]);
            }
            System.out.println("");
        }
    }
}

