package com.profifty.nflscrapper.db.beans;


import java.sql.ResultSet;
import java.sql.SQLException;

public class RosterData{

	private int RosterID;
	private String TeamMascot;
	private int AvgAge;
	private int AvgWeight;
	private int rosterCount;
	
	public int getRosterId() {
		return RosterID;
	}
	public void setRosterId(int rosterId) {
		RosterID = rosterId;
	}
	
	
	public String getTeamMascot() {
		return TeamMascot;
	}
	public void setTeamMascot(String teamMascot) {
		TeamMascot = teamMascot;
	}
	public int getAvgAge() {
		return AvgAge;
	}
	public void setAvgAge(int avgAge) {
		AvgAge = avgAge;
	}
	public int getAvgWeight() {
		return AvgWeight;
	}
	public void setAvgWeight(int avgWeight) {
		AvgWeight = avgWeight;
	}
	public int getRosterCount() {
		return rosterCount;
	}
	public void setRosterCount(int rosterCount) {
		this.rosterCount = rosterCount;
	}
	public static void displayData(ResultSet result) throws SQLException{
		
		while(result.next()){
			StringBuffer buffer = new StringBuffer();
			
			buffer.append("Roster Data " + result.getInt("RosterID") + ": " );
			buffer.append("Team Mascot " + result.getString("TeamMascot") + ", ");
			
			buffer.append("Average Age " + result.getInt("AvgAge") + ", ");
			buffer.append("Average Weight " + result.getInt("AvgWeight") + ", ");
			buffer.append("Roster Count " + result.getInt("rosterCount") + ", ");
			System.out.println(buffer.toString());
			
			
			
			
			
		}
	}
	
}
