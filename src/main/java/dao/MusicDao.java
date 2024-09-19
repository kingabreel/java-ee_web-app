package dao;

import db.DbConnect;
import model.Music;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicDao {
    private final Connection connection;

    public MusicDao() throws ClassNotFoundException, SQLException{
        connection = DbConnect.getConnection();
    }

    public void addMusic(Music music) throws SQLException{
        try {
            PreparedStatement pst = connection.prepareStatement("INSERT INTO music(id, title, band, genre, durationSec, album) values(?, ?, ?, ?, ?, ?)");
            pst.setInt(1, music.getId());
            pst.setString(2, music.getTitle());
            pst.setString(3, music.getBand());
            pst.setString(4, music.getGenre());
            pst.setInt(5, music.getDurationSec());
            pst.setString(6, music.getAlbum());

            pst.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Music> getMusic() throws SQLException {
        List<Music> musics = new ArrayList<>();

        try {
            Statement stm = connection.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM music");

            while (rs.next()){
                Music music = new Music();

                music.setId(rs.getInt("id"));
                music.setTitle(rs.getString("title"));
                music.setBand(rs.getString("band"));
                music.setAlbum(rs.getString("album"));
                music.setGenre(rs.getString("genre"));
                music.setDurationSec(rs.getInt("durationSec"));

                musics.add(music);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return musics;
    }
    public List<Music> byTitle(String title) throws SQLException {
        List<Music> musics = new ArrayList<>();

        try {
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM music WHERE LOWER(title) LIKE ?");
            pst.setString(1, "%" + title.toLowerCase() + "%");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Music music = new Music();
                music.setId(rs.getInt("id"));
                music.setTitle(rs.getString("title"));
                music.setBand(rs.getString("band"));
                music.setAlbum(rs.getString("album"));
                music.setGenre(rs.getString("genre"));
                music.setDurationSec(rs.getInt("durationSec"));

                musics.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return musics;
    }
}
