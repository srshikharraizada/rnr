package com.signon.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "nominations")
public class Nominations implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nomination_id")
    private Long NominationID;
    @Column(name = "projectname")
    private String projectname;
    @Column(name = "rewardID", updatable = false, nullable = false)
    private String rewardID;
    @Column(name = "User_id", updatable = false, nullable = false)
    private Long userid;
    @Column(name = "frequency")
    private String frequency;
    @Column(name = "startingdate")
    private Date startingdate;
    @Column(name = "endingdate")
    private Date endingdate;

    @OneToMany(mappedBy = "nominations", cascade = CascadeType.ALL)
    List<Evidences> evidencesList;


    public Long getNominationID() {
        return NominationID;
    }

    public void setNominationID(Long nominationID) {
        NominationID = nominationID;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getRewardID() {
        return rewardID;
    }

    public void setRewardID(String rewardID) {
        this.rewardID = rewardID;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Date getStartingdate() {
        return startingdate;
    }

    public void setStartingdate(Date startingdate) {
        this.startingdate = startingdate;
    }

    public Date getEndingdate() {
        return endingdate;
    }

    public void setEndingdate(Date endingdate) {
        this.endingdate = endingdate;
    }

    public List<Evidences> getEvidencesList() {
        return evidencesList;
    }

    public void setEvidencesList(List<Evidences> evidencesList) {
        this.evidencesList = evidencesList;
    }
}








