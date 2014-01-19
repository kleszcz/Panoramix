/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bean.ImageInfo;
import bean.ObjectsOnImage;
import bean.POI;
import dao.ImagesDAO;
import dao.ObjectsOnImageDAO;
import dao.POIDAO;
import java.util.List;

/**
 *
 * @author Jan
 */
public class ImageService {

	private ImagesDAO imagesDAO;
	private POIDAO poiDAO; //TODO get rid of it
	private ObjectsOnImageDAO objectsOnImageDAO;

	public ObjectsOnImageDAO getObjectsOnImageDAO() {
		return objectsOnImageDAO;
	}

	public void setObjectsOnImageDAO(ObjectsOnImageDAO objectsOnImageDAO) {
		this.objectsOnImageDAO = objectsOnImageDAO;
	}

	public POIDAO getPoiDAO() {
		return poiDAO;
	}

	public void setPoiDAO(POIDAO poiDAO) {
		this.poiDAO = poiDAO;
	}

	public ImagesDAO getImagesDAO() {
		return imagesDAO;
	}

	public void setImagesDAO(ImagesDAO imagesDAO) {
		this.imagesDAO = imagesDAO;
	}

	public ImageInfo getImageById(int iid) {
		return imagesDAO.getImageById(iid);
	}

	public List<POI> getPOIByIid(int iid) {
		return poiDAO.getPOIsByIid(iid);
	}

	public List<ObjectsOnImage> getObjectsOnImageByIid(int iid) {
		return objectsOnImageDAO.getByIid(iid);
	}
}
