package com.example.demo2.Objects;

import java.util.List;

public class Room {
   public static int capacity;
    public static double max_amount, current_amount;
    public static List<Toy> toys;

    public Room()
    {
        capacity = 0;
        max_amount = 0.0;
        current_amount  = 0.0;
    }
    public Room(int rcapacity, double rmax_amount, List<Toy> toysl)
    {
        capacity = rcapacity;
        max_amount = rmax_amount;
        toys.addAll(toysl);
    }

    public static int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        Room.capacity = capacity;
    }

    public static double getMax_amount() {
        return max_amount;
    }
    public void setMax_amount(double max_amount) {
        Room.max_amount = max_amount;
    }

    public List<Toy> getToys() {
        return toys;
    }
    public void setToys(List<Toy> toys) {
        Room.toys = toys;
    }
    public static void setToy(Toy toy){Room.toys.add(toy);}

    public static double getCurrent_amount(List<Toy> toys)
    {
        current_amount = 0.0;
        for (Toy toy : toys) {
            current_amount += toy.getCost();
        }
        return current_amount;
    }
    public static void SortToysByName(List<Toy> toys)
    {
        Toy temp;
        for(int i = 0; i<toys.size();i++)
            for(int j = i+1;j<toys.size();j++)
                if(toys.get(i).getName().compareTo(toys.get(j).getName())>0) {
                    temp = toys.get(i);
                    toys.set(i,toys.get(j));
                    toys.set(j,temp);
        }
    }
    public static void SortToysByCost(List<Toy> toys)
    {
        Toy temp;
        for(int i = 0; i<toys.size();i++)
            for(int j = i+1;j<toys.size();j++)
                if(toys.get(i).getCost()<(toys.get(j).getCost())) {
                    temp = toys.get(i);
                    toys.set(i,toys.get(j));
                    toys.set(j,temp);
                }
    }
    public static void SortToysByType(List<Toy> toys)
    {
        Toy temp;
        for(int i = 0; i<toys.size();i++)
            for(int j = i+1;j<toys.size();j++)
                if(toys.get(i).getType().compareTo(toys.get(j).getType())<0) {
                    temp = toys.get(i);
                    toys.set(i,toys.get(j));
                    toys.set(j,temp);
                }
    }
    public static void SortToysBySize(List<Toy> toys)
    {
        Toy temp;
        for(int i = 0; i<toys.size();i++)
            for(int j = i+1;j<toys.size();j++)
                if(toys.get(i).getSize_category().compareTo(toys.get(j).getSize_category())<0) {
                    temp = toys.get(i);
                    toys.set(i,toys.get(j));
                    toys.set(j,temp);
                }
    }
    @Override
    public String toString() {
        return "Room{capacity=" + capacity + ", max_amount=" + max_amount +
                "$, toys=" + toys + "}\n";
    }
}
