package com.example.myapplication;

public class Book {
    private  int id;
    private String name;
    private String Author;
    private int pages;
    private String imageUrl;
    private String sortDesc;
    private String LongDesc;
    private boolean isExpanded;

    public Book(int id, String name, String author, int pages, String imageUrl, String sortDesc, String longDesc) {
        this.id = id;
        this.name = name;
        Author = author;
        this.pages = pages;
        this.imageUrl = imageUrl;
        this.sortDesc = sortDesc;
        LongDesc = longDesc;
        this.isExpanded = false;

    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
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

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSortDesc() {
        return sortDesc;
    }

    public void setSortDesc(String sortDesc) {
        this.sortDesc = sortDesc;
    }

    public String getLongDesc() {
        return LongDesc;
    }

    public void setLongDesc(String longDesc) {
        LongDesc = longDesc;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Author='" + Author + '\'' +
                ", pages=" + pages +
                ", imageUrl='" + imageUrl + '\'' +
                ", sortDesc='" + sortDesc + '\'' +
                ", LongDesc='" + LongDesc + '\'' +
                '}';
    }
}
