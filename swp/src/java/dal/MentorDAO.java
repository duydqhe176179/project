/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Have_SKill;
import model.Mentor;
import model.SkillMentor;
import model.info;

/**
 *
 * @author admin
 */
public class MentorDAO extends DBContext{
    PreparedStatement stm;
    ResultSet rs;
    List<Mentor> listMentor = new ArrayList<>();
    List<Have_SKill> listhskill = new ArrayList<>();
    List<info> listinfo = new ArrayList<>();
    List<SkillMentor> skill = new ArrayList<>();

    public Mentor getIDMentor(int IdMentor) {
        try {
            String strSelect = "select * from mentor where idMentor = ?";

            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, IdMentor);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idMentor = rs.getInt(1);
                String fullname = rs.getString(2);
                String avatar = rs.getString(3);
                String phone = rs.getString(4);

                String dob = rs.getString(5);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                // Chuyển đổi ngày sinh từ chuỗi sang LocalDate
                LocalDate ngaySinh = LocalDate.parse(dob, formatter);

                // Lấy ngày hiện tại
                LocalDate ngayHienTai = LocalDate.now();

                // Tính tuổi
                Period period = Period.between(ngaySinh, ngayHienTai);

         
                String sex = rs.getString(6);
                String address = rs.getString(7);
                String registerDate = rs.getString(8);
                String profession = rs.getString(9);
                String pro_introduc = rs.getString(10);
                String archivement_sescition = rs.getString(11);
                String framework = rs.getString(12);
                String experience = rs.getString(13);
                String education = rs.getString(14);
                String myservice = rs.getString(15);
                int age = period.getYears();

                Mentor a = new Mentor(idMentor, fullname, avatar, phone, dob, sex, address,registerDate, profession, pro_introduc, archivement_sescition, framework, experience, education, myservice, age);
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        MentorDAO dao = new MentorDAO();
        System.out.println(dao.getIDMentor(6));
        //System.out.println(dao.getMentor(6));
    }

    public Mentor getMentor() {
        try {
            String strSelect = "select * from mentor where idMentor = 1";

            stm = connection.prepareStatement(strSelect);

            rs = stm.executeQuery();
            while (rs.next()) {
                int idMentor = rs.getInt(1);
                String fullname = rs.getString(2);
                String avatar = rs.getString(3);
                String phone = rs.getString(4);

                String dob = rs.getString(5);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                // Chuyển đổi ngày sinh từ chuỗi sang LocalDate
                LocalDate ngaySinh = LocalDate.parse(dob, formatter);

                // Lấy ngày hiện tại
                LocalDate ngayHienTai = LocalDate.now();

                // Tính tuổi
                Period period = Period.between(ngaySinh, ngayHienTai);

                String sex = rs.getString(6);
                String address = rs.getString(7);
                 String registerDate = rs.getString(8);
                String profession = rs.getString(8);
                String pro_introduc = rs.getString(9);
                String archivement_sescition = rs.getString(10);
                String framework = rs.getString(11);
                String experience = rs.getString(12);
                String education = rs.getString(13);
                String myservice = rs.getString(14);
                int age = period.getYears();

                Mentor a = new Mentor(idMentor, fullname, avatar, phone, dob, sex, address,registerDate, profession, pro_introduc, archivement_sescition, framework, experience, education, myservice, age);
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public SkillMentor skill() {
        try {
            String strSelect = "select * \n"
                    + "from skill";

            stm = connection.prepareStatement(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                String tiltle = rs.getString(2);

                String image = rs.getString(3);
                String skillName = rs.getString(4);
                String Skill_description = rs.getString(5);
                String status = rs.getString(6);
                SkillMentor a = new SkillMentor(id, tiltle, image, skillName, Skill_description, status);
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Have_SKill gethaveskill() {
        try {
            String strSelect = "select idMentor,idSkill,score,cost,skillName \n"
                    + "from have_skill join skill on have_skill.idSkill = skill.id \n"
                    + "where have_skill.idMentor=6";

            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idMentor = rs.getInt(1);
                int idSkill = rs.getInt(2);
                int score = ((rs.getInt(3)) * 100) / 100;
                int cost = rs.getInt(4);
                String skillName = rs.getString(5);

                Have_SKill a = new Have_SKill(idMentor, idSkill, score, cost, skillName);

               return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public  Have_SKill getidhaveskill(int IdMentor) {
        try {
            String strSelect = "select idMentor,idSkill,score,cost,skillName \n"
                    + "from have_skill join skill on have_skill.idSkill = skill.id \n"
                    + "where have_skill.idMentor=?";

            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, IdMentor);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idMentor = rs.getInt(1);
                int idSkill = rs.getInt(2);
                int score = ((rs.getInt(3)) * 100) / 100;
                int cost = rs.getInt(4);
                String skillName = rs.getString(5);

                Have_SKill a = new Have_SKill(idMentor, idSkill, score, cost, skillName);
             return a;
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public info info() {
        try {
            String strSelect = "select * from info where idMentor = 6";

            stm = connection.prepareStatement(strSelect);

            rs = stm.executeQuery();
            while (rs.next()) {
                int idInfo = rs.getInt(1);
                int idMentor = rs.getInt(2);
                String link = rs.getString(3);
                info a = new info(idInfo, idMentor, link);
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public info getIdinfo(int IdMentor) {
        try {
            String strSelect = "select * from info where idMentor = ?";

            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, IdMentor);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idInfo = rs.getInt(1);
                int idMentor = rs.getInt(2);
                String link = rs.getString(3);
                info a = new info(idInfo, idMentor, link);
               return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
   
public Account getAccountByid(int idAccount) {
        try {
            String strSelect = "SELECT * FROM dbo.account WHERE idAccount = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, idAccount);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String user = rs.getString(2);
                String email = rs.getString(3);
                String pass = rs.getString(4);
                String role = rs.getString(5);
                int confirm = rs.getInt(6);

                Account a = new Account(id, user, email, pass, role, confirm);
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }


    
}
