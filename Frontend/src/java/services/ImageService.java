/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bean.ImageInfo;
import bean.Objects;
import bean.POI;
import dao.ImagesDAO;
import dao.POIDAO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jan
 */
public class ImageService {

	private ImagesDAO imagesDAO;
	private POIDAO poiDAO;

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

	public Map<POI, Objects> getPOIToObjectsMapByIid(int iid) {
		return poiDAO.getPOIToObjectsMapByIid(iid);
	}
}
