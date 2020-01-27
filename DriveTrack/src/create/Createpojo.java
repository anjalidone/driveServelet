package create;

import java.sql.Date;

public class Createpojo {
	 int did;
	String companyname;
    int resources;   
    int experience; 
    float ctc;       
    float bond;
    String followup;
    int criteria;
    int position;
    int joining;
   
    public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public int getResources() {
		return resources;
	}
	public void setResources(int resources) {
		this.resources = resources;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public float getCtc() {
		return ctc;
	}
	public void setCtc(float ctc) {
		this.ctc = ctc;
	}
	public float getBond() {
		return bond;
	}
	public void setBond(float bond) {
		this.bond = bond;
	}
	public String getFollowup() {
		return followup;
	}
	public void setFollowup(String followup) {
		this.followup = followup;
	}
	public int getCriteria() {
		return criteria;
	}
	public void setCriteria(int criteria) {
		this.criteria = criteria;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getJoining() {
		return joining;
	}
	public void setJoining(int joining) {
		this.joining = joining;
	}
	@Override
	public String toString() {
		return "Createpojo [CompanyName=" + companyname + ", resources=" + resources + ", experience=" + experience
				+ ", ctc=" + ctc + ", bond=" + bond + ", followup=" + followup + ", criteria=" + criteria
				+ ", position=" + position + ", joining=" + joining + "]";
	} 
	



}
