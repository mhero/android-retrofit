package com.mac.cv.model;

import com.google.gson.annotations.SerializedName;

public class Event {

    @SerializedName("id")
    private Integer id;
    @SerializedName("companyName")
    private String title;
    @SerializedName("projectName")
    private String url;
    @SerializedName("logoUrl")
    private String thumbnailUrl;

    public Event(Integer albumId, Integer id, String title, String url, String thumbnailUrl) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
