package PACK;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class Read_MTs {
	
	public Read_MTs(){
	}
	
	public String FindPokeMTs(String pokename, String path) {
		String result = "";
		try {
			FileReader f = new FileReader(path+"tm.txt");
			BufferedReader bf = new BufferedReader(f);
			//JOptionPane.showMessageDialog(null, "Loading tm.txt");
			//System.out.println("Checking poke: "+pokename);
			
			String linea;
			int counter = 0;
			
			while ((linea = bf.readLine()) != null) {
				if(linea.equals("[WILDCHARGE]")){
					linea = bf.readLine(); //[CUT]
					if(searchWordInString(pokename, linea)) {
						//System.out.println("Put Cut on this poke");
						result += "[VOLTIO CRUEL] ";
					}
				}
				
				if(linea.equals("[GIGADRAIN]")){
					linea = bf.readLine(); //[CUT]
					if(searchWordInString(pokename, linea)) {
						//System.out.println("Put Cut on this poke");
						result += "[GIGADRENADO] ";
					}
				}
			}
			
			return result;
		}
		catch(Exception e) {
			//JOptionPane.showMessageDialog(null, "Error: Reading mt.txt");
			System.out.println("Error: Reading mt.txt");
		}	
		return result;
	}
	
	public boolean searchWordInString(String word, String line) {
		int i = 0;
		while(i < line.length()) {
			String pokename = "";
			while(line.charAt(i) != ',' & i < line.length()) {
				pokename += line.charAt(i);
				i++;
				if(i == line.length()) break;
			}
			//System.out.println("Comparando con: "+pokename);
			if(pokename.equals(word)) return true;
			i++;
		}
		return false;
	}
}
