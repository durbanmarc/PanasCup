package PACK;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

import javax.swing.JOptionPane;

public class Read_Pokes {
	
	public File directori;
	public File arxiu;
    public Read_MHs RMH = new Read_MHs();
    public Read_MTs RMT = new Read_MTs();

	 public Read_Pokes(String path) {		 
		try {
			FileReader f = new FileReader(path+"pokemon.txt");			
			BufferedReader bf = new BufferedReader(f);
			//JOptionPane.showMessageDialog(null, "Loading pokemon.txt");
			
			String linea;
			
			System.out.println("NUM"+'\t'+"NAME"+'\t'+'\t'+"TYPE"+'\t'+'\t'+'\t'+"BASE STATS"+'\t'+'\t'+"EVOLUTIONS"+'\t'+'\t'+'\t'+"MHs");
			System.out.println("=========================================================================================================================");
			
			while ((linea = bf.readLine()) != null) {
				if (linea.equals("[1]")) break;
				if (linea.charAt(0) == '['){
					int c = Character.getNumericValue(linea.charAt(1));
					int d = Character.getNumericValue(linea.charAt(2));
					int u = Character.getNumericValue(linea.charAt(3));
					int pokenum = (c*100) + (d*10) + u;
					String Xpokenum = String.valueOf(pokenum);
					
					linea = bf.readLine(); //Name
					
					linea = bf.readLine(); //Internal Name
					String Xpokename = "";
					int i = 13;
					while(i < linea.length()){
						Xpokename += linea.charAt(i);
						i++;
					}
					String XpokeMHs = RMH.FindPokeMHs(Xpokename, path);
					String XpokeMTs = RMT.FindPokeMTs(Xpokename, path);
					if(XpokeMHs.length() < 8) XpokeMHs += '\t';
					if(XpokeMHs.length() < 16) XpokeMHs += '\t';
					if(XpokeMHs.length() < 24) XpokeMHs += '\t';
					if(XpokeMHs.length() < 32) XpokeMHs += '\t';
					if(XpokeMHs.length() < 40) XpokeMHs += '\t';
					if(Xpokename.length() < 8)	Xpokename +='\t';
					
					linea = bf.readLine(); //Type
					String Xpoketype = "";
					i = 6;
					while(i < linea.length()){
						Xpoketype += linea.charAt(i);
						i++;
					}
					
					linea = bf.readLine(); //NEXT LINE
					if(linea.charAt(0) == 'T') {
						i = 6;
						Xpoketype += " - ";
						while(i < linea.length()){
							Xpoketype += linea.charAt(i);
							i++;
						}						
						linea = bf.readLine(); //Base Stats
					}
					if(Xpoketype.length() < 8)	Xpoketype +='\t';
					if(Xpoketype.length() < 16)	Xpoketype +='\t';
					
					i = 10;
					String XpokeBaseStats = "";
					while(i < linea.length()){
						XpokeBaseStats += linea.charAt(i);
						i++;
					}
					
					while((linea = bf.readLine()) != null) {
						if(linea.charAt(0) == 'E' & linea.charAt(1) == 'v') break;
					}
					
					i = 11;
					String XpokeEvo = "";
					while(i < linea.length()){
						XpokeEvo += linea.charAt(i);
						i++;
					}
					if(XpokeEvo.length() < 8)	XpokeEvo +='\t';
					if(XpokeEvo.length() < 16)	XpokeEvo +='\t';
					if(XpokeEvo.length() < 24)	XpokeEvo +='\t';
					
					String Xfulldata = Xpokenum+'\t'+Xpokename+'\t'+Xpoketype+'\t'+XpokeBaseStats+'\t'+XpokeEvo+'\t'+XpokeMHs+'\t'+XpokeMTs;
					System.out.println(Xfulldata);
				}
			}
			
			JOptionPane.showMessageDialog(null, "Update finished.");
		}
		catch(Exception e){
			//JOptionPane.showMessageDialog(null, "Error: Reading pokemon.txt");
			System.out.println("Error: Reading pokemon.txt");
		}
	 }
			
}

