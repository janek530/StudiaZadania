import java.io.*;
import java.util.Scanner;

public class Main {
    static Scanner skaner = new Scanner(System.in);
    static int counter = 0;

    public static void main(String[] args) {
        dodajProdukt();
        przetwarzajPlik("dostawa.dat");
    }
    public static int przetwarzajPlik(String nazwaPliku) {
        String[] towary = new String[counter];
        double[] cena = new double[counter];
        int[] ilosc = new int[counter];
        try {
            FileInputStream fis = new FileInputStream("dostawa.dat");
            DataInputStream dis = new DataInputStream(fis);
            for (int i = 0; i < counter; i++) {
                towary[i] = dis.readUTF();
                cena[i] = dis.readDouble();
                ilosc[i] = dis.readInt();
                if (ilosc[i] > 100) {
                    cena[i] = cena[i] - (cena[i] * 0.1);
                }
            }
            dis.close(); fis.close();
            System.out.println("Wybierz produkt");
            for (int i = 0; i < counter; i++) {
                System.out.println((i+1) + ": " + towary[i]);
            }
            int wybranyProdukt = skaner.nextInt();
            while (wybranyProdukt < 0 || wybranyProdukt > counter){
                System.out.print("Podano nieprawidłową wartość, wpisz wartość jeszcze raz: ");
                wybranyProdukt = skaner.nextInt();
            }
            System.out.println("Wybrany Towar: " + towary[wybranyProdukt-1]  + ", a jego ilość wynosi: " + ilosc[wybranyProdukt-1]);
        }
        catch (FileNotFoundException e) {
            System.out.println("bład pliku");
        }

        catch (IOException e) {
            System.out.println("Błąd Odczytu");
        }
        try {
            FileOutputStream fos = new FileOutputStream("dostawa.dat");
            DataOutputStream dos = new DataOutputStream(fos);

            for (int i = 0; i < counter; i++) {
                dos.writeUTF(towary[i]);
                dos.writeDouble(cena[i]);
                dos.writeInt(ilosc[i]);
            }

            dos.close(); fos.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("bład pliku");
        }

        catch (IOException e) {
            System.out.println("Błąd Zapisu");
        }
        return 0;
    }

    public static void dodajProdukt() {
        try {
            FileOutputStream fos = new FileOutputStream("dostawa.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            while (true) {
                String nazwa = "";
                double cena;
                int ilosc;
                System.out.println("Czy chcesz dodać Produkt? <y/n>");
                char wybor = skaner.next().charAt(0);
                if (wybor == 'y') {
                    System.out.println("Podaj nazwe produktu: ");
                    while (nazwa.equals("")) {
                        nazwa = skaner.nextLine();
                    }
                    System.out.println("Podaj cene produktu: ");
                    cena = skaner.nextDouble();
                    System.out.println("Podaj ilość do zamowienia: ");
                    ilosc = skaner.nextInt();
                    System.out.println(nazwa + " " + cena + " " + ilosc);
                    dos.writeUTF(nazwa);
                    dos.writeDouble(cena);
                    dos.writeInt(ilosc);
                    counter += 1;
                } else break;
            }
            dos.close();
            fos.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Brak pliku");
        }
        catch (IOException e) {
            System.out.println("Błąd zapisu");
        }
    }
}
