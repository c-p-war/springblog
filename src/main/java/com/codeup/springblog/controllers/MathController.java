package com.codeup.springblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    //add
    @RequestMapping(path = "/add/{numberOne}/and/{numberTwo}", method = RequestMethod.GET)
    @ResponseBody
    //must declare both both as PathVariables
    public String addNumbers(@PathVariable int numberOne, @ PathVariable int numberTwo){
        return numberOne + " + " + numberTwo + " = " + (numberOne + numberTwo);
    }

    //subtract
    @RequestMapping(path = "/sub/{numberOne}/and/{numberTwo}", method = RequestMethod.GET)
    @ResponseBody
    //must declare both both as PathVariables
    public String subNumbers(@PathVariable int numberOne, @ PathVariable int numberTwo){
        return numberOne + " - " + numberTwo + " = " + (numberOne - numberTwo);
    }

    //multiply
    @RequestMapping(path = "/mul/{numberOne}/and/{numberTwo}", method = RequestMethod.GET)
    @ResponseBody
    //must declare both both as PathVariables
    public String mulNumbers(@PathVariable int numberOne, @ PathVariable int numberTwo){
        return numberOne + " * " + numberTwo + " = " + (numberOne * numberTwo);
    }

    //divide

    @RequestMapping(path = "/div/{numberOne}/and/{numberTwo}", method = RequestMethod.GET)
    @ResponseBody
    //must declare both both as PathVariables
    public String divNumbers(@PathVariable float numberOne, @ PathVariable float numberTwo){
        return numberOne + " / " + numberTwo + " = " + (numberOne / numberTwo);
    }


}
