/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Mentor.TakeMoney;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.GetMoney;

/**
 *
 * @author Admin
 */
public class TakeMoneyDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;

    public boolean addTakeMoney(GetMoney t) {
        try {
            String sql = "INSERT INTO [dbo].[requestTakeMoney]\n"
                    + "     VALUES(?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, t.getFullname());
            stm.setString(2, t.getUsername());
            stm.setInt(3, t.getMoney());
            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("addTakeMoney: "+e);
            return false;
        }
    }
    
    public static void main(String[] args) {
        TakeMoneyDAO dao=new TakeMoneyDAO();
        System.out.println(dao.addTakeMoney(new GetMoney(0, "sdssd", "sdssd", 200000)));
    }
}
