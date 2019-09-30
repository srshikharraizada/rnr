package com.signon.model;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RewardsCriteriasId implements Serializable {

    private long rewardId;
    private long criteriaId;

    public long getRewardId() {
        return rewardId;
    }

    public void setRewardId(long rewardId) {
        this.rewardId = rewardId;
    }

    public long getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(long criteriaId) {
        this.criteriaId = criteriaId;
    }
}
