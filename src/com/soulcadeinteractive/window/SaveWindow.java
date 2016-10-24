package com.soulcadeinteractive.window;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.soulcadeinteractive.constants.Constants;

public class SaveWindow implements ActionListener{
	private int width, height;
	private Dimension dim;
	private boolean error;
	
	private JFrame extraWin;
	private JPanel panel;
	
	private static boolean saved;
	
	public static boolean trySave(){
		return true;
	}
	
	public SaveWindow(boolean saved){
		extraWin = new JFrame((saved)?Constants.SAVED:Constants.ERROR);
		error = !saved;
		
		width = Constants.WWWIDTH;
		height = Constants.HHHEIGHT;
		dim = new Dimension(width, height);
		
		/* Set up the JFrame */
		setUpWindow();
	}
	
	public void setUpWindow(){
		extraWin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		extraWin.setPreferredSize(dim);
		extraWin.setSize(dim);
		extraWin.setMaximumSize(dim);
		
		extraWin.setLocationRelativeTo(null);
		extraWin.setResizable(false);
		
		addInformation();
		
		extraWin.setVisible(true);
	}
	
	public void addInformation(){
		JLabel info = new JLabel();
		info.setText((error)?" ERROR":" SAVED");
		
		JButton ok = new JButton("OK");
		ok.setActionCommand("ok");
		ok.addActionListener(this);
		
		info.setAlignmentX(Component.CENTER_ALIGNMENT);
		ok.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createRigidArea(new Dimension(0, 5)));
		panel.add(info);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(ok);
		
		extraWin.add(panel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("ok")){
			extraWin.dispose();
		}
	}
}
