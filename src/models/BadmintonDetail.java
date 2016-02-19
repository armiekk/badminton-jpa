package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the badminton_detail database table.
 * 
 */
@Entity
@Table(name="badminton_detail")
@NamedQuery(name="BadmintonDetail.findAll", query="SELECT b FROM BadmintonDetail b")
public class BadmintonDetail  {
	private static final long serialVersionUID = 1L;
	private BadmintonDetailPK id;
	private int detailScrFoeman;
	private int detailScrUs;
	private double detailTime;
	private BadmintonEvent badmintonEvent;
	private BadmintonMatch badmintonMatch;

	public BadmintonDetail() {
	}


	@EmbeddedId
	public BadmintonDetailPK getId() {
		return this.id;
	}

	public void setId(BadmintonDetailPK id) {
		this.id = id;
	}


	@Column(name="detail_scr_foeman")
	public int getDetailScrFoeman() {
		return this.detailScrFoeman;
	}

	public void setDetailScrFoeman(int detailScrFoeman) {
		this.detailScrFoeman = detailScrFoeman;
	}


	@Column(name="detail_scr_us")
	public int getDetailScrUs() {
		return this.detailScrUs;
	}

	public void setDetailScrUs(int detailScrUs) {
		this.detailScrUs = detailScrUs;
	}


	@Column(name="detail_time")
	public double getDetailTime() {
		return this.detailTime;
	}

	public void setDetailTime(double detailTime) {
		this.detailTime = detailTime;
	}


	//bi-directional many-to-one association to BadmintonEvent
	@ManyToOne
	@JoinColumn(name="event_id")
	public BadmintonEvent getBadmintonEvent() {
		return this.badmintonEvent;
	}

	public void setBadmintonEvent(BadmintonEvent badmintonEvent) {
		this.badmintonEvent = badmintonEvent;
	}


	//bi-directional many-to-one association to BadmintonMatch
	@ManyToOne
	@JoinColumn(name="match_id")
	public BadmintonMatch getBadmintonMatch() {
		return this.badmintonMatch;
	}

	public void setBadmintonMatch(BadmintonMatch badmintonMatch) {
		this.badmintonMatch = badmintonMatch;
	}

}