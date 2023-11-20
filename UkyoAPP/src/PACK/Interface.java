package PACK;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author marc.durban.rodrigues
 */

public class Interface {
	
	private JTable table;
    public JFrame frmXxx;
    public Read_Pokes RPoke;
    public Read_Rutas RRutas;
    public Read_MHs RMH = new Read_MHs();
    public String path = "";
    public JPanel PanelDex;
    public PokedexData DexData;
    
    public void makeFrameFullSize(JFrame aFrame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        aFrame.setSize(screenSize.width, screenSize.height);
    }
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interface window = new Interface();
                    window.frmXxx.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Interface() {
    	String currentDirectory = System.getProperty("user.dir");
	    System.out.println("The current working directory is " + currentDirectory);
	    
	    String PBSpath = "";
	    for(int i = 0; i<currentDirectory.length(); i++) {
	    	if(currentDirectory.charAt(i) != '\\'){
	    		PBSpath+=currentDirectory.charAt(i);
	    	}
	    	else PBSpath+="/";
	    }
	    path = PBSpath.substring(0, PBSpath.length()-7);

        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frmXxx = new JFrame();
        frmXxx.setResizable(false);
        frmXxx.setTitle("");
        frmXxx.setBounds(0, 0, 806, 527);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frmXxx.setSize(screenSize.width, (screenSize.height*97)/100);
        frmXxx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmXxx.getContentPane().setLayout(new CardLayout(0, 0));

        //********************************** PANEL CREATION *************************************************************************
	        //######################### PANEL MAIN ##################################################################
	        JPanel panelMain = new JPanel();
	        frmXxx.getContentPane().add(panelMain, "name_22986523724004");
	        panelMain.setVisible(true);
	        panelMain.setLayout(null);
	        
	        //######################### PANEL DEX ##################################################################
	        JPanel panelDex = new JPanel();
	        frmXxx.getContentPane().add(panelDex, "name_592170788494700");
	        panelDex.setVisible(false);
		    panelDex.setLayout(null);
        
        //******************************** CONTENT CREATION **********************************************************************
        
	        //######################### PANEL MAIN: PANEL CONTENT ##################################################################
	        
	        JLabel lblPokemonUkyo = new JLabel("POKEMON UKYO");
	        lblPokemonUkyo.setHorizontalAlignment(SwingConstants.CENTER);
	        lblPokemonUkyo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	        lblPokemonUkyo.setBounds(10, 27, 1894, 37);
	        panelMain.add(lblPokemonUkyo);
	        
	        JButton btnNewButton = new JButton("POKEMON LIST");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {    		    
	        		//RPoke = new Read_Pokes(path+"PBS/");	
	        		panelMain.setVisible(false);
	        		panelDex.setVisible(true);
	        	}
	        });
	        btnNewButton.setBounds(20, 75, 258, 97);
	        panelMain.add(btnNewButton);
	        
	        JButton btnNewButton_1 = new JButton("Exit");
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		System.exit(0);
	        	}
	        });
	        btnNewButton_1.setBounds(1722, 888, 162, 97);
	        panelMain.add(btnNewButton_1);        
	        
	        JButton button = new JButton("POKEDEX");
	        button.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		//RRutas = new Read_Rutas(path+"PBS/");		
	        		
	        	}
	        });
	        button.setBounds(288, 75, 237, 97);
	        panelMain.add(button);
	        
	        JButton button_1 = new JButton("TESTING");
	        button_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		try {
	        		    String currentDirectory = System.getProperty("user.dir");
	        		    //System.out.println("The current working directory is " + currentDirectory);
	        		    
	        		    String PBSpath = "";
	        		    for(int i = 0; i<currentDirectory.length(); i++) {
	        		    	if(currentDirectory.charAt(i) != '\\'){
	        		    		PBSpath+=currentDirectory.charAt(i);
	        		    	}
	        		    	else PBSpath+="/";
	        		    }
	        		    String PBSclean = PBSpath.substring(0, PBSpath.length()-7);
	        		    PBSclean+="PBS/";
	        		      
	    				System.out.println("Reading from path: "+PBSclean);
	        		}
	        		catch(Exception e){
	        			System.out.println("Error: testing");
	        		}
	        	}
	        });
	        button_1.setBounds(535, 75, 228, 97);
	        panelMain.add(button_1);
	        
	    	//######################### PANEL DEX: PANEL CONTENT ##################################################################
	        
	        // Column Names 
	        String[] columnNames = { "#NUM", "NAME", "ICON", "TYPE1", "TYPE2" }; 
	        
	        DexData = new PokedexData();
	        
		    JButton btn = new JButton("Exit");
	        btn.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		System.exit(0);
	        	}
	        });
		    btn.setBounds(1726, 897, 162, 97);
		    panelDex.add(btn);
		    
		    JButton btn2 = new JButton("");
	        btn2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		panelDex.setVisible(false);
	        		panelMain.setVisible(true);
	        	}
	        });
	        btn2.setIcon(new ImageIcon(path+"iconBackBig.png"));
		    btn2.setBounds(30, (screenSize.height*85)/100, 79, 79);
		    panelDex.add(btn2);
		    
		    JScrollPane scrollPane = new JScrollPane();
		    scrollPane.setBounds(92, 37, 1709, 729);
		    panelDex.add(scrollPane);
		    
		    Object[][] tableData = DexData.GetDexData(path);
		    //Object[][] tableData = {{"a", "b", "c", "d", "e"},{"a", "b", "c", "d", "e"}};
		    
		    table = new JTable(tableData, columnNames);
		    scrollPane.setViewportView(table);
		    
		    Component horizontalGlue = Box.createHorizontalGlue();
		    horizontalGlue.setBounds(10, 310, 72, 48);
		    panelDex.add(horizontalGlue);
		    
		    Component verticalGlue = Box.createVerticalGlue();
		    verticalGlue.setBounds(307, 777, 86, 230);
		    panelDex.add(verticalGlue);
		    
		    Component horizontalGlue_1 = Box.createHorizontalGlue();
		    horizontalGlue_1.setBounds(1811, 555, 93, 56);
		    panelDex.add(horizontalGlue_1);
		    
		    Component verticalGlue_1 = Box.createVerticalGlue();
		    verticalGlue_1.setBounds(1104, 11, 46, 15);
		    panelDex.add(verticalGlue_1);
		    
	    	//######################### PANEL DEX: PANEL CONTENT ##################################################################
		    
		    JPanel panelPoke = new JPanel();
		    frmXxx.getContentPane().add(panelPoke, "name_73507707394300");
	        panelPoke.setVisible(false);
		    panelPoke.setLayout(null);
	    }
}
