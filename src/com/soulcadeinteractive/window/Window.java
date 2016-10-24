package com.soulcadeinteractive.window;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.soulcadeinteractive.constants.Constants;

public class Window extends JFrame implements ActionListener{
	private static final long serialVersionUID = Constants.SERIAL;
	private int width, height;
	private Dimension w_dimension;
	private Dimension w_maxdimension;
	
	/* Insert components here instead of setScreen function */
	@SuppressWarnings("unused")
	private JLabel email;
	
	public Window(){
		super(Constants.NAME);
		
		width = Constants.WIDTH;
		height = Constants.HEIGHT;
		w_dimension = new Dimension(width, height);	//No reason to do this at all
		w_maxdimension = new Dimension(width*Constants.MULTIPLIER, height*Constants.MULTIPLIER);
		
		/* Print the serial ID for... Reasons */
		System.out.println("Serial Version ID: "+serialVersionUID);

		setWindow();
	}
	
	/* Set window preferences */
	private void setWindow(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GroupLayout layout = new GroupLayout(this.getContentPane());
		getContentPane().setLayout(layout);
		
		setPreferredSize(w_dimension);
		setSize(w_dimension);
		setMaximumSize(w_maxdimension);
		
		setLocationRelativeTo(null);
		
		setResizable(false);
		setScreen(layout);
		setVisible(true);
	}
	
	private void setScreen(GroupLayout layout){
		
		/* Begin init */
		JLabel email = new JLabel(Constants.EMAIL);
		JLabel current = new JLabel(Constants.PROJECTS);
		
		JButton newproject = new JButton(Constants.NEWPROJECT);
		JButton savework = new JButton(Constants.SAVE);
		JButton finish = new JButton(Constants.FINISH);
		
		finish.setActionCommand(Constants.ACTION_FINISH);
		finish.addActionListener(this);
		
		newproject.setActionCommand(Constants.ACTION_NEWPROJECT);
		newproject.addActionListener(this);
		
		JTextArea current_ta = new JTextArea(Constants.ROWS, Constants.COLUMNS);
		
		current_ta.setEditable(false);
		current_ta.setMargin(new Insets(5, 5, 5, 5));
		
		JTextField email_tf = new JTextField(Constants.NOTHING, 20);
		
		savework.setActionCommand(Constants.ACTION_SAVEWORK);
		savework.addActionListener(this);
		/* End init */
		
		/*Deal with Gaps*/
		
		/* Start adding items to layout */
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(email)
						.addComponent(newproject)
						.addComponent(current)
						.addComponent(savework)
						.addComponent(finish))
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(email_tf)
						.addComponent(current_ta))
		);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(email)
						.addComponent(email_tf))
					.addComponent(newproject)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(current)
						.addComponent(current_ta))
					.addComponent(savework)
					.addComponent(finish)
		);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals(Constants.ACTION_NEWPROJECT)){

			/* Need this class to listen for the Save/Discard action from the newProject Window*/
			@SuppressWarnings("unused")
			NewProject newProject = new NewProject(this);
		}
		else if(e.getActionCommand().equals(Constants.ACTION_FINISH)){
			dispose();
		} else if(e.getActionCommand().equals(Constants.ACTION_SAVEWORK)){

			/* the save window */
			@SuppressWarnings("unused")
			SaveWindow saveWindow = new SaveWindow(SaveWindow.trySave());
		}
	}
}
