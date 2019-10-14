package autosprogi.controller;

import autosprogi.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AutoController {
    AutoService service;

    public AutoController(@Autowired(required = true) AutoService service) {
        this.service = service;
    }

    @RequestMapping(value = "cica")
    public void proba(){
        System.out.println("ITT VAGYOk");
    }


    @RequestMapping(value = "test")
    public void testService(){
        System.out.println(service.listAllAutos().size());
    }
}
