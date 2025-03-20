package com.zyx.common.core.domain.entity;

import com.zyx.common.annotation.Excel;
import com.zyx.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 一分一段表（位次表）对象 sys_ranking
 *
 * @author 张银祥
 * @date 2021-08-10
 */
public class SysRanking extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 位次id
     */
    private Long rankingId;

    /**
     * 分数段
     */
    @Excel(name = "分数段")
    private Long grade;

    /**
     * 全体本段人数
     */
    @Excel(name = "全体本段人数")
    private Long allPeopleNumber;

    /**
     * 全体本段位次
     */
    @Excel(name = "全体本段位次")
    private Long allRanking;

    /**
     * 选考物理本段人数
     */
    @Excel(name = "选考物理本段人数")
    private Long physicsPeopleNumber;

    /**
     * 选考物理累计人数
     */
    @Excel(name = "选考物理累计人数")
    private Long physicsTotalPeople;

    /**
     * 选考化学本段人数
     */
    @Excel(name = "选考化学本段人数")
    private Long chemicalPeopleNumber;

    /**
     * 选考化学累计人数
     */
    @Excel(name = "选考化学累计人数")
    private Long chemicalTotalPeople;

    /**
     * 选考生物本段人数
     */
    @Excel(name = "选考生物本段人数")
    private Long biologyPeopleNumber;

    /**
     * 选考生物累计人数
     */
    @Excel(name = "选考生物累计人数")
    private Long biologyTotalPeople;

    /**
     * 选考政治本段人数
     */
    @Excel(name = "选考政治本段人数")
    private Long politicsPeopleNumber;

    /**
     * 选考政治累计人数
     */
    @Excel(name = "选考政治累计人数")
    private Long politicsTotalPeople;

    /**
     * 选考历史本段人数
     */
    @Excel(name = "选考历史本段人数")
    private Long historyPeopleNumber;

    /**
     * 选考历史累计人数
     */
    @Excel(name = "选考历史累计人数")
    private Long historyTotalPeople;

    /**
     * 选考地理本段人数
     */
    @Excel(name = "选考地理本段人数")
    private Long geographyPeopleNumber;

    /**
     * 选考地理累计人数
     */
    @Excel(name = "选考地理累计人数")
    private Long geographyTotalPeople;

    /**
     * 年份
     */
    @Excel(name = "年份")
    private String years;

    public void setRankingId(Long rankingId) {
        this.rankingId = rankingId;
    }

    public Long getRankingId() {
        return rankingId;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }

    public Long getGrade() {
        return grade;
    }

    public void setAllPeopleNumber(Long allPeopleNumber) {
        this.allPeopleNumber = allPeopleNumber;
    }

    public Long getAllPeopleNumber() {
        return allPeopleNumber;
    }

    public void setAllRanking(Long allRanking) {
        this.allRanking = allRanking;
    }

    public Long getAllRanking() {
        return allRanking;
    }

    public void setPhysicsPeopleNumber(Long physicsPeopleNumber) {
        this.physicsPeopleNumber = physicsPeopleNumber;
    }

    public Long getPhysicsPeopleNumber() {
        return physicsPeopleNumber;
    }

    public void setPhysicsTotalPeople(Long physicsTotalPeople) {
        this.physicsTotalPeople = physicsTotalPeople;
    }

    public Long getPhysicsTotalPeople() {
        return physicsTotalPeople;
    }

    public void setChemicalPeopleNumber(Long chemicalPeopleNumber) {
        this.chemicalPeopleNumber = chemicalPeopleNumber;
    }

    public Long getChemicalPeopleNumber() {
        return chemicalPeopleNumber;
    }

    public void setChemicalTotalPeople(Long chemicalTotalPeople) {
        this.chemicalTotalPeople = chemicalTotalPeople;
    }

    public Long getChemicalTotalPeople() {
        return chemicalTotalPeople;
    }

    public void setBiologyPeopleNumber(Long biologyPeopleNumber) {
        this.biologyPeopleNumber = biologyPeopleNumber;
    }

    public Long getBiologyPeopleNumber() {
        return biologyPeopleNumber;
    }

    public void setBiologyTotalPeople(Long biologyTotalPeople) {
        this.biologyTotalPeople = biologyTotalPeople;
    }

    public Long getBiologyTotalPeople() {
        return biologyTotalPeople;
    }

    public void setPoliticsPeopleNumber(Long politicsPeopleNumber) {
        this.politicsPeopleNumber = politicsPeopleNumber;
    }

    public Long getPoliticsPeopleNumber() {
        return politicsPeopleNumber;
    }

    public void setPoliticsTotalPeople(Long politicsTotalPeople) {
        this.politicsTotalPeople = politicsTotalPeople;
    }

    public Long getPoliticsTotalPeople() {
        return politicsTotalPeople;
    }

    public void setHistoryPeopleNumber(Long historyPeopleNumber) {
        this.historyPeopleNumber = historyPeopleNumber;
    }

    public Long getHistoryPeopleNumber() {
        return historyPeopleNumber;
    }

    public void setHistoryTotalPeople(Long historyTotalPeople) {
        this.historyTotalPeople = historyTotalPeople;
    }

    public Long getHistoryTotalPeople() {
        return historyTotalPeople;
    }

    public void setGeographyPeopleNumber(Long geographyPeopleNumber) {
        this.geographyPeopleNumber = geographyPeopleNumber;
    }

    public Long getGeographyPeopleNumber() {
        return geographyPeopleNumber;
    }

    public void setGeographyTotalPeople(Long geographyTotalPeople) {
        this.geographyTotalPeople = geographyTotalPeople;
    }

    public Long getGeographyTotalPeople() {
        return geographyTotalPeople;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("rankingId", getRankingId())
                .append("grade", getGrade())
                .append("allPeopleNumber", getAllPeopleNumber())
                .append("allRanking", getAllRanking())
                .append("physicsPeopleNumber", getPhysicsPeopleNumber())
                .append("physicsTotalPeople", getPhysicsTotalPeople())
                .append("chemicalPeopleNumber", getChemicalPeopleNumber())
                .append("chemicalTotalPeople", getChemicalTotalPeople())
                .append("biologyPeopleNumber", getBiologyPeopleNumber())
                .append("biologyTotalPeople", getBiologyTotalPeople())
                .append("politicsPeopleNumber", getPoliticsPeopleNumber())
                .append("politicsTotalPeople", getPoliticsTotalPeople())
                .append("historyPeopleNumber", getHistoryPeopleNumber())
                .append("historyTotalPeople", getHistoryTotalPeople())
                .append("geographyPeopleNumber", getGeographyPeopleNumber())
                .append("geographyTotalPeople", getGeographyTotalPeople())
                .append("years", getYears())
                .toString();
    }
}
