package com.zyx.common.core.domain.entity;

public class planDto {
    private Integer isGrade;

    private String batch;

    private String provinceName;

    private String cityName;

    private String majorLevel;

    private String universityType;

    private String majorCategory;

    private String universityName;

    private String majorName;

    public Integer getIsGrade() {
        return isGrade;
    }

    public void setIsGrade(Integer isGrade) {
        this.isGrade = isGrade;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getMajorLevel() {
        return majorLevel;
    }

    public void setMajorLevel(String majorLevel) {
        this.majorLevel = majorLevel;
    }

    public String getUniversityType() {
        return universityType;
    }

    public void setUniversityType(String universityType) {
        this.universityType = universityType;
    }

    public String getMajorCategory() {
        return majorCategory;
    }

    public void setMajorCategory(String majorCategory) {
        this.majorCategory = majorCategory;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    @Override
    public String toString() {
        return "planDto{" +
                "isGrade=" + isGrade +
                ", batch='" + batch + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", majorLevel='" + majorLevel + '\'' +
                ", universityType='" + universityType + '\'' +
                ", majorCategory='" + majorCategory + '\'' +
                ", universityName='" + universityName + '\'' +
                ", majorName='" + majorName + '\'' +
                '}';
    }
}
