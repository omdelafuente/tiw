package es.uc3m.tiw.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Event implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id private int id;
	private String title;
	private String category;
	private byte[] image;
	private BigDecimal price;
	private Timestamp date;
	private String place;
	private String description;
	private int availableTickets;
	private String state;
	private UserBean creator;


	public Event(int id, String title, String category, byte[] image, BigDecimal price, Timestamp date,
			String place, String description, int availableTickets, String state, UserBean creator) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.image = image;
		this.price = price;
		this.date = date;
		this.place = place;
		this.description = description;
		this.availableTickets = availableTickets;
		this.state = state;
		this.creator = creator;
	}


	public Event(){
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public Timestamp getDate() {
		return date;
	}


	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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


	public UserBean getCreator() {
		return creator;
	}


	public void setCreator(UserBean creator) {
		this.creator = creator;
	}
	
	
}