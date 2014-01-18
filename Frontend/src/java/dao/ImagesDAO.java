/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import bean.Images;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 *
 * @author Jan
 */
public class ImagesDAO {




    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Images> getImagesByOID(int oid) {
        String query = "select DISTINCT Images.IID, Images.UID, Images.FILENAME, Images.DESCRIPTION, Images.ADDED, Images.TAKEN_FROM  from PANORAMIX.Images join POI using (iid) join Assumptions using (pid) where oid = ?";
        List<Map<String, Object>> result = null;
        List<Images> images = null;
        try {
            result = jdbcTemplate.queryForList(query, new Object[] {oid});
            //TODO Get data from result



             System.out.println("Get images for object [" + oid +"]");
             
             images = new ArrayList<>();
             for(Map<String, Object> el : result)
             {
                 Images img = new Images();
                 img.setIid((int) el.get("IID"));
                 img.setUid((int) el.get("UID"));
                 img.setFilename((String) el.get("FILENAME"));
                 img.setDescription((String) el.get("DESCRIPTION"));
                 img.setAdded((Timestamp) el.get("ADDED"));
                 if(el.get("TAKEN_FROM") != null) 
                     img.setTaken_from((int) el.get("TAKEN_FROM"));
				 
                 images.add(img);
             }
             System.out.println(images.get(0).getFilename());
        }
        catch(DataAccessException e) {
            System.out.println("Couldn't get images for object [" + oid +"]");
        }
        return images;


    }
    
    public Images getImageById(int iid)
    {
        String query = "select * from PANORAMIX.Images where iid =?";
        Images image = null;
        try {
            image = (Images)jdbcTemplate.queryForObject(query, new Object[] {iid}, new RowMapper(){
                    @Override
                    public Object mapRow(ResultSet rs, int i) throws SQLException {
                        return new Images(  rs.getInt("iid"), 
                                            rs.getInt("uid"),
                                            rs.getString("filename"),
                                            rs.getString("description"),
                                            rs.getTimestamp("added"),
                                            rs.getInt("taken_from")
                        );
                    }
            });
        }
        catch(DataAccessException e)
        {
            System.out.println("Couldn't get object [" + iid +"]");
        }       
        return image;
    }
}
