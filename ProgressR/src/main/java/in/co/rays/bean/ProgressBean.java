package in.co.rays.bean;

import java.util.Date;

public class ProgressBean {
	
	 private int id ;
	  private String DeveloperName ;
	  private String Work ;
	  private String Target ;
	  private String LastWeek;
	  private String CurrentWeek;
	  private  Date  Today;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeveloperName() {
		return DeveloperName;
	}
	public void setDeveloperName(String developerName) {
		DeveloperName = developerName;
	}
	public String getWork() {
		return Work;
	}
	public void setWork(String work) {
		Work = work;
	}
	public String getTarget() {
		return Target;
	}
	public void setTarget(String target) {
		Target = target;
	}
	public String getLastWeek() {
		return LastWeek;
	}
	public void setLastWeek(String lastWeek) {
		LastWeek = lastWeek;
	}
	public String getCurrentWeek() {
		return CurrentWeek;
	}
	public void setCurrentWeek(String currentWeek) {
		CurrentWeek = currentWeek;
	}
	public Date getToday() {
		return Today;
	}
	public void setToday(Date today) {
		Today = today;
	}	  
	 
	 
	

}
