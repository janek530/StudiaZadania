import java.util.Scanner;
public class Macierze {
    static Scanner skaner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Wyznacznik macierzy jest równy: " + obliczWyznacznikMacierzy2(new double[2][2]));
        System.out.println("wyznacznik macierzy jest równy: " + obliczWyznacznikMacierzy3(new double[3][3]));
    }
    public static double obliczWyznacznikMacierzy2(double [][] t) {
        double wyznacznik;
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t.length; j++) {
                System.out.println("Podaj " + i + " " + j + " element tablicy: ");
                t[i][j] = skaner.nextDouble();
            }
        }
            wyznacznik = (t[0][0]*t[1][1])-(t[0][1]*t[1][0]);
        return wyznacznik;
    }

    public static double obliczWyznacznikMacierzy3(double [][] t) {
        double wyznacznik;
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t.length; j++) {
                System.out.println("Podaj " + i + " " + j + " element tablicy: ");
                t[i][j] = skaner.nextDouble();
            }
        }
        wyznacznik = ((t[0][0]*t[1][1]*t[2][2])+(t[1][0]*t[2][1]*t[0][2])+(t[2][0]*t[0][1]*t[1][2]))-((t[0][2]*t[1][1]*t[2][0])+(t[1][2]*t[2][1]*t[0][0])+(t[2][2]*t[0][1]*t[1][0]));
        return wyznacznik;
    }
}