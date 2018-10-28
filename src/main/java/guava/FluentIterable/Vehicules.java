package guava.FluentIterable;

import java.util.List;

enum Color {
    BLACK, GREEN, RED, BLUE
}

public class Vehicules {
    private String brand;
    private String model;
    private Color color;
    private List<User> users;

    public Vehicules(String brand, String model, Color color, List<User> users) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.users = users;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
