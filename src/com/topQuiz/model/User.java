package com.topQuiz.model;

public class User {
    private int id;
    private String username;
    private int maxSocre;
    private int curScore;



    public User(int id, String username, int maxSocre) {
        this.id = id;
        this.username = username;
        this.maxSocre = maxSocre;
        this.curScore = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMaxSocre() {
        return maxSocre;
    }

    public void setMaxSocre(int maxSocre) {
        this.maxSocre = maxSocre;
    }

    public int getCurScore() {
        return curScore;
    }

    public void setCurScore(int curScore) {
        this.curScore = curScore;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", maxSocre=" + maxSocre +
                '}';
    }
}
