package dev.hugo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void testAccelerate() {
        Car car = new Car("Toyota", 2021, 1.8, Car.FuelType.GASOLINE, Car.CarType.COMPACT, 
                          4, 5, 180, Car.Color.BLUE, true);
        car.accelerate(50);
        assertEquals(50, car.getCurrentSpeed());

        car.accelerate(200);
        assertEquals(180, car.getCurrentSpeed());
        assertEquals(1, car.getFines());
    }

    @Test
    public void testDecelerate() {
        Car car = new Car("Toyota", 2021, 1.8, Car.FuelType.GASOLINE, Car.CarType.COMPACT, 
                          4, 5, 180, Car.Color.BLUE, true);
        car.accelerate(100);
        car.decelerate(30);
        assertEquals(70, car.getCurrentSpeed());

        car.decelerate(100);
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    public void testBrake() {
        Car car = new Car("Toyota", 2021, 1.8, Car.FuelType.GASOLINE, Car.CarType.COMPACT, 
                          4, 5, 180, Car.Color.BLUE, true);
        car.accelerate(100);
        car.brake();
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    public void testCalculateEstimatedTime() {
        Car car = new Car("Toyota", 2021, 1.8, Car.FuelType.GASOLINE, Car.CarType.COMPACT, 
                          4, 5, 180, Car.Color.BLUE, true);
        car.accelerate(90);
        double time = car.calculateEstimatedTime(180);
        assertEquals(2.0, time);

        car.brake();
        assertThrows(IllegalStateException.class, () -> {
            car.calculateEstimatedTime(100);
        });
    }

    @Test
public void testCarConstructor() {
    Car car = new Car("Ford", 2023, 2.0, Car.FuelType.DIESEL, Car.CarType.SUV, 
                      5, 7, 200, Car.Color.GREEN, false);
    assertEquals("Ford", car.getBrand());
    assertEquals(2023, car.getModelYear());
    assertEquals(2.0, car.getEngineVolume());
    assertEquals(Car.FuelType.DIESEL, car.getFuelType());
    assertEquals(Car.CarType.SUV, car.getCarType());
    assertEquals(5, car.getDoorCount());
    assertEquals(7, car.getSeatCount());
    assertEquals(200, car.getMaxSpeed());
    assertEquals(Car.Color.GREEN, car.getColor());
    assertFalse(car.isAutomatic());
}

@Test
public void testAccelerateAboveMaxSpeed() {
    Car car = new Car("Honda", 2022, 1.5, Car.FuelType.BIOETHANOL, Car.CarType.FAMILY, 
                      4, 5, 150, Car.Color.RED, true);
    car.accelerate(160);
    assertEquals(150, car.getCurrentSpeed());
    assertEquals(1, car.getFines());
}

@Test
public void testDecelerateBelowZero() {
    Car car = new Car("BMW", 2020, 3.0, Car.FuelType.NATURAL_GAS, Car.CarType.EXECUTIVE, 
                      4, 4, 220, Car.Color.BLACK, true);
    car.accelerate(100);
    car.decelerate(150);
    assertEquals(0, car.getCurrentSpeed());
}

@Test
public void testCalculateEstimatedTimeWithValidSpeed() {
    Car car = new Car("Nissan", 2024, 1.6, Car.FuelType.BIODIESEL, Car.CarType.SUBCOMPACT, 
                      4, 4, 180, Car.Color.YELLOW, true);
    car.accelerate(60);
    double time = car.calculateEstimatedTime(120);
    assertEquals(2.0, time, 0.01);
}

@Test
public void testCalculateEstimatedTimeWhenStopped() {
    Car car = new Car("Chevrolet", 2021, 2.5, Car.FuelType.GASOLINE, Car.CarType.CITY_CAR, 
                      2, 2, 140, Car.Color.WHITE, false);
    car.brake();
    assertThrows(IllegalStateException.class, () -> {
        car.calculateEstimatedTime(100);
    });
}

}
