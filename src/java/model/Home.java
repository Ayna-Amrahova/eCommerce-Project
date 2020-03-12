package model;

public class Home {

    private int id;
    private String imgPath;
    private String header;
    private String paragraph;
    private String btnInfo;

    private String imgPath2;
    private String header2;
    private String paragraph2;

    private String imgPath3;

    public Home() {
    }

    public Home(int id, String imgPath3) {
        this.id = id;
        this.imgPath3 = imgPath3;
    }

    public String getImgPath3() {
        return imgPath3;
    }

    public void setImgPath3(String imgPath3) {
        this.imgPath3 = imgPath3;
    }

    public Home(int id, String imgPath2, String header2, String paragraph2) {
        this.id = id;
        this.imgPath2 = imgPath2;
        this.header2 = header2;
        this.paragraph2 = paragraph2;
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

    public String getImgPath2() {
        return imgPath2;
    }

    public void setImgPath2(String imgPath2) {
        this.imgPath2 = imgPath2;
    }

    public String getHeader2() {
        return header2;
    }

    public void setHeader2(String header2) {
        this.header2 = header2;
    }

    public String getParagraph2() {
        return paragraph2;
    }

    public void setParagraph2(String paragraph2) {
        this.paragraph2 = paragraph2;
    }

}
