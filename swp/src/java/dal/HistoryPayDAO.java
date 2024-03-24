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
                int amount = rs.getInt(3);
                String datePay = rs.getString(4);
                String content = rs.getString(5);
                String stype = rs.getString(6);

                HistoryWallet h = new HistoryWallet(id, idAccount, amount, datePay, content, stype);
                listHistoryWallet.add(h);
            }
        } catch (Exception e) {
            System.out.println("getHistoryWalletByIdAccount " + e);
        }
        return listHistoryWallet;
    }

    public static void main(String[] args) {
        HistoryPayDAO dao = new HistoryPayDAO();
        System.out.println(dao.getHistoryWalletByIdAccount(1));
    }
}
