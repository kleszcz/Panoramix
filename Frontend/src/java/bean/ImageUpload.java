package bean;

import org.springframework.web.multipart.MultipartFile;

public class ImageUpload {

	MultipartFile image;
	String name;
	String description;
	Integer takenFrom;

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getTakenFrom() {
		return takenFrom;
	}

	public void setTakenFrom(Integer takenFrom) {
		this.takenFrom = takenFrom;
	}
}
