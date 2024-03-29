/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.HistoryWallet;

/**
 *
 * @author Admin
 */
public class HistoryPayDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    List<HistoryWallet> listHistoryWallet = new ArrayList<>();

    public List<HistoryWallet> getHistoryWalletByIdAccount(int idAccount) {
        try {
            String sql = "SELECT * FROM dbo.historyWallet\n"
                    + "WHERE idAccount=?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idAccount);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nameMentee = rs.getString(3);
                int amount = rs.getInt(4);
                String datePay = rs.getString(5);
                String content = rs.getString(6);
                String stype = rs.getString(7);

                listHistoryWallet.add(new HistoryWallet(id, idAccount, nameMentee, amount, datePay, content, stype));
            }
        } catch (Exception e) {
            System.out.println("getHistoryWalletByIdAccount " + e);
        }
        return listHistoryWallet;
    }

    public boolean addHistoryPay(HistoryWallet h) {
        try {
            String sql = "INSERT INTO dbo.historyWallet\n"
                    + "(\n"
                    + "    idAccount,\n"
                    + "    amount,\n"
                    + "    datePay,\n"
                    + "    content,\n"
                    + "    stype\n"
                    + ")\n"
                    + "VALUES(?,?,?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, h.getIdAccount());
            stm.setInt(2, h.getAmount());
            stm.setString(3, h.getDatePay());
            stm.setString(4, h.getContent());
            stm.setString(5, h.getStype());
            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("addHistoryPay "+e);
        }
        return false;
    }

    public static void main(String[] args) {
        HistoryPayDAO dao = new HistoryPayDAO();
        System.out.println(dao.getHistoryWalletByIdAccount(1));
    }
}
