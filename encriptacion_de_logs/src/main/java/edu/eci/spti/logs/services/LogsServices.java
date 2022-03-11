package edu.eci.spti.logs.services;

import edu.eci.spti.logs.model.Logs;
import edu.eci.spti.logs.persistance.LogsNotFoundException;
import edu.eci.spti.logs.persistance.LogsPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class LogsServices {
    @Qualifier("InMemoryLogsPersistance")
    @Autowired LogsPersistance lg=null;

    public void addNewLog(Logs logs){
        try {
            lg.saveLogs(logs);
        } catch (LogsNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Set<Logs> getAllLogs(){
        try {
            return lg.getAllLogs();
        } catch (LogsNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Logs getLogAuthor(String author){
        try {
            return lg.getLogAuthor(author);
        } catch (LogsNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
