package app.data.getraenke;

/**
 * Bier
 */
public class Bier extends Getraenk {

    public Bier(){
        super();
        this.alcLevel = 0.05;
        this.amountMilli = 300;
        this.name = "Bier";
    }
}