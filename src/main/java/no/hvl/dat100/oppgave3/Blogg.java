package no.hvl.dat100.oppgave3;

import no.hvl.dat100.oppgave1.Innlegg;

public class Blogg {

    private Innlegg[] innleggtabell; // tabell av Innlegg-objekter
    private int nesteledig = 0;      // antall innlegg lagret i tabellen og neste ledige posisjon

    // b) Standardkonstruktør som setter tabellstørrelsen til 20
    public Blogg() {
        this.innleggtabell = new Innlegg[20];
    }

    // b) Konstruktør som tar en parameter for å angi tabellens startstørrelse
    public Blogg(int lengde) {
        this.innleggtabell = new Innlegg[lengde];
    }

    // c) Returnerer antall innlegg i tabellen
    public int getAntall() {
        return nesteledig;
    }

    // d) Returnerer referansen til innleggtabellen
    public Innlegg[] getSamling() {
        return innleggtabell;
    }

    // e) Finner indeksen til et innlegg med samme id
    public int finnInnlegg(Innlegg innlegg) {
        for (int i = 0; i < nesteledig; i++) {
            if (innleggtabell[i].erLik(innlegg)) {
                return i;
            }
        }
        return -1;
    }

    // f) Returnerer true hvis et innlegg med samme id finnes i tabellen
    public boolean finnes(Innlegg innlegg) {
        return finnInnlegg(innlegg) != -1;
    }

    // g) Returnerer true hvis det er ledig plass i tabellen
    public boolean ledigPlass() {
        return nesteledig < innleggtabell.length;
    }

    // h) Legger til et nytt innlegg i tabellen hvis det er plass og det ikke finnes fra før
    public boolean leggTil(Innlegg innlegg) {
        if (ledigPlass() && !finnes(innlegg)) {
            innleggtabell[nesteledig] = innlegg;
            nesteledig++;
            return true;
        }
        return false;
    }

    // i) Returnerer en tekstrepresentasjon av samlingen
    public String toString() {
    	String str ="";
        for (int i = 0; i < nesteledig; i++) {
            str = str+innleggtabell[i].toString();
        }
        str=nesteledig+"\n"+str;
        System.out.print(str);
        return str;
    }

    // j) - Valgfri - Utvid tabellen ved å doble størrelsen
    public void utvid() {
        Innlegg[] nyTabell = new Innlegg[innleggtabell.length * 2];
        System.arraycopy(innleggtabell, 0, nyTabell, 0, innleggtabell.length);
        innleggtabell = nyTabell;
    }

    // k) - Valgfri - Legg til et innlegg, og utvid tabellen hvis den er full
    public boolean leggTilUtvid(Innlegg innlegg) {
        if (!finnes(innlegg)) {
            if (!ledigPlass()) {
                utvid();
            }
            innleggtabell[nesteledig] = innlegg;
            nesteledig++;
            return true;
        }
        return false;
    }
}
