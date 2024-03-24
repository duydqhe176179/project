/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Wallet {
    private int idAccount,amount;

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Wallet() {
    }

    public Wallet(int idAccount, int amount) {
        this.idAccount = idAccount;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Wallet{" + "idAccount=" + idAccount + ", amount=" + amount + '}';
    }
    
    
}
