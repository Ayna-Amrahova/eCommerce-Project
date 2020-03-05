package model;

public class SelectedProducts {

    private int id;
    private String name;
    private double actualPrice;

    public SelectedProducts() {
    }

    public SelectedProducts(int id, String name, double actualPrice) {
        this.id = id;
        this.name = name;
        this.actualPrice = actualPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }



}
