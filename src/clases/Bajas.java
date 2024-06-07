/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import static clases.PrbAltas.mult;
import static clases.PrbAltas.r;
import estructuras.Nodo;
import clases.Elemento;
import java.util.Scanner;

/**
 *
 * @author Nayeli
 */

public class Bajas 
{
    private Scanner scanner;
    //private Nodo ne;
    
    public Nodo bajaElemento(String nombre, char tipo)
    {
        Nodo ne =  mult.buscarNodo(r, nombre);
        
        if (ne == null)
        {
            System.out.println("Elemento no encontrado: " + nombre);
            
            return r;
        }
        
        if (Character.toUpperCase(tipo) == 'C') 
        {
            if (confirmarEliminacionCarpeta(ne)) 
            {
                r = eliminarCarpeta(r, ne);
            }
        } else 
        {
            if (confirmarEliminacionArchivo(ne)) 
            {
                r = eliminarArchivo(r, ne);
            }
        }
        return r;
    }
    
    public Elemento bajaElimina(String nombre)
    {
        
        
       Nodo elementoEliminado = mult.eliminarNodo(r, nombre);
        if (elementoEliminado!=null) {
           Elemento elemento=(Elemento)elementoEliminado.getObj();
            return elemento;
        }
        return null;
    }
    
    private boolean confirmarEliminacionArchivo(Nodo ne) 
    {
        Elemento arch = (Elemento) ne.getObj();
        System.out.println("¿Está seguro de que desea eliminar el archivo: " + arch.getNombre() + "? (S/N)");
        String respuesta = scanner.nextLine();
        return respuesta.equalsIgnoreCase("S");
    }
    
    private boolean confirmarEliminacionCarpeta(Nodo ne) 
    {
        int[] stats = obtenerEstadisticasCarpeta(ne);
        //Elemento carpt = (Elemento) ne.getObj();
        System.out.println("La carpeta contiene " + stats[0] + " archivos con un tamaño total de " + stats[1] + " bytes.");
        System.out.println("¿Está seguro de que desea eliminar la carpeta: " + ne.getEtq() + "? (S/N)");
        String respuesta = scanner.nextLine();
        return respuesta.equalsIgnoreCase("S");
    }
    
    private int[] obtenerEstadisticasCarpeta(Nodo carpt) 
    {
        int[] stats = new int[2]; // [0]: número de archivos, [1]: tamaño total

        Elemento elm = (Elemento) carpt.getAbj().getObj();
        //Nodo aux = carpt.getAbj();
        
        while (elm != null) 
        {
            if (elm.getTipo() == 'A') 
            {
                stats[0]++;
                stats[1] += elm.getTamanio();
            } else if (elm.getTipo() == 'C') 
            {
                int[] subStats = obtenerEstadisticasCarpeta(carpt);
                stats[0] += subStats[0];
                stats[1] += subStats[1];
            }
            carpt = carpt.getSig();
        }

        return stats;
    }
    
    private Nodo eliminarArchivo(Nodo r, Nodo ne) 
    {
        Elemento arch = (Elemento) ne.getObj();
        r = mult.elimina(r, ne.getEtq());
        actualizarTamanio(ne, -arch.getTamanio());
        return r;
    }

    private Nodo eliminarCarpeta(Nodo r, Nodo ne) 
    {
        int[] stats = obtenerEstadisticasCarpeta(ne);
        r = mult.elimina(r, ne.getEtq());
        actualizarTamanio(ne, -stats[1]);
        return r;
    }

    private void actualizarTamanio(Nodo carpt, int tamanio) 
    {
        while (carpt != null) 
        {
            Elemento elm = (Elemento) carpt.getObj();
            if (elm.getTipo() == 'C') 
            {
                elm.setTamanio(elm.getTamanio() + tamanio);
            }
            carpt = carpt.getAnt();
        }
    }
}
