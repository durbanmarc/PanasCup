package PACK;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class Read_MHs {
	
	public Read_MHs(){
	}
	
	public String FindPokeMHs(String pokename, String path) {
		String result = "";
		try {
			FileReader f = new FileReader(path+"tm.txt");
			BufferedReader bf = new BufferedReader(f);
			//JOptionPane.showMessageDialog(null, "Loading tm.txt");
			//System.out.println("Checking poke: "+pokename);
			
			String linea;
			int counter = 0;
			
			while ((linea = bf.readLine()) != null) {
				if(linea.equals("[CUT]")){
					linea = bf.readLine(); //[CUT]
					if(searchWordInString(pokename, linea)) {
						result += "[CORTE] ";
					}
				}
				if(linea.equals("[FLY]")){
					linea = bf.readLine(); //[FLY]
					if(searchWordInString(pokename, linea)) {
						result += "[VUELO] ";
					}
				}
				if(linea.equals("[SURF]")){
					linea = bf.readLine(); //[SURF]
					if(searchWordInString(pokename, linea)) {
						result += "[SURF] ";
					}
				}
				if(linea.equals("[STRENGTH]")){
					linea = bf.readLine(); //[STRENGTH]
					if(searchWordInString(pokename, linea)) {
						result += "[FUERZA] ";
					}
				}
				if(linea.equals("[ROCKSMASH]")){
					linea = bf.readLine(); //[ROCKSMASH]
					if(searchWordInString(pokename, linea)) {
						result += "[GOLPEROCA] ";
					}
				}
			}
			return result;
		}
		catch(Exception e) {
			//JOptionPane.showMessageDialog(null, "Error: Reading mh.txt");
			System.out.println("Error: Reading mh.txt");
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
