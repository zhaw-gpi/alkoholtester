package app.ui;

import java.util.Scanner;

import app.logic.AlkTest;

public class Kommandozeile {
    private AlkTest tester = new AlkTest();

    public void commandLine() {
        String cmdInput = "";
        Scanner keyScan = new Scanner(System.in);

        System.out.println("\nAnzahl Sekunden in einer Stunde (Default 3600)> ");
        int secondsPerHour = keyScan.nextInt();
        tester.secondsOfHour = secondsPerHour;

        while (!cmdInput.equals("exit")) {
            System.out.print("\nCMD (config, drink, test, print, exit)> ");
            cmdInput = keyScan.nextLine();
            if (cmdInput.equals("drink")) {
                System.out.println("Bier (0), Wein (1), Likör(2), Schnaps(3)>");
                int drink = keyScan.nextInt();
                keyScan.nextLine();
                tester.addKonsum(drink);
            } else if (cmdInput.equals("config")) {
                System.out.println("Frau (f) oder Mann (m)>");
                String s = keyScan.nextLine();
                if (!s.equals("f") && !s.equals("m")) {
                    continue;
                }
                System.out.println("Gewicht>");
                int weight = keyScan.nextInt();
                keyScan.nextLine();
                tester.setPerson(weight, s.equals("f"));
            } else if (cmdInput.equals("test")) {
                if (tester.hasPerson()) {
                    System.out.println("Alkoholwert: " + tester.getCurrentLevel());
                } else {
                    System.out.println("Bitte zuerst Angaben zur Person erfassen");
                }
            } else if (cmdInput.equals("print")) {
                tester.printAll();
            }
        }
        keyScan.close();
    }
}
