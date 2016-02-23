package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the bmt_match database table.
 * 
 */
@Entity
@Table(name="bmt_match")
@NamedQuery(name="BmtMatch.findAll", query="SELECT b FROM BmtMatch b")
public class BmtMatch  {
	private static final long serialVersionUID = 1L;
	private int matchId;
	private Date matchDate;
	private String matchFoeman;
	private int matchHcolB;
	private int matchHcolG;
	private int matchHcolR;
	private int matchLcolB;
	private int matchLcolG;
	private int matchLcolR;
	private String matchName;
	private String matchStadium;
	private String matchTitle;
	private String matchTournament;
	private List<BmtDetail> bmtDetails;

	public BmtMatch() {
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


	@Temporal(TemporalType.DATE)
	@Column(name="match_date")
	public Date getMatchDate() {
		return this.matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}


	@Column(name="match_foeman")
	public String getMatchFoeman() {
		return this.matchFoeman;
	}

	public void setMatchFoeman(String matchFoeman) {
		this.matchFoeman = matchFoeman;
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


	@Column(name="match_stadium")
	public String getMatchStadium() {
		return this.matchStadium;
	}

	public void setMatchStadium(String matchStadium) {
		this.matchStadium = matchStadium;
	}


	@Column(name="match_title")
	public String getMatchTitle() {
		return this.matchTitle;
	}

	public void setMatchTitle(String matchTitle) {
		this.matchTitle = matchTitle;
	}


	@Column(name="match_tournament")
	public String getMatchTournament() {
		return this.matchTournament;
	}

	public void setMatchTournament(String matchTournament) {
		this.matchTournament = matchTournament;
	}


	//bi-directional many-to-one association to BmtDetail
	@OneToMany(mappedBy="bmtMatch")
	public List<BmtDetail> getBmtDetails() {
		return this.bmtDetails;
	}

	public void setBmtDetails(List<BmtDetail> bmtDetails) {
		this.bmtDetails = bmtDetails;
	}

	public BmtDetail addBmtDetail(BmtDetail bmtDetail) {
		getBmtDetails().add(bmtDetail);
		bmtDetail.setBmtMatch(this);

		return bmtDetail;
	}

	public BmtDetail removeBmtDetail(BmtDetail bmtDetail) {
		getBmtDetails().remove(bmtDetail);
		bmtDetail.setBmtMatch(null);

		return bmtDetail;
	}

}