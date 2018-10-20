package fr.CodeMajorGeek.panel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Frame extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = -3008780810174738402L;
	
	private String title;
	
	private JMenuBar toolsBar = new JMenuBar();
	
	private JMenu menu0 = new JMenu("Fichier");
	private JMenu menu1 = new JMenu("Tournoi");
	private JMenu menu2 = new JMenu("Round");
	private JMenu menu3 = new JMenu("Team");
	private JMenu menu4 = new JMenu("Aide");
	
	private JMenuItem item0 = new JMenuItem("Ouvrir", KeyEvent.VK_T);
	private JMenuItem item1 = new JMenuItem("Enrengistrer", KeyEvent.VK_T);
	private JMenuItem item2 = new JMenuItem("Accueil", KeyEvent.VK_T);
	private JMenuItem item3 = new JMenuItem("Créer un tournoi", KeyEvent.VK_T);
	private JMenuItem item4 = new JMenuItem("Lister les tournois", KeyEvent.VK_T);
	private JMenuItem item5 = new JMenuItem("Actualiser", KeyEvent.VK_T);
	private JMenuItem item6 = new JMenuItem("Créer une team", KeyEvent.VK_T);
	private JMenuItem item7 = new JMenuItem("Lister les teams", KeyEvent.VK_T);
	private JMenuItem item8 = new JMenuItem("Actualiser Round", KeyEvent.VK_T);
	
	public Frame() {
		
		toolsBar.add(menu0);
		toolsBar.add(menu1);
		toolsBar.add(menu2);
		toolsBar.add(menu3);
		toolsBar.add(menu4);
		
		menu0.add(item0);
		menu0.add(item1);
		menu4.add(item2);
		menu1.add(item3);
		menu1.add(item4);
		menu2.add(item8);
		menu3.add(item6);
		menu3.add(item7);
		menu4.add(item5);
		
		item0.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		item0.getAccessibleContext().setAccessibleDescription("Ouvrir une configuration");
		
		item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		item1.getAccessibleContext().setAccessibleDescription("Enrengistrer une configuration");
		
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		item2.getAccessibleContext().setAccessibleDescription("Accueil");
		
		item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		item3.getAccessibleContext().setAccessibleDescription("Créer un tournoi");
		
		item4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		item4.getAccessibleContext().setAccessibleDescription("Lister tout les tournois");
		
		item5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		item5.getAccessibleContext().setAccessibleDescription("Actualiser tout les serveurs");
		
		item6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		item6.getAccessibleContext().setAccessibleDescription("Créer une team");
		
		item7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		item7.getAccessibleContext().setAccessibleDescription("Lister tout les teams");
		
		item8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		item8.getAccessibleContext().setAccessibleDescription("Actualiser un round");
		
		item0.addActionListener(this);
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		item5.addActionListener(this);
		item6.addActionListener(this);
		item7.addActionListener(this);
		item8.addActionListener(this);
	}
	
	public void createFrame(String title, Dimension dim) {
		
		this.title = title;
		
		setSize(dim);
		setTitle(title + " - Accueil");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(toolsBar);
		setContentPane(new Panel());
		setVisible(true);
	}
	
	private void changePane(int panel) {
		JPanel contentPane = (JPanel) getContentPane();
		
		if(panel == 0) {
			
			contentPane.removeAll();
			contentPane.add(new AddPanel());
			contentPane.revalidate(); 
			contentPane.repaint();
			setTitle(title + " - Accueil");
		} else if(panel == 1) {
			
			contentPane.removeAll();
			contentPane.add(new AddPanel());
			contentPane.revalidate(); 
			contentPane.repaint();
			setTitle(title + " - Créer un tournoi");
		} else if(panel == 2) {
			
			contentPane.removeAll();
			contentPane.add(new ListTourneyPanel());
			contentPane.revalidate(); 
			contentPane.repaint();
			setTitle(title + " - Liste des tournois");
		} else if(panel == 3) {
			
			contentPane.removeAll();
			contentPane.add(new TeamPanel());
			contentPane.revalidate(); 
			contentPane.repaint();
			setTitle(title + " - Crééer une team");
		} else if(panel == 4) {
			
			contentPane.removeAll();
			contentPane.add(new ListTeamPanel());
			contentPane.revalidate(); 
			contentPane.repaint();
			setTitle(title + " - Liste des teams");
		} else if(panel == 5) {
			
			contentPane.removeAll();
			contentPane.add(new RoundPanel());
			contentPane.revalidate(); 
			contentPane.repaint();
			setTitle(title + " - Actualiser un round");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(item0)) {
			
			
		} else if(e.getSource().equals(item1)) {
			
			
		} else if(e.getSource().equals(item2)) {
			
			Main.refresh();
			changePane(0);
		} else if(e.getSource().equals(item3)) {
			
			Main.refresh();
			changePane(1);
		} else if(e.getSource().equals(item4)) {
			
			Main.refresh();
			changePane(2);
		} else if(e.getSource().equals(item5)) {
			
			Main.refresh();
		} else if(e.getSource().equals(item6)) {
			
			Main.refresh();
			changePane(3);
		} else if(e.getSource().equals(item7)) {
			
			Main.refresh();
			changePane(4);
		} else if(e.getSource().equals(item8)) {
			
			Main.refresh();
			changePane(5);
		}
	}
	
}
