package autosprogi.exceptions;

public class RendszamMarHasznalatban extends Throwable {
    public RendszamMarHasznalatban(String rendszam) {
        super("A megadott rendszam mar szerepel az adatbázisunkban:"+rendszam);
    }
}
