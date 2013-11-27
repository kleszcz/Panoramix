/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Timestamp;

/**
 *
 * @author Jan
 */
public class Images {

    private int iid;
    private int uid;
    private String filename;
    private String description;
    private Timestamp added;
    private int taken_from;

    public Images() {
    }

    public Images(
            int iid,
            int uid,
            String filename,
            String description,
            Timestamp added,
            int taken_from
    ) {
        this.iid = iid;
        this.uid =  uid;
        this.filename =  filename;
        this.description =  description;
        this.added =  added;
        this.taken_from =  taken_from;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getAdded() {
        return added;
    }

    public void setAdded(Timestamp added) {
        this.added = added;
    }

    public int getTaken_from() {
        return taken_from;
    }

    public void setTaken_from(int taken_from) {
        this.taken_from = taken_from;
    }

}
