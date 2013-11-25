/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import bean.Images;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
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
        String query = "select * from PANORAMIX.Images join POI using (iid) join Assumptions using (pid) where oid =?";
        List<Map<String, Object>> result = null;
        List<Images> images = null;
        try {
            result = jdbcTemplate.queryForList(query, new Object[] {oid});
            //TODO Get data from result
        }
        catch(Exception e) {
            
        }
        return images;
    }
    
}
