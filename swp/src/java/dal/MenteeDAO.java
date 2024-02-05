package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Mentee;

/**
 *
 * @author anhdu
 */
public class MenteeDAO extends DBContext{
    
    public Mentee getMenteeByAccountId(int idAccount) {
        String query = "SELECT m.* FROM mentee m " +
                       "JOIN account a ON m.idMentee = a.idAccount " +
                       "WHERE a.idAccount = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idAccount);

            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToMentee(resultSet);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving mentee by accountId: " + e.getMessage());
        }

        return null;
    }

    private Mentee mapResultSetToMentee(ResultSet resultSet) throws Exception {
        return new Mentee(
                resultSet.getInt("idMentee"),
                resultSet.getString("fullname"),
                resultSet.getString("avatar"),
                resultSet.getString("story"),
                resultSet.getDate("dob"),
                resultSet.getString("phone"),
                resultSet.getString("sex"),
                resultSet.getString("experience"),
                resultSet.getDate("registerDate"),
                resultSet.getString("address")
        );
    }
    
}
