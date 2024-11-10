package com.jdbc.dao;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

@Repository
public class PercentageCountDao {

    @Autowired
    private static JdbcTemplate jdbcTemplate;
    public static void setPercentCount(Integer percentCount) throws SQLException {
        JSONObject insertStatus = new JSONObject();

        Connection con = null;
        InputStream is = null;
        JSONObject versionDetails = new JSONObject();

        try {
            System.out.println("Inside setPercentCount Dao--------------------> ");
            con = jdbcTemplate.getDataSource().getConnection();
            String sql = "INSERT INTO sanity_progress_percent " + "(progres) VALUES (?)";

            PreparedStatement ps = con.prepareStatement(sql);
            String hash = Calendar.getInstance().getTimeInMillis() + "";

            ps.setInt(1, percentCount);

            //ResultSet rs=ps.executeQuery();
            int rs = ps.executeUpdate();
            System.out.println("rs for percent count  : " + rs);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}


