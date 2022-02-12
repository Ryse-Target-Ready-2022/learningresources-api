package com.tgt.rysetii.learningresourcesapi.entity;

import java.time.LocalDate;

public class LearningResource {
    private Integer learningResourceId;
    private String learningResourceName;
    private Double costPrice;
    private Double sellingPrice;
    private LearningResourceStatus learningResourceStatus;
    private LocalDate createdDate;
    private LocalDate publishedDate;
    private LocalDate retiredDate;

    public LearningResource() {
    }

    public LearningResource(Integer learningResourceId, String learningResourceName, Double costPrice, Double sellingPrice, LearningResourceStatus learningResourceStatus, LocalDate createdDate, LocalDate publishedDate, LocalDate retiredDate) {
        this.learningResourceId = learningResourceId;
        this.learningResourceName = learningResourceName;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.learningResourceStatus = learningResourceStatus;
        this.createdDate = createdDate;
        this.publishedDate = publishedDate;
        this.retiredDate = retiredDate;
    }

    public Integer getLearningResourceId() {
        return learningResourceId;
    }

    public void setLearningResourceId(Integer learningResourceId) {
        this.learningResourceId = learningResourceId;
    }

    public String getLearningResourceName() {
        return learningResourceName;
    }

    public void setLearningResourceNameName(String learningResourceName) {
        this.learningResourceName = learningResourceName;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public LearningResourceStatus getLearningResourceStatus() {
        return learningResourceStatus;
    }

    public void setLearningResourceStatus(LearningResourceStatus learningResourceStatus) {
        this.learningResourceStatus = learningResourceStatus;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public LocalDate getRetiredDate() {
        return retiredDate;
    }

    public void setRetiredDate(LocalDate retiredDate) {
        this.retiredDate = retiredDate;
    }

    @Override
    public String toString() {
        return "LearningResource{" +
                "learningResourceId=" + learningResourceId +
                ", learningResourceName='" + learningResourceName + '\'' +
                ", costPrice=" + costPrice +
                ", sellingPrice=" + sellingPrice +
                ", learningResourceStatus=" + learningResourceStatus +
                ", createdDate=" + createdDate +
                ", publishedDate=" + publishedDate +
                ", retiredDate=" + retiredDate +
                '}';
    }
}
