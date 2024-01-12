/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Account {
    int id;
    String user,pass,role;

    public Account() {
    }

    public Account(String user, String pass, String role) {
        this.user = user;
        this.pass = pass;
        this.role = role;
    }

    public Account(int id, String user, String pass, String role) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.role = role;
    }

    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" + "user=" + user + ", pass=" + pass + ", role=" + role + '}';
    }
    
    
}
