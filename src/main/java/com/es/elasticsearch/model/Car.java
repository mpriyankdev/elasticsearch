package com.es.elasticsearch.model;

import java.util.Objects;

public class Car {

    private String type;
    private String model;
    private String make;
    private Integer year;

    public Car(String type, String model, String make, Integer year) {
        this.type = type;
        this.model = model;
        this.make = make;
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(type, car.type) &&
                Objects.equals(model, car.model) &&
                Objects.equals(make, car.make) &&
                Objects.equals(year, car.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, model, make, year);
    }
}
