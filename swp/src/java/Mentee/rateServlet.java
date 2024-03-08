package Mentee;

import dal.DAO;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Mentor;
import model.Rate;
import model.Request;

@WebServlet(name = "RateServlet", urlPatterns = {"/rate"})
public class rateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Check if the user has the role "Mentee"
        Account account = (Account) session.getAttribute("account");
        if (account == null || !"Mentee".equals(account.getRole())) {
            // Handle the case where the user is not signed in or does not have the role "Mentee"
            System.out.println("Error: User not signed in or does not have the role 'Mentee'");
            request.setAttribute("errorMess", "You do not have permission to access this page.");
            request.getRequestDispatcher("rate.jsp").forward(request, response);
        } else {
            // Assuming you have a method in DAO to get all mentors
            DAO dao = new DAO();
            List<Mentor> mentors = dao.getAllMentor();  // Assuming a correct method name
            int idRequest = Integer.parseInt(request.getParameter("idrequest"));
            request.setAttribute("idreq", idRequest);
            int idMentee = Integer.parseInt(request.getParameter("idMentee"));
            request.setAttribute("idreqd", idMentee);
           // System.out.println(idRequest);
            int idMentor = Integer.parseInt(request.getParameter("idMentor"));
            
            request.setAttribute("req", idMentor);
            Rate r = dao.getRateByIDRequest(idRequest);
          //  System.out.println(r);
            request.setAttribute("rate", r);
            // Set the mentors attribute for use in rate.jsp
            request.setAttribute("mentors", mentors);

            // Set idMentee as a request attribute
            request.setAttribute("idMentee", account.getId());

            // Set the account attribute to the session before forwarding
            session.setAttribute("account", account);

            // Forward to rate.jsp
            System.out.println("Successfully forwarded to rate.jsp");
            request.getRequestDispatcher("rate.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve idMentee from the session
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        int idRequest;
        int idMentee;
        try {
            DAO dao = new DAO();
            idRequest = Integer.parseInt(request.getParameter("idrequest"));
            idMentee = Integer.parseInt(request.getParameter("idMentee"));
            System.out.println(idRequest);
            Rate ru = dao.getRateByIDRequest(idRequest);

            // Retrieve other parameters (rating, opinion, mentorId)
            int rating = Integer.parseInt(request.getParameter("rating"));
            String opinion = request.getParameter("opinion");
            int idMentor = Integer.parseInt(request.getParameter("idMentor"));

            // Get current timestamp
            java.util.Date date = new java.util.Date();
            Timestamp currentTimestamp = new Timestamp(date.getTime());
            String currentTime = currentTimestamp.toString();

            // Create a Rate object
            Rate r = new Rate(idRequest, idMentee, idMentor, rating, opinion, currentTime);

            if (ru != null) {
                if (dao.updateratebyidreq(idRequest, rating, opinion, currentTime)) {
                    System.out.println("Successfully updated rating in the database");
                    request.setAttribute("messsuccess", "Thank you for updating your rating!");

                    response.sendRedirect("listrequest");
                } else {
                    System.out.println("Error: Could not update rating in the database");
                    request.setAttribute("messerror", "Cannot update rating. Please try again later.");
                }
            } else {
                if (dao.insertr(r)) {
                    System.out.println("Successfully inserted rating into the database");
                    request.setAttribute("messsuccess", "Thank you for rating!");

                    response.sendRedirect("listrequest");
                } else {
                    System.out.println("Error: Could not insert rating into the database");
                    request.setAttribute("messerror", "Cannot rate. Please try again later.");
                }
            }
        } catch (NumberFormatException e) {

            System.out.println("Error: Invalid input format");
            request.setAttribute("messerror", "Invalid input format. Please try again.");
        }

    }

    @Override
    public String getServletInfo() {
        return "Servlet for handling ratings";
    }
}
