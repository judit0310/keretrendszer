package autosprogi.service;

import autosprogi.exceptions.AutoNemTalalhato;
import autosprogi.model.Auto;
import autosprogi.exceptions.RosszDatum;
import autosprogi.exceptions.RosszEvjarat;
import autosprogi.exceptions.RosszRendszam;

import java.util.Collection;

public interface AutoService {
    public Collection<Auto> listAllAutos();

    public Auto getAuto(String rendszam) throws RosszRendszam, AutoNemTalalhato;

    public void addAuto(Auto auto) throws RosszDatum, RosszEvjarat, RosszRendszam;

    public void deleteAuto(Auto auto) throws AutoNemTalalhato;

    public Collection<Auto> listAllAutosByManufacturer(String manufacturer);


}
