package com.example.h2demo.controller;

import com.example.h2demo.service.api.CustomFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class MainController {

    private CustomFileReader customFileReader;

    @Autowired
    public MainController(CustomFileReader customFileReader) {
        this.customFileReader = customFileReader;
    }

    @RequestMapping(value = {"/","/main"}, method = RequestMethod.GET)
    public ModelAndView getMainPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainpage.html");
        return modelAndView;
    }

    @RequestMapping(value = "/second", method = RequestMethod.GET)
    public String getSecondPage(){
        return "secondpage.html";
    }

    @RequestMapping(value = "/parse", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getParsedObj(){
        try {
            return new ResponseEntity<>(customFileReader.read(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
