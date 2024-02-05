package model;

import java.util.Date;

/**
 *
 * @author anhdu
 */
public class Mentee {
    
    private int idMentee;
    private String fullname;
    private String avatar;
    private String story;
    private Date dob;
    private String phone;
    private String sex;
    private String experience;
    private Date registerDate;
    private String address;

    public Mentee() {
    }

    public Mentee(int idMentee, String fullname, String avatar, String story, Date dob, String phone, String sex, String experience, Date registerDate, String address) {
        this.idMentee = idMentee;
        this.fullname = fullname;
        this.avatar = avatar;
        this.story = story;
        this.dob = dob;
        this.phone = phone;
        this.sex = sex;
        this.experience = experience;
        this.registerDate = registerDate;
        this.address = address;
    }

    public int getIdMentee() {
        return idMentee;
    }

    public void setIdMentee(int idMentee) {
        this.idMentee = idMentee;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
}
