package edu.eci.spti.logs.services;
import edu.eci.spti.logs.persistance.LogsNotFoundException;
import edu.eci.spti.logs.persistance.LogsPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.Set;
import edu.eci.spti.logs.model.User;
@Service
public class LogsServices {
    @Qualifier("InMemoryLogsPersistance")
    @Autowired LogsPersistance lg=null;

    public void addNewLog(User logs){
        try {
            lg.saveLogs(logs);
        } catch (LogsNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Set<User> getAllUsers(){
        try {
            return lg.getAllUsers();
        } catch (LogsNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getLogAuthor(String author){
        try {
            return lg.getLogAuthor(author);
        } catch (LogsNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
