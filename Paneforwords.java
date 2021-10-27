package sftwderv1mod2;


import java.awt.EventQueue; // to establish connection 
import javax.swing.JFrame; //build the pane 
import javax.swing.JPanel; // set text 
import javax.swing.border.EmptyBorder; //no border but still imported when 
import java.awt.Color;
import java.io.*;  //standard input and output 
import javax.swing.JTextArea; //to add text field  jPanel to write the text
import javax.swing.JButton;  //to add the button used to display text scraped when pressed
import java.awt.event.ActionListener; //constructor used to display declare text area
import java.awt.event.ActionEvent; //used in the constructor to display the text
import javax.swing.JScrollPane;  //used to make the text area scrollable 
 // used to display words object


@SuppressWarnings("serial")
public class Paneforwords extends JFrame {  //called this class pane for words because its just a pane displaying words!

	private JPanel contentPane; //had to make a private variable to set the pane for it to display
	
	

	public static void main(String[] args) { //main method
		
		EventQueue.invokeLater(new Runnable() { // running the app 
			public void run() {  //run method 
				try {     // try catch for run method
			
					Paneforwords frame = new Paneforwords(); //pane for words declaring frame object 
					frame.setVisible(true);  
					//declaring object in run method for it to run
					

				} catch (Exception e) {  //catch exception just in case
					e.printStackTrace();  //any errors print to console..
				}
			}
		});
	}

	
	public Paneforwords() throws IOException { //method for class to display pane 
		
		
		
		  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300); // size of
		contentPane = new JPanel(); // contentPane object 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// size of
		setContentPane(contentPane); //creating window
		contentPane.setLayout(null); //setting to just blank window

		JScrollPane scrollPane = new JScrollPane();  //creatring object scrollPane
		scrollPane.setBounds(50, 74, 319, 171); // setting size of the window for text
		contentPane.add(scrollPane);  //creating the scrollpane 
		
		JTextArea textArea = new JTextArea(); //for the input of the text
		scrollPane.setViewportView(textArea); //setting the viewport in scrollpane

		

		contentPane.setBackground(Color.red); //set the background to red
		

		JButton btnNewButton = new JButton("Display text from poem"); // button for displaying text
		btnNewButton.addActionListener(new ActionListener() { //actons listener for displaying button
			public void actionPerformed(ActionEvent e) {  //constructor for actoin listener 
				String words = ""; //declaring variable words 
				
					words = MapFile.getPeomWords(); //setting words to the poem
					
					textArea.setText(words); // text area for setting text 
				
					
			}
		});
		btnNewButton.setBounds(40, 39, 193, 23); //button size
		contentPane.add(btnNewButton); //adding the button
		
			}
}

		

	

