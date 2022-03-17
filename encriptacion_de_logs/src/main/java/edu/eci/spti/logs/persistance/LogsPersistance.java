package edu.eci.spti.logs.persistance;
import edu.eci.spti.logs.model.User;
import org.springframework.stereotype.Controller;

import java.util.Set;
@Controller
public interface LogsPersistance {

    public void saveLogs(User user) throws LogsNotFoundException;

    public User getLogAuthor(String correo) throws LogsNotFoundException;

    public Set<User> getAllUsers() throws LogsNotFoundException;
}
