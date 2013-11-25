/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Objects;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Jan
 */
public class ObjectsDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public Integer getOIDByName(String name) {
        //TODO select * from PANORAMIX.Objects where label == name
<<<<<<< HEAD
        Integer oid = null;
        String query = "select oid from PANORAMIX.Objects where label=?";

 
=======
        Integer oid = -1;
        String query = "select oid from PANORAMIX.Objects where label=?";
>>>>>>> ImagesDAO in progress
  
        try {
            oid = (Integer)jdbcTemplate.queryForObject(query, new Object[] {name}, new RowMapper(){
                    @Override
                    public Object mapRow(ResultSet rs, int i) throws SQLException {
                        return new Integer(rs.getInt("oid"));
                    }
            });

            System.out.println("Get object id [" + name +"] oid = " + oid);

        }
        catch(DataAccessException e)
        {
            System.out.println("Couldn't get object id [" + name +"]");
        } 
        return oid;

    }
    
    public Object getObjectByName(String name) {
        //TODO select * from PANORAMIX.Objects where label == name
        String query = "select * from PANORAMIX.Objects where label=?";
        Objects object = null;
        try {
            object = (Objects)jdbcTemplate.queryForObject(query, new Object[] {name}, new RowMapper(){
                    @Override
                    public Object mapRow(ResultSet rs, int i) throws SQLException {
                        return new Objects( rs.getInt("oid"), 
                                            rs.getInt("uid"),
                                            rs.getString("label"),
                                            rs.getString("description"),
                                            rs.getFloat("latitude"),
                                            rs.getFloat("longitude")
                        );
                    }
            });
        }
        catch(DataAccessException e)
        {
            System.out.println("Couldn't get object [" + name +"]");
        }       
        return object;

    }

}
