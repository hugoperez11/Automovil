package dev.hugo;

public class Car {
    // Enumerations for fuel type, car type, and colors
    public enum FuelType { GASOLINE, BIOETHANOL, DIESEL, BIODIESEL, NATURAL_GAS }
    public enum CarType { CITY_CAR, SUBCOMPACT, COMPACT, FAMILY, EXECUTIVE, SUV }
    public enum Color { WHITE, BLACK, RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET }

    // Attributes of the Car class
    private String brand;
    private int modelYear;
    private double engineVolume;
    private FuelType fuelType;
    private CarType carType;
    private int doorCount;
    private int seatCount;
    private int maxSpeed;
    private Color color;
    private int currentSpeed;
    private boolean isAutomatic;
    private int fines;

    // Constructor
    public Car(String brand, int modelYear, double engineVolume, FuelType fuelType, CarType carType,
               int doorCount, int seatCount, int maxSpeed, Color color, boolean isAutomatic) {
        this.brand = brand;
        this.modelYear = modelYear;
        this.engineVolume = engineVolume;
        this.fuelType = fuelType;
        this.carType = carType;
        this.doorCount = doorCount;
        this.seatCount = seatCount;
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.currentSpeed = 0;
        this.isAutomatic = isAutomatic;
        this.fines = 0;
    }

    // Getters and setters
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public int getModelYear() { return modelYear; }
    public void setModelYear(int modelYear) { this.modelYear = modelYear; }

    public double getEngineVolume() { return engineVolume; }
    public void setEngineVolume(double engineVolume) { this.engineVolume = engineVolume; }

    public FuelType getFuelType() { return fuelType; }
    public void setFuelType(FuelType fuelType) { this.fuelType = fuelType; }

    public CarType getCarType() { return carType; }
    public void setCarType(CarType carType) { this.carType = carType; }

    public int getDoorCount() { return doorCount; }
    public void setDoorCount(int doorCount) { this.doorCount = doorCount; }

    public int getSeatCount() { return seatCount; }
    public void setSeatCount(int seatCount) { this.seatCount = seatCount; }

    public int getMaxSpeed() { return maxSpeed; }
    public void setMaxSpeed(int maxSpeed) { this.maxSpeed = maxSpeed; }

    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }

    public int getCurrentSpeed() { return currentSpeed; }
    public void setCurrentSpeed(int currentSpeed) { this.currentSpeed = currentSpeed; }

    public boolean isAutomatic() { return isAutomatic; }
    public void setAutomatic(boolean isAutomatic) { this.isAutomatic = isAutomatic; }

    public int getFines() { return fines; }

    // Methods for accelerating, decelerating and braking
    public void accelerate(int increment) {
        if (currentSpeed + increment > maxSpeed) {
            currentSpeed = maxSpeed;
            fines++;
            System.out.println("You have received a fine for exceeding the maximum speed.");
        } else {
            currentSpeed += increment;
        }
    }

    public void decelerate(int decrement) {
        if (currentSpeed - decrement < 0) {
            currentSpeed = 0;
            System.out.println("The car has come to a stop.");
        } else {
            currentSpeed -= decrement;
        }
    }

    public void brake() {
        currentSpeed = 0;
        System.out.println("The car has come to a complete stop.");
    }

    // Method to calculate the estimated arrival time
    public double calculateEstimatedTime(double distance) {
        if (currentSpeed == 0) {
            throw new IllegalStateException("The car is stopped. Cannot calculate estimated time.");
        }
        return distance / currentSpeed;
    }

    // Method to display the attributes of the car
    public void displayAttributes() {
        System.out.println("Brand: " + brand);
        System.out.println("Model Year: " + modelYear);
        System.out.println("Engine Volume: " + engineVolume + " liters");
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Car Type: " + carType);
        System.out.println("Door Count: " + doorCount);
        System.out.println("Seat Count: " + seatCount);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Color: " + color);
        System.out.println("Current Speed: " + currentSpeed + " km/h");
        System.out.println("Automatic: " + (isAutomatic ? "Yes" : "No"));
        System.out.println("Fines: " + fines);
    }

    // Method to get the total value of fines
    public int getTotalFines() {
        return fines * 100; // Assuming each fine is 100 units of currency
    }

    public static void main(String[] args) {
        Car car = new Car("Toyota", 2021, 1.8, FuelType.GASOLINE, CarType.COMPACT, 
                          4, 5, 180, Color.BLUE, true);
        car.setCurrentSpeed(100);
        car.displayAttributes();

        car.accelerate(20);
        System.out.println("Current Speed: " + car.getCurrentSpeed() + " km/h");

        car.decelerate(50);
        System.out.println("Current Speed: " + car.getCurrentSpeed() + " km/h");

        car.brake();
        System.out.println("Current Speed: " + car.getCurrentSpeed() + " km/h");
    }
}
