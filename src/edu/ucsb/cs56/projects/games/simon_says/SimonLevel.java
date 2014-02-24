package edu.ucsb.cs56.projects.games.simon_says;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimonLevel extends JFrame{
	
	 private JPanel mp;
	 private ActionListener al;
	 private final String Level[] = {"Professional", "Intermediate", "Amateur"};
	    
	   
	 public SimonLevel()
     {
	    super("Simon");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	    try
	    {
	       	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    }
        catch(Exception ex)
	    {
        	
	    }
	    mp = new JPanel();
	    mp.setBackground(Color.BLACK);
	    mp.setLayout(null);
	             
        getContentPane().add(BorderLayout.CENTER, mp);
	    for(int i = 0; i < Level.length; i++){
	    	JButton jb = new JButton(Level[i]);
			jb.setBackground(new Color(0x3399FF));
			jb.setBorderPainted(false);
			jb.setOpaque(true);
			jb.addActionListener(new LevelListener());
			jb.setBounds(70, 80 + 32 * i, 150, 20);
			mp.add(jb);
		    }
	        setSize(300, 300);
	        setVisible(true);
	    }
	      
	    public class LevelListener implements ActionListener{
		public void actionPerformed(ActionEvent ex) {
		    String cmd = ex.getActionCommand();
		    if(cmd.equals("Amateur")){
			dispose();
			SimonFrame frame = new SimonFrame();
			frame.display();
		    }
		    else if(cmd.equals("Intermediate")){
		    	dispose();
		    	SimonInterLF inter=new SimonInterLF();
		    	inter.setVisible(true);
		    }
		    else if(cmd.equals("Professional")){
		    	dispose();
		    	SimonProL pro=new SimonProL();
		    	pro.setVisible(true);
		    }
		    
		    
		}
	    }

}