package autosprogi.model;

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

    public void setUzembehelyezes_datuma(LocalDate uzembehelyezes_datuma) {
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

    public void setEvjarat(int evjarat) {
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
