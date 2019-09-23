package autosprogi.service.impl;

import autosprogi.dao.AutoDAO;
import autosprogi.exceptions.AutoNemTalalhato;
import autosprogi.exceptions.RosszDatum;
import autosprogi.exceptions.RosszEvjarat;
import autosprogi.exceptions.RosszRendszam;
import autosprogi.model.Auto;
import autosprogi.service.AutoService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class AutoServiceImpl implements AutoService {
    private AutoDAO dao;

    public AutoServiceImpl(AutoDAO dao) {
        this.dao = dao;
    }

    public Collection<Auto> listAllAutos() {
        return dao.readAllAutos();
    }

    public Auto getAuto(String rendszam) throws RosszRendszam, AutoNemTalalhato {
        return null;
    }

    public void addAuto(Auto auto) throws RosszDatum, RosszEvjarat, RosszRendszam {

    }

    public void deleteAuto(Auto auto) throws AutoNemTalalhato {


    }

    public Collection<Auto> listAllAutosByManufacturer(String manufacturer) {
        Collection<Auto> allAuto = dao.readAllAutos();
        //Collection<Auto> selected = allAuto.stream().filter(a->a.getMarka().equalsIgnoreCase(manufacturer)).collect(Collectors.toList());
        Collection<Auto> result = new ArrayList<Auto>();
        for (Auto a: allAuto){
            if(a.getMarka().equalsIgnoreCase(manufacturer)){
                result.add(a);
            }

        }
        return result;
    }
}
