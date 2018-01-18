package com.profifty.nflscrapper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sun.applet.Main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.jsoup.*;

import org.jsoup.nodes.*;
import org.jsoup.select.*;

import com.profifty.nflscrapper.db.beans.RosterData;

public class NFLRosterScrapperController {
	private static final String USERNAME = "profifty_admin20";
	private static final String PASSWORD = "34#1Chris!";
	private static final String CONN_STRING = "jdbc:mysql://184.154.73.76/profifty_nflapp";
	
	
	@FXML
	private Label labelRoster;
	
	@FXML
	private ImageView teamLogo;
	
	@FXML
	private TableView<Roster> tableId ;
		@FXML
		private TableColumn<Roster, Number> tableCol1Number;
		@FXML
		private TableColumn<Roster, String> tableColName;
		@FXML
		private TableColumn<Roster, String> tableColPos;
		@FXML
		private TableColumn<Roster, String> tableColHt;
		@FXML
		private TableColumn<Roster, Number> tableColWt;
		@FXML
		private TableColumn<Roster, Number> tableColAge;
		@FXML
		private TableColumn<Roster, String> tableColEx;
		@FXML
		private TableColumn<Roster, String> tableColCollege;
	
	@FXML
	private ImageView nflLogoId;
	
	@FXML 
	private Button grabTeamInfoId;
	
		
	@FXML
	private TextField textFieldTeamEntryId;
	
	@FXML
	private Label enterTeamLabelId;
	
	@FXML
	private TextField averageAgeId;
	
	@FXML
	private TextField avgWeightId;
	
	@FXML
	private TextField rosterCountId;
	
	
	public void getTeamRosterInfo() throws SQLException{
		// load the image
        
       

		
		//Initializing Document object to null
		Document doc = null;
		String team = textFieldTeamEntryId.getText().toLowerCase();
		//Exception Handling
		try {
		     switch(team) {
	         case "bears" :
	            team = "http://www.chicagobears.com/team/roster.html"; 
	            Image image1 = new Image(NFLRosterScrapperController.class.getResourceAsStream("assets/logo.png"));
	            teamLogo.setImage(image1);
	            //teamLogo.setImage("logo.png");
	            break;
	         case "vikings" :
	        	 team = "http://www.vikings.com/team/roster.html";
	            Image image2 = new Image(NFLRosterScrapperController.class.getResourceAsStream("assets/vikings.png"));
	            teamLogo.setImage(image2);
	        	 break;
	         case "packers" :
	            team = "http://www.packers.com/team/roster.html";
	            Image image3 = new Image(NFLRosterScrapperController.class.getResourceAsStream("assets/greenbay.png"));
	            teamLogo.setImage(image3);
	            break;
	         case "titans":
	        	 team = "http://www.titansonline.com/team/roster.html";
		            Image image4 = new Image(NFLRosterScrapperController.class.getResourceAsStream("assets/titans.png"));
		            teamLogo.setImage(image4);
	        	 break;
	         case "dolphins":
	        	 team = "http://www.miamidolphins.com/team/player-roster.html";
		            Image image5 = new Image(NFLRosterScrapperController.class.getResourceAsStream("assets/dolphins.png"));
		            teamLogo.setImage(image5);
	        	 break;
	         case "raiders":
	        	 team = "http://www.raiders.com/team/roster.html";
		         Image image6 = new Image(NFLRosterScrapperController.class.getResourceAsStream("assets/raiders.png"));
		         teamLogo.setImage(image6);
	        	 break;
	         case "rams":
	        	 team = "http://www.therams.com/team/roster.html";
		         Image image7 = new Image(NFLRosterScrapperController.class.getResourceAsStream("assets/rams.png"));
		         teamLogo.setImage(image7);
	        	 break;
	         case "chiefs":
	        	 team = "http://www.chiefs.com/team/roster.html";
		         Image image8 = new Image(NFLRosterScrapperController.class.getResourceAsStream("assets/chiefs.png"));
		         teamLogo.setImage(image8);
	        	 break;
	         case "49ers":
        	 team = "http://www.49ers.com/team/roster.html";
	            Image image9 = new Image(NFLRosterScrapperController.class.getResourceAsStream("assets/forty.png"));
	            teamLogo.setImage(image9);
	        	 break;
	         case "saints":
	        	 team = "http://www.neworleanssaints.com/team/roster.html";
		         Image image10 = new Image(NFLRosterScrapperController.class.getResourceAsStream("assets/saints.png"));
		         teamLogo.setImage(image10);
	        	 break;
	         case "steelers":
	        	 team = "http://www.steelers.com/team/roster.html";
		         Image image11 = new Image(NFLRosterScrapperController.class.getResourceAsStream("assets/steelers.png"));
		         teamLogo.setImage(image11);
	        	 break;
	         case "chargers":
	        	 team = "http://www.chargers.com/team/roster";
		         Image image12 = new Image(NFLRosterScrapperController.class.getResourceAsStream("assets/chargers.png"));
		         teamLogo.setImage(image12);
	        	 break;
	         case "cardinals":
	        	 team = "http://www.azcardinals.com/roster/player-roster.html";
		         Image image13 = new Image(NFLRosterScrapperController.class.getResourceAsStream("assets/cardinals.png"));
		         teamLogo.setImage(image13);
	        	 break;
	         case "bengals":
	        	 team = "http://www.bengals.com/team/roster.html";
		         Image image14 = new Image(NFLRosterScrapperController.class.getResourceAsStream("assets/bengals.png"));
		         teamLogo.setImage(image14);
	        	 break;
	         case "buffalo bills":
	        	 team = "http://www.buffalobills.com/team/roster.html";
		         Image image15 = new Image(NFLRosterScrapperController.class.getResourceAsStream("assets/buffalobills.png"));
		         teamLogo.setImage(image15);
	        	 break;
	         case "patriots":
	        	 team = "http://www.patriots.com/team/roster";
	        	 break;
	         case "seahawks":
	        	 team = "http://www.seahawks.com/team/roster";
	        	 break;
	         case "falcons":
	        	 team = "http://www.atlantafalcons.com/team/player-roster.html";
	        	 break;
	         case "browns" :
	            team = "http://www.clevelandbrowns.com/team/roster.html";
	            break;
	         default :
	        	 team = "http://www.chicagobears.com/team/roster.html"; 
		         Image image0 = new Image(NFLRosterScrapperController.class.getResourceAsStream("assets/logo.png"));
		         teamLogo.setImage(image0);
	      }
	     
			
			doc = Jsoup.connect(team).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObservableList<Roster> rosterData = FXCollections.observableArrayList();
        // Initialize the Roster table with the 8 columns.
        tableCol1Number.setCellValueFactory(cellData -> cellData.getValue().jerseyProperty());
        tableColName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());        
        tableColPos.setCellValueFactory(cellData -> cellData.getValue().positionProperty());
        tableColHt.setCellValueFactory(cellData -> cellData.getValue().heightProperty());
        tableColWt.setCellValueFactory(cellData -> cellData.getValue().weightProperty());
        tableColAge.setCellValueFactory(cellData -> cellData.getValue().ageProperty());
        tableColEx.setCellValueFactory(cellData -> cellData.getValue().experienceProperty());
        tableColCollege.setCellValueFactory(cellData -> cellData.getValue().collegeProperty());

		
		Elements RosterInfo = doc.select("tbody").first().children();
		//System.out.println(RosterInfo.text());
		//System.out.println(RosterInfo.select("td").first().text());
		//System.out.println(RosterInfo.select("td").next().first().text());
		
//			if(team == "raiders"){
//	        	// load the image
//				teamLogo = new ImageView("@raiders.png");
//				//teamLogo.setImage(new Image("@raiders.png"));
//			}
	
	    
		for (Element row : RosterInfo){
		    Integer jersy;
			if((row.child(0).text().equals("")) || (row.child(0).text().equals("N/A"))){
				 jersy = 0;
			}else{
			 jersy = Integer.parseInt(row.child(0).text());
			}
			
			String name = row.child(1).text();
			String position = row.child(2).text();
			String height = row.child(3).text();
			Integer weight = null;
			if(row.child(4).text().equals("")){
				weight = null;
			}else{
				weight = Integer.parseInt(row.child(4).text());
			}
			Integer age = null;
			if(row.child(5).text().equals("")){
				age = 0;
			}else{
				age = Integer.parseInt(row.child(5).text());
			}
			
			String experience = row.child(6).text();
			String college = row.child(7).text();
			
			
			 rosterData.add(new Roster(jersy,name,position,height,weight,age,experience,college));
			 
			 tableId.setItems(rosterData);
			 
			 
			
		}
		calculateStats(rosterData);
		//syncToDB(rosterData, arrayValues, team);
	  
		
		
		
		
		
	}
	
	public int[] calculateStats(ObservableList<Roster> rosterData){
		int averageAge, averageWeight, age, weight, ageSum = 0, weightSum =0;
		String name;
		int[] arrayValues = new int[2];
		
		
		//gets the average age of all players on a roster
		for(Roster x : rosterData){
			
			age = x.getAge();
			if(age != 0){
				ageSum +=age;
			}
			
			System.out.println(ageSum);
		}
		System.out.println("-----------------");
		int rosterCount = rosterData.size();
		rosterCountId.setText(Integer.toString(rosterCount));;
		System.out.println(averageAge = ageSum/rosterCount);
		averageAgeId.setText(Integer.toString(averageAge));
		
		//gets the average weight of all players on a roster
		for(Roster i : rosterData){
			weight = i.getWeight();
			if(weight != 0){
				weightSum += weight;
			}else{
				--rosterCount;
			}
		}
		
		System.out.println("Average weight");
		System.out.println(averageWeight = weightSum/rosterCount);
		avgWeightId.setText(Integer.toString(averageWeight));
		arrayValues[0] = averageAge;
		arrayValues[1] = averageWeight;
		
		return arrayValues;
			
		
			
	}
	
	public void syncToDB() throws SQLException{
		//(ObservableList<Roster> rosterData, int [] arr, String name
			Connection conn = null;
			
			Statement stmt = null;
			ResultSet results = null;
			
//			int [] arrayValues = new int[2];
//			arrayValues = calculateStats(rosterData);
			try {
				conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
				System.out.println("Connected!");
				stmt = conn.createStatement(/*ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY*/);
				//results = stmt.executeQuery("INSERT INTO ROSTER_STATS VALUES('Bears','23','201', '90',now());");
				
				//results.last();
				String sql = "INSERT INTO ROSTER_STATS (TeamMascot, AvgAge, AvgWeight, rosterCount, date)" +
				        "VALUES (?, ?,?,?,?)";
				PreparedStatement preparedStatement = conn.prepareStatement(sql);
				
				preparedStatement.setString(1, textFieldTeamEntryId.getText());
				preparedStatement.setInt(2, Integer.parseInt(averageAgeId.getText()));
				preparedStatement.setInt(3, Integer.parseInt(avgWeightId.getText()));
				preparedStatement.setInt(4, Integer.parseInt(rosterCountId.getText()));
				preparedStatement.setDate(5, new Date(new java.util.Date().getTime()));	
				preparedStatement.executeUpdate(); 
				//stmt.executeUpdate("INSERT INTO ROSTER_STATS VALUES('Bears','23','201', '90',now());");
				System.out.println("Records Inserted");
				/*results = stmt.executeQuery("SELECT * FROM ROSTER_STATS");
				System.out.println("Number of rows: " + results.getRow());*/
				
				
				//RosterData.displayData(results);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e);
			}finally{
				if(results != null){
					results.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(conn != null){
					conn.close();
				}
			}
		
		
	}
	public RosterData getRow(int RosterID) throws SQLException{
		
		String sql = "SELECT * FROM ROSTER_STATS WHERE RosterID = ?";
		ResultSet rs = null;
		
		try(
				Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
				stmt.setInt(1,  RosterID);
				rs = stmt.executeQuery();
					
				if(rs.next()){
					RosterData bean = new RosterData();
					bean.setRosterId(RosterID);
					bean.setTeamMascot(rs.getString("TeamMascot")); //3:34
					bean.setAvgAge(rs.getInt("AvgAge"));
					bean.setAvgWeight(rs.getInt("AvgWeight"));
					bean.setRosterCount(rs.getInt("rosterCount"));
					return bean;
				}else{
					System.err.println("No rows were found");
					return null;
				}
		}
	
		
		
	}
	
	

}
