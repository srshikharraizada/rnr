package com.signon.model;

import com.signon.enums.FrequencyEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="rewards")
public class Rewards implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reward_id",unique = true,nullable = false)
    private long rewardId;

    @Column
    private String reward_name;

    @Column
    @Enumerated(EnumType.STRING)
    private FrequencyEnum frequency;

    @Column
    private String description;

    @Column
    private Date start_date;

    @Column
    private Date end_date;


    @Column
    private boolean self_nominate;

    @Column
    private int nominations_allowed;

    @Column
    private int award_status = 0;

    @Column
    private Date discontinuingDate;

    @Column
    private String discontinuingReason;


    @OneToMany(
            mappedBy = "rewards"
    )
    private List<RewardsCriterias> criterias = new ArrayList<>();


/*
    //CRITERIAS

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "rewards_criterias",
            joinColumns = {@JoinColumn(name = "Reward_Id")},
            inverseJoinColumns = {@JoinColumn(name = "Criterias_Id")}

    )
    private Set<RewardsCriterias> criterias= new HashSet<>();*/
//    private Set<Criterias> criterias = new HashSet<>();


   // private Set<RewardsCriterias> rewardsCriterias= new HashSet<>();


    //nominations

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {

                    CascadeType.MERGE,
            },
            mappedBy = "rewards2")
    private Set<UserInfo> userInfo4 = new HashSet<>();


    public Rewards() {
    }

    public Rewards(String reward_name, FrequencyEnum frequency, String description, Date start_date, Date end_date, boolean self_nominate, int nominations_allowed, int award_status, Date discontinuingDate, String discontinuingReason, List<RewardsCriterias> criterias, Set<UserInfo> userInfo4) {
        this.reward_name = reward_name;
        this.frequency = frequency;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.self_nominate = self_nominate;
        this.nominations_allowed = nominations_allowed;
        this.award_status = award_status;
        this.discontinuingDate = discontinuingDate;
        this.discontinuingReason = discontinuingReason;
        this.criterias = criterias;
        this.userInfo4 = userInfo4;
    }

    public long getId() {
        return rewardId;
    }

    public void setId(long id) {
        this.rewardId = id;
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

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
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

    public int getAward_status() {
        return award_status;
    }

    public void setAward_status(int award_status) {
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

    public List<RewardsCriterias> getCriterias() {
        return criterias;
    }

    public void setCriterias(List<RewardsCriterias> criterias) {
        this.criterias = criterias;
    }


    //    public Set<Criterias> getCriterias() {
//        return criterias;
//    }
//
//    public void setCriterias(Set<Criterias> criterias) {
//        this.criterias = criterias;
//    }


    public Set<UserInfo> getUserInfo4() {
        return userInfo4;
    }

    public void setUserInfo4(Set<UserInfo> userInfo4) {
        this.userInfo4 = userInfo4;
    }
//
//    public Set<RewardsCriterias> getRewardsCriterias() {
//        return rewardsCriterias;
//    }
//
//    public void setRewardsCriterias(Set<RewardsCriterias> rewardsCriterias) {
//        this.rewardsCriterias = rewardsCriterias;
//    }

/*

    public Set<RewardsCriterias> getCriterias() {
        return criterias;
    }

    public void setCriterias(Set<RewardsCriterias> criterias) {
        this.criterias = criterias;
    }
*/

    public long getRewardId() {
        return rewardId;
    }

    public void setRewardId(long rewardId) {
        this.rewardId = rewardId;
    }


    @Override
    public String toString() {
        return "Rewards{" +
                "rewardId=" + rewardId +
                ", reward_name='" + reward_name + '\'' +
                ", frequency=" + frequency +
                ", description='" + description + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", self_nominate=" + self_nominate +
                ", nominations_allowed=" + nominations_allowed +
                ", award_status=" + award_status +
                ", discontinuingDate=" + discontinuingDate +
                ", discontinuingReason='" + discontinuingReason + '\'' +
                ", criterias=" + criterias +
//                ", rewardsCriterias=" + rewardsCriterias +
                ", userInfo4=" + userInfo4 +
                '}';
    }

   /* public void add(Tag tag) {
        PostTag postTag = new PostTag(this, tag);
        tags.add(postTag);
        tag.getPosts().add(postTag);*/
//    }







}
