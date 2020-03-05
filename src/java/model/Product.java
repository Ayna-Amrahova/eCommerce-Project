package model;

public class Product {

    private int id;
    private String categoryId;
    private String name;
    private double price;
    private double actualPrice;
    private String info;
    private String imgPath; 

    public Product() {
    }

    public Product(int id, String categoryId, String name, double price, double actualPrice, String info, String imgPath) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
        this.actualPrice = actualPrice;
        this.info = info;
        this.imgPath = imgPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

}
