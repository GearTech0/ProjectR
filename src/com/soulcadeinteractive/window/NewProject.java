package com.soulcadeinteractive.window;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.soulcadeinteractive.constants.Constants;

public class NewProject extends JFrame implements ActionListener{
	public static final long serialVersionUID = Constants.SSERIAL;
	public static boolean serialShown = false;
	private int width, height;
	private Dimension w_dimension,w_maxdimension;
	
	@SuppressWarnings("unused")
	private ActionListener win;
	
	public NewProject(ActionListener win){
		super(Constants.NNAME);
		
		this.win = win;
		width = Constants.WWIDTH;
		height = Constants.HHEIGHT;
		w_dimension = new Dimension(width, height);
		w_maxdimension = new Dimension(width*Constants.MULTIPLIER, height*Constants.MULTIPLIER);
		
		/* Print the serial ID for... Reasons */
		if(!serialShown){ System.out.println("Serial Version ID: "+serialVersionUID); serialShown = true;}
		
		setWindow();
	}
	
	private void setWindow(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		GroupLayout layout = new GroupLayout(this.getContentPane());
		getContentPane().setLayout(layout);
		
		setPreferredSize(w_dimension);
		setSize(w_dimension);
		setMaximumSize(w_maxdimension);
		setResizable(false);
		setLocationRelativeTo(null);
		
		setScreen(layout);
		
		setVisible(true);
	}
	
	private void setScreen(GroupLayout l){
		JLabel description = new JLabel(Constants.DESCRIPTION);
		JLabel to = new JLabel(Constants.TO);
		JLabel cc = new JLabel(Constants.CC);
		
		JTextField description_tf = new JTextField(Constants.NOTHING, 20);
		JTextField to_tf = new JTextField(Constants.NOTHING, 20);
		JTextField cc_tf = new JTextField(Constants.NOTHING, 20);
		
		JButton save = new JButton(Constants.SAVE);
		JButton discard = new JButton(Constants.DISCARD);
		
		discard.setActionCommand(Constants.ACTION_DISCARD);
		discard.addActionListener(this);
		
		l.setHorizontalGroup(
				l.createSequentialGroup()
					.addGroup(l.createParallelGroup()
							.addComponent(description)
							.addComponent(to)
							.addComponent(cc)
							.addComponent(save))
					.addGroup(l.createParallelGroup()
							.addComponent(description_tf)
							.addComponent(to_tf)
							.addComponent(cc_tf)
							.addComponent(discard))
		);
		l.setVerticalGroup(
				l.createSequentialGroup()
					.addGroup(l.createParallelGroup()
							.addComponent(description)
							.addComponent(description_tf))
					.addGroup(l.createParallelGroup()
							.addComponent(to)
							.addComponent(to_tf))
					.addGroup(l.createParallelGroup()
							.addComponent(cc)
							.addComponent(cc_tf))
					.addGroup(l.createParallelGroup()
							.addComponent(save)
							.addComponent(discard))
		);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals(Constants.ACTION_DISCARD)){
			dispose();
		}
	}
}
