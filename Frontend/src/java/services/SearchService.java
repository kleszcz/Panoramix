/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import bean.Images;
import dao.ImagesDAO;
import dao.ObjectsDAO;

/**
 *
 * @author Jan
 */
public class SearchService {
    ImagesDAO imagesDAO;
    ObjectsDAO objectsDAO;
    
    int getOIDByObjectName(String name) {
        return objectsDAO.getOIDByName(name);
    }
    
    Images[] getImagesByOID(int oid) {
        return imagesDAO.getImagesByOID(oid);
    }
}
