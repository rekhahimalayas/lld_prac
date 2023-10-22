package lld_demos.practise;

interface ilogger {
    void log(String str);
}

class debug_logger implements ilogger {
    public void log(String str) {
        System.out.println("DEBUG: "+ str);
    }
}

class info_logger implements ilogger {
    public void log(String str) {
        System.out.println("INFO: "+ str);
    }
}

class error_logger implements ilogger {
    public void log(String str) {
        System.out.println("ERROR: "+ str);
    }
}

enum log_type {
    DEBUG_LOG, INFO_LOG, ERROR_LOG
}

/* 
class logger_factory {
    ilogger get_logger(log_type type) {
        switch (type) {
            case DEBUG_LOG:
            return new debug_logger();

            case INFO_LOG:
            return new info_logger();

            case ERROR_LOG:
            return new error_logger();

            default:
            throw new IllegalArgumentException("Invalid log type");
        }
    }
}
*/

interface ifactory {
    ilogger get_logger();
}

class error_logger_factory implements ifactory {
    public ilogger get_logger() {
        return new error_logger();
    }
}

class info_logger_factory implements ifactory {
    public ilogger get_logger() {
        return new info_logger();
    }
}

class debug_logger_factory implements ifactory {
    public ilogger get_logger() {
        return new debug_logger();
    }
}

public class factory_pattern_demo {
    public static void main(String[] str) {
        ifactory fact = new debug_logger_factory();
        ilogger debug_logger = fact.get_logger();
        debug_logger.log("Rekha is calling");
        ifactory fact1 = new info_logger_factory();
        ilogger info_logger = fact1.get_logger();
        info_logger.log("Rekha is calling");
        ifactory fact2 = new error_logger_factory();
        ilogger error_logger = fact2.get_logger();
        error_logger.log("Rekha is calling");
    }
}