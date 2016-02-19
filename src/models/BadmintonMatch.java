package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the badminton_match database table.
 * 
 */
@Entity
@Table(name="badminton_match")
@NamedQuery(name="BadmintonMatch.findAll", query="SELECT b FROM BadmintonMatch b")
public class BadmintonMatch  {
	private static final long serialVersionUID = 1L;
	private int matchId;
	private int matchHcolB;
	private int matchHcolG;
	private int matchHcolR;
	private int matchLcolB;
	private int matchLcolG;
	private int matchLcolR;
	private String matchName;
	private List<BadmintonDetail> badmintonDetails;

	public BadmintonMatch() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="match_id")
	public int getMatchId() {
		return this.matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}


	@Column(name="match_hcol_b")
	public int getMatchHcolB() {
		return this.matchHcolB;
	}

	public void setMatchHcolB(int matchHcolB) {
		this.matchHcolB = matchHcolB;
	}


	@Column(name="match_hcol_g")
	public int getMatchHcolG() {
		return this.matchHcolG;
	}

	public void setMatchHcolG(int matchHcolG) {
		this.matchHcolG = matchHcolG;
	}


	@Column(name="match_hcol_r")
	public int getMatchHcolR() {
		return this.matchHcolR;
	}

	public void setMatchHcolR(int matchHcolR) {
		this.matchHcolR = matchHcolR;
	}


	@Column(name="match_lcol_b")
	public int getMatchLcolB() {
		return this.matchLcolB;
	}

	public void setMatchLcolB(int matchLcolB) {
		this.matchLcolB = matchLcolB;
	}


	@Column(name="match_lcol_g")
	public int getMatchLcolG() {
		return this.matchLcolG;
	}

	public void setMatchLcolG(int matchLcolG) {
		this.matchLcolG = matchLcolG;
	}


	@Column(name="match_lcol_r")
	public int getMatchLcolR() {
		return this.matchLcolR;
	}

	public void setMatchLcolR(int matchLcolR) {
		this.matchLcolR = matchLcolR;
	}


	@Column(name="match_name")
	public String getMatchName() {
		return this.matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}


	//bi-directional many-to-one association to BadmintonDetail
	@OneToMany(mappedBy="badmintonMatch")
	public List<BadmintonDetail> getBadmintonDetails() {
		return this.badmintonDetails;
	}

	public void setBadmintonDetails(List<BadmintonDetail> badmintonDetails) {
		this.badmintonDetails = badmintonDetails;
	}

	public BadmintonDetail addBadmintonDetail(BadmintonDetail badmintonDetail) {
		getBadmintonDetails().add(badmintonDetail);
		badmintonDetail.setBadmintonMatch(this);

		return badmintonDetail;
	}

	public BadmintonDetail removeBadmintonDetail(BadmintonDetail badmintonDetail) {
		getBadmintonDetails().remove(badmintonDetail);
		badmintonDetail.setBadmintonMatch(null);

		return badmintonDetail;
	}

}