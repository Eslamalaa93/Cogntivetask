package com.cognitev.application.cognitevtask.entity;

import javax.persistence.*;

/**
 * Created by Eslam
 *
 * Usage: User Status Entity
 */

@Entity
@Table(name = "userStatus")
public class EBUserStatus {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "statusId")
    private int statusId;

    @Column(name = "userStatus")
    private String userStatus;

    @OneToOne
    @JoinColumn(name = "userId")
    private EBRegistrant registerantId;


    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public EBRegistrant getRegisterantId() {
        return registerantId;
    }

    public void setRegisterantId(EBRegistrant registerantId) {
        this.registerantId = registerantId;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }



}
