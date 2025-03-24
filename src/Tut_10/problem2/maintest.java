package Tut_10.problem2;
import java.lang.reflect.Constructor;
class Logger {
    private static Logger instance;
    private Logger() {}
    public static Logger getInstance() {
        if (instance == null) {

                    instance = new Logger();

        }
        return instance;
    }
    public void log(String level, String msg){
        System.out.println("[" + level + "] " + msg);
    }

    public void info(String msg){
        log("INFO", msg);
    }
    public void warning(String msg){
        log("WARNING", msg);
    }
    public void error(String msg){
        log("ERROR", msg);
    }

}
public class maintest {
    public static void main(String[] args) {
        // Test Singleton behavior
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.info("Application started.");
        logger1.warning("Low disk space warning.");
        logger2.error("Database connection failed.");

        // Verify Singleton: Both instances should be the same
        System.out.println("Logger instances are the same: " + (logger1 == logger2));

        // Check if developers left any public constructors
        Constructor<?>[] constructors = Logger.class.getDeclaredConstructors();
        boolean hasPublicConstructor = false;

        for (Constructor<?> constructor : constructors) {
            if (constructor.canAccess(null)) {
                hasPublicConstructor = true;
                break;
            }
        }

        if (hasPublicConstructor) {
            System.out.println("WARNING: Public constructor found! Singleton pattern is violated.");
        } else {
            System.out.println("Singleton pattern is correctly implemented.");
        }
    }
}
