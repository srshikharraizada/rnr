package com.signon.model;


import com.signon.enums.DesignationEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="criterias")
public class Criterias implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Criterias_Id",unique = true,nullable = false)
    private long criteriaId;

    @Column(name="criterias_desc",nullable = false)
    private String criterias_desc;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
            },
            mappedBy = "criterias")
    private Set<Rewards> rewards1 = new HashSet<>();

    public Criterias() {
    }

    public Criterias(long criteriaId, String criterias_desc) {
        this.criteriaId = criteriaId;
        this.criterias_desc = criterias_desc;
    }

    public long getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(long criteriaId) {
        this.criteriaId = criteriaId;
    }

    public String getCriterias_desc() {
        return criterias_desc;
    }

    public void setCriterias_desc(String criterias_desc) {
        this.criterias_desc = criterias_desc;
    }

    public Set<Rewards> getRewards1() {
        return rewards1;
    }

    public void setRewards1(Set<Rewards> rewards1) {
        this.rewards1 = rewards1;
    }

    @Override
    public String toString() {
        return "Criterias{" +
                "criteriaId=" + criteriaId +
                ", criterias_desc='" + criterias_desc + '\'' +
                '}';
    }
}
