import java.io.*;
import java.util.*;

public class Main {
    static int suma = 0, srednia;
    public static void main(String[] args) throws FileNotFoundException {

        wpisz();
        srednia = suma/1000;
        System.out.println(srednia);
        sprawdz();
    }

    public static void wpisz() throws FileNotFoundException {

    int random_number = 0;
    Random rand = new Random();
    File plik = new File("plik.txt");
    PrintWriter wpisz = new PrintWriter(plik);
        for (int i = 1; i <= 1000; i++){
            random_number = rand.nextInt(1, 100);
            wpisz.println(random_number);
            suma += random_number;
        }
    wpisz.close();
    }

    public static void sprawdz() throws FileNotFoundException {
        File plik = new File("plik.txt");
        File wieksze = new File("wieksze.txt");
        File mniejsze = new File("mniejsze.txt");
        PrintWriter wiekszeW = new PrintWriter(wieksze);
        PrintWriter mniejszeW = new PrintWriter(mniejsze);
        Scanner skaner = new Scanner(plik);
        int liczba = 0;
        while (skaner.hasNext()) {
            liczba = Integer.parseInt(skaner.next());
            if (liczba < srednia) {
                mniejszeW.println(liczba);
            }
            else wiekszeW.println(liczba);
        }
        wiekszeW.close();
        mniejszeW.close();
    }
}
