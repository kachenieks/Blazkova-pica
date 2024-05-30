import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
            	apskatitPasutijumu();
                break;
            case 2:
                System.exit(0);
                break;
        }
    }
}
    private static void jaunsPasutijums() {
        String vards;
        while (true) {
            vards = JOptionPane.showInputDialog("Ievadiet savu vārdu (vismaz 3 burti):");
            if (vards == null) return;
            if (vards.matches("[a-zA-ZāčēģīķļņšūžĀČĒĢĪĶĻŅŠŪŽ]{3,}")) break;
            JOptionPane.showMessageDialog(null, "Vārdam jāsatur vismaz 3 burti.");
        }
        String telefons;
        while (true) {
            telefons = JOptionPane.showInputDialog("Ievadiet savu telefona numuru (tieši 8 cipari):");
            if (telefons == null) return; 
            if (telefons.matches("\\d{8}")) break;
            JOptionPane.showMessageDialog(null, "Telefona numuram jābūt tieši 8 cipariem un saturēt tikai ciparus.");
        }

        String[] picas = {"Margarita", "Pepperoni", "Havaju", "Čorizo", "Vezuva"};
        String pica = (String) JOptionPane.showInputDialog(null, "Izvēlieties picu:",
                "Picas izvēle", JOptionPane.QUESTION_MESSAGE, null, picas, picas[0]);
        if (pica == null) return;
        
        String[] izmeri = new String[3];
        switch (pica) {
            case "Margarita":
                izmeri[0] = "20 cm - 4.99 EUR";
                izmeri[1] = "30 cm - 7.99 EUR";
                izmeri[2] = "50 cm - 9.99 EUR";
                break;
            case "Pepperoni":
                izmeri[0] = "20 cm - 5.49 EUR";
                izmeri[1] = "30 cm - 8.49 EUR";
                izmeri[2] = "50 cm - 11.99 EUR";
                break;
            case "Havaju":
                izmeri[0] = "20 cm - 5.99 EUR";
                izmeri[1] = "30 cm - 8.99 EUR";
                izmeri[2] = "50 cm - 12.49 EUR";
                break;
            case "Čorizo":
            	izmeri[0] = "20 cm - 6.99 EUR";
                izmeri[1] = "30 cm - 9.99 EUR";
                izmeri[2] = "50 cm - 12.99 EUR";
            	break;
            case "Vezuva":
            	izmeri[0] = "20 cm - 5.29 EUR";
                izmeri[1] = "30 cm - 5.99 EUR";
                izmeri[2] = "50 cm - 7.69 EUR";
            	break;
            	
        }
        
        String izmers = (String) JOptionPane.showInputDialog(null, "Izvēlieties picas izmēru:",
                "Picas izmērs", JOptionPane.QUESTION_MESSAGE, null, izmeri, izmeri[0]);
        if (izmers == null) return;

        double picasCena = Double.parseDouble(izmers.split(" - ")[1].replace(" EUR", ""));

        String[] toppinguOpcijas = {"Siers - 1 EUR", "Šampinjoni - 1 EUR", "Sīpoli - 1 EUR", "Olīvas - 1 EUR"};
        JCheckBox[] toppingiCheckboxes = new JCheckBox[toppinguOpcijas.length];
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (int i = 0; i < toppinguOpcijas.length; i++) {
            toppingiCheckboxes[i] = new JCheckBox(toppinguOpcijas[i]);
            panel.add(toppingiCheckboxes[i]);
        }

        int result = JOptionPane.showConfirmDialog(null, panel, "Izvēlieties toppingus", JOptionPane.OK_CANCEL_OPTION);
        if (result != JOptionPane.OK_OPTION) return;

        List<String> toppingi = new ArrayList<>();
        double toppinguCena = 0;
        for (JCheckBox checkbox : toppingiCheckboxes) {
            if (checkbox.isSelected()) {
                toppingi.add(checkbox.getText());
                toppinguCena += 1;
            }
        }
        double totalCena = picasCena + toppinguCena;
        Pasutijums pasutijums = new Pasutijums(vards, telefons, pica, izmers.split(" - ")[0], toppingi, totalCena);
        pasutijumi.add(pasutijums);

        JOptionPane.showMessageDialog(null, "Pasūtījums pieņemts!\nKopējā cena: " + totalCena + " EUR");
    }

    private static void apskatitPasutijumu() {
        if (pasutijumi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nav veikti pasūtījumi.");
            return;
        }

        StringBuilder pasutijumuSaraksts = new StringBuilder("<html><body>");
        for (Pasutijums pasutijums : pasutijumi) {
            pasutijumuSaraksts.append("<p>").append(pasutijums.toString().replace("\n", "<br>")).append("</p><hr>");
        }
        pasutijumuSaraksts.append("</body></html>");

        JOptionPane.showMessageDialog(null, new JLabel(pasutijumuSaraksts.toString()));
    }
}


