/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import clases.Elemento;

/**
 *
 * @author Nayeli
 */
public class Multilista<T>
{

    public Nodo inserta(Nodo r, int nivel, String s[], Nodo n)
    {
        if (s.length - 1 == nivel)
        {
            ListaDobleCircular obj = new ListaDobleCircular();
            obj.r = r;
            obj.inserta(n);
            return obj.r;
        } else
        {
            Nodo aux = busca(r, s[nivel]);
            if (aux == null)
            {  // Si no se encuentra, se crea un nuevo nodo en ese nivel
                aux = new Nodo(null, s[nivel]);
                if (r == null)
                {
                    r = aux; // Si r es null, establece r como aux
                } else
                {
                    // Lógica para insertar aux en r si no es el primer nodo
                    Nodo temp = r;
                    while (temp.getSig() != null)
                    {
                        temp = temp.getSig(); // Encuentra el último nodo
                    }
                    temp.setSig(aux); // Conecta el último nodo con aux
                    aux.setAnt(temp); // Establece el anterior de aux
                }
                aux.setAbj(inserta(null, nivel + 1, s, n));
            } else
            {
                aux.setAbj(inserta(aux.getAbj(), nivel + 1, s, n));
            }
            return r;
        }
    }

    public Nodo elimina(Nodo r, String etq)
    {
        if (r == null)
        {
            System.out.println("La multilista está vacía");
            return null;
        }

        Nodo ne = busca(r, etq);

        if (ne == null)
        {
            System.out.println("El nodo con la etiqueta " + etq + " no fue encontrado en la multilista");
            return null;
        }

        if (ne == r)
        {
            // Si el nodo a eliminar es el primer nodo de la multilista
            // Actualizamos la referencia al primer nodo (r)
            if (r.getSig() == r)
            {
                // Si la multilista tiene solo un nodo
                r = null;
            } else
            {
                // Si hay más de un nodo en la multilista
                r = r.getSig(); // Movemos la referencia al siguiente nodo
            }
        }

        // Eliminamos el nodo de la lista doble circular
        ne.getAnt().setSig(ne.getSig());
        ne.getSig().setAnt(ne.getAnt());

        // Limpiamos las referencias del nodo eliminado
        ne.setSig(null);
        ne.setAnt(null);

        System.out.println("Nodo con la etiqueta " + etq + " eliminado de la multilista");
        return ne;
    }

    public Nodo busca(Nodo r, String s)
    {
        ListaDobleCircular obj = new ListaDobleCircular();
        obj.r = r;
        return obj.busca(s);
    }
    
    public Nodo buscaBajas(Nodo r, String s)
    {
        ListaDobleCircular obj = new ListaDobleCircular();
        obj.r = r;
        return obj.buscaBajas(s);
    }

    public void desp(Nodo r, String s)
    {
        if (r == null)
        {
            return;
        }

        Nodo start = r;
        do
        {
//            Elemento elemento=(Elemento)r.getObj();
//            System.out.println("Autor: "+elemento.getAutor());
//            System.out.println("Ruta: "+elemento.getRuta());
            System.out.println(s + r.getEtq());
            desp(r.getAbj(), s + "\t");  // Recursividad para manejar subniveles
            r = r.getSig();
            if (r == start)
            {
                return;  // Salir si se detecta un ciclo
            }
        } while (r != start && r != null);  // Continuar mientras no se regrese al inicio o se encuentre un nodo nulo
    }

}
