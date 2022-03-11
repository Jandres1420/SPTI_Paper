package edu.eci.spti.logs.persistance;

import edu.eci.spti.logs.model.Logs;
import org.springframework.stereotype.Controller;

import java.util.Set;
@Controller
public interface LogsPersistance {

    public void saveLogs(Logs log) throws LogsNotFoundException;

    public Logs getLogAuthor(String author) throws LogsNotFoundException;

    public Set<Logs> getAllLogs() throws LogsNotFoundException;
}
