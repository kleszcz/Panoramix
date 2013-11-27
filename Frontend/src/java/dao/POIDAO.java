/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Objects;
import bean.POI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Jan
 */
public class POIDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<POI> getPOIsByIid(int iid) {
        String query = "select * from POI where iid=?";
        List<POI> pois = null;
        List<Map<String, Object>> result;
        try {
            result = jdbcTemplate.queryForList(query, new Object[]{iid});
            System.out.println("Get POIs for image [" + iid + "]");

            pois = new ArrayList<>();
            for (Map<String, Object> el : result) {
                POI poi = new POI();
                poi.setPid((int) el.get("PID"));
                poi.setIid((int) el.get("IID"));
                poi.setUid((int) el.get("UID"));
                poi.setX((int) el.get("X"));
                poi.setY((int) el.get("Y"));
                pois.add(poi);
            }
        } catch (DataAccessException e) {
            System.out.println("Couldn't get POIS for image [" + iid + "]");
        }
        return pois;
    }

    public Map<POI, Objects> getPOIToObjectsMapByIid(int iid) {
        String query = "select * from POI left join Assumptions using (pid) left join Objects using (oid) where iid=?";
        Map<POI, Objects> poisMap = null;
        List<Map<String, Object>> result;
        try {
            result = jdbcTemplate.queryForList(query, new Object[]{iid});
            System.out.println("Get POIs for image [" + iid + "]");

            poisMap = new HashMap<>();
            for (Map<String, Object> el : result) {
                POI poi = new POI();
                Objects obj = new Objects();
                poi.setPid((int) el.get("PID"));
                poi.setIid((int) el.get("IID"));
                poi.setUid((int) el.get("UID"));
                poi.setX((int) el.get("X"));
                poi.setY((int) el.get("Y"));
                obj.setLabel((String) el.get("LABEL"));
                obj.setDescription((String) el.get("DESCRIPTION"));
                if(el.get("LATITUDE") != null)
                    obj.setLatitude((float) el.get("LATITUDE"));
                if(el.get("LONGITUDE") != null)
                    obj.setLongitude((float) el.get("LONGITUDE"));
                obj.setUid((int) el.get("UID"));
                obj.setOid((int) el.get("OID"));
                poisMap.put(poi, obj);
            }
        } catch (DataAccessException e) {
            System.out.println("Couldn't get POIS for image [" + iid + "]");
        }
        return poisMap;
    }
}
