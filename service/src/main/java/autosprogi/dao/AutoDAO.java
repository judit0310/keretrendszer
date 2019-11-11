package autosprogi.dao;

import autosprogi.exceptions.AutoNemTalalhato;
import autosprogi.exceptions.RendszamMarHasznalatban;
import autosprogi.exceptions.RosszRendszam;
import autosprogi.model.Auto;

import java.util.Collection;

public interface AutoDAO {

    public Collection<Auto> readAllAutos();

    public Auto readAuto(String rendszam) throws RosszRendszam, AutoNemTalalhato;

    public void insertAuto(Auto auto) throws RendszamMarHasznalatban, RosszRendszam;

    public void updateAuto(Auto auto) throws AutoNemTalalhato;

    public void deleteAuto(Auto auto) throws AutoNemTalalhato;
}
