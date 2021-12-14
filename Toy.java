package com.example.demo2.Objects;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class Toy {
    private String type, name,size_category;
    private double cost;
    private  int number;

    public Toy()
    {
        type = "Default";
        name = "None";
        cost = 0.0;
        size_category = "Default";
        number = 0;
    }
    public Toy(String type,String name, double cost,String size_category, int number)
    {
        this.type = type;
        this.name = name;
        this.cost = cost;
        this.size_category = size_category;
        this.number = number;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getSize_category() {
        return size_category;
    }
    public void setSize_category(String size_category) {
        this.size_category = size_category;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "type ='" + type + '\'' +
                ", name ='" + name + '\'' +
                ", size_category ='" + size_category + '\'' +
                ", cost =" + cost +
                "$, number =" + number +
                '}';
    }
}
