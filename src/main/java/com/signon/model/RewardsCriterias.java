package com.signon.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "rewards_criterias")
public class RewardsCriterias{

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private RewardsCriteriasId id;


    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("Reward_Id")
    private Rewards rewards;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("Criterias_Id")
    private Criterias criterias;

    @Column(name = "isCompulsory")
    private Boolean isCompulsory;


    public RewardsCriterias() {
    }

    public RewardsCriterias(Rewards rewards, Criterias criterias) {
        this.rewards = rewards;
        this.criterias = criterias;
        this.id = new RewardsCriteriasId(rewards.getId(), criterias.getCriteriaId());
    }

    public RewardsCriterias(Rewards rewards){
        this.id=new RewardsCriteriasId(rewards.getId(),rewards.getCriterias(getCriteriaId()));
    }

    public RewardsCriteriasId getId() {
        return id;
    }

    public void setId(RewardsCriteriasId id) {
        this.id = id;
    }

    public Rewards getRewards() {
        return rewards;
    }

    public void setRewards(Rewards rewards) {
        this.rewards = rewards;
    }

    public Criterias getCriterias() {
        return criterias;
    }

    public void setCriterias(Criterias criterias) {
        this.criterias = criterias;
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
                "id=" + id +
                ", rewards=" + rewards +
                ", criterias=" + criterias +
                ", isCompulsory=" + isCompulsory +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        RewardsCriterias that = (RewardsCriterias) o;
        return Objects.equals(rewards, that.rewards) &&
                Objects.equals(criterias, that.criterias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewards, criterias);
    }
}
