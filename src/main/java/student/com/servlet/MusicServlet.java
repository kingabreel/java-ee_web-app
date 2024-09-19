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
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class MusicServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MusicDao dao;
    private static ArrayList<Music> musics = new ArrayList<>();
    private HttpSession session;

    public MusicServlet () throws SQLException, ClassNotFoundException {
        super();
        this.dao = new MusicDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().append("Served at:").append(request.getContextPath());
        session = request.getSession();

        try {
            request.setAttribute("musics", dao.getMusic());

            RequestDispatcher dispatcher = request.getRequestDispatcher("music.jsp");

            musics = (ArrayList<Music>) request.getAttribute("musics");

            session.setAttribute("musics", musics);
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String title = req.getParameter("title");
        String album = req.getParameter("album");
        String genre = req.getParameter("genre");
        String band = req.getParameter("band");
        String secDuration = req.getParameter("durationSec");

        Random random = new Random();

        Music music = new Music(random.nextInt(), title, band, genre, Integer.parseInt(secDuration), album);

        try {
            dao.addMusic(music);
            PrintWriter out =  res.getWriter();
            out.println("<html><body><h1>Music added</h1><br> <button><a href='/music'>Return</a></button></body></html>");

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
