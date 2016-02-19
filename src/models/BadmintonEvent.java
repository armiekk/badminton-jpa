package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the badminton_event database table.
 * 
 */
@Entity
@Table(name="badminton_event")
@NamedQuery(name="BadmintonEvent.findAll", query="SELECT b FROM BadmintonEvent b")
public class BadmintonEvent  {
	private static final long serialVersionUID = 1L;
	private int eventId;
	private String eventDetail;
	private List<BadmintonDetail> badmintonDetails;

	public BadmintonEvent() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="event_id")
	public int getEventId() {
		return this.eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}


	@Column(name="event_detail")
	public String getEventDetail() {
		return this.eventDetail;
	}

	public void setEventDetail(String eventDetail) {
		this.eventDetail = eventDetail;
	}


	//bi-directional many-to-one association to BadmintonDetail
	@OneToMany(mappedBy="badmintonEvent")
	public List<BadmintonDetail> getBadmintonDetails() {
		return this.badmintonDetails;
	}

	public void setBadmintonDetails(List<BadmintonDetail> badmintonDetails) {
		this.badmintonDetails = badmintonDetails;
	}

	public BadmintonDetail addBadmintonDetail(BadmintonDetail badmintonDetail) {
		getBadmintonDetails().add(badmintonDetail);
		badmintonDetail.setBadmintonEvent(this);

		return badmintonDetail;
	}

	public BadmintonDetail removeBadmintonDetail(BadmintonDetail badmintonDetail) {
		getBadmintonDetails().remove(badmintonDetail);
		badmintonDetail.setBadmintonEvent(null);

		return badmintonDetail;
	}

}