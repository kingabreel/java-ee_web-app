package student.com.servlet;

import dao.SingerDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Singer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class SingerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SingerDao dao;
    private static ArrayList<Singer> singers = new ArrayList<>();
    private HttpSession session;

    public SingerServlet () throws SQLException, ClassNotFoundException {
        super();
        this.dao = new SingerDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().append("Served at:").append(request.getContextPath());
        session = request.getSession();

        try {
            request.setAttribute("singers", dao.getSingers());

            RequestDispatcher dispatcher = request.getRequestDispatcher("singer.jsp");

            singers = (ArrayList<Singer>) request.getAttribute("singers");

            session.setAttribute("singers", singers);
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String country = req.getParameter("country");

        Random random = new Random();

        Singer singer = new Singer(random.nextInt(), name, Integer.parseInt(age), country);

        try {
            dao.addSinger(singer);
            PrintWriter out =  res.getWriter();
            out.println("<html><body><h1>Singer added</h1><br> <button><a href='/singer'>Return</a></button></body></html>");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
