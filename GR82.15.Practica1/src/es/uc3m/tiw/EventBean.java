package es.uc3m.tiw;

import java.awt.image.BufferedImage;
import java.util.Date;

public class EventBean {
	

	private String title;
	private String category;
	private float price;
	private Date date;
	private BufferedImage image;
	private String imagePath;
	private String place;
	private String info;
	private int availableTickets;
	private String state;

	public EventBean(){
	}
	
	public EventBean(String title, String category, float price, Date date, BufferedImage image, String imagePath,
			String place, String info, int availableTickets, String state) {
		super();
		this.title = title;
		this.category = category;
		this.price = price;
		this.date = date;
		this.image = image;
		this.imagePath = imagePath;
		this.place = place;
		this.info = info;
		this.availableTickets = availableTickets;
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getAvailableTickets() {
		return availableTickets;
	}

	public void setAvailableTickets(int availableTickets) {
		this.availableTickets = availableTickets;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
