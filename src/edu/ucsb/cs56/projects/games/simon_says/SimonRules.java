package edu.ucsb.cs56.projects.games.simon_says;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;



public class SimonRules extends JFrame{
    JPanel panel;
    JPanel returnPanel;
    JButton returnButton;

    JTextArea textArea;
    JScrollPane scrollPane;

    public SimonRules(){
        super("Simon Rules");
        this.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
        this.setSize(350,300);

        panel=new JPanel(new BorderLayout());
        this.getContentPane().add(BorderLayout.WEST,panel);
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);

        scrollPane.setPreferredSize(new Dimension(300, 300));
        panel.add(BorderLayout.WEST,scrollPane);

        returnPanel=new JPanel(new BorderLayout());

        this.getContentPane().add(BorderLayout.EAST,returnPanel);
        returnPanel.setBackground(Color.BLACK);

        returnButton=new JButton("Back");
        returnButton.setBorderPainted(false);
        returnButton.setOpaque(true);
        returnButton.setBackground(Color.BLACK);
        returnButton.setForeground(Color.CYAN);
        returnPanel.add(BorderLayout.SOUTH,returnButton);
        returnButton.addActionListener(new returnListener());



        try{
            File myFile = new File("Rules.txt");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;

            while((line = reader.readLine()) != null)
                textArea.append(line + "\n");
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        panel.setBackground(Color.BLACK);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.YELLOW);
        setVisible(true);

    }


    public class returnListener implements ActionListener {
        public void actionPerformed(ActionEvent ex){
            dispose();
            new SimonMenu().setVisible(true);

        }
    }
}
