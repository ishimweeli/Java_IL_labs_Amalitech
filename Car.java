public class Car {
    private String model;
    private int year;
    private Engine engine;

    public Car(String model, int year, int horsePower) {
        this.model = model;
        this.year = year;
        this.engine = new Engine(horsePower);
    }

    public void start() {
        System.out.println("Starting the " + model + "...");
        engine.startEngine();
        System.out.println(model + " has started!");
    }

    private class Engine {
        private int horsePower;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
        }

        public void startEngine() {
            System.out.println("Engine with " + horsePower + " horse power has started.");
        }
    }

    public static void main(String[] args) {
        Car myCar = new Car("Toyota Camry", 2022, 250);
        myCar.start();
    }
}
