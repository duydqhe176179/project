/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Request;

/**
 *
 * @author ADMIN
 */
public class ListRequest extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    List<Request> listRequest = new ArrayList<Request>();

    public List<Request> getAllRequest() {
        Connection conn = null;
        String query = "SELECT * FROM request";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                listRequest.add(new Request(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(9), rs.getFloat(10)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return listRequest;

    }
    

    public List<String> getAllDistinctStatus() {
    Connection conn = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    List<String> distinctStatuses = new ArrayList<>();

    String query = "SELECT DISTINCT status FROM request"; // Modified SQL query

    try {
        conn = new DBContext().connection;
        stm = conn.prepareStatement(query);
        rs = stm.executeQuery();

        while (rs.next()) {
            distinctStatuses.add(rs.getString("status"));
        }
    } catch (Exception e) {
        System.out.println(e);
    } finally {
        // Close resources
        try {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    return distinctStatuses;
}

    public List<Request> getRequestsByFilter(String sql) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Request> listRequest = new ArrayList<>();

          try {
            stm = connection.prepareStatement(sql);
          
            rs = stm.executeQuery();

            while (rs.next()) {
                Request objE = new Request(
                        rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getFloat(11)
                );
                listRequest.add(objE);

            }
        } catch (SQLException e) {
            System.out.println("Error when selecting");
            // Xử lý ngoại lệ một cách đúng đắn, ghi log hoặc ném lại nếu cần thiết
        } finally {
            // Đảm bảo đóng các tài nguyên, ví dụ: PreparedStatement, ResultSet
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                System.out.println("Error when closing resources");
            }
        }
        

        return listRequest;
    }
    public int getIdAccountByUsername(String username) {
        Connection conn = null;
        int idAccount = -1;
        String query = "SELECT idAccount FROM account where username = ?";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            stm.setString(1, username);
            rs = stm.executeQuery();
            if (rs.next()) {
                idAccount = rs.getInt("idAccount");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return idAccount;

    }

    public List<Request> ListRequestById(int idAccount) {
        List<Request> listRequest1 = new ArrayList<>();
        Connection conn = null;
        String query = "SELECT idRequest, idMentee,idMentor, title, content, skill, status, startDate,endDate, hour ,r.totalCost\n"
                + "               FROM request r JOIN account a ON r.idMentee = a.idAccount \n"
                + "                WHERE a.idAccount = ? ";

        PreparedStatement _stm;
        ResultSet _rs;
        try {
            conn = new DBContext().connection;
            _stm = conn.prepareStatement(query);
            _stm.setInt(1, idAccount);
            _rs = _stm.executeQuery();
            while (_rs.next()) {
                Request request = new Request();
                request.setIdRequest(_rs.getInt("idRequest"));
                request.setIdMentee(_rs.getInt("idMentee"));
                request.setIdMentor(_rs.getInt("idmentor"));
                request.setTitle(_rs.getString("title"));
                request.setContent(_rs.getString("content"));
                request.setSkill(_rs.getString("skill"));
                request.setStatus(_rs.getString("status"));
                request.setStartDate(_rs.getString("startDate"));
                request.setEndDate(_rs.getString("endDate"));
                request.setHour(_rs.getFloat("hour"));
                request.setTotalCost(_rs.getInt("totalCost"));
                listRequest1.add(request);
            }
        } catch (Exception e) {
        }
        return listRequest1;
    }
    

    public static void main(String[] args) {
        ListRequest req = new ListRequest();

        List<Request> listRequest = req.getAllRequest();
        for (Request s : listRequest) {
            System.out.println(s);
        }

        System.out.println(req.getIdAccountByUsername("user4"));
        System.out.println(req.ListRequestById(4));
    }
}
