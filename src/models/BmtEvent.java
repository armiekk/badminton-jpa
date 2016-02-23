package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bmt_event database table.
 * 
 */
@Entity
@Table(name="bmt_event")
@NamedQuery(name="BmtEvent.findAll", query="SELECT b FROM BmtEvent b")
public class BmtEvent  {
	private static final long serialVersionUID = 1L;
	private int eventId;
	private String eventDetail;
	private List<BmtDetail> bmtDetails;

	public BmtEvent() {
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


	//bi-directional many-to-one association to BmtDetail
	@OneToMany(mappedBy="bmtEvent")
	public List<BmtDetail> getBmtDetails() {
		return this.bmtDetails;
	}

	public void setBmtDetails(List<BmtDetail> bmtDetails) {
		this.bmtDetails = bmtDetails;
	}

	public BmtDetail addBmtDetail(BmtDetail bmtDetail) {
		getBmtDetails().add(bmtDetail);
		bmtDetail.setBmtEvent(this);

		return bmtDetail;
	}

	public BmtDetail removeBmtDetail(BmtDetail bmtDetail) {
		getBmtDetails().remove(bmtDetail);
		bmtDetail.setBmtEvent(null);

		return bmtDetail;
	}

}