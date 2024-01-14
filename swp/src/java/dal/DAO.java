/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Requirements;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    List<Account> listAccount = new ArrayList<>();

    public boolean addAccount(String user, String pass) {
        try {
            String sql = "  INSERT INTO account (username, password, role) VALUES (?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);
            stm.setString(3, "0");

            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public List<Account> getAllAccount() {
        try {
            String strSelect = "SELECT * FROM dbo.account";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                String user = rs.getString(1);
                String pass = rs.getString(2);
                String role = rs.getString(3);

                Account a = new Account(user, pass, role);
                listAccount.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listAccount;
    }

//    public Account Login(String username, String password) {
//        String sql = "SELECT * FROM dbo.Account\n"
//                + "WHERE username=? AND password=?";
//        try {
//            stm = connection.prepareStatement(sql);
//            stm.setString(1, username);
//            stm.setString(2, password);
//            rs = stm.executeQuery();
//            if (rs.next()) {
//                String user = rs.getString(1);
//                String pass = rs.getString(2);
//                int role = rs.getInt(3);
//                Account a = new Account(user, pass, role);
//                return a;
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
    public boolean deleteAccount(String user) {
        try {
            String strDelete = "DELETE FROM dbo.mentee WHERE idMentee=(\n"
                    + "	SELECT idAccount FROM dbo.account WHERE username=?\n"
                    + ")\n"
                    + "GO\n"
                    + "DELETE FROM dbo.account WHERE username=?";
            stm = connection.prepareStatement(strDelete);
            stm.setString(1, user);
            stm.setString(2, user);

            int rowAffected = stm.executeUpdate();

            return rowAffected > 0;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean updateOld(int id, String image, String review, String name) {
        try {
            String strUPDATE = "UPDATE dbo.oldStudent\n"
                    + "SET image=?, review=?,name=?\n"
                    + "WHERE id=?";
            stm = connection.prepareStatement(strUPDATE);
            stm.setString(1, image);
            stm.setString(2, review);
            stm.setString(3, name);
            stm.setInt(4, id);

            int rowsAffected = stm.executeUpdate();
            stm.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("loi, ko update dc");
            return false;
        }
    }
public Account login(String username, String password) {
        String query = "SELECT *"
                + "FROM account "
                + "WHERE username = ? AND password = ?";

        try ( PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                int idAccount = resultSet.getInt(1);
                String user = resultSet.getString(2);
                String pass = resultSet.getString(3);
                String role = resultSet.getString(4);

                return new Account(idAccount, user, password, role);
            }
        } catch (Exception e) {
            System.out.println("Login: " + e.getMessage());
        }

        return null;
    }
    public boolean changePassword(String username, String newPassword) {
        String query = "UPDATE account SET password = ? WHERE username = ? ";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, newPassword);
            pstmt.setString(2, username);
            

            int rowsUpdated = pstmt.executeUpdate();

            return rowsUpdated > 0;
        } catch (Exception e) {
            System.out.println("Change Password: " + e.getMessage());
        }

        return false;
    }
    public boolean insertRe(Requirements r) {
        String query = "INSERT INTO [dbo].[Requirements]\n"
                + "           (title,content,skill,status,deadline,hour)\n"
                + "VALUES (?, ?, ?, ?, ?,?)";

        try ( PreparedStatement pstmt = connection.prepareStatement(query)) {
            // Set the parameter values

            pstmt.setString(1, r.getTitle());
            pstmt.setString(2, r.getContent());
            pstmt.setString(3, r.getSkill());
            pstmt.setString(4, r.getStatus());
            pstmt.setString(5, r.getDeadline());
            pstmt.setFloat(6, r.getHour());

            // Execute the query
            int rowsInserted = pstmt.executeUpdate();

            // Check if the insertion was successful
            return (rowsInserted > 0);
        } catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    public static void main(String[] args) {
        DAO dao = new DAO();
        System.out.println(dao.addAccount("test", "test"));
    }
}
