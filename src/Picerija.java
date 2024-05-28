import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Picerija {

    static class Pasutijums {
        String vards;
        String telefons;
        String pica;
        String izmers;
        List<String> toppingi;
        double cena;
        
        public Pasutijums(String vards, String telefons, String pica, String izmers, List<String> toppingi, double cena) {
            this.vards = vards;
            this.telefons = telefons;
            this.pica = pica;
            this.izmers = izmers;
            this.toppingi = toppingi;
            this.cena = cena;
        }
        
        @Override
        public String toString() {
            return "Vārds: " + vards + "\n" +
                   "Telefons: " + telefons + "\n" +
                   "Pica: " + pica + " (" + izmers + ")\n" +
                   "Toppingi: " + toppingi + "\n" +
                   "Cena: " + cena + " EUR\n";
        }
    }
    
    private static List<Pasutijums> pasutijumi = new ArrayList<>();
    
    public static void main (String[] args) {
    	while(true) {
    		String[] opcijas = {"Jauna pasūtījuma izveide", "Apskatīt pasūtījumus", "Iziet"};
    		int izvele = JOptionPane.showOptionDialog(null, "Izvēlieties opciju", "Picērija",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcijas, opcijas[0]);
            switch (izvele) {
            case 0:
                jaunsPasutijums();
                break;
            case 1:
                skatitiesPasutijumus();
                break;
            case 2:
                System.exit(0);
                break;
        }
    }
}

	}


