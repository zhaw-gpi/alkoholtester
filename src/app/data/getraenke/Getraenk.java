package app.data.getraenke;

/**
 * Getraenk
 */
public class Getraenk {

    private long drinkTime;
    public int amountMilli;
    public double alcLevel;
    public String name;
    
    public Getraenk(){
        drinkTime = System.currentTimeMillis();
        name = "Unbekanntes Getränk";
    }

    public long getDiffSeconds(){
        return (System.currentTimeMillis() - drinkTime)/1000;
    }

    public long getTimeMilli(){
        return drinkTime;
    }

    public double getAlcTotal(){
        return amountMilli * alcLevel * 0.8;
    }

    public void print(){
        System.out.println("Getränk:\t" + name);
        System.out.println("Konsum vor " + getDiffSeconds() + " Sekunden");
        System.out.println("Menge:\t" + amountMilli + " Milliliter");
        System.out.println("Gehalt:\t" + alcLevel + " %");
    }
}