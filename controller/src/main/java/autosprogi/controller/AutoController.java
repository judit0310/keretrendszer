package autosprogi.controller;

import autosprogi.exceptions.RendszamMarHasznalatban;
import autosprogi.exceptions.AutoNemTalalhato;
import autosprogi.exceptions.RosszDatum;
import autosprogi.exceptions.RosszEvjarat;
import autosprogi.exceptions.RosszRendszam;
import autosprogi.model.Auto;
import autosprogi.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class AutoController {
    AutoService service;

    public AutoController(@Autowired(required = true) AutoService service) {
        this.service = service;
    }

    @RequestMapping(value = "cica")
    @ResponseBody
    public void proba(){
        System.out.println("ITT VAGYOk");
    }


    @RequestMapping(value = "test")
    @ResponseBody
    public String testService(){
        return String.valueOf(service.listAllAutos().size());
    }

    @RequestMapping(value = "/getAutoData/{rendszam}")
    @ResponseBody
    public Auto getAutoByRendszam(@PathVariable(value = "rendszam") String rendszam) throws AutoNemTalalhato, RosszRendszam {
        System.out.println("CICA");
        return service.getAuto(rendszam);
    }

    @RequestMapping(value ="addAuto", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addAuto(@RequestBody Auto auto) throws RosszDatum, RosszEvjarat, RosszRendszam, RendszamMarHasznalatban {
        service.addAuto(auto);

    }

    @RequestMapping(value = "/listAuto", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Auto> listAuto(){
        return service.listAllAutos();

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAuto(@RequestBody Auto auto) throws AutoNemTalalhato {
        service.deleteAuto(auto);
    }

    @RequestMapping(value = "/update", method= RequestMethod.POST)
    @ResponseBody
    public void updateAuto(@RequestBody Auto auto) throws AutoNemTalalhato {
        service.updateAuto(auto);
    }


}
