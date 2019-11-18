package autosprogi.controller;

import autosprogi.exceptions.RendszamMarHasznalatban;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(RendszamMarHasznalatban.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.IM_USED)
    public String duplikalt(RendszamMarHasznalatban e){
        return e.getMessage()+", nem update kellene?"+e.toString();

    }
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ResponseBody
    public String unsupoorted(){
        return "elfogadhato media tipusok:"+ MediaType.APPLICATION_JSON_VALUE;
    }
}
