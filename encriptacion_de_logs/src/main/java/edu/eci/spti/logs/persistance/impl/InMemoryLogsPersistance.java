package edu.eci.spti.logs.persistance.impl;

import edu.eci.spti.logs.model.Logs;
import edu.eci.spti.logs.persistance.LogsNotFoundException;
import edu.eci.spti.logs.persistance.LogsPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Repository
public class InMemoryLogsPersistance implements LogsPersistance {

    private final ArrayList<Logs>logs = new ArrayList<Logs>();

    public InMemoryLogsPersistance() {
        Logs log = new Logs("Hola esto es una prueba","Andrés",new Date());
        Logs log2 = new Logs("Hola esto es una prueba 2","Yeison",new Date());
        Logs log3 = new Logs("Hola esto es una prueba 3" ,"Johann",new Date());
        Logs log4 = new Logs("Hola esto es una prueba 4","xd",new Date());
        logs.add(log);
        logs.add(log2);
        logs.add(log3);
        logs.add(log4);
    }
    @Override
    public void saveLogs(Logs log) throws LogsNotFoundException {
        if(logs.contains(log)){
            throw new LogsNotFoundException("The current log already exist: " +log.getLog());
        }else{
            logs.add(log);
        }
    }

    @Override
    public Logs getLogAuthor(String author) throws LogsNotFoundException {
        if(logs.size() <= 1){
            throw new LogsNotFoundException("there is no Logs");
        }
        Logs log = null;
        for(int i = 0; i<logs.size();i++){
            if(logs.get(i).getAuthor()==author){
                log = new Logs(logs.get(i).getLog(),logs.get(i).getAuthor(),new Date());
            }
            else{
                log = new Logs("No hay log","Admin",new Date());
            }
        }

        if(logs == null){
            throw new LogsNotFoundException("logs doesn't exist");
        }
        return log;

    }
    @Override
    public Set<Logs> getAllLogs() throws LogsNotFoundException {
        Set<Logs> hSet = new HashSet<Logs>();
        if(logs.size() <= 1){
            throw new LogsNotFoundException("there is no blueprint");
        }
        for (Logs x : logs)
            hSet.add(x);
        return hSet;
    }

}