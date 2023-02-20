import java.util.Scanner;

public class FiguryPlaskie {
    public static void main(String[] args) {
        int wybor;
        Scanner skaner = new Scanner(System.in);
        System.out.println("Program oblicza pole i obwód wybranej figury. Aby zakończyć działanie, wpisz jakąkolwiek inna liczbe.");
        do {
            menu();
            System.out.println("Wybierz opcje");
            wybor = skaner.nextInt();
            switch (wybor) {
                case 1 -> {
                    System.out.println("Podaj bok kwadratu");
                    double bok = skaner.nextDouble();
                    System.out.println("Pole kwadratu wynosi: " + kwadratPole(bok));
                    System.out.println("Obwód kwadratu wynosi: " + kwadratObwod(bok));
                }
                case 2 -> {
                    System.out.println("Podaj pierwszy bok prostokątu: ");
                    double a = skaner.nextDouble();
                    System.out.println("Podaj drugi bok prostokątu: ");
                    double b = skaner.nextDouble();
                    System.out.println("Pole prostokąta wynosi: " + prostokatPole(a, b));
                    System.out.println("Obwód porstokąta wynosi: " + prostokatObwod(a, b));
                }
                case 3 -> {
                    System.out.println("Podaj promień koła: ");
                    double r = skaner.nextDouble();
                    System.out.println("Pole koła wynosi: " + koloPole(r));
                    System.out.println("Obwód koła wynosi: " + koloObwod(r));
                }
                case 4 -> {
                    System.out.println("Podaj wysokość trójkąta: ");
                    double h = skaner.nextDouble();
                    System.out.println("Podaj podstawe trójkąta: ");
                    double a = skaner.nextDouble();
                    System.out.println("Podaj pierwszą ściane trójkąta: ");
                    double b = skaner.nextDouble();
                    System.out.println("Podaj drugą ściane trójkąta: ");
                    double c = skaner.nextDouble();
                    System.out.println("Pole trójkąta wynosi: " + trojkatPole(h, a));
                    System.out.println("Obwód trójkąta wynosi: " + trojkatObwod(a, b, c));
                }
                case 5 -> {
                    System.out.println("Podaj podstawe trapezu: ");
                    double a = skaner.nextDouble();
                    System.out.println("Podaj drugą podstawe trapezu: ");
                    double b = skaner.nextDouble();
                    System.out.println("Podaj wysokość trapezu: ");
                    double h = skaner.nextDouble();
                    System.out.println("Podaj pierwszą ścianę trapezu: ");
                    double c = skaner.nextDouble();
                    System.out.println("Podaj drugą ścianę trapezu: ");
                    double d = skaner.nextDouble();
                    System.out.println("Pole trapezu wynosi: " + trapezPole(a, b, h));
                    System.out.println("Obwócd trapezu wynosi: " + trapezObwod(a, b, c, d));
                }
                default -> System.out.println("Do widzenia");
            }
        }
        while (wybor >= 1 && wybor <= 5);
    }

    private static void menu() {
        System.out.println("1 - Kwadrat");
        System.out.println("2 - Prostokąt");
        System.out.println("3 - Koło");
        System.out.println("4 - Trójkąt");
        System.out.println("5 - Trapez");
    }
    private static double kwadratPole(double bok) {
        double pole = bok*bok;
        return pole;
    }
    public static double kwadratObwod(double bok) {
        double obwod = 4*bok;
        return obwod;
    }

    private static double prostokatPole(double bokA, double bokB) {
        double pole = bokA * bokB;
        return pole;
    }
    private static double prostokatObwod(double bokA, double bokB) {
        double obwod = 2*bokA + 2*bokB;
        return obwod;
    }

    private static double koloPole(double r) {
        double pole = Math.PI*(r*r);
        return pole;
    }
    private static double koloObwod(double r) {
        double obwod = 2*Math.PI*r;
        return obwod;
    }

    private static double trojkatPole(double h, double a) {
        double pole = (a*h)/2;
        return pole;
    }
    private static double trojkatObwod(double a, double b, double c) {
        double obwod = a+b+c;
        return obwod;
    }

    private static double trapezPole(double a, double b, double h) {
        double pole = (((a+b)*h)/2);
        return pole;
    }
    private static double trapezObwod(double a, double b, double c, double d) {
        double obwod  = a + b + c + d;
        return obwod;
    }
}