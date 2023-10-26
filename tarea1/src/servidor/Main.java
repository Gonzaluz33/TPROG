package servidor;

import servidor.publicar.WebServices;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        WebServices p = new WebServices();
        p.publicar();
    }

}
