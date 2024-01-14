package model;

import java.util.Date;

public class Requirements {

    String title;
    String content;
    String skill;
    String status;
    String deadline;
    float hour;

    // Constructors
    public Requirements() {
    }

    public Requirements(String title, String content, String skill, String status, String deadline, float hour) {
        this.title = title;
        this.content = content;
        this.skill = skill;
        this.status = status;
        this.deadline = deadline;
        this.hour = hour;
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
