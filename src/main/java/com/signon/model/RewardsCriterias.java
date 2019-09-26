package com.signon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "rewards_criterias")
public class RewardsCriterias implements Serializable {

    @Id
    @Column(name = "Reward_Id")
    private long rewardid;

    @Column(name = "Criterias_Id")
    private long criteriaId;

    @Column(name = "isCompulsory")
    private Boolean isCompulsory;

    public RewardsCriterias() {
    }

    public RewardsCriterias(long rewardId, long criteriaId, Boolean isCompulsory) {
        this.rewardid = rewardId;
        this.criteriaId = criteriaId;
        this.isCompulsory = isCompulsory;
    }

    public long getRewardId() {
        return rewardid;
    }

    public void setRewardId(long rewardId) {
        this.rewardid = rewardId;
    }

    public long getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(long criteriaId) {
        this.criteriaId = criteriaId;
    }

    public Boolean getCompulsory() {
        return isCompulsory;
    }

    public void setCompulsory(Boolean compulsory) {
        isCompulsory = compulsory;
    }

    @Override
    public String toString() {
        return "RewardsCriterias{" +
                "rewardId=" + rewardid +
                ", criteriaId=" + criteriaId +
                ", isCompulsory=" + isCompulsory +
                '}';
    }
}
