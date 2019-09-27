package com.signon.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RewardsCriteriasId implements Serializable {


    @Column(name = "Reward_Id")
    private long rewardid;

    @Column(name = "Criterias_Id")
    private long criteriaId;

    public RewardsCriteriasId() {
    }

    public RewardsCriteriasId(long rewardid, long criteriaId) {
        this.rewardid = rewardid;
        this.criteriaId = criteriaId;
    }

    public long getRewardid() {
        return rewardid;
    }

    public void setRewardid(long rewardid) {
        this.rewardid = rewardid;
    }

    public long getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(long criteriaId) {
        this.criteriaId = criteriaId;
    }

    @Override
    public String toString() {
        return "RewardsCriteriasId{" +
                "rewardid=" + rewardid +
                ", criteriaId=" + criteriaId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        RewardsCriteriasId that = (RewardsCriteriasId) o;
        return Objects.equals(rewardid, that.rewardid) &&
                Objects.equals(criteriaId, that.criteriaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardid, criteriaId);
    }
}
