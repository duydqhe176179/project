/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Have_SKill {
    int idMentor;
    int idSkill;
    int score;
    int cost;
    String skillName;

    public Have_SKill() {
    }

    public Have_SKill(int idMentor, int idSkill, int score, int cost, String skillName) {
        this.idMentor = idMentor;
        this.idSkill = idSkill;
        this.score = score;
        this.cost = cost;
        this.skillName = skillName;
    }

    @Override
    public String toString() {
        return "Have_SKill{" + "idMentor=" + idMentor + ", idSkill=" + idSkill + ", score=" + score + ", cost=" + cost + ", skillName=" + skillName + '}';
    }

    public int getIdMentor() {
        return idMentor;
    }

    public void setIdMentor(int idMentor) {
        this.idMentor = idMentor;
    }

    public int getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(int idSkill) {
        this.idSkill = idSkill;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

  
}
