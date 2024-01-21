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

    public Request() {
    }

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
        this.idMentee = idMentee;
        this.idMentor = idMentor;
        this.title = title;
        this.content = content;
        this.skill = skill;
        this.status = status;
        this.deadline = deadline;
        this.hour = hour;
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
    
    
    
}
