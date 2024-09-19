package dao;

import db.DbConnect;
import model.Singer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SingerDao {
    private final Connection connection;

    public SingerDao() throws ClassNotFoundException, SQLException {
        connection = DbConnect.getConnection();
    }

    public void addSinger(Singer singer) throws SQLException{
        try {
            PreparedStatement pst = connection.prepareStatement("INSERT INTO singer(id, name, age, country) values(?, ?, ?, ?)");
            pst.setInt(1, singer.getId());
            pst.setString(2, singer.getName());
            pst.setInt(3, singer.getAge());
            pst.setString(4, singer.getCountry());

            pst.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Singer> getSingers() throws SQLException {
        List<Singer> singers = new ArrayList<>();

        try {
            Statement stm = connection.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM singer");

            while (rs.next()){
                Singer singer = new Singer();

                singer.setId(rs.getInt("id"));
                singer.setName(rs.getString("name"));
                singer.setAge(rs.getInt("age"));
                singer.setCountry(rs.getString("country"));

                singers.add(singer);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return singers;
    }
}
