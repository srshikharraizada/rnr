package com.signon.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="employeeRelation")
public class EmployeeRelation implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeRelation_Id",unique = true,nullable = false)
    private long erid;



    @Column(name="manager_email",nullable = false)
    private String manager_email;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "employeeRelation")
    private Set<UserInfo> userInfo = new HashSet<>();






    public EmployeeRelation() {
    }

    public EmployeeRelation(long id, String manager_email) {
        this.erid = id;
        this.manager_email = manager_email;
    }


    public long getId() {
        return erid;
    }

    public void setId(long erid) {
        this.erid = erid;
    }

    public String getManager_email() {
        return manager_email;
    }

    public void setManager_email(String manager_email) {
        this.manager_email = manager_email;
    }

    public Set<UserInfo> getUserInfo() {
        return userInfo;
    }

    public long getErid() {
        return erid;
    }

    public void setErid(long erid) {
        this.erid = erid;
    }

    public void setUserInfo(Set<UserInfo> userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "EmployeeRelation{" +
                "id=" + erid +

                ", manager_email='" + manager_email + '\'' +
                '}';
    }
}