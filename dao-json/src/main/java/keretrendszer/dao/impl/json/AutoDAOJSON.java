package keretrendszer.dao.impl.json;

import autosprogi.dao.AutoDAO;
import autosprogi.exceptions.AutoNemTalalhato;
import autosprogi.exceptions.RosszRendszam;
import autosprogi.model.Auto;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class AutoDAOJSON implements AutoDAO {

    File jsonfile;

    ObjectMapper mapper;

    public AutoDAOJSON(String filepath) {
        jsonfile = new File(filepath);
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        if (!jsonfile.exists()) {
            try {
                jsonfile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Collection<Auto> readAllAutos() {
        Collection<Auto> result = new ArrayList<Auto>();
        try {
            result = mapper.readValue(jsonfile, new TypeReference<ArrayList<Auto>>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Auto readAuto(String rendszam) throws RosszRendszam, AutoNemTalalhato {
        try {
            Auto auto = new Auto();
            auto.setRendszam(rendszam);
        } catch (RosszRendszam rosszRendszam) {
            throw rosszRendszam;
        }
        Collection<Auto> autos = readAllAutos();
        for(Auto auto: autos){
            if (auto.getRendszam().equalsIgnoreCase(rendszam)){
                return auto;
            }
        }
        throw new AutoNemTalalhato();
}

    public void insertAuto(Auto auto) {
        try{
            readAuto(auto.getRendszam());
        } catch (AutoNemTalalhato autoNemTalalhato) {
            Collection<Auto> autos = readAllAutos();
            autos.add(auto);
            try {
                mapper.writeValue(jsonfile, autos);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;


        } catch (RosszRendszam rosszRendszam) {
            ;
        }

    }

    public void updateAuto(Auto auto) throws AutoNemTalalhato {

    }

    public void deleteAuto(Auto auto) throws AutoNemTalalhato {
        Collection<Auto> autok = readAllAutos();
        try {
            Auto autotorlendo = readAuto(auto.getRendszam());
        } catch (RosszRendszam rosszRendszam) {
            rosszRendszam.printStackTrace();
        } catch (AutoNemTalalhato nem_talalhato){
            throw nem_talalhato;
        }

    }
}
