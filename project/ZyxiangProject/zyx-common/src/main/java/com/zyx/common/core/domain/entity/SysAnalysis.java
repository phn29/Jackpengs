package com.zyx.common.core.domain.entity;

public class SysAnalysis {
    //录取率分析
    private String rateInfo;

    //目标区域分析
    private String addressInfo;

    //目标专业分析
    private String majorInfo;

    //MBTI分析
    private String mbtiInfo;

    //院校级别
    private String universityLevel;

    //专业级别
    private String majorLevel;

    //综合评定


    public String getRateInfo() {
        return rateInfo;
    }

    public void setRateInfo(String rateInfo) {
        this.rateInfo = rateInfo;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    public String getMajorInfo() {
        return majorInfo;
    }

    public void setMajorInfo(String majorInfo) {
        this.majorInfo = majorInfo;
    }

    public String getMbtiInfo() {
        return mbtiInfo;
    }

    public void setMbtiInfo(String mbtiInfo) {
        this.mbtiInfo = mbtiInfo;
    }

    public String getUniversityLevel() {
        return universityLevel;
    }

    public void setUniversityLevel(String universityLevel) {
        this.universityLevel = universityLevel;
    }

    public String getMajorLevel() {
        return majorLevel;
    }

    public void setMajorLevel(String majorLevel) {
        this.majorLevel = majorLevel;
    }
}
