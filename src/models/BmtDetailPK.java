package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the bmt_detail database table.
 * 
 */
@Embeddable
public class BmtDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int matchId;
	private int detailRunnum;

	public BmtDetailPK() {
	}

	@Column(name="match_id", insertable=false, updatable=false)
	public int getMatchId() {
		return this.matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	@Column(name="detail_runnum")
	public int getDetailRunnum() {
		return this.detailRunnum;
	}
	public void setDetailRunnum(int detailRunnum) {
		this.detailRunnum = detailRunnum;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BmtDetailPK)) {
			return false;
		}
		BmtDetailPK castOther = (BmtDetailPK)other;
		return 
			(this.matchId == castOther.matchId)
			&& (this.detailRunnum == castOther.detailRunnum);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.matchId;
		hash = hash * prime + this.detailRunnum;
		
		return hash;
	}
}