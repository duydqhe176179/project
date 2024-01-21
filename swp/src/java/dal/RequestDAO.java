package dal;

import java.sql.Connection;
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
        String query = "INSERT INTO request (idMentee, title, content, skill, status, deadline, hour, idMentor) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try ( Connection connection = this.connection;  
            PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setInt(1, request.getIdMentee());
            pstmt.setString(2, request.getTitle());
            pstmt.setString(3, request.getContent());
            pstmt.setString(4, request.getSkill());
            pstmt.setString(5, request.getStatus());
            pstmt.setString(6, request.getDeadline());
            pstmt.setFloat(7, request.getHour());
            pstmt.setFloat(8, request.getIdMentor());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Handle database access or SQL exception
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateRequest(Request request) {
        String query = "UPDATE request SET "
                + "idMentee = ?, "
                + "title = ?, "
                + "content = ?, "
                + "skill = ?, "
                + "status = ?, "
                + "deadline = ?, "
                + "hour = ? "
                + "WHERE idRequest = ?";

        try ( Connection connection = this.connection;  
            PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setInt(1, request.getIdMentee());
            pstmt.setString(2, request.getTitle());
            pstmt.setString(3, request.getContent());
            pstmt.setString(4, request.getSkill());
            pstmt.setString(5, request.getStatus());
            pstmt.setString(6, request.getDeadline());
            pstmt.setFloat(7, request.getHour());
            pstmt.setInt(8, request.getIdRequest());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Handle database access or SQL exception
            e.printStackTrace();
        }
        return false;
    }

    public List<Request> getAllRequests() {
        List<Request> requests = new ArrayList<>();
        String query = "SELECT * FROM request";

        try ( Connection connection = this.connection;  
            PreparedStatement pstmt = connection.prepareStatement(query);  ResultSet resultSet = pstmt.executeQuery()) {

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

        try ( Connection connection = this.connection;  
            PreparedStatement pstmt = connection.prepareStatement(query)) {

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

    private Request mapResultSetToRequest(ResultSet resultSet) throws SQLException {
        return new Request(
                resultSet.getInt("idRequest"),
                resultSet.getInt("idMentee"),
                resultSet.getInt("idMentor"),
                resultSet.getString("title"),
                resultSet.getString("content"),
                resultSet.getString("skill"),
                resultSet.getString("status"),
                resultSet.getString("deadline"),
                resultSet.getFloat("hour")
        );
    }

}
