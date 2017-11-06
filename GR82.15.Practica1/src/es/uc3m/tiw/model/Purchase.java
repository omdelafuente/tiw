package es.uc3m.tiw.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PURCHASE")
public class Purchase implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id private int id;
	private int tickets;
	@ManyToOne
    @JoinColumn(name = "event")
	private Event event;
	@ManyToOne
    @JoinColumn(name = "client")
	private Usr client;
	
	public Purchase() {
		
	}
	
	public Purchase(int tickets, Event event, Usr client) {
		super();
		this.tickets = tickets;
		this.event = event;
		this.client = client;
	}
	public int getTickets() {
		return tickets;
	}
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public Usr getClient() {
		return client;
	}
	public void setClient(Usr client) {
		this.client = client;
	}

}
