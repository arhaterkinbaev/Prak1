import java.util.ArrayList;
import java.util.List;

class Vehicle {
    private String brand;
    private String model;
    private int year;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public void startEngine() {
        System.out.println(brand + " " + model + " двигатель запущен.");
    }

    public void stopEngine() {
        System.out.println(brand + " " + model + " двигатель остановлен.");
    }
}

class Car extends Vehicle {
    private int doors;
    private String transmissionType;

    public Car(String brand, String model, int year, int doors, String transmissionType) {
        super(brand, model, year);
        this.doors = doors;
        this.transmissionType = transmissionType;
    }
}

class Motorcycle extends Vehicle {
    private String bodyType;
    private boolean hasBox;

    public Motorcycle(String brand, String model, int year, String bodyType, boolean hasBox) {
        super(brand, model, year);
        this.bodyType = bodyType;
        this.hasBox = hasBox;
    }
}

class Garage {
    private List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println(vehicle.getBrand() + " " + vehicle.getModel() + " добавлен в гараж.");
    }

    public void delVehicle(Vehicle vehicle) {
        if (vehicles.remove(vehicle)) {
            System.out.println(vehicle.getBrand() + " " + vehicle.getModel() + " удален из гаража.");
        } else {
            System.out.println(vehicle.getBrand() + " " + vehicle.getModel() + " не найден в гараже.");
        }
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}

class Autopark {
    private List<Garage> garages = new ArrayList<>();

    public void addGarage(Garage garage) {
        garages.add(garage);
        System.out.println("Гараж добавлен в автопарк.");
    }

    public void delGarage(Garage garage) {
        if (garages.remove(garage)) {
            System.out.println("Гараж удален из автопарка.");
        } else {
            System.out.println("Гараж не найден в автопарке.");
        }
    }

    public void poisk(String brand, String model) {
        for (Garage garage : garages) {
            for (Vehicle vehicle : garage.getVehicles()) {
                if (vehicle.getBrand().equals(brand) && vehicle.getModel().equals(model)) {
                    System.out.println("Машина " + brand + " " + model + " найдена!");
                    return;
                }
            }
        }
        System.out.println("Машина " + brand + " " + model + " не найдена.");
    }
}

public class Main {
    public static void main(String[] args) {
        Garage myGarage = new Garage();
        myGarage.addVehicle(new Car("BMW", "M3 GTR", 2001, 2, "Механическая"));
        myGarage.addVehicle(new Motorcycle("Ferrari", "458 Italia", 2010, "Спорткар", false));

        Autopark myAutopark = new Autopark();
        myAutopark.addGarage(myGarage);

        System.out.println("Машины в гараже:");
        for (Vehicle vehicle : myGarage.getVehicles()) {
            System.out.println("Марка: " + vehicle.getBrand() + ", Модель: " + vehicle.getModel() + ", Год выпуска: " + vehicle.getYear());
        }

        myGarage.getVehicles().get(0).startEngine();
        myGarage.getVehicles().get(0).stopEngine();
        myGarage.delVehicle(myGarage.getVehicles().get(0));

        myAutopark.poisk("BMW", "M3 GTR");
    }
}
