package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bmt_detail database table.
 * 
 */
@Entity
@Table(name="bmt_detail")
@NamedQuery(name="BmtDetail.findAll", query="SELECT b FROM BmtDetail b")
public class BmtDetail  {
	private static final long serialVersionUID = 1L;
	private BmtDetailPK id;
	private int detailScrFoeman;
	private int detailScrUs;
	private int detailSet;
	private double detailTime;
	private BmtEvent bmtEvent;
	private BmtMatch bmtMatch;

	public BmtDetail() {
	}


	@EmbeddedId
	public BmtDetailPK getId() {
		return this.id;
	}

	public void setId(BmtDetailPK id) {
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


	@Column(name="detail_set")
	public int getDetailSet() {
		return this.detailSet;
	}

	public void setDetailSet(int detailSet) {
		this.detailSet = detailSet;
	}


	@Column(name="detail_time")
	public double getDetailTime() {
		return this.detailTime;
	}

	public void setDetailTime(double detailTime) {
		this.detailTime = detailTime;
	}


	//bi-directional many-to-one association to BmtEvent
	@ManyToOne
	@JoinColumn(name="event_id")
	public BmtEvent getBmtEvent() {
		return this.bmtEvent;
	}

	public void setBmtEvent(BmtEvent bmtEvent) {
		this.bmtEvent = bmtEvent;
	}


	//bi-directional many-to-one association to BmtMatch
	@ManyToOne
	@JoinColumn(name="match_id")
	public BmtMatch getBmtMatch() {
		return this.bmtMatch;
	}

	public void setBmtMatch(BmtMatch bmtMatch) {
		this.bmtMatch = bmtMatch;
	}

}