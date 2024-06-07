/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

/**
 *
 * @author chenc
 */
public class PrbTablasHash
{
/**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        NodoArbol a1 = new NodoArbol("Narciso", null);
        NodoArbol a2 = new NodoArbol("Pancracio", null);
        NodoArbol a3 = new NodoArbol("Ambrocio", null);
        NodoArbol a4 = new NodoArbol("Panfilo", null);
        NodoArbol a5 = new NodoArbol("Petra", null);
        NodoArbol a6 = new NodoArbol("Putla", null);
        
        TablaHash th = new TablaHash();
        
        th.inserta(a1);
        th.inserta(a2);
        th.inserta(a3);
        th.inserta(a4);
        th.inserta(a5);
        th.inserta(a6);
        
        NodoArbol na = th.busca("Putla");
        if (na != null) 
        {
            System.out.println(na.getEtq());
        }
    }
    
    
}
