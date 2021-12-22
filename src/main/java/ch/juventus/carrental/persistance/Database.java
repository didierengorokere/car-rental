package ch.juventus.carrental.persistance;
import ch.juventus.carrental.model.Car;
import java.io.IOException;

public interface Database {

    String loadHelloWorldGreeting();
    String dbAsString() throws IOException;


/*
    void saveCar () throws IOException;
    String loadCars() throws IOException;
 */

}
