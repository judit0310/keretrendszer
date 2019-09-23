package autosprogi.model;

import autosprogi.exceptions.RosszDatum;
import autosprogi.exceptions.RosszEvjarat;
import autosprogi.exceptions.RosszRendszam;

import java.time.LocalDate;

public class Auto {
    private String marka;
    private String tipus;
    private String rendszam;
    private LocalDate uzembehelyezes_datuma;
    private int loero;
    private int suly;
    private int ajtok_szama;
    private int ulesek_szama;
    private int kerek_atmero;
    private int evjarat;
    private String szinkod;
    private Allapot allapot;

    public Auto() {
    }


    public Auto(String marka, String tipus, String rendszam, LocalDate uzembehelyezes_datuma, int loero, int suly, int ajtok_szama, int ulesek_szama, int kerek_atmero, int evjarat, String szinkod, Allapot allapot) throws RosszDatum, RosszRendszam, RosszEvjarat {
        this.marka = marka;
        this.tipus = tipus;
        setRendszam(rendszam);
        setUzembehelyezes_datuma(uzembehelyezes_datuma);
        this.loero = loero;
        this.suly = suly;
        this.ajtok_szama = ajtok_szama;
        this.ulesek_szama = ulesek_szama;
        this.kerek_atmero = kerek_atmero;
        setEvjarat(evjarat);
        this.szinkod = szinkod;
        this.allapot = allapot;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) throws RosszRendszam {
        if(rendszam.matches("^\\w\\w\\w-\\d\\d\\d$")){
            this.rendszam = rendszam;
        }
        else{
            throw new RosszRendszam(rendszam);
        }
    }

    public LocalDate getUzembehelyezes_datuma() {
        return uzembehelyezes_datuma;
    }

    public void setUzembehelyezes_datuma(LocalDate uzembehelyezes_datuma) throws RosszDatum {
        if(uzembehelyezes_datuma.isBefore(LocalDate.MIN) ||
                uzembehelyezes_datuma.isAfter(LocalDate.now())){
            throw new RosszDatum(uzembehelyezes_datuma.toString());
        }
        this.uzembehelyezes_datuma = uzembehelyezes_datuma;
    }

    public int getLoero() {
        return loero;
    }

    public void setLoero(int loero) {
        this.loero = loero;
    }

    public int getSuly() {
        return suly;
    }

    public void setSuly(int suly) {
        this.suly = suly;
    }

    public int getAjtok_szama() {
        return ajtok_szama;
    }

    public void setAjtok_szama(int ajtok_szama) {
        this.ajtok_szama = ajtok_szama;
    }

    public int getUlesek_szama() {
        return ulesek_szama;
    }

    public void setUlesek_szama(int ulesek_szama) {
        this.ulesek_szama = ulesek_szama;
    }

    public int getKerek_atmero() {
        return kerek_atmero;
    }

    public void setKerek_atmero(int kerek_atmero) {
        this.kerek_atmero = kerek_atmero;
    }

    public int getEvjarat() {
        return evjarat;
    }

    public void setEvjarat(int evjarat) throws RosszEvjarat {
        if(evjarat<0 || evjarat> LocalDate.now().getYear()){
            throw new RosszEvjarat(String.valueOf(evjarat));
        }
        this.evjarat = evjarat;
    }

    public String getSzinkod() {
        return szinkod;
    }

    public void setSzinkod(String szinkod) {
        this.szinkod = szinkod;
    }

    public Allapot getAllapot() {
        return allapot;
    }

    public void setAllapot(Allapot allapot) {
        this.allapot = allapot;
    }
}
