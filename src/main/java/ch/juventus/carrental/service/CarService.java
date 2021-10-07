package ch.juventus.carrental.service;

import ch.juventus.carrental.persistance.FileDatabase;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final FileDatabase fileDataBase;

       public CarService(FileDatabase fileDataBase) {
           this.fileDataBase = fileDataBase;
       }

    public String getHelloWorldGreeting() {
        return fileDataBase.loadHelloWorldGreeting();
    }
}
