import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(int temperature);
}

// Concrete observer (Display)
class Display implements Observer {
    private int temperature;

    @Override
    public void update(int temperature) {
        this.temperature = temperature;
        display();
    }

    public void display() {
        System.out.println("Current Temperature: " + temperature);
    }
}

// Subject interface
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete subject (Weather Station)
class WeatherStation implements Subject {
    private List<Observer> observers;
    private int temperature;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers(); // Notify observers whenever temperature changes
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

public class WeatherApp {
    public static void main(String[] args) {
        // Create Weather Station
        WeatherStation weatherStation = new WeatherStation();

        // Create Display
        Display display = new Display();

        // Register Display with Weather Station
        weatherStation.registerObserver(display);

        // Simulate weather data updates
        weatherStation.setTemperature(25); // Update temperature to 25 degrees
        weatherStation.setTemperature(30); // Update temperature to 30 degrees

        // Output:
        // Current Temperature: 25
        // Current Temperature: 30
    }
}

