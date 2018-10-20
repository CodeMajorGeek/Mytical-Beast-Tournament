package fr.CodeMajorGeek.panel;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ListTeamPanel extends JPanel{
	
	private static final long serialVersionUID = -8753870744351547552L;
	
	public static ListTeamPanel getMainList;
	
	public static ArrayList<TeamList> teamList = new ArrayList<TeamList>();
	
	public ListTeamPanel() {
		
		setFocusable(true);
		requestFocus();
		
		getMainList = this;
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		refresh();
	}
	
	public void refresh() {
		
		removeAll();
		revalidate();
		
		for(TeamList list : teamList) 
			add(list.getList());
	}
}
