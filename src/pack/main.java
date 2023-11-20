package pack;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class main {

    public static void main(String[] args) {
        try {
            System.out.println("Hello");
            FileReader f = new FileReader("./PBS/pokemon.txt");
            System.out.println("find");
            BufferedReader bf = new BufferedReader(f);

            String linea;
            int ff = 0;

            while ((linea = bf.readLine()) != null || ff < 1) {
                String comp = "";
                if (linea.equals("[1]")) break;
                Object[] databit = {};
                if (linea.charAt(0) == '[') {

                    /******** POKE NUM ********************************************************************/
                    int c = Character.getNumericValue(linea.charAt(1));
                    int d = Character.getNumericValue(linea.charAt(2));
                    int u = Character.getNumericValue(linea.charAt(3));
                    int pokenum = (c * 100) + (d * 10) + u;
                    comp += "{num: "+pokenum;

                    /******** POKE NAME *******************************************************************/
                    linea = bf.readLine(); //Name
                    linea = bf.readLine(); //Internal Name
                    String Xpokename = getData(13, linea);
                    if(Xpokename.equals("JOLTIKFA")) Xpokename = "JOLTIK FORMA ASTHAR";
                    if(Xpokename.equals("GALVANTULAFA")) Xpokename = "MAGNEMITE FORMA ASTHAR";
                    if(Xpokename.equals("MAGNEMITEFA")) Xpokename = "MAGNEMITE FORMA ASTHAR";
                    if(Xpokename.equals("MAGNETONFA")) Xpokename = "MAGNETON FORMA ASTHAR";
                    if(Xpokename.equals("EKANSFA")) Xpokename = "EKANS FORMA ASTHAR";
                    if(Xpokename.equals("ARBOKFA")) Xpokename = "ARBOK FORMA ASTHAR";
                    comp += ", name: \""+Xpokename+"\"";

                    /******** POKE TYPE1 *******************************************************************/
                    linea = bf.readLine(); //Name
                    String Xpoketype1 = getData(6, linea);
                    comp += ", type1: \""+Xpoketype1+"\"";
                    /******** POKE TYPE2 *******************************************************************/
                    linea = bf.readLine(); //Name
                    if(linea.charAt(0) == 'T') {
                        String Xpoketype2 = getData(6, linea);
                        comp += ", type2: \"" + Xpoketype2 + "\"";
                    }
                    else{
                        comp += ", type2: null";
                    }
                    while(linea.charAt(0) != 'P'){
                        linea = bf.readLine();
                    }

                    String Xpokedes = getData(8, linea);

                    while(linea.charAt(0) != 'E'){
                        linea = bf.readLine();
                    }

                    /******** POKE EVOLUTION *******************************************************************/
                    String Xpokeevo = "";
                    if(Character.isDigit(linea.charAt(linea.length()-2))) {
                        Xpokeevo += linea.charAt(linea.length() - 2);
                        Xpokeevo += linea.charAt(linea.length() - 1);
                    }
                    else Xpokeevo = "null";

                    comp += ", evo: "+Xpokeevo;

                    comp += ", descrip: \""+Xpokedes+"\"}";

                }
                while(linea.charAt(0) != '#'){
                    linea = bf.readLine();
                }
                System.out.println(comp);
            }
        }
        catch (Exception e){
            System.out.println("Error: Reading pokemon.txt");
        }
    }

    public static String getData(int offset, String linea){
        String myStr = "";
        int i = offset;
        while (i < linea.length()) {
            myStr += linea.charAt(i);
            i++;
        }
        return myStr;
    }
}

/* INPUT FORM

    #-------------------------------
    [650]
    Name=Tabe
    InternalName=TABE
    Type1=GRASS
    BaseStats=55,68,64,31,45,55
    GenderRate=FemaleOneEighth
    GrowthRate=Parabolic
    BaseEXP=64
    EffortPoints=0,1,0,0,0,0
    Rareness=45
    Happiness=70
    Abilities=OVERGROW
    HiddenAbility=SHELLARMOR
    Moves=1,TACKLE,3,GROWL,7,ABSORB,9,RAGE,13,RAZORLEAF,17,CURSE,21,BITE,25,MEGADRAIN,29,LEECHSEED,33,SYNTHESIS,37,CRUNCH,41,GIGADRAIN,45,LEAFSTORM
    EggMoves=AMNESIA,BODYSLAM,DOUBLEEDGE,EARTHPOWER,GROWTH,SANDTOMB,SEEDBOMB,SPITUP,STOCKPILE,SUPERPOWER,SWALLOW,THRASH,TICKLE,WIDEGUARD,WORRYSEED
    Compatibility=Monster,Grass
    StepsToHatch=5355
    Height=0.4
    Weight=10.2
    Color=Green
    Shape=9
    RegionalNumbers=1
    Kind=Tiny Leaf
    Pokedex=Se dice que Tabe pude ser un antiguo dinosaurio herbivoro que en vez de desaparecer como el resto se transformo en un Pokémon.
    BattlerPlayerY=0
    BattlerEnemyY=21
    BattlerAltitude=0
    Evolutions=TABON,Level,16
    #-------------------------------

 */

/* OUTPUT FORM I WANT
		pokes =[
			{num: 659, name: "LORUGA", type1: "BICHO", type2: null, captura: "Ruta 2", evo: 16,
				descrip: "El Pokémon ornitorrinco. Es curioso y le encanta hacer burbujas."},
			{num: 660, name: "GOMADAM", type1: "BICHO", type2: null, captura: "Bosque Travieso", evo: 36,
				descrip: "Su cuerpo atlético le permite nadar a gran velocidad. Hacer carreras de natación es uno de sus pasatiempos favoritos."},
			{num: 661, name: "MATRIUS", type1: "BICHO", type2: "VOLADOR", captura: "evo GOMADAM", evo: null,
				descrip: "Su potente cola le permite nadar contracorriente sin problemas. Suele ser muy terriorial."}
			];
 */

