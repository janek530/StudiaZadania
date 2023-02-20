import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner skaner = new Scanner(System.in);
        double cal = 39.3700787, foot = 3.2808399, jard = 1.0936133, LM = 0.000621371192;
        int ile, start, max, counter = 1;
        System.out.println("Podaj o ile jednostek zwiększać ma sie program: ");
        try {
            ile = skaner.nextInt();
            if (ile <= 0) {
                System.out.println("Podaj wartość jeszcze raz: ");
                ile = skaner.nextInt();
            }

            System.out.println("Podaj od jakiej wartości ma działać program: ");
            start = skaner.nextInt();
            if (start < 0) {
                System.out.println("Podaj wartość jeszcze raz: ");
                start = skaner.nextInt();
            }
            System.out.println("Podaj do jakiej wartości ma działać program: ");
            max = skaner.nextInt();
            if (max <= 0 || max <= start) {
                System.out.println("Podaj wartość jeszcze raz: ");
                max = skaner.nextInt();
            }
            for (int i = start; i <= max; i = i + ile) {
                if (counter > 24) {
                    System.out.println("Zostało wykonanych 24 operacje, program kończy działanie.");
                    break;
                }
                System.out.println(counter + ": " + i + " metrów" + " | " + i * cal + " cali" + " | " + i * foot + " stóp" + " | " + i * jard + " jardów" + " | " + i * LM + " mil lądowych");
                counter++;
            }
        }
        catch(Exception e){
            System.out.println("podana wartość nie jest liczbą");
        }
    }
}
