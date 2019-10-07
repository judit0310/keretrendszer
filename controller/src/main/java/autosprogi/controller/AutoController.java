package autosprogi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AutoController {

    @RequestMapping(value = "cica")
    public void proba(){
        System.out.println("ITT VAGYOk");
    }
}
