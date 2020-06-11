package model;

public class Blog {

    private int id;
    private String imgPath;
    private String header;
    private String text;
    private String btnInfo;
    private String likeImg;
    private String lastComment;

    public Blog(int id, String imgPath, String header, String text, String btnInfo, String likeImg, String lastComment) {
        this.id = id;
        this.imgPath = imgPath;
        this.header = header;
        this.text = text;
        this.btnInfo = btnInfo;
        this.likeImg = likeImg;
        this.lastComment = lastComment;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBtnInfo() {
        return btnInfo;
    }

    public void setBtnInfo(String btnInfo) {
        this.btnInfo = btnInfo;
    }

    public String getLikeImg() {
        return likeImg;
    }

    public void setLikeImg(String likeImg) {
        this.likeImg = likeImg;
    }

    public String getLastComment() {
        return lastComment;
    }

    public void setLastComment(String lastComment) {
        this.lastComment = lastComment;
    }

}
