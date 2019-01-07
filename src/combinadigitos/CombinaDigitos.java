/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combinadigitos;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author diego
 */
public class CombinaDigitos {

    public static ArrayList<Integer> addNotContains(ArrayList<Integer> n, ArrayList<Integer> m){
        ArrayList<Integer> out = (ArrayList<Integer>) n.clone();
        for (int i = 0; i < m.size(); i++) {
            int x = m.get(i);
            if (!n.contains(x)) out.add(x);
        }
        
        return out;
    }
    
    public static double exponente(double n, int exp){
        if (exp == 0) return 1;
        else if (exp > 0) return n * exponente(n, exp-1);
        else return exponente(n, exp+1) / n;
    }
    
    //Realiza exponentes positivos
    public static int exponentePos(int n, int exp){
        if (exp == 0) return 1;
        else return n * exponentePos(n, exp-1);
    }
    
    //Se mueve manteniendo o eliminando dígitos para obtener nuevos dígitos
    //coincidentes con ambas entradas
    public static ArrayList<Integer> CombinaDigitos(int n, int acumulado, int digitos){
        ArrayList<Integer> out = new ArrayList<>();
        
        if (n == 0){
            if (acumulado != 0) out.add(acumulado);
            return out;
        } else {
            int r = n%10;
            int c = n/10;
            int exp = exponentePos(10, digitos);
            
            out.addAll(CombinaDigitos(c, acumulado + r*exp, digitos+1));//si mantenemos el dígito
            out = addNotContains(out, (CombinaDigitos(c, acumulado, digitos)));//si eliminamos el digito
            
            return out;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        if (args.length > 0){
            System.out.println(CombinaDigitos(Integer.parseInt(args[0]), 0, 0));
        } else {
            System.out.println(CombinaDigitos(1151451, 0, 0));
        }
    }
    
}
