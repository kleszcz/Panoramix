/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import bean.Images;
import dao.ImagesDAO;
import dao.ObjectsDAO;
import java.util.List;

/**
 *
 * @author Jan
 */
public class SearchService {
    private ImagesDAO imagesDAO;
    private ObjectsDAO objectsDAO;

    public List<Images> getImagesByObjectName(String name) {
        Integer oid;
        oid = objectsDAO.getOIDByName(name);
        if(oid == null)
            return null;
        return imagesDAO.getImagesByOID(oid);
    }

    public void setImagesDAO(ImagesDAO imagesDAO) {
        this.imagesDAO = imagesDAO;
    }

    public void setObjectsDAO(ObjectsDAO objectsDAO) {
        this.objectsDAO = objectsDAO;
    }
}
