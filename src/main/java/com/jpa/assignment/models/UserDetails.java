package com.jpa.assignment.models;

import jakarta.persistence.*;

@Entity
@Table(name="user_details")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    /*@Column(name="loginId")
    private int loginId;*/
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String contactNo;
    @Column
    private String type;

    /**/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loginId")
    private LoginDetails loginDetails;

    public LoginDetails getLoginDetails(){return loginDetails;}

    public void setLoginDetails(LoginDetails login){ this.loginDetails = login; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public int getLoginId() {
        return loginId;
    }*/

    /*public void setLoginId(int loginId) {
        this.loginId = loginId;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
