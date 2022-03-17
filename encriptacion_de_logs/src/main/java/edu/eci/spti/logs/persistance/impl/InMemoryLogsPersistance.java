package edu.eci.spti.logs.persistance.impl;

import edu.eci.spti.logs.persistance.LogsNotFoundException;
import edu.eci.spti.logs.persistance.LogsPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.eci.spti.logs.model.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Repository
public class InMemoryLogsPersistance implements LogsPersistance {

    private final ArrayList<User>User = new ArrayList<User>();

    public InMemoryLogsPersistance() {
        User log = new User("andres@gmail.com","admin123");
        User log2 = new User("johann@gmail.com","admin123");
        User log3 = new User("yeison@gmail.com" ,"admin123");
        User.add(log);
        User.add(log2);
        User.add(log3);
    }
    @Override
    public void saveLogs(User user) throws LogsNotFoundException{
        if(User.contains(user)){
            throw new LogsNotFoundException("The current log already exist: " +user.getCorreo());
        }else{
            User.add(user);
        }
    }

    @Override
    public User getLogAuthor(String author) throws LogsNotFoundException {
        if(User.size() <= 1){
            throw new LogsNotFoundException("there is no User");
        }
        User log = null;
        for(int i = 0; i<User.size();i++){
            if(User.get(i).getCorreo()==author){
                log = new User(User.get(i).getCorreo(),User.get(i).getContraseña());
            }
            else{
                log = new User("No hay log","Admin");
            }
        }

        if(User == null){
            throw new LogsNotFoundException("User doesn't exist");
        }
        return log;

    }
    @Override
    public Set<User> getAllUsers() throws LogsNotFoundException {
        Set<User> hSet = new HashSet<User>();
        if(User.size() <= 1){
            throw new LogsNotFoundException("there is no blueprint");
        }
        for (User x : User)
            hSet.add(x);
        return hSet;
    }

}