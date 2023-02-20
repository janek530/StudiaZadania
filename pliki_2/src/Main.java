import java.io.*;

public class Main {
    public static void main(String[] args){
        try {
            FileOutputStream fos = new FileOutputStream("obiekty.dat");
            DataOutputStream out = new DataOutputStream(fos);

            String n1 = "Napis testowy";
            out.writeUTF(n1);

            int liczba1 = 10;
            out.writeInt(liczba1);

            double d1 = 10.23;
            out.writeDouble(d1);
            out.close(); fos.close();
        }
        catch (FileNotFoundException e) {
            System.err.println("Błąd pliku");
        }
        catch (IOException e) {
            System.err.println("Błąd zapisu");
        }

        try {
            FileInputStream fis = new FileInputStream("obiekty.dat");
            DataInputStream ois = new DataInputStream(fis);

            String napis1 = ois.readUTF();
            int l1 = ois.readInt();
            double s = ois.readDouble();
            System.out.println(napis1);
            System.out.println(l1);
            System.out.println(s);
            fis.close(); ois.close();
        }
        catch (FileNotFoundException e) {
            System.err.println("bład");
        }
        catch (IOException e) {
            System.out.println("bład Odczytu");
        }
    }
}