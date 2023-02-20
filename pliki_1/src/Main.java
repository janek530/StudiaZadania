import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // Otwarcie pliku
        File plik = new File("plik.txt");
        File plik1 = new File("plik1.txt");
        File plik2 = new File("plik2.txt");
        PrintWriter pw1 = new PrintWriter(plik);
        PrintWriter pw2 = new PrintWriter(plik1);
        PrintWriter pw3 = new PrintWriter(plik2);

        Scanner skaner = new Scanner(plik);
        //Operacje na pliku
        for (int i = 0; i < 1000; i++) {
            int random = (int)(Math.random() * 50);
            pw1.println(random);
        }

        //zamkniecie pliku i zapisanie danych
        pw1.close();
        Scanner skaner2 = new Scanner(plik);

        int suma = 0;
        while(skaner.hasNextInt()){
            suma += skaner.nextInt();
        }
        int srednia = suma/1000;
        while(skaner2.hasNextInt()) {
            if (skaner2.nextInt() > srednia){
                pw2.println(skaner2.nextInt());
            }
            else pw3.println(skaner2.nextInt());
        }
        pw2.close();
        pw3.close();
        skaner.close();
        skaner2.close();



    }
}