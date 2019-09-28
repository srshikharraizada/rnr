package com.signon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "evidences")
public class Evidences {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "serialNumber")
    private Long evedenceId;

    @Column(name = "criterianame")
    private Long criterianame;

    @Column(name = "evidence",length = 2147483000)
    private String evidences;

    @Column(name = "nomination_id")
    private long nominationId;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "nomination_id", referencedColumnName = "nomination_id", insertable = false, updatable = false)
    })
    @JsonIgnore
    Nominations nominations;

    public Long getEvedenceId() {
        return evedenceId;
    }

    public void setEvedenceId(Long evedenceId) {
        this.evedenceId = evedenceId;
    }

    public Long getCriterianame() {
        return criterianame;
    }

    public void setCriterianame(Long criterianame) {
        this.criterianame = criterianame;
    }

    public String getEvidences() {
        return evidences;
    }

    public void setEvidences(String evidences) {
        this.evidences = evidences;
    }

    public long getNominationId() {
        return nominationId;
    }

    public void setNominationId(long nominationId) {
        this.nominationId = nominationId;
    }

    public Nominations getNominations() {
        return nominations;
    }

    public void setNominations(Nominations nominations) {
        this.nominations = nominations;
    }

}
