package model;

public class HomeFooter {

    private int id;
    private String imgPath;

    public HomeFooter() {
    }

    public HomeFooter(int id, String imgPath) {
        this.id = id;
        this.imgPath = imgPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

}
