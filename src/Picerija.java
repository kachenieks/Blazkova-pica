import java.util.List;

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

	}

}
