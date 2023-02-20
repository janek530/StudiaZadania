import java.util.Scanner;

public class Napisy {
    public static void main(String[] args) {
        Scanner skaner = new Scanner(System.in);
        String text;
        int key;
        int wybor;
        System.out.println("Napisz jakiś text: ");
        text = skaner.nextLine();
        System.out.println("Wybierz opcje z menu");
        System.out.println("1. Odwróć text");
        System.out.println("2. Przestaw słowa");
        System.out.println("3. Szyfr Cezara");
        System.out.println("4. Odszyfruj szyfr Cezara");
        System.out.println("5. Uporządkuj");
        System.out.println("6. liczba wystąpień litery w stringu");
        System.out.println("7. Histogram liter");
        System.out.println("8. Palindrom");
        System.out.println("9. Anagram");
        wybor = skaner.nextInt();
            switch (wybor) {
                case 1 -> {
                    System.out.println("Odwrotnie: " + odwrocony(text));
                }
                case 2 -> {
                    System.out.println("Po przestawieniu słów: " + przestawioneSlowa(text));
                }
                case 3 -> {
                    System.out.println("podaj o ile przesuwasz text: ");
                    key = skaner.nextInt();
                    System.out.println("Szyfr cezara: " + szyfrCezara(text, key));
                }
                case 4 -> {
                    System.out.println("podaj o ile przesuwasz text: ");
                    key = skaner.nextInt();
                    System.out.println("Szyfr cezara: " + decode(text, key));
                }
                case 5 -> {
                    System.out.println("Uporządkowany tekst: " + uporzadkuj(text));
                }
                case 6 -> {
                    System.out.print("\njaką litere chcesz policzyc? ");
                    char znak = skaner.next().charAt(0);
                    System.out.println("W zdaniu : " + text +"\nznak " + znak + " wystąpił " + liczbaWystapien(text, znak));
                }
                case 7 -> {
                    int[] litery = histogram(text);
                    for (int i = 0; i < litery.length; i++){
                        char litera = (char) (65+i);
                        System.out.println(litera +" "+ litery[i]);
                    }
                }
                case 8 -> {
                    boolean palindrom = palindrom(text);
                    System.out.println(palindrom);
                }
                case 9 -> {
                    System.out.print("\nPodaj 2 słowo/tekst: ");
                    String text2;
                    do {
                        text2 = skaner.nextLine();
                    }
                    while (text2.length() == 0);
                    boolean anagram = anagram(text, text2);
                    System.out.println(anagram);
                }
            }
        }
    public static String odwrocony(String text) {
        String text2 = "";
        for (int i = text.length()-1; i >= 0; i--) {
            text2 += text.charAt(i);
        }
        return text2;
    }

    public static String przestawioneSlowa(String text) {
        String[] slowa = text.split(" ");
        text = "";
        for (int i = slowa.length-1; i >= 0; i--) {
            text += " ";
            text += slowa[i];
        }
        return text;
    }
    public static String szyfrCezara(String text, int key){
        char[] letters = new char[text.length()];
        int asciiChar;
        letters = text.toCharArray();
        text = "";
        for (int i = 0; i < letters.length; i++) {
            asciiChar = letters[i];
            for (int j = 0; j < key; j++){
                if (asciiChar >= 65 && asciiChar < 90 || asciiChar >= 97 && asciiChar < 122){
                    asciiChar += 1;
                }
                else if (asciiChar == 122){
                    asciiChar = 97;
                }
                else if (asciiChar == 90 ){
                    asciiChar = 65;
                }
            }
            letters[i] = (char) asciiChar;
            text += letters[i];
        }

        return text;
    }
    public static String decode(String text, int key){
        char[] letters = new char[text.length()];
        int asciiChar;
        letters = text.toCharArray();
        text = "";
        for (int i = 0; i < letters.length; i++) {
            asciiChar = letters[i];
            for (int j = 0; j < key; j++){
                if (asciiChar > 65 && asciiChar <= 90 || asciiChar > 97 && asciiChar <= 122){
                    asciiChar -= 1;
                }
                else if (asciiChar == 97){
                    asciiChar = 122;
                }
                else if (asciiChar == 65 ){
                    asciiChar = 90;
                }
            }
            letters[i] = (char) asciiChar;
            text += letters[i];
        }

        return text;
    }

    public static String uporzadkuj(String text) {
        String[] slowa = text.split(" ");
        String text2 = "";
        for (int i = 0; i < slowa.length; i++) {
                if (!slowa[i].equals("") && i != 0 && !slowa[i].equals(",") && !slowa[i].equals(".") && !slowa[i].equals("!") && !slowa[i].equals("?")){
                    text2 += " " + slowa[i];
                } else {
                    text2 += slowa[i];
            }
        }
        return text2;
    }
    public static int liczbaWystapien(String text, char znak) {
        int buf = 0;
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == znak) {
                buf++;
            }
        }
        return buf;
    }

    public static int[] histogram(String text) {
        int[] histogram = new int[26];
        for (int i = 0; i < histogram.length; i++){
            for (int j = 0; j < text.length(); j++) {
                if((char)(i+65) == text.toUpperCase().charAt(j)) {
                    histogram[i] += 1;
                }
            }
        }
        return histogram;
    }

    public static boolean palindrom(String text) {
        boolean palindrom = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == text.charAt(text.length()-i-1)){
                palindrom = true;
            }
            else palindrom = false;
        }
        return palindrom;
    }

    public static boolean anagram(String text, String text2) {
        boolean anagram = false;
        int[] histogramText = histogram(text);
        int[] histogramText2 = histogram(text2);
        for (int i = 0; i < histogramText.length; i++) {
            if (histogramText[i] == histogramText2[i]) {
                anagram = true;
            }
            else {
                anagram = false;
                break;
            }
        }
    return anagram;
    }
}