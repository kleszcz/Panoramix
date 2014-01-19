/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bean.Comments;
import bean.ImageInfo;
import bean.ObjectsOnImage;
import dao.CommentsDAO;
import dao.ImagesDAO;
import dao.ObjectsOnImageDAO;
import java.util.List;

/**
 *
 * @author Jan
 */
public class ImageService {

	private ImagesDAO imagesDAO;
	private ObjectsOnImageDAO objectsOnImageDAO;
	private CommentsDAO commentsDAO;

	public CommentsDAO getCommentsDAO() {
		return commentsDAO;
	}

	public void setCommentsDAO(CommentsDAO commentsDAO) {
		this.commentsDAO = commentsDAO;
	}

	public ObjectsOnImageDAO getObjectsOnImageDAO() {
		return objectsOnImageDAO;
	}

	public void setObjectsOnImageDAO(ObjectsOnImageDAO objectsOnImageDAO) {
		this.objectsOnImageDAO = objectsOnImageDAO;
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

	public List<ObjectsOnImage> getObjectsOnImageByIid(int iid) {
		return objectsOnImageDAO.getByIid(iid);
	}
	
	public List<Comments> getCommentsByIid(int iid) {
		return commentsDAO.getByIid(iid);
	}
}
