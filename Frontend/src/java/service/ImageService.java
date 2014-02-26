package service;

import bean.*;
import dao.CommentsDAO;
import dao.ImagesDAO;
import dao.ObjectsDAO;
import dao.UsersDAO;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public class ImageService {

	private ImagesDAO imagesDAO;
	private ObjectsDAO objectsDAO;
	private CommentsDAO commentsDAO;
	private UsersDAO usersDAO;

	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	public CommentsDAO getCommentsDAO() {
		return commentsDAO;
	}

	public void setCommentsDAO(CommentsDAO commentsDAO) {
		this.commentsDAO = commentsDAO;
	}

	public ObjectsDAO getObjectsOnImageDAO() {
		return objectsDAO;
	}

	public void setObjectsOnImageDAO(ObjectsDAO objectsOnImageDAO) {
		this.objectsDAO = objectsOnImageDAO;
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
		return objectsDAO.getByIid(iid);
	}

	public List<Comment> getCommentsByIid(Integer iid) {
		return commentsDAO.getByIid(iid);
	}

	public List<UserInfo> getUsersOnImage(Integer iid) {
		return usersDAO.getByIid(iid);
	}

	public void addObject(ObjectInfo object) {
		objectsDAO.addObject(object);
	}

	public void addAssumption(AssumptionInfo assumption) {
		imagesDAO.addAssumption(assumption);
	}

	public void addPoi(PoiInfo poi) {
		imagesDAO.addPoi(poi);
	}

	public void addComment(Comment comment) {
		commentsDAO.addComment(comment);
	}

	public List<ImageInfo> getAllImages() {
		return imagesDAO.getAllImages();
	}

	public Map<Integer, String> getUidMapForIid(Integer iid) {
		HashMap<Integer, String> userMap = new HashMap<>();
		for (UserInfo u : getUsersOnImage(iid)) {
			userMap.put(u.getUid(), u.getUname());
		}
		return userMap;
	}

	public void addImageInfo(ModelAndView mv, int iid) {
		mv.addObject("iid", iid);
		mv.addObject("image", getImageById(iid));
		mv.addObject("usersMap", getUidMapForIid(iid));
		mv.addObject("objects", getAllObjects());

		mv.addObject("objectsList", getObjectsOnImageByIid(iid));
		mv.addObject("commentsList", getCommentsByIid(iid));
	}

	public List<ObjectInfo> getAllObjects() {
		return objectsDAO.getAllObjects();
	}

	public int saveImage(ImageUpload iu) throws Exception {
		/*MultipartFile image = iu.getImage();
		 String filename = "images/" + UUID.randomUUID().toString();
		 image.transferTo(new File(filename));*/
		throw new Exception("" + iu.getImage() + iu.getDescription() + iu.getName() + iu.getTakenFrom());
		//return 5;
	}
}
