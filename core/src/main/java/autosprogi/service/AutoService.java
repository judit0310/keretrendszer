package autosprogi.service;

import autosprogi.exceptions.*;
import autosprogi.model.Auto;

import java.util.Collection;

public interface AutoService {
    public Collection<Auto> listAllAutos();

    public Auto getAuto(String rendszam) throws RosszRendszam, AutoNemTalalhato;

    public void addAuto(Auto auto) throws RosszDatum, RosszEvjarat, RosszRendszam, RendszamMarHasznalatban;

    public void deleteAuto(Auto auto) throws AutoNemTalalhato;

    public Collection<Auto> listAllAutosByManufacturer(String manufacturer);


    public void updateAuto(Auto auto) throws AutoNemTalalhato;

}
