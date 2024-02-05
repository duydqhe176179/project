/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Request {
    
    private int idRequest, idMentee, idMentor;
    private String title, content, skill, status;
    private String deadlineDate;
    private BigDecimal deadlineHour;

    public Request() {
    }

    public Request(int idRequest, int idMentee, int idMentor, String title, String content, String skill, String status, String deadlineDate, BigDecimal deadlineHour) {
        this.idRequest = idRequest;
        this.idMentee = idMentee;
        this.idMentor = idMentor;
        this.title = title;
        this.content = content;
        this.skill = skill;
        this.status = status;
        this.deadlineDate = deadlineDate;
        this.deadlineHour = deadlineHour;
    }

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public BigDecimal getDeadlineHour() {
        return deadlineHour;
    }

    public void setDeadlineHour(BigDecimal deadlineHour) {
        this.deadlineHour = deadlineHour;
    }

    @Override
    public String toString() {
        return "Request{" + "idRequest=" + idRequest + ", idMentee=" + idMentee + ", idMentor=" + idMentor + ", title=" + title + ", content=" + content + ", skill=" + skill + ", status=" + status + ", deadlineDate=" + deadlineDate + ", deadlineHour=" + deadlineHour + '}';
    }

   
    
   
}
