package PACK;

import java.io.*;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Read_Rutas {
	
	public File directori;
	public File arxiu;
    public Read_MHs RMH = new Read_MHs();
    public Read_MTs RMT = new Read_MTs();
    
    ArrayList<String> pokeRutaArray;

	public Read_Rutas(String path) {		 
		try {
			FileReader f = new FileReader(path+"encounters.txt");
			BufferedReader bf = new BufferedReader(f);
			JOptionPane.showMessageDialog(null, "Loading encounters.txt");
			
			String linea;
			String ruteName = "";
			String pokeName = "";
			int q = 1; //Para saltar primera iteracion ya que empezamos en la linea RUTA 1
			
			System.out.println("NAME +'\t' ");
			System.out.println("=========================================================================================================================");
			
			//Busco primera linea interesante
			while ((linea = bf.readLine()) != null) {
				if (linea.equals("081 # RUTA 1")) {
					ruteName = "RUTA 1";
					break;
				}
			}
			
			//Empiezo a leer la parte interesante
			while ((linea = bf.readLine()) != null) {
				if(q != 1) {
					ruteName = "";
					for(int t = 6; t<linea.length();t++) {
						ruteName += linea.charAt(t);
					}
				}
				else q = 0;
				
				//System.out.println("el nombre RUTA es : "+ruteName);
				
				linea = bf.readLine(); //pasamos a linea numeros
				linea = bf.readLine(); //pasamos a linea tipo de mapa
				
				//System.out.println("Reading pokes: ... ");
				pokeRutaArray = new ArrayList<String>(); //Creamos Array limpia
				while ((linea = bf.readLine()).charAt(0) != '#') {					
					pokeName = "";
					for(int g = 0; g<linea.length(); g++){
						if(linea.charAt(g)==',') break;
						pokeName += linea.charAt(g);			
						//System.out.println("Reading pokemon linea");
					}
					//System.out.println("el nombre pokemon es : "+pokeName);
					
					if(inArray(pokeName,pokeRutaArray));
					else pokeRutaArray.add(pokeName);
					
				}
				//System.out.println("END reading pokes: ... ");
				
				String Xfullrute = ruteName+'\t';
				if(ruteName.length()<8) Xfullrute +='\t';
				if(ruteName.length()<16) Xfullrute +='\t';
				if(ruteName.length()<24) Xfullrute +='\t';
				for(int u=0; u<pokeRutaArray.size(); u++) {
					Xfullrute += pokeRutaArray.get(u);
					Xfullrute += " ";
				}
				System.out.println(Xfullrute);
				System.out.println(" ");
			}
		}
		catch(Exception e){
			//JOptionPane.showMessageDialog(null, "Error: Reading encounters.txt");
			System.out.println("Error: Reading encounters.txt");
		}
	 }

	//Dada una Array mira si un String esta dentro de esta.
	public boolean inArray(String name, ArrayList<String> arrayGiven) {
		for(int k = 0; k < arrayGiven.size(); k++) {
			if(name.equals(arrayGiven.get(k))) return true;
		}
		return false;
	}
}