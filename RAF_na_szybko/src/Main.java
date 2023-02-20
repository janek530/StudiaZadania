import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        wpisz();
        oblicz();
        odczytaj();
    }

    public static void wpisz() {
        String nazwa = "", lokalizacja = "";
        int liczbaKondygnacji, choice;
        double cena;
        char helper;

        try {
            RandomAccessFile file = new RandomAccessFile("domy.dat", "rw");
            file.seek(file.length());
            while (true) {
                Scanner skaner = new Scanner(System.in);
                while (nazwa.equals("")) {
                    System.out.print("Podaj nazwe domu: ");
                    nazwa = skaner.nextLine();
                }
                System.out.print("Podaj liczbe Kondygnacji: ");
                liczbaKondygnacji = skaner.nextInt();
                System.out.print("Podaj cene Domu: ");
                cena = skaner.nextDouble();
                System.out.println("Podaj lokalizacje domu: \n 1. wies \n 2. miasto");
                choice = skaner.nextInt();
                switch (choice) {
                    case 1 -> lokalizacja = "wies";
                    case 2 -> lokalizacja = "miasto";
                }

                file.writeUTF(nazwa);
                file.writeInt(liczbaKondygnacji);
                file.writeDouble(cena);
                file.writeUTF(lokalizacja);
                System.out.println("Upload succesful");

                System.out.println("Czy chcesz dodac jeszcze jeden dom? (Y/N)");
                helper = skaner.next().charAt(0);
                if (helper == 'Y' || helper == 'y') {
                    nazwa = "";
                    lokalizacja = "";
                } else break;
            }
            file.close();
        } catch (Exception e) {
            System.out.println("Bład odczytu, zapisu pliku, lub niepoprawny format");
        }
    }

    public static void oblicz() {
        long pozition;
        double cena;
        int liczbaKondygnacji;
        try {
            RandomAccessFile file = new RandomAccessFile("domy.dat", "rw");
            while (true) {
                try {
                    file.readUTF();
                    liczbaKondygnacji = file.readInt();
                    if (liczbaKondygnacji == 1) {
                        pozition = file.getFilePointer();
                        cena = file.readDouble();
                        if (file.readUTF().equals("wies")) {
                            file.seek(pozition);
                            cena *= 0.9;
                            file.writeDouble(cena);
                            file.readUTF();
                        } else
                            file.readUTF();
                    } else {
                        file.readDouble();
                        file.readUTF();
                    }
                } catch (Exception e){
                    break;
                }
            }
            file.close();
        }
        catch (Exception e) {
            System.out.println("Bład odczytu, zapisu pliku, lub niepoprawny format");
        }
    }

    public static void odczytaj() {
        try {
            RandomAccessFile file = new RandomAccessFile("domy.dat", "r");
            while (true) {
                System.out.println(file.readUTF());
                System.out.println(file.readInt());
                System.out.println(file.readDouble());
                System.out.println(file.readUTF());
            }
        }
        catch(Exception e){
            System.out.println("Koniec pliku");
        }
    }
}
