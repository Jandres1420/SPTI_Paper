package edu.eci.spti.logs.persistance;

public class LogsNotFoundException extends  Exception{
    public LogsNotFoundException(String message) {
        super(message);
    }

    public LogsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
