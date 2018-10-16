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
	private JMenu menu1 = new JMenu("Outils");
	
	private JMenuItem item0 = new JMenuItem("Ouvrir", KeyEvent.VK_T);
	private JMenuItem item1 = new JMenuItem("Enrengistrer", KeyEvent.VK_T);
	private JMenuItem item2 = new JMenuItem("Accueil", KeyEvent.VK_T);
	private JMenuItem item3 = new JMenuItem("Créer un tournoi", KeyEvent.VK_T);
	private JMenuItem item4 = new JMenuItem("Lister les tournois", KeyEvent.VK_T);
	
	public Frame() {
		
		toolsBar.add(menu0);
		toolsBar.add(menu1);
		
		menu0.add(item0);
		menu0.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		menu1.add(item4);
		
		item0.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		item0.getAccessibleContext().setAccessibleDescription("Ouvrir une configuration");
		
		item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		item1.getAccessibleContext().setAccessibleDescription("Enrengistrer une configuration");
		
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		item2.getAccessibleContext().setAccessibleDescription("Accueil");
		
		item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		item3.getAccessibleContext().setAccessibleDescription("Créer un tournoi");
		
		item4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		item4.getAccessibleContext().setAccessibleDescription("Lister tous les tournois");
		
		item0.addActionListener(this);
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
	}
	
	public void createFrame(String title, Dimension dim) {
		
		this.title = title;
		
		setSize(dim);
		setTitle(title + " - Accueil");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(toolsBar);
		setContentPane(new ListPanel());
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
			contentPane.add(new ListPanel());
			contentPane.revalidate(); 
			contentPane.repaint();
			setTitle(title + " - Liste des tournois");
		} 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(item0)) {
			
			
		} else if(e.getSource().equals(item1)) {
			
			
		} else if(e.getSource().equals(item2)) {
			
			changePane(0);
		} else if(e.getSource().equals(item3)) {
			
			changePane(1);
		} else if(e.getSource().equals(item4)) {
			
			changePane(2);
		}
	}
	
}
