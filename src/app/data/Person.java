package app.data;

/**
 * Person
 */
public class Person {

    private boolean isFemale;
    private double weight;
    private double distribution;

    private static double rFemale = 0.6;
    private static double rMale = 0.7;

    public Person(boolean isFemale, double weight){
        this.weight = weight;
        this.isFemale = isFemale;
        this.distribution = weight * (isFemale ? rFemale : rMale);
    }

    public double getDistribution(){
        return this.distribution;
    }

    public void print(){
        System.out.println("Geschlecht:\t" + (isFemale ? "Frau" : "Mann"));
        System.out.println("Gewicht:\t" + weight);
        System.out.println("Reduktion:\t" + distribution);
    }
}