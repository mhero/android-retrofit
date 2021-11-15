package com.mac.cv.model;

import com.google.gson.annotations.SerializedName;

public class Event {

    @SerializedName("id")
    private Integer id;
    @SerializedName("companyName")
    private String companyName;
    @SerializedName("projectName")
    private String projectName;
    @SerializedName("logoUrl")
    private String logoUrl;

    public Event(Integer id, String companyName, String projectName, String logoUrl) {
        this.setId(id);
        this.setCompanyName(companyName);
        this.setProjectName(projectName);
        this.setLogoUrl(logoUrl);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
