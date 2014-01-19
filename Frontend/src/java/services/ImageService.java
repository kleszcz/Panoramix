/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bean.Comments;
import bean.ImageInfo;
import bean.ObjectsOnImage;
import bean.UsersOnImage;
import dao.CommentsDAO;
import dao.ImagesDAO;
import dao.ObjectsOnImageDAO;
import dao.UsersOnImageDAO;
import java.util.List;

/**
 *
 * @author Jan
 */
public class ImageService {

	private ImagesDAO imagesDAO;
	private ObjectsOnImageDAO objectsOnImageDAO;
	private CommentsDAO commentsDAO;
	private UsersOnImageDAO usersOnImageDAO;

	public UsersOnImageDAO getUsersOnImageDAO() {
		return usersOnImageDAO;
	}

	public void setUsersOnImageDAO(UsersOnImageDAO usersOnImageDAO) {
		this.usersOnImageDAO = usersOnImageDAO;
	}

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

	public ImageInfo getImageById(Integer iid) {
		return imagesDAO.getByIid(iid);
	}

	public List<ObjectsOnImage> getObjectsOnImageByIid(Integer iid) {
		return objectsOnImageDAO.getByIid(iid);
	}

	public List<Comments> getCommentsByIid(Integer iid) {
		return commentsDAO.getByIid(iid);
	}

	public List<UsersOnImage> getUsersOnImage(Integer iid) {
		return usersOnImageDAO.getByIid(iid);
	}
}
