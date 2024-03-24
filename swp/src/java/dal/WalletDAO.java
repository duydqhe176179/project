/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Request;

/**
 *
 * @author Admin
 */
public class WalletDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;

    public boolean addWallet(Account a) {
        try {
            String sql = "INSERT INTO dbo.wallet\n"
                    + "(\n"
                    + "    idAccount,\n"
                    + "    amount\n"
                    + ")\n"
                    + "VALUES (?,?)";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, a.getId());
            stm.setInt(2, 0);
            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
    
    public static void main(String[] args) {
        WalletDAO dao=new WalletDAO();
        
    }
}
