package model;

public class About {

    private int id;
    private String imgPath;
    private String paragraph;

    public About() {
    }

    public About(int id, String imgPath, String paragraph) {
        this.id = id;
        this.imgPath = imgPath;
        this.paragraph = paragraph;
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

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }
}
