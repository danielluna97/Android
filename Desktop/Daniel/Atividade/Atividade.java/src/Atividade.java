
import static java.lang.Math.sqrt;
import java.security.PrivateKey;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sala302b
 */
public class Atividade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     int cateto1 = 10;
     int cateto2 = 20;
     double hipotenusa = teoriaPitaguras(cateto1, cateto2);
     
    
    }
    private static double teoriaPitaguras(double cat1,double cat2){
        double r = Math.sqrt((cat1*cat1)+ (cat2*cat2) );
        return r;
        
    }
}
    
