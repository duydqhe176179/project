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
import model.Wallet;

/**
 *
 * @author Admin
 */
public class WalletDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;

    // function for Mentor
    public int totalIncome(int idAccount) {
        try {
            String sql = "SELECT SUM(amount) FROM dbo.historyWallet\n"
                    + "WHERE idAccount=? AND stype='Deposit'";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idAccount);
            rs = stm.executeQuery();
            int totalIncome = 0;
            if (rs.next()) {
                totalIncome = rs.getInt(1);
            }
            return totalIncome;
        } catch (Exception e) {
            System.out.println("totalIncome: " + e);
        }
        return 0;
    }

    //function for system
    public int incomeSystem() {
        try {
            String sql = "SELECT SUM(totalCost) FROM dbo.request \n"
                    + "WHERE status IN ('Learning','Completed','Closed')";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            int totalIncome = 0;
            if (rs.next()) {
                totalIncome = rs.getInt(1);
            }
            return totalIncome / 10;
        } catch (Exception e) {
            System.out.println("incomeSystem " + e);
            return 0;
        }
    }

    public int getWalletBalance(int idAccount) {
        try {
            String sql = "SELECT * FROM dbo.wallet WHERE idAccount=?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idAccount);
            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(2);
            }
        } catch (Exception e) {
        }
        return 0;
    }

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

    public boolean updateWallet(int idAccount, int balance) {
        try {
            String sql = "UPDATE dbo.wallet\n"
                    + "SET amount=?\n"
                    + "WHERE idAccount=?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, balance);
            stm.setInt(2, idAccount);
            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("updateWallet " + e);
            return false;
        }
    }

    public Wallet getWalletByIdAccount(int idAccount) {
        try {
            String sql = "SELECT * FROM dbo.wallet\n"
                    + "WHERE idAccount=?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idAccount);
            rs = stm.executeQuery();
            if (rs.next()) {
                return new Wallet(idAccount, rs.getInt(2));
            }
        } catch (Exception e) {
            System.out.println("getWalletByIdAccount " + e);
        }
        return null;
    }

    public static void main(String[] args) {
        WalletDAO dao = new WalletDAO();
        System.out.println(dao.incomeSystem());
    }
}
