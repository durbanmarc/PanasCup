package PACK;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PokedexData {
	
	public PokedexData() {
		
	}
	
	public static Object[] add2Vec(Object[] vec, Object x) {
		Object resVec[] = new Object[vec.length+1];
		
		for(int i = 0; i<vec.length; i++) {
			resVec[i] = vec[i];
		}
		resVec[vec.length] = x;
		
		return resVec;
	}
	
	public static Object[][] add2Mtx(Object[][] mtx, Object[] vec) {
		Object resMtx[][] = new Object[mtx.length+1][];
		
		for(int i = 0; i<mtx.length; i++) {
			resMtx[i] = mtx[i];
		}
		resMtx[mtx.length] = vec;
		
		return resMtx;
	}
	
	public Object[][] GetDexData(String path){
        Object[][] data = {};
        
		try {
			FileReader f = new FileReader(path+"PBS/pokemon.txt");			
			BufferedReader bf = new BufferedReader(f);
			
			String linea;
			int ff = 0;
			
			while ((linea = bf.readLine()) != null || ff<1) {
				if (linea.equals("[1]")) break;
				Object[] databit = {};
				if (linea.charAt(0) == '['){
					
					/******** POKE NUM ********************************************************************/
					int c = Character.getNumericValue(linea.charAt(1));
					int d = Character.getNumericValue(linea.charAt(2));
					int u = Character.getNumericValue(linea.charAt(3));
					int pokenum = (c*100) + (d*10) + u;
					Object UXpokenum = String.valueOf(pokenum);
					
					//System.out.println("Poke num: "+UXpokenum);
					//databit = add2Vec(databit, UXpokenum);
					
					/********************/
					
					/******** POKE NAME *******************************************************************/
					linea = bf.readLine(); //Name
					String Xpokename = "";
					int i = 5;
					while(i < linea.length()){
						Xpokename += linea.charAt(i);
						i++;
					}
					Object UXpokename = Xpokename;
					
					//System.out.println("Poke name: "+UXpokename);
					//databit = add2Vec(databit, UXpokename);
					
					/********************/
					
					/******** POKE ICON *******************************************************************/
					Object UXpokeIcon = new ImageIcon(path+"Graphics/Battlers/"+pokenum+".png");
					
					//databit = add2Vec(databit, UXpokeIcon);
					
					/********************/
							linea = bf.readLine(); //SALTAR -> INTERN NAME
					
					/******** POKE TYPE1 *******************************************************************/
					linea = bf.readLine(); //Type1
					String Xpoketype = "";
					i = 6;
					while(i < linea.length()){
						Xpoketype += linea.charAt(i);
						i++;
					}
					Object UXpoketype1 = Xpoketype;
					
					Object UXpoketype2 = null;
					
					/********************/
					
					linea = bf.readLine(); //Type2
					if(linea.charAt(0) == 'T' && linea.charAt(1) == 'y') {
						String Xpoketype2 = "";
						i = 6;
						while(i < linea.length()){
							Xpoketype2 += linea.charAt(i);
							i++;
						}
						UXpoketype2 = Xpoketype2;
					}
					/******** ADDING ROW *******************************************************************/
					
					Object[] insertVec = {UXpokenum, UXpokename, UXpokeIcon, UXpoketype1, UXpoketype2};
					data = add2Mtx(data,insertVec);
				}
				ff++;
			}		
			//JOptionPane.showMessageDialog(null, "Update finished.");
		}
		catch(Exception e){
			//JOptionPane.showMessageDialog(null, "Error: Reading pokemon.txt");
			System.out.println("Error: Reading pokemon.txt");
		}
		
        return data;
	}
}
