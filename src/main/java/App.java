import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {

    final static Logger logger = LoggerFactory.getLogger(App.class);

    public String getGreeting() {
        logger.info("holooooo");
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
