<<<<<<< HEAD
package model;

import java.util.Date;

public class Request {
    
    private int idRequest;
    private int idMentee;
    private int idMentor;
    private String title;
    private String content;
    private String skill;
    private String status;
    private String deadline;
    private float hour;
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Request {
    int idMentee, idMentor;
    String title, content, skill, status, deadline;
    float hour;
>>>>>>> d33b27bfe93553ddd288527eff07634291d0710c

    public Request() {
    }

<<<<<<< HEAD
    public Request(int idRequest, int idMentee, int idMentor, String title, String content, String skill, String status, String deadline, float hour) {
        this.idRequest = idRequest;
        this.idMentee = idMentee;
        this.idMentor = idMentor;
        this.title = title;
        this.content = content;
        this.skill = skill;
        this.status = status;
        this.deadline = deadline;
        this.hour = hour;
    }

    public Request(int idMentee, int idMentor, String title, String content, String skill, String status, String deadline, float hour) {
        this.idRequest = idRequest;
=======
    public Request(int idMentee, int idMentor, String title, String content, String skill, String status, String deadline, float hour) {
>>>>>>> d33b27bfe93553ddd288527eff07634291d0710c
        this.idMentee = idMentee;
        this.idMentor = idMentor;
        this.title = title;
        this.content = content;
        this.skill = skill;
        this.status = status;
        this.deadline = deadline;
        this.hour = hour;
    }

<<<<<<< HEAD
    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }
=======
   
>>>>>>> d33b27bfe93553ddd288527eff07634291d0710c

    public int getIdMentee() {
        return idMentee;
    }

    public void setIdMentee(int idMentee) {
        this.idMentee = idMentee;
    }

    public int getIdMentor() {
        return idMentor;
    }

    public void setIdMentor(int idMentor) {
        this.idMentor = idMentor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

<<<<<<< HEAD
=======
    

>>>>>>> d33b27bfe93553ddd288527eff07634291d0710c
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public float getHour() {
        return hour;
    }

    public void setHour(float hour) {
        this.hour = hour;
    }
<<<<<<< HEAD
    
=======

    @Override
    public String toString() {
        return "Request{" + "idMentee=" + idMentee + ", idMentor=" + idMentor + ", title=" + title + ", content=" + content + ", skill=" + skill + ", status=" + status + ", deadline=" + deadline + ", hour=" + hour + '}';
    }
>>>>>>> d33b27bfe93553ddd288527eff07634291d0710c
    
    
}
