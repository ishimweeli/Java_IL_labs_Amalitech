package week2_IL_labs;

public class Adapter {

    // CelsiusTemperaturePredictor class
    public class CelsiusTemperaturePredictor {
        public boolean willRain(double temperature) {
            return temperature < 2;
        }
    }

    // FahrenheitData class
    public class FahrenheitData {
        public double getTemperature() {
            return 35; // Example Fahrenheit temperature data
        }
    }

    // TemperatureAdapter class
    public class TemperatureAdapter {
        public double convertToFahrenheit(double celsiusTemperature) {
            return (celsiusTemperature * 9 / 5) + 32;
        }
    }

    // Main method
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        FahrenheitData fahrenheitData = adapter.new FahrenheitData();
        TemperatureAdapter tempAdapter = adapter.new TemperatureAdapter();
        double fahrenheitTemperature = fahrenheitData.getTemperature();
        double celsiusTemperature = (fahrenheitTemperature - 32) * 5 / 9;
        CelsiusTemperaturePredictor predictor = adapter.new CelsiusTemperaturePredictor();
        boolean willRain = predictor.willRain(celsiusTemperature);
        System.out.println("Temperature in Celsius: " + celsiusTemperature);
        System.out.println("Prediction: It will " + (willRain ? "rain" : "not rain"));
    }
}
