package com.example.cst2335finalproject;

public class Favorites {
    private String article;
    private String category;
    private String url;
    private long id;

    public Favorites(String article, String category, String url, long id) {
        this.article = article;
        this.category = category;
        this.url = url;
        this.id = id;
    }

    public void update(String article, String category, String url) {
        this.article = article;
        this.category = category;
        this.url = url;
    }

    public String getArticle() {
        return article;
    }

    public String getCategory() {
        return category;
    }

    public String getUrl() {
        return url;
    }

    public long getId() {
        return id;
    }
}

