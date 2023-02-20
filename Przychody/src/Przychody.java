import java.util.Scanner;

public class Przychody {
    private static double srednia = 0;

    public static void main(String[] args) {
        try {
            Scanner skaner = new Scanner(System.in);
            double[] dochod = new double[12];
            System.out.println("Program oblicza i wyznacza sumę dochodów, średni dochód, maksymalny i minimalny dochód.");
            while(true) {
                menu();
                System.out.println("Podaj opcje: ");
                int opcja = skaner.nextInt();
                switch (opcja) {
                    case 1 -> wczytajDochody(dochod);
                    case 2 -> wyswietlDochody(dochod);
                    case 3 -> sredniaDochodow(dochod);
                    case 4 -> minMaxDochod(dochod);
                    case 5 -> sortuj(dochod);
                    case 6 -> podNadSrednimDochodem(dochod);
                }
            }
        }
        catch (Exception e){
            System.out.println("podano nieprawidłową wartość");
        }
    }
    private static void menu() {
        System.out.println("1 - Wczytaj dochody");
        System.out.println("2 - Wyświetl dochody");
        System.out.println("3 - Średnia suma dochodów");
        System.out.println("4 - Maksymalny/Minimalny dochód");
        System.out.println("5 - Sortuj dochody");
        System.out.println("6 - Ponad i poniżej średniego dochodu");
    }

    private static void wczytajDochody(double[] dochody) {
        Scanner skaner = new Scanner(System.in);
        for (int i=0; i<12; i++) {
            System.out.println("dochod za " + (i+1) + " miesiąc wynosi: ");
            dochody[i] = skaner.nextDouble();
        }
    }

    private static void wyswietlDochody(double[] dochody) {
        int i = 1;
        for (double dochod : dochody){
            System.out.println("dochod za " + i + " wynosi: " + dochod);
            i++;
        }
    }

    public static void sredniaDochodow (double[] dochody) {
        double suma = 0;

        for (double dochod : dochody) {
            suma += dochod;
        }
        srednia = suma / 12;
        System.out.println("srednia dochodow wynosi " + srednia);
    }

    private static void minMaxDochod(double[] dochody) {
        double min = dochody[0], max = dochody[0];
        for (double dochod : dochody) {
            if (min > dochod) min = dochod;
            if (max < dochod) max = dochod;
        }
        System.out.println("Maxymalny dochód wyniósł " + max);
        System.out.println("Minimalny dochód wyniósł " + min);
    }

    private static void sortuj(double[] dochody) {
        int n = dochody.length;
        double buf;
        do {
            for (int i = 0; i < n-1; i++) {
                if (dochody[i] > dochody[i+1]){
                   buf = dochody[i];
                   dochody[i] = dochody[i+1];
                   dochody[i+1] = buf;
                }
            }
            n--;
        }
        while (n > 1);
    }

    private static void podNadSrednimDochodem(double[] dochody) {
        if (srednia == 0){
            System.out.println("Srednia nie ma żadnej wartości. Wykonaj polecenie 'sredniaDochodow'.");
        }
        else{
            sortuj(dochody);
            System.out.println("dochód poniżej średniego: ");
            for (double dochod : dochody) {
                if (dochod < srednia){
                    System.out.println(dochod);
                }
            }
            System.out.println("dochód powyżej średniego: ");
            for (double dochod : dochody){
                    if (dochod > srednia){
                        System.out.println(dochod);
                }
            }
        }
    }
}