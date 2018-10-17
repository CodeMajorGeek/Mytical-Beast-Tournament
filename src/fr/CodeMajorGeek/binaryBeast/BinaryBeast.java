package fr.CodeMajorGeek.binaryBeast;

import org.json.JSONException;

import com.binarybeast.api.BBRequest;
import com.binarybeast.api.BBRequestHandler;
import com.binarybeast.api.BBResult;
import com.binarybeast.api.BinaryBeastAPI;

import fr.CodeMajorGeek.panel.Main;
import fr.CodeMajorGeek.sql.SQLConnection;

public class BinaryBeast {
	
	private SQLConnection sql;
	
	public BinaryBeast(String key) {
		
		new BinaryBeastAPI(key);
		sql = Main.getSQLConnection();
	}
	
	public void addTournament(String title) {
		
		BBRequest.tourneyCreate(title).execute(new BBRequestHandler() {

			@Override
			public void onResponse(BBResult r) {
				
				if(r.result == 200) {
					
					try {
						
						sql.addTournament(title, r.getInt("APIRequestID"), r.getString("TourneyID"), r.getString("APIFrameworkTime"), r.getString("APITotalTime"), r.getString("APIServiceTime"), r.getString("URL"), r.result);
					} catch (JSONException e) {
						
						e.printStackTrace();
						System.exit(-1);
					}
					
				} else {
					
					System.exit(-1);
				}
			}
		});
	}
	
	public void deleteTournament(String tourneyID) {
		
		BBRequest.tourneyDelete(tourneyID).execute(new BBRequestHandler() {

			@Override
			public void onResponse(BBResult r) {
				
				if(r.result == 200) {
					
					sql.deleteTournament(tourneyID);
				} else {
					
					System.exit(-1);
				}
			}
		});
	}
	
	public void updateTournament(String tourneyID) {
		
		BBRequest.tourneyUpdate(tourneyID).execute(new BBRequestHandler() {

			@Override
			public void onResponse(BBResult r) {
				
				if(r.result == 200) {
					
					System.out.println(r);
					try {
						
						sql.updateTournament(tourneyID, r.getString("APIRequestID"));
					} catch (JSONException e) {
						
						e.printStackTrace();
						System.exit(-1);
					}
				} else {
					
					System.exit(-1);
				}
			}	
		});
	}
	
	public void startTournament(String tourneyID, String seeding, String seeds) {
		
		BBRequest.tourneyStart(tourneyID, seeding, seeds).execute(new BBRequestHandler() {

			@Override
			public void onResponse(BBResult r) {
				
				if(r.result == 200) {
					
					System.out.println(r);
				} else {
					
					System.exit(-1);
				}
			}
		});
	}
	
	public void updateRoundTournament(String tourneyID, int bracket, int round, int bestOf, String map, String date) {
		
		BBRequest.tourneyRoundUpdate(tourneyID, bracket, round, bestOf, map, date).execute(new BBRequestHandler() {

			@Override
			public void onResponse(BBResult r) {
				
				if(r.result == 200) {
					
					System.out.println(r);
				} else {
					
					System.exit(-1);
				}
			}
		});;
	}
	
	public void insertTeam(String tourneyID, String displayName) {
		
		BBRequest.teamInsert(tourneyID, displayName).execute(new BBRequestHandler() {

			@Override
			public void onResponse(BBResult r) {
				
				if(r.result == 200) {
					
					System.out.println(r);
				} else {
					
					System.exit(-1);
				}
			}
		});
	}
}
