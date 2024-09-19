package student.com.servlet;

import dao.MusicDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Music;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final MusicDao dao;
    private static List<Music> musics = new ArrayList<>();
    private HttpSession session;

    public SearchServlet () throws SQLException, ClassNotFoundException {
        super();
        this.dao = new MusicDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().append("Served at:").append(request.getContextPath());
        session = request.getSession();

        try {
            request.setAttribute("musics", dao.getMusic());

            RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");

            musics = (ArrayList<Music>) request.getAttribute("musics");

            session.setAttribute("musics", musics);
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            musics = dao.getMusic();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String searchQuery = req.getParameter("title").toLowerCase();
        ArrayList<Music> filteredMusics = (ArrayList<Music>) musics.stream()
                .filter(music -> music.getTitle().toLowerCase().contains(searchQuery))
                .collect(Collectors.toList());

        req.setAttribute("musics", filteredMusics);
        try {
            RequestDispatcher dispatcher = req.getRequestDispatcher("search.jsp");
            dispatcher.forward(req, res);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
