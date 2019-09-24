package com.signon.model;

import com.signon.enums.DesignationEnum;
import com.signon.enums.RoleEnum;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@Table(name="users")

public class UserInfo implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id",unique = true,nullable = false)
    private Long uid;

    @NotNull
    @Email
    @Size(max = 100)
    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @Column
    @Enumerated(EnumType.STRING)
    private DesignationEnum designation;

    @Column
    private Boolean firstSign=false;

    @Column
    private String imageUrl;





    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(
            name = "user_employeerelation",
            joinColumns = {@JoinColumn(name = "User_Id")},
            inverseJoinColumns = {@JoinColumn(name = "EmployeeRelation_Id")}
    )
    private Set<EmployeeRelation> employeeRelation = new HashSet<>();



//    public Set<EmployeeRelation> getEmployeeRelation() {
//        return employeeRelation;
//    }







    public UserInfo() {

    }

    public UserInfo(Long uid, @NotNull @Email @Size(max = 100) String email, String name, RoleEnum role, DesignationEnum designation, Boolean firstSign, String imageUrl) {
        this.uid = uid;
        this.email = email;
        this.name = name;
        this.role = role;
        this.designation = designation;
        this.firstSign = firstSign;
        this.imageUrl = imageUrl;
    }
//
//    public UserInfo(Long uid, @NotNull @Email @Size(max = 100) String email, String name, RoleEnum role, DesignationEnum designation, Boolean firstSign, String imageUrl, Set<EmployeeRelation> employeeRelation) {
//        this.uid = uid;
//        this.email = email;
//        this.name = name;
//        this.role = role;
//        this.designation = designation;
//        this.firstSign = firstSign;
//        this.imageUrl = imageUrl;
//        this.employeeRelation = employeeRelation;
//    }

    public Long getId() {
        return uid;
    }

    public void setId(Long uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Boolean getFirstSign() {
        return firstSign;
    }

    public void setFirstSign(Boolean firstSign) {
        this.firstSign = firstSign;
    }

    public DesignationEnum getDesignation() {
        return designation;
    }

    public void setDesignation(DesignationEnum designation) {
        this.designation = designation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<EmployeeRelation> getEmployeeRelation() {
        return employeeRelation;
    }

    public void setEmployeeRelation(Set<EmployeeRelation> employeeRelation) {
        this.employeeRelation = employeeRelation;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + uid +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", designation=" + designation +
                ", firstSign=" + firstSign +
                ", imageUrl='" + imageUrl + '\'' +
                ", employeeRelation=" + employeeRelation +
                '}';
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

}
