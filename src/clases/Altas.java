/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import static clases.PrbAltas.mult;
import static clases.PrbAltas.r;
import estructuras.Nodo;

/**
 *
 * @author Nayeli
 */
public class Altas 
{
    public void altaRuta(String ruta, String nombreCompleto, int tamanio, char tipo) 
    {
    if (!ruta.isEmpty()) 
    {
        String nombre = null, extension = null;

        // Asegurarse de que la comparación de 'tipo' se haga sin errores
        if (Character.toUpperCase(tipo) == 'C') 
        {
            nombre = nombreCompleto;
        } else if (Character.toUpperCase(tipo) == 'A') 
        {
            String[] partes = nombreCompleto.split("\\.");
            if (partes.length != 2) 
            {
                System.out.println("Nombre de archivo no válido.");
                return; // Terminar la ejecución si el nombre no es válido
            }
            nombre = partes[0];
            extension = partes[1];
        } else 
        {
            System.out.println("Tipo de archivo no válido.");
            return; // Terminar la ejecución si el tipo no es válido
        }

        String autor = System.getProperty("user.name");
        String[] partesRuta = ruta.split("/");
        
        Elemento nElemento = new Elemento(nombre, extension, tipo, tamanio, ruta);
        Nodo nuevoNodo = new Nodo(nElemento,nombre);
        
        //Nodo busca = mult.busca(r, nombre);
        if (r == null) 
        {
            String[] arr = {nombre}; // Aquí 'nombre' en vez de 'busca.getEtq()' que parece ser incorrect
            r = mult.inserta(r, 0, arr, nuevoNodo);
        } else 
        {
            String[] arr = areglo(partesRuta,nombre);
            r = mult.inserta(r, 0, arr, nuevoNodo);
        }
        
         // Actualiza el tamaño si es un archivo
//        if (tipo == 'A' && carpetaDestino != null) 
//        {
//            actualizarTamanio(carpetaDestino, tamanio);
//        }

    } else 
    {
        System.out.println("Faltan datos");
    }
}

    public String[] areglo(String arr[], String nombre)
    {
       String  array[] =new String[arr.length+1];
        for (int i = 0; i < array.length; i++) {
            if ((i+1)==array.length) {
                array[i]=nombre;
            }else
            {
                array[i]=arr[i];
            }
        }
        return array;
    }
    
    // Actualiza el tamaño de las carpetas anteriores cuando se añade un archivo
    private void actualizarTamanio(Nodo<Elemento> carpt, int tamanio) 
    {
        while (carpt != null) 
        {
            Elemento elm = (Elemento) carpt.getObj();
            if (elm != null) 
            {
                elm.setTamanio(elm.getTamanio() + tamanio);
            }
            carpt = carpt.getArb();
        }
    }
}
