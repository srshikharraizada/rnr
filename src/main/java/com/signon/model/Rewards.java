package com.signon.model;

import com.signon.enums.CategoryEnum;
import com.signon.enums.FrequencyEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="rewards")
public class Rewards implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Reward_Id",unique = true,nullable = false)
    private long rewardId;

    @Column
    private String reward_name;

    @Column
    @Enumerated(EnumType.STRING)
    private FrequencyEnum frequency;

    @Column
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;


    @Column
    private String description;

    @Column
    private LocalDate start_date;

    @Column
    private LocalDate end_date;

    @Column
    private boolean regenerated=true;


    @Column
    private boolean self_nominate;

    @Column
    private int nominations_allowed;

    @Column
    private String award_status;

    @Column
    private Date discontinuingDate;

    @Column
    private String discontinuingReason;


    //CRITERIAS

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "rewards_criterias",
            joinColumns = {@JoinColumn(name = "Reward_Id")},
            inverseJoinColumns = {@JoinColumn(name = "Criterias_Id")}
    )
    private Set<Criterias> criterias = new HashSet<>();



    public Rewards() {
    }

    public long getRewardId() {
        return rewardId;
    }

    public void setRewardId(long rewardId) {
        this.rewardId = rewardId;
    }

    public String getReward_name() {
        return reward_name;
    }

    public void setReward_name(String reward_name) {
        this.reward_name = reward_name;
    }

    public FrequencyEnum getFrequency() {
        return frequency;
    }

    public void setFrequency(FrequencyEnum frequency) {
        this.frequency = frequency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate  start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public boolean isRegenerated() {
        return regenerated;
    }

    public void setRegenerated(boolean regenerated) {
        this.regenerated = regenerated;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public boolean isSelf_nominate() {
        return self_nominate;
    }

    public void setSelf_nominate(boolean self_nominate) {
        this.self_nominate = self_nominate;
    }

    public int getNominations_allowed() {
        return nominations_allowed;
    }

    public void setNominations_allowed(int nominations_allowed) {
        this.nominations_allowed = nominations_allowed;
    }

    public String getAward_status() {
        return award_status;
    }

    public void setAward_status(String award_status) {
        this.award_status = award_status;
    }

    public Date getDiscontinuingDate() {
        return discontinuingDate;
    }

    public void setDiscontinuingDate(Date discontinuingDate) {
        this.discontinuingDate = discontinuingDate;
    }

    public String getDiscontinuingReason() {
        return discontinuingReason;
    }

    public void setDiscontinuingReason(String discontinuingReason) {
        this.discontinuingReason = discontinuingReason;
    }


    public Set<Criterias> getCriterias() {
        return criterias;
    }

    public void setCriterias(Set<Criterias> criterias) {
        this.criterias = criterias;
    }

    @Override
    public String toString() {
        return "Rewards{" +
                "id=" + rewardId +
                ", reward_name='" + reward_name + '\'' +
                ", frequency=" + frequency +
                ", description='" + description + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +

                ", self_nominate=" + self_nominate +
                ", nominations_allowed=" + nominations_allowed +
                ", award_status='" + award_status + '\'' +
                ", discontinuingDate=" + discontinuingDate +
                ", discontinuingReason='" + discontinuingReason + '\'' +
                '}';
    }
}
