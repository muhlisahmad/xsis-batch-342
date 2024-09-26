package oop.data;

public class Car {
  private String model;
  private String manufacture;

  public Car() {
    this.model = "Ghost";
    this.manufacture = "Esemka";
  }

  public Car(String model, String manufacture) {
    this.model = model;
    this.manufacture = manufacture;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getManufacture() {
    return manufacture;
  }

  public void setManufacture(String manufacture) {
    this.manufacture = manufacture;
  }

  public String getName() {
    return manufacture + " " + model;
  }
}
