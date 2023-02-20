public class Pojazd {

    public static void main(String[] args) {
            Samochod auto = new Samochod();
            System.out.println(auto.czasDojazdu(200));
            System.out.println(auto.zasieg());
        }
}

class Samochod {
    public Samochod(){
        vMax = 180;
        paliwoWZbiorniku = 100;
        zuzycieNa100 = 9.3;
    }

    public Samochod(int vMax, double paliwoWZbiorniku, double zuzycieNa100) {
        this.vMax = vMax;
        this.paliwoWZbiorniku = paliwoWZbiorniku;
        this.zuzycieNa100 = zuzycieNa100;
    }
    int vMax;
    double paliwoWZbiorniku, zuzycieNa100;


    public double zasieg() {
        return this.paliwoWZbiorniku/this.zuzycieNa100;
    }

    public double czasDojazdu(double dystans) {
        return (vMax*0.75)/dystans;
    }

    public void zatankuj(double ilePaliwaZatankowano) {
        paliwoWZbiorniku += ilePaliwaZatankowano;
    }

    public void trasa(double liczbaKilometrow) {
        paliwoWZbiorniku -= liczbaKilometrow/zuzycieNa100;
    }
}