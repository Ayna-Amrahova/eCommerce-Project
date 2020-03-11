package model;

public class Home {

    private int id;
    private String imgPath;
    private String header;
    private String paragraph;
    private String btnInfo;

    public Home() {
    }

    public Home(int id, String imgPath, String header, String paragraph, String btnInfo) {
        this.id = id;
        this.imgPath = imgPath;
        this.header = header;
        this.paragraph = paragraph;
        this.btnInfo = btnInfo;
    }

    public String getBtnInfo() {
        return btnInfo;
    }

    public void setBtnInfo(String btnInfo) {
        this.btnInfo = btnInfo;
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

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

}
