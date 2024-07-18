public class Car implements Comparable<Car> {
  
    private String brand;
    private String modelName;
    private long modelYear;

    // Constructor
    public Car(String brand, String modelName, long modelYear) {
        this.brand = brand;
        this.modelName = modelName;
        this.modelYear = modelYear;
    }

    // Getters and setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public long getModelYear() {
        return modelYear;
    }

    public void setModelYear(long modelYear) {
        this.modelYear = modelYear;
    }

    // Implementing Comparable interface
    @Override
    public int compareTo(Car otherCar) {
        return Long.compare(this.modelYear, otherCar.getModelYear());
    }

    // toString method for better representation
    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", modelName='" + modelName + '\'' +
                ", modelYear=" + modelYear +
                '}';
    }
}
