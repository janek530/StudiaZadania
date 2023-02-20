public class Ulamek {
    public static void main(String[] args) {
        Rational first = new Rational(14,8);
        Rational second = new Rational(7, 4);
        System.out.println(first);
        System.out.println(second);
        System.out.println("dodawanie: " + first.add(second));
        System.out.println("mnozenie: " + first.mul(second));
        System.out.println("odejmowanie: " + first.sub(second));
        System.out.println("dzielenie: " + first.div(second));
        System.out.println("równość: " + first.skroc().equals(second));
        System.out.println("porównywanie: " + first.compareTo(second));
    }
}

class Rational {
    public Rational(){
        licznik = 1;
        mianownik = 2;
    }
    public Rational(int licznik, int mianownik) {
        this.licznik = licznik;
        this.mianownik = mianownik;
    }

    @Override
    public String toString() {
        return licznik + "/" + mianownik;
    }
    int licznik, mianownik;

    public Rational add(Rational obj) {
        Rational newObj = new Rational();
        newObj.mianownik = this.mianownik * obj.mianownik;
        newObj.licznik = (this.licznik * obj.mianownik) + (obj.licznik * this.mianownik);
        return newObj.skroc();
    }

    public Rational mul(Rational obj) {
        Rational newObj = new Rational();
        newObj.mianownik = this.mianownik * obj.mianownik;
        newObj.licznik = this.licznik * obj.licznik;
        return newObj.skroc();
    }

    public Rational sub(Rational obj) {
        Rational newObj = new Rational();
        newObj.mianownik = this.mianownik * obj.mianownik;
        newObj.licznik = (this.licznik * obj.mianownik) - (obj.licznik * this.mianownik);
        return newObj.skroc();
    }

    public Rational div(Rational obj) {
        Rational newObj = new Rational();
        newObj.licznik = this.licznik * obj.mianownik;
        newObj.mianownik = this.mianownik * obj.licznik;
        return newObj.skroc();
    }

    public boolean equals(Rational obj) {
        obj = obj.skroc();
        boolean equal = false;
        if(this.licznik == obj.licznik) {
            if(this.mianownik == obj.mianownik){
                equal = true;
            }
        }
        return equal;
    }

    public int compareTo(Rational obj) {
        int compare = 0;
        if (((double)this.licznik / (double)this.mianownik) > ((double)obj.licznik / (double)obj.mianownik)) {
            compare = 1;
        } else if (((double)this.licznik / (double)this.mianownik) < ((double)obj.licznik / (double)obj.mianownik)){
            compare = -1;
            }
        return compare;
    }


    public Rational skroc() {
        Rational newObj = new Rational();
        newObj.licznik = licznik;
        newObj.mianownik = mianownik;
        for (int i = 1; i < mianownik; i++) {
            if (mianownik % i == 0 && licznik % i == 0) {
                newObj.mianownik = mianownik / i;
                newObj.licznik = licznik / i;
            }
        }
    return newObj;
    }
}