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

public class simplefactory_demo {
    public static void main(String[] str) {
        logger_factory fact = new logger_factory();
        ilogger debug_logger = fact.get_logger(log_type.DEBUG_LOG);
        debug_logger.log("Rekha is calling");
        ilogger info_logger = fact.get_logger(log_type.INFO_LOG);
        info_logger.log("Rekha is calling");
        ilogger error_logger = fact.get_logger(log_type.ERROR_LOG);
        error_logger.log("Rekha is calling");
    }
}
