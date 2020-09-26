package app.ui;

import java.util.Scanner;

import app.logic.AlkTest;

public class KommandoZeile {
    private AlkTest alkTest = new AlkTest();

    public void startCli() {
        String cmdInput = "";
        Scanner keyScan = new Scanner(System.in);

        System.out.println("\nAnzahl Sekunden in einer Stunde (Default 3600)> ");
        int secondsPerHour = keyScan.nextInt();
        AlkTest.secondsOfHour = secondsPerHour;

        while (!cmdInput.equals("exit")) {
            System.out.print("\nCMD (config, drink, test, print, exit)> ");
            cmdInput = keyScan.nextLine();
            if (cmdInput.equals("drink")) {
                System.out.println("Bier (0), Wein (1), Likör(2), Schnaps(3)>");
                int drink = keyScan.nextInt();
                keyScan.nextLine();
                alkTest.addKonsum(drink);
            } else if (cmdInput.equals("config")) {
                System.out.println("Frau (f) oder Mann (m)>");
                String s = keyScan.nextLine();
                if (!s.equals("f") && !s.equals("m")) {
                    continue;
                }
                System.out.println("Gewicht>");
                int weight = keyScan.nextInt();
                keyScan.nextLine();
                alkTest.setPerson(weight, s.equals("f"));
            } else if (cmdInput.equals("test")) {
                if (alkTest.hasPerson()) {
                    System.out.println("Alkoholwert: " + alkTest.getCurrentLevel());
                } else {
                    System.out.println("Bitte zuerst Angaben zur Person erfassen");
                }
            } else if (cmdInput.equals("print")) {
                alkTest.printAll();
            }
        }
        keyScan.close();
    }
}
