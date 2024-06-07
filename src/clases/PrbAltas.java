/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases;

import estructuras.Multilista;
import estructuras.Nodo;

/**
 *
 * @author Nayeli
 */
public class PrbAltas 
{
    public static Nodo r = null;
    public static  Multilista mult = new Multilista();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
     
       Altas alt = new Altas();
       Bajas bj = new Bajas();
       
       alt.altaRuta("C:", "C:", 0, 'c');
       alt.altaRuta("C:", "Documentos", 0, 'c');
       alt.altaRuta("C:/Documentos", "archivo.txt", 6, 'A');
       alt.altaRuta("C:", "Descarga", 0, 'c');
       alt.altaRuta("C:/Descarga", "archivo2.txt", 6, 'A');
       alt.altaRuta("C:/Documentos", "EDD", 0, 'c');
//       alt.altaRuta("D:", "D:", 0, 'c');
//       alt.altaRuta("D:", "Imagenes", 0, 'c');
//       alt.altaRuta("D:/Imagenes", "img.png", 6, 'A');

        mult.desp(r,"etq: ");
        
        bj.bajaElemento("EDD", 'C');
       
       
        mult.desp(r,"etq: ");
     }
}
