package fr.CodeMajorGeek.panel;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Frame extends JFrame{
	
	private static final long serialVersionUID = -3008780810174738402L;
	
	public Frame(String title, Dimension dim) {
		
		setSize(dim);
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new ListPanel());
		setVisible(true);
	}
	
}
