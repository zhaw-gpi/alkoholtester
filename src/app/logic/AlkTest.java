package app.logic;

import java.util.ArrayList;

import app.data.Person;
import app.data.getraenke.Bier;
import app.data.getraenke.Getraenk;
import app.data.getraenke.Likoer;
import app.data.getraenke.Schnaps;
import app.data.getraenke.Wein;

/**
 * AlkTest
 */
public class AlkTest {

    private Person person;
    private ArrayList<Getraenk> konsum = new ArrayList<>();
    public static int secondsOfHour = 3600;
    private static final double ABBAURATEPROSTUNDE = 0.15;

    public Person getPerson() {
        return person;
    }

    public void setPerson(double weight, boolean isFemale) {
        this.person = new Person(isFemale, weight);
    }

    public boolean hasPerson() {
        return person != null;
    }

    public void printPerson() {
        person.print();
    }

    public ArrayList<Getraenk> getKonsum() {
        return konsum;
    }

    public void addKonsum(int drink) {
        switch (drink) {
            case 0:
                konsum.add(new Bier());
                break;
            case 1:
                konsum.add(new Wein());
                break;
            case 2:
                konsum.add(new Likoer());
                break;
            case 3:
                konsum.add(new Schnaps());
                break;
            default:
                break;
        }
    }

    public void printAll(){
        this.printPerson();

        System.out.println("");

        for (Getraenk g : konsum) {
            g.print();
            System.out.println("");
        }
    }

    public double getCurrentLevel(){
        double level = 0.0;
        long timeDiff;
        double abbaurate = ABBAURATEPROSTUNDE / secondsOfHour;


        for (int i = 0; i < this.konsum.size(); i++) {
            Getraenk getraenk = this.konsum.get(i);
            level += getraenk.getAlcTotal() / this.person.getDistribution();

            if(i < this.konsum.size() - 1){
                Getraenk nextGetraenk = this.konsum.get(i + 1);
                timeDiff = (nextGetraenk.getTimeMilli() - getraenk.getTimeMilli()) / 1000;
            } else {
                timeDiff = getraenk.getDiffSeconds();
            }

            level -= timeDiff * abbaurate;
        }

        return (level < 0 ? 0.0 : level);
    }
}