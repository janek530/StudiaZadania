import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Macierze {
    static Random random = new Random();
    static Scanner skaner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
        System.out.println("Wybierz opcje z menu: ");
        int menu = skaner.nextInt();
        switch (menu){
            case 1 -> {
                System.out.println("Podaj ilość kolumn");
                int kolumna = skaner.nextInt();
                System.out.println("Podaj ilość wierszy");
                int wiersz = skaner.nextInt();
                System.out.println("Podaj minimalna liczbe z zakresu");
                int min = skaner.nextInt();
                System.out.println("Podaj maksymalna liczbe z zakresu");
                int max = skaner.nextInt();
                int [][] tablica = (wypelnijTablcie(kolumna, wiersz, min, max));
                for (int[] ints : tablica) {
                    System.out.println(Arrays.toString(ints));
                }
            }
            case 2 -> {
                System.out.println("Podaj ilość kolumn");
                int kolumna = skaner.nextInt();
                System.out.println("Podaj ilość wierszy");
                int wiersz = skaner.nextInt();
                int [][] tablica = (wypelnijJedynkami(kolumna, wiersz));
                for (int[] ints : tablica) {
                    System.out.println(Arrays.toString(ints));
                }
            }
            case 3 -> {
                System.out.println("Podaj ilość kolumn");
                int kolumna = skaner.nextInt();
                System.out.println("Podaj ilość wierszy");
                int wiersz = skaner.nextInt();
                int[][] tablica = (transponujTablice1(kolumna, wiersz));
                for (int[] ints : tablica) {
                    System.out.println(Arrays.toString(ints));
                }
            }
            case 4 -> {

                System.out.println("Podaj ilość kolumn");
                int kolumna = skaner.nextInt();
                System.out.println("Podaj ilość wierszy");
                int wiersz = skaner.nextInt();
                if (kolumna == wiersz) {
                    int[][] tablica = (transponujTablice2(kolumna, wiersz));
                    for (int[] ints : tablica) {
                        System.out.println(Arrays.toString(ints));
                    }
                }
                else{
                    int[][] tablica = null;
                    System.out.println(tablica);
                }
            }
            case 5 -> {
                System.out.println("Podaj pierwszą tablice:");
                System.out.println("Podaj ilość kolumn");
                int kolumnaA = skaner.nextInt();
                System.out.println("Podaj ilość wierszy");
                int wierszA = skaner.nextInt();
                int[][] tablicaA = wpiszMacierz(kolumnaA, wierszA);
                System.out.println("Podaj drugą tablice:");
                System.out.println("Podaj ilość kolumn");
                int kolumnaB = skaner.nextInt();
                System.out.println("Podaj ilość wierszy");
                int wierszB = skaner.nextInt();
                int[][] tablicaB = wpiszMacierz(kolumnaB, wierszB);
                if (wierszA == kolumnaB) {
                    int[][] tablica = mnozenieMacierzy(tablicaA, tablicaB);
                    for (int[] ints : tablica) {
                        System.out.println(Arrays.toString(ints));
                    }
                }
                else{
                    System.out.println("Macierze nie spełniają warunku mnożenia.");
                }
            }
        }
    }

    public static void menu() {
        System.out.println("1. Wypełnij tablice \n2. Wypełnij tablice z jedynkami \n3. Transponuj tablice \n4. Transponuj tablice [kwadratowa] \n5. Mnożenie macierzy ");
    }

    public static int[][] wypelnijTablcie(int kolumna, int wiersz, int min, int max) {
        int[][] tablica = new int[kolumna][wiersz];
        for (int i=0; i<tablica.length; i++){
            for (int j=0; j<tablica[i].length; j++) {
                tablica[i][j] = random.nextInt(min,max+1);
            }
        }
        return tablica;
    }

    public static int[][] wypelnijJedynkami(int kolumna, int wiersz) {
        int[][] tablica = new int[kolumna][wiersz];
        for (int i=0; i<tablica.length; i++){
            for (int j=0; j<tablica[i].length; j++) {
                if (i == j || tablica.length-i-1 == j) {
                    tablica[i][j] = 1;
                }
                else tablica[i][j] = 0;
            }
        }
        return tablica;
    }

    public static int[][] transponujTablice1(int kolumna, int wiersz) {
        int [][] tablica = wpiszMacierz(kolumna, wiersz);
        int [][] tablicaT = new int[wiersz][kolumna];
        for (int i=0; i<tablica.length; i++) {
            for (int j=0; j<tablica[i].length; j++) {
                tablicaT[j][i] = tablica[i][j];
            }
        }
        return tablicaT;
    }

    public static int[][] transponujTablice2(int kolumna, int wiersz) {
        int[][] tablica = wpiszMacierz(kolumna, wiersz);
        int temp;
        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < i; j++) {
                temp = tablica[i][j];
                tablica[i][j] = tablica[j][i];
                tablica[j][i] = temp;
            }
        }
        return tablica;
    }
    public static int[][] wpiszMacierz(int kolumn, int wiersz){
        int[][] tablica = new int[kolumn][wiersz];
        for (int i=0; i<tablica.length; i++) {
            for (int j=0; j<tablica[i].length; j++) {
                System.out.print("Podaj [" + (i+1) + ":" + (j+1) + "] element tablicy: ");
                tablica[i][j] = skaner.nextInt();
            }
        }
        return tablica;
    }

    public static int[][] mnozenieMacierzy(int[][] macierzA, int[][] macierzB){
        int[][] macierzC = new int[macierzB.length][macierzA.length];
        int sum = 0;
        for (int k=0; k<macierzC.length; k++) {
            for (int i = 0; i < macierzC.length; i++) {
                for (int j = 0; j < macierzC[i].length; j++) {
                    sum += macierzA[k][j]*macierzB[j][i];
                }
                macierzC[k][i] += sum;
                sum = 0;
            }
        }
        return macierzC;
    }
}
