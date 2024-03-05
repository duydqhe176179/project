/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Account;
import model.Adshowreq;
import model.News;
import model.ReDetail;

import model.SkillMentor;

/**
 *
 * @author Admin
 */
public class AdminDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    List<SkillMentor> listSkill = new ArrayList<>();

    public List<SkillMentor> listAllSkill() {
        try {
            String sql = "SELECT * FROM dbo.skill";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String image = rs.getString(3);
                String skillName = rs.getString(4);
                String Skill_description = rs.getString(5);
                String status = rs.getString(6);

                SkillMentor s = new SkillMentor(id, title, image, skillName, Skill_description, status);
                listSkill.add(s);
            }
        } catch (Exception e) {
            System.out.println("ko lay dc list skill");
        }
        return listSkill;

    }

    public SkillMentor getSkillById(int id) {
        try {
            String sql = "SELECT * FROM dbo.skill WHERE id=?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                String title = rs.getString(2);
                String image = rs.getString(3);
                String name = rs.getString(4);
                String descrip = rs.getString(5);
                String status = rs.getString(6);
                SkillMentor s = new SkillMentor(id, title, image, name, descrip, status);

                return s;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean updateSkill(int id, String title, String image, String name, String description, String status) {
        try {
            String strUPDATE = "UPDATE dbo.skill \n"
                    + "SET title=?,image=?,skillName=?,skill_description=?,status=?\n"
                    + "WHERE id=?";
            stm = connection.prepareStatement(strUPDATE);
            stm.setString(1, title);
            stm.setString(2, image);
            stm.setString(3, name);
            stm.setString(4, description);
            stm.setString(5, status);
            stm.setInt(6, id);

            int rowsAffected = stm.executeUpdate();
            stm.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("loi, ko update dc");
            return false;
        }
    }

    public boolean activeSkill(String id) {
        AdminDAO admindao = new AdminDAO();
        SkillMentor skill = admindao.getSkillById(Integer.parseInt(id));
        try {
            String strUPDATE = "UPDATE dbo.skill \n"
                    + "SET status =?\n"
                    + "WHERE id=?";
            stm = connection.prepareStatement(strUPDATE);
            String status = "";
            if (skill.getStatus().equals("enable")) {
                status = "disable";
            } else {
                status = "enable";
            }
            stm.setString(1, status);
            stm.setString(2, id);

            int rowsAffected = stm.executeUpdate();
            stm.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("loi, ko update dc");
            return false;
        }
    }

    public boolean addSkill(SkillMentor skill) {
        try {
            String strSelect = "INSERT INTO dbo.skill(title,image,skillName,skill_description)\n"
                    + "VALUES (?,?,?,?)";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, skill.getTiltle());
            stm.setString(2, skill.getImage());
            stm.setString(3, skill.getSkillName());
            stm.setString(4, skill.getSkill_description());

            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    List<News> listnews = new ArrayList<>();
// news

    public List<News> getAllnews() {
        try {
            String strSelect = "select * from news";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                News i = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9));

                listnews.add(i);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listnews;
    }

    public boolean addNews(News news) {
        try {
            String strSelect = "INSERT INTO news (title, content, imageURL, postDate, eventDay, eventMonth, eventYear, summary)\n"
                    + "VALUES (?,?,?,?,?,?,?,?)";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, news.getTitle());
            stm.setString(2, news.getContent());
            stm.setString(3, news.getImageURL());
            stm.setString(4, news.getPostDate());
            stm.setInt(5, news.getEventday());
            stm.setString(6, news.getMonthdate());
            stm.setInt(7, news.getYeardate());
            stm.setString(8, news.getSummary());

            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public News getNewsById(int id) {
        try {
            String sql = "SELECT * FROM news WHERE newsid = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                String title = rs.getString(2);
                String content = rs.getString(3);
                String ImageURL = rs.getString(4);
                String PostDate = rs.getString(5);
                int eventday = rs.getInt(6);
                String Monthdate = rs.getString(7);
                int Yeardate = rs.getInt(8);
                String Summary = rs.getString(9);
                News s = new News(id, title, content, ImageURL, PostDate, eventday, Monthdate, Yeardate, Summary);

                return s;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean updateNews(int newsID, String title, String content, String imageURL, String postDate, int eventDay, String eventMonth, int eventYear, String summary) {
        try {
            String strUPDATE = "UPDATE dbo.news "
                    + "SET title=?, content=?, imageURL=?, postDate=?, eventDay=?, eventMonth=?, eventYear=?, summary=? "
                    + "WHERE newsID=?";
            stm = connection.prepareStatement(strUPDATE);
            stm.setString(1, title);
            stm.setString(2, content);
            stm.setString(3, imageURL);
            stm.setString(4, postDate);
            stm.setInt(5, eventDay);
            stm.setString(6, eventMonth);
            stm.setInt(7, eventYear);
            stm.setString(8, summary);
            stm.setInt(9, newsID);

            int rowsAffected = stm.executeUpdate();
            stm.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace(); // In ra thông tin lỗi nếu có
            return false;
        }
    }
// delete

    public boolean deleteNews(int newsID) {
        try {
            String strDELETE = "DELETE FROM dbo.news WHERE newsID=?";
            PreparedStatement stm = connection.prepareStatement(strDELETE);
            stm.setInt(1, newsID);

            int rowsAffected = stm.executeUpdate();
            stm.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace(); // In ra thông tin lỗi nếu có
            return false;
        }
    }

    // trangdh
    List<Adshowreq> listR = new ArrayList<>();

    public List<Adshowreq> getAllAdshowreq() {
        List<Adshowreq> listR = new ArrayList<>(); // Initialize the list

        String sql = "SELECT m.idMentee,r.idRequest, a.username, r.title, r.content, r.skill, r.status,r.startDate, r.deadline, r.hour,r.reasonReject\n"
                + "                                     FROM mentee m\n"
                + "                                     JOIN dbo.account a ON m.idMentee = a.idAccount\n"
                + "                                     JOIN dbo.request r ON m.idMentee = r.idMentee\n"
                + "                                     ORDER BY r.idRequest ASC";
        try ( PreparedStatement stm = connection.prepareStatement(sql);  ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                Adshowreq objE = new Adshowreq(
                        rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getFloat(10), rs.getString(11)
                );
                listR.add(objE);
            }
        } catch (SQLException e) {
            System.out.println("Error when selecting: " + e.getMessage());
        }
        return listR;
    }

// seach
    public List<Adshowreq> searchAdshowreq(String searchTerm) {
        List<Adshowreq> listR = new ArrayList<>();

        String sql = "SELECT m.idMentee, r.idRequest, a.username, r.title, r.content, r.skill, r.status, r.startDate, r.deadline, r.hour,r.reasonReject\n"
                + "FROM mentee m\n"
                + "JOIN dbo.account a ON m.idMentee = a.idAccount\n"
                + "JOIN dbo.request r ON m.idMentee = r.idMentee\n"
                + "WHERE a.username LIKE ? \n" // Filter by username
                + "ORDER BY r.idRequest ASC";

        try ( PreparedStatement stm = connection.prepareStatement(sql)) {
            // Set the search term for username using LIKE clause
            stm.setString(1, "%" + searchTerm + "%");

            try ( ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Adshowreq objE = new Adshowreq(
                            rs.getInt(1), rs.getInt(2), rs.getString(3),
                            rs.getString(4), rs.getString(5), rs.getString(6),
                            rs.getString(7), rs.getString(8), rs.getString(9),
                            rs.getFloat(10), rs.getString(11)
                    );
                    listR.add(objE);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error when selecting");
            e.printStackTrace();
        }

        return listR;
    }

    // 
    // chi tiet request
    public List<ReDetail> getAllReDetails() {
        List<ReDetail> reDetailList = new ArrayList<>();
        String sql = "SELECT m.idMentee, r.idRequest, a.username, m.fullname, m.dob, m.phone, m.sex, m.avatar, m.address, r.title, r.content, r.status, r.skill, r.startDate, r.deadline, r.hour, r.reasonReject\n"
                + "FROM mentee AS m\n"
                + "JOIN request AS r ON m.idMentee = r.idMentee\n"
                + "JOIN account AS a ON m.idMentee = a.idAccount";

        try ( PreparedStatement stm = connection.prepareStatement(sql);  ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                ReDetail reDetail = new ReDetail(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getFloat(16),
                        rs.getString(17)
                );
                reDetailList.add(reDetail);
            }
        } catch (SQLException e) {
            System.out.println("Error when selecting: " + e.getMessage());
            e.printStackTrace(); // Log or handle the exception as needed
        }

        return reDetailList;
    }

//
    public ReDetail getRequestById(int idRequest) {
        ReDetail requestDetail = null;
        String sql = "SELECT m.idMentee, r.idRequest, a.username, m.fullname, m.dob, "
                + "m.phone, m.sex, m.avatar, m.address, r.title, r.content, r.status, "
                + "r.skill, r.startDate, r.deadline, r.hour, r.reasonReject\n"
                + "FROM mentee AS m \n"
                + "JOIN request AS r ON m.idMentee = r.idMentee\n"
                + "JOIN account AS a ON m.idMentee = a.idAccount\n"
                + "WHERE r.idRequest = ?";

        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idRequest); // Use setInt for integer parameter
            rs = stm.executeQuery();

            if (rs.next()) {
                requestDetail = new ReDetail(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getFloat(16),
                        rs.getString(17)
                );
            }
        } catch (SQLException e) {
            System.out.println("Error when selecting");
            e.printStackTrace(); // Log or handle the exception as needed
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Log or handle the exception as needed
            }
        }

        return requestDetail;
    }

// check status 
    public List<String> getAllDistinctStatus() {
        List<String> statusList = new ArrayList<>();
        String sql = "SELECT DISTINCT r.status FROM dbo.request r";

        try {
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                statusList.add(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Error when selecting distinct status");
        } finally {
            // Close PreparedStatement and ResultSet here (if not using try-with-resources)
        }

        return statusList;
    }

// check date 
    public List<Adshowreq> checkdate(String startDate, String endDate) {
        List<Adshowreq> listR = new ArrayList<>();

        String sql = "SELECT m.idMentee, r.idRequest, a.username, r.title, r.content, r.skill, r.status, r.startDate, r.deadline,r.hour,r.reasonReject\n"
                + "FROM mentee m\n"
                + "JOIN dbo.account a ON m.idMentee = a.idAccount\n"
                + "JOIN dbo.request r ON m.idMentee = r.idMentee\n"
                + "WHERE r.startDate >= ? AND r.deadline <= ?\n"
                + "ORDER BY r.idRequest ASC";

        try ( PreparedStatement stm = connection.prepareStatement(sql)) {
            // Set the start date and end date parameters
            stm.setString(1, startDate);
            stm.setString(2, endDate);

            try ( ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Adshowreq objE = new Adshowreq(
                            rs.getInt(1), rs.getInt(2), rs.getString(3),
                            rs.getString(4), rs.getString(5), rs.getString(6),
                            rs.getString(7), rs.getString(8), rs.getString(9),
                            rs.getFloat(10), rs.getString(11)
                    );
                    listR.add(objE);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error when checking date");
            e.printStackTrace();
        }

        return listR;
    }

// checkfitter date and 
    public List<Adshowreq> getAdshowreqByStatusAndDate(String status, String startDate, String endDate) {
        List<Adshowreq> listR = new ArrayList<>();

        String sql = "SELECT m.idMentee, r.idRequest, a.username, r.title, r.content, r.skill, r.status, r.startDate, r.deadline,r.hour,r.reasonReject\n"
                + "FROM mentee m\n"
                + "JOIN dbo.account a ON m.idMentee = a.idAccount\n"
                + "JOIN dbo.request r ON m.idMentee = r.idMentee\n"
                + "WHERE r.status = ? AND r.startDate >= ? AND r.deadline <= ?";

        try ( PreparedStatement stm = connection.prepareStatement(sql)) {
            // Set parameters
            stm.setString(1, status);
            stm.setString(2, startDate);
            stm.setString(3, endDate);

            try ( ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Adshowreq objE = new Adshowreq(
                            rs.getInt(1), rs.getInt(2), rs.getString(3),
                            rs.getString(4), rs.getString(5), rs.getString(6),
                            rs.getString(7), rs.getString(8), rs.getString(9),
                            rs.getFloat(10), rs.getString(11)
                    );
                    listR.add(objE);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error when fetching Adshowreq by status and date");
            e.printStackTrace();
        }

        return listR;
    }

    // lay nhieu status
    public List<Adshowreq> getAdshowreqByStatus(String status, String startDate, String endDate) {
        List<Adshowreq> listR = new ArrayList<>();

        // SQL query
        String sql = "SELECT m.idMentee, r.idRequest, a.username, r.title, r.content, r.skill, r.status, r.startDate, r.deadline,r.hour,r.reasonReject\n"
                + "FROM mentee m\n"
                + "JOIN dbo.account a ON m.idMentee = a.idAccount\n"
                + "JOIN dbo.request r ON m.idMentee = r.idMentee\n"
                + "WHERE r.status = ?";

        try {
            // Dynamically add date conditions if provided
            if (startDate != null && !startDate.isEmpty()) {
                sql += " AND r.startDate >= ?";
            }
            if (endDate != null && !endDate.isEmpty()) {
                sql += " AND r.deadline <= ?";
            }

            // Prepare and execute the SQL statement
            try ( PreparedStatement stm = connection.prepareStatement(sql)) {
                stm.setString(1, status);

                int parameterIndex = 2;

                if (startDate != null && !startDate.isEmpty()) {
                    stm.setString(parameterIndex++, startDate);
                }
                if (endDate != null && !endDate.isEmpty()) {
                    stm.setString(parameterIndex, endDate);
                }

                try ( ResultSet rs = stm.executeQuery()) {
                    while (rs.next()) {
                        Adshowreq objE = new Adshowreq(
                                rs.getInt(1), rs.getInt(2), rs.getString(3),
                                rs.getString(4), rs.getString(5), rs.getString(6),
                                rs.getString(7), rs.getString(8), rs.getString(9),
                                rs.getFloat(10), rs.getString(11)
                        );
                        listR.add(objE);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error when fetching Adshowreq by status and date");
            e.printStackTrace();
        }

        return listR;
    }

    public List<Adshowreq> getMulStatus(List<String> statuses, String startDate, String endDate) {
        List<Adshowreq> listR = new ArrayList<>();

        try {
            // Create a dynamic SQL query with the correct number of placeholders
            StringBuilder sqlBuilder = new StringBuilder("SELECT m.idMentee, r.idRequest, a.username, r.title, r.content, r.skill, r.status, r.startDate, r.deadline,r.hour,r.reasonReject\n"
                    + "FROM mentee m\n"
                    + "JOIN dbo.account a ON m.idMentee = a.idAccount\n"
                    + "JOIN dbo.request r ON m.idMentee = r.idMentee\n"
                    + "WHERE r.status IN (");

            // Append placeholders based on the number of statuses
            for (int i = 0; i < statuses.size(); i++) {
                sqlBuilder.append("?");
                if (i < statuses.size() - 1) {
                    sqlBuilder.append(", ");
                }
            }

            sqlBuilder.append(")");

            // Append conditions for startDate and endDate if they are provided
            if (startDate != null && endDate != null) {
                sqlBuilder.append(" AND r.startDate >= ? AND r.deadline <= ?");
            }

            // Use try-with-resources to ensure PreparedStatement and ResultSet are closed
            try ( PreparedStatement stm = connection.prepareStatement(sqlBuilder.toString())) {
                // Set parameters for statuses
                for (int i = 0; i < statuses.size(); i++) {
                    stm.setString(i + 1, statuses.get(i));
                }

                // Set parameters for startDate and endDate if they are provided
                int parameterIndex = statuses.size() + 1;
                if (startDate != null && endDate != null) {
                    stm.setString(parameterIndex++, startDate);
                    stm.setString(parameterIndex, endDate);
                }

                // Execute the query
                try ( ResultSet rs = stm.executeQuery()) {
                    while (rs.next()) {
                        Adshowreq objE = new Adshowreq(
                                rs.getInt(1), rs.getInt(2), rs.getString(3),
                                rs.getString(4), rs.getString(5), rs.getString(6),
                                rs.getString(7), rs.getString(8), rs.getString(9),
                                rs.getFloat(10), rs.getString(11)
                        );
                        listR.add(objE);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error when fetching Adshowreq by multiple statuses and date");
            e.printStackTrace();
        }

        return listR;
    }

    public static void main(String[] args) {
        AdminDAO dao = new AdminDAO();

//        // Sample data for testing
//        List<String> statuses = new ArrayList<>(Arrays.asList("Open", "Reject", "Learning"));
//        String startDate = "2022-01-01"; // Adjust the date based on your data
//        String endDate = "2024-05-05";   // Adjust the date based on your data
//
//        // Call the getMulStatus method
//        List<Adshowreq> result = dao.getMulStatus(statuses, startDate, endDate);
//
//        // Print the result
//        for (Adshowreq adshowreq : result) {
//            System.out.println(adshowreq);
//        }
        System.out.println(dao.getRequestById(9));
    }
}
