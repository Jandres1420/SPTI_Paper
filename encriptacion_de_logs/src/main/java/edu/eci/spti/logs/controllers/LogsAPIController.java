package edu.eci.spti.logs.controllers;

import edu.eci.spti.logs.services.LogsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/logs")
public class LogsAPIController {
    @Qualifier("InMemoryLogsPersistance")
    @Autowired
    private LogsServices logsServices;

    /**
     * Toma todos los logs actuales de InmemoryLogs
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?>getAllLogs(){
        try{
            return new ResponseEntity<>(logsServices.getAllLogs(), HttpStatus.ACCEPTED);
        }catch (Exception e){
            Logger.getLogger(LogsAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Toma los logs dependiendo el author
     * @param authors
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/authors/{authors}")
    public ResponseEntity<?>getLogsByAuthor(String authors){
        try{
            return new ResponseEntity<>(logsServices.getLogAuthor(authors),HttpStatus.ACCEPTED);
        }catch (Exception e){
            Logger.getLogger(LogsAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
    }


}
