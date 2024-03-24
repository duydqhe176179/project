/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package VNPay;

import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dal.MentorDAO;
import dal.RequestDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import model.Account;
import model.Have_SKill;
import model.Mentor;
import model.Request;

/**
 *
 * @author admin
 */
@WebServlet(name = "VNPResponeController", urlPatterns = {"/vnpayresponse"})
public class VNPResponeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String requestId = request.getParameter("vnp_TxnRef");

        RequestDAO dao = new RequestDAO();
        dao.UpdateRequestStatus(requestId, "Learning ");

        dal.ListRequest req = new dal.ListRequest();
        HttpSession session = request.getSession(true );
        Account account = (Account) session.getAttribute("account");
        String userName = account.getUser();

        int idAccount = req.getIdAccountByUsername(userName);
        List<Request> listRequest1 = req.ListRequestById(idAccount);
        request.setAttribute("listReq", listRequest1);
        request.getRequestDispatcher("view/listallreq.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
