package dal;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Request;

/**
 *
 * @author anhdu
 */
public class RequestDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;

    public boolean createRequest(Request request) {
        String query = "INSERT INTO dbo.request(idMentee,idMentor,title,content,skill,status,startDate,endDate,hour,totalCost)\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";

        try ( Connection connection = this.connection;  PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setInt(1, request.getIdMentee());
            pstmt.setInt(2, request.getIdMentor());
            pstmt.setString(3, request.getTitle());
            pstmt.setString(4, request.getContent());
            pstmt.setString(5, request.getSkill());
            pstmt.setString(6, request.getStatus());
            pstmt.setString(7, request.getStartDate());
            pstmt.setString(8, request.getEndDate());
            pstmt.setBigDecimal(9, request.getDeadlineHour());
            pstmt.setInt(10, request.getTotalCost());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Handle database access or SQL exception
            e.printStackTrace(); // Log the exception details
        }
        return true;
    }

    public boolean closeRequest(int idRequest) {
        try {
            String sql = "UPDATE dbo.request\n"
                    + "SET status='Closed'\n"
                    + "WHERE idRequest=?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idRequest);
            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("closeRequest " + e);
            return false;
        }
    }

    public List<Request> getAllRequests() {
        List<Request> requests = new ArrayList<>();
        String query = "SELECT * FROM request";

        try ( Connection connection = this.connection;  PreparedStatement pstmt = connection.prepareStatement(query);  ResultSet resultSet = pstmt.executeQuery()) {

            while (resultSet.next()) {
                Request request = mapResultSetToRequest(resultSet);
                requests.add(request);
            }
        } catch (SQLException e) {
            // Handle database access or SQL exception
            e.printStackTrace();
        }
        return requests;
    }

    public Request getRequestById(int idRequest) {
        String query = "SELECT * FROM request WHERE idRequest = ?";

        try ( Connection connection = this.connection;  PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setInt(1, idRequest);

            try ( ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToRequest(resultSet);
                }
            }
        } catch (SQLException e) {
            // Handle database access or SQL exception
            e.printStackTrace();
        }
        return null;
    }

    public List<Request> getAllRequestsManager() {
        List<Request> list = new ArrayList<>();  // Khởi tạo một danh sách mới

        String sql = "SELECT r.idRequest, r.idMentee, r.idMentor, m.fullname AS FullName, r.title, r.content, r.skill, r.status, r.startDate,r r.deadline, r.hour\n"
                + "FROM request r\n"
                + "JOIN mentee m ON r.idMentee = m.idMentee\n";

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
                list.add(objE);

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
        return list;
    }

    private Request mapResultSetToRequest(ResultSet resultSet) throws SQLException {
        return new Request(
                resultSet.getInt("idRequest"),
                resultSet.getInt("idMentee"),
                resultSet.getInt("idMentor"),
                resultSet.getString("title"),
                resultSet.getString("content"),
                resultSet.getString("skill"),
                resultSet.getString("status"),
                resultSet.getString("startDate"),
                resultSet.getString("endDate"),
                resultSet.getBigDecimal("hour"),
                resultSet.getInt("totalCost")
        );
    }

    public boolean UpdateRequest(int idRequest, String title, String content, String nameSkill, String startDate, String endDate, Float hour, int totalCost) {
        Connection conn = null;
        String query = "UPDATE [dbo].[request]\n"
                + "   SET [title] = ?\n"
                + "      ,[content] = ?\n"
                + "      ,[skill] =?\n"
                + "      ,[status] = ?\n"
                + "      ,[startDate] = ?\n"
                + "      ,[endDate] = ?\n"
                + "      ,[hour] = ?\n"
                + "      ,[totalCost] = ?\n"
                + " WHERE  idRequest=?";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            stm.setString(1, title);
            stm.setString(2, content);
            stm.setString(3, nameSkill);
            stm.setString(4, "Open");
            stm.setString(5, startDate);
            stm.setString(6, endDate);
            stm.setFloat(7, hour);
            stm.setInt(8, totalCost);
            stm.setInt(9, idRequest);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean UpdateRequestStatus(String idr, String status) {
        Connection conn = null;
        PreparedStatement stm = null;
        String query = "UPDATE [dbo].[request]\n"
                + "SET \n"
                + "[status] = ?\n"
                + "WHERE idRequest = ?";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            stm.setString(1, status);
            stm.setString(2, idr);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Assuming you have a Request object ready for testing

        // Call the createRequest method and handle the result
    }

}
