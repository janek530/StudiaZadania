import java.util.Arrays;
import java.util.Scanner;

public class Wyznacznik {
    public static void main(String[] args) {
        Scanner skaner = new Scanner(System.in);
        double [][] macierz3 = new double[3][3];
        double [][] macierz2 = new double[2][2];
        System.out.println("Podaj parametry tablicy 3x3");
        for (int i = 0; i < macierz3.length; i++) {
            for (int j = 0; j < macierz3[i].length; j++) {
                System.out.print("Podaj [" + (i+1) + ":" + (j+1)  + "] element tablicy: ");
                macierz3[i][j] = skaner.nextDouble();
            }
        }
        for (double[] doubles : macierz3) {
            System.out.println(Arrays.toString(doubles));
        }

        System.out.println("Podaj parametry tablicy 2x2");
        for (int i = 0; i < macierz2.length; i++) {
            for (int j = 0; j < macierz2[i].length; j++) {
                System.out.print("Podaj [" + (i+1) + ":" + (j+1) + "] element tablicy: ");
                macierz2[i][j] = skaner.nextDouble();
            }
        }

        for (double[] doubles : macierz2) {
            System.out.println(Arrays.toString(doubles));
        }
        double wyznacznik = 0;
        wyznacznik = macierz2[0][0]*macierz2[1][1]-macierz2[0][1]*macierz2[1][0];
        System.out.println("Wyznacznik jest równy: " + wyznacznik);
        wyznacznik = 0;
        wyznacznik = ((macierz3[0][0]*macierz3[1][1]*macierz3[2][2])+(macierz3[1][0]*macierz3[2][1]*macierz3[0][2])+(macierz3[2][0]*macierz3[0][1]*macierz3[1][2]))-((macierz3[0][2]*macierz3[1][1]*macierz3[2][0])+(macierz3[1][2]*macierz3[2][1]*macierz3[0][0])+(macierz3[2][2]*macierz3[0][1]*macierz3[1][0]));
        for (int i = 0; i< macierz3.length; i++)
            System.out.println(Arrays.toString(macierz3[i]));
        System.out.println("Wyznacznik jest równy: " + wyznacznik);
    }
}