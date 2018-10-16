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
}
