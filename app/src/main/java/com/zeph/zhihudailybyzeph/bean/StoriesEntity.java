package com.zeph.zhihudailybyzeph.bean;


import java.util.List;

public class StoriesEntity {

  private int id;
  private String title;
  private List<String> images;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<String> getImages() {
    return images;
  }

  public void setImages(List<String> images) {
    this.images = images;
  }
}
