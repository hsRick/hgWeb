package com.hg.reading.springstart.pojo;

public class HgUsers {
    private int userid;
    private String username;
    private String password;
    private String sex;
    private String text;
    private String img;
    private String bimg;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public HgUsers() {
    }

    public HgUsers(int userid, String username, String password, String sex, String text) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.text = text;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBimg() {
        return bimg;
    }

    public void setBimg(String bimg) {
        this.bimg = bimg;
    }

    @Override
    public String toString() {
        return "HgUsers{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", text='" + text + '\'' +
                ", img='" + img + '\'' +
                ", bimg='" + bimg + '\'' +
                '}';
    }
}
