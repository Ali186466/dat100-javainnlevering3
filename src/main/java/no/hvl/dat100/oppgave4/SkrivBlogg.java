package no.hvl.dat100.oppgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import no.hvl.dat100.oppgave3.Blogg;

public class SkrivBlogg {

    public static boolean skriv(Blogg samling, String mappe, String filnavn) {
        // Kombiner mappe og filnavn til en full filbane
        String filbane = mappe + File.separator + filnavn;
        
        // Bruk try-catch for å håndtere filskriving
        try (PrintWriter writer = new PrintWriter(filbane)) {
            // Skriv hele blogg-samlingen til fil ved hjelp av toString-metoden
            writer.print(samling.toString());
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Fil ikke funnet eller kan ikke skrives: " + e.getMessage());
            return false;
        }
    }
}
