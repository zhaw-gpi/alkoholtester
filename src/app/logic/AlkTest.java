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

    public void setPerson(double weight, boolean isFemale){
        person = new Person(weight, isFemale);
    }

    public Person getPerson(){
        return person;
    }

    public boolean hasPerson(){
        return person != null;
    }

    public void print(){
        person.print();
    }

    public void addKonsum(int drink){
        switch(drink){
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
        }
    }

    public ArrayList<Getraenk> getKonsum(){
        return konsum;
    }

    public void printAll(){
        System.out.println("");
        print();

        for (Getraenk getraenk : konsum) {
            System.out.println("");
            getraenk.print();
        }
    }

    public double getCurrentLevel() {
		double level = 0;
		
		for (int i=0; i < konsum.size(); i++) {
			Getraenk drink = konsum.get(i);
			// Alkohol des neuen Getraenks zu Blutalkoholgehalt addieren
			level += drink.getAlcTotal() / person.getDistribution();

			// Abbau seit letztem Getraenk berechnen und subtrahieren
			double abbaurateProSekunde = 0.15d / secondsOfHour;
			if (i != konsum.size() - 1) {
				// alle Getraenke ausser letztes Getraenk
				Getraenk nextDrink = konsum.get(i + 1);
				// Zeit zwischen Getraenken berechnen
				double deltaSec = (nextDrink.getTimeMilli() - drink.getTimeMilli()) / 1000d;
				level -= abbaurateProSekunde * deltaSec;
			} else {
				// letztes Getraenk, vergangene Zeit berechnen
				double deltaSec = drink.getDiffSeconds();
				level -= abbaurateProSekunde * deltaSec;
			}

			if (level < 0) {
				level = 0;
			}
		}

		return level;
	}
}