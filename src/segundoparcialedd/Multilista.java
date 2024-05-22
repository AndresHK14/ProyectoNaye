/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segundoparcialedd;

/**
 *
 * @author Nayeli
 */
public class Multilista <T>
{
    public Nodo inserta(Nodo r, int nivel, String s[], Nodo n)
    {
        if (s.length -1 == nivel) 
        {
            ListaDobleCircular obj = new ListaDobleCircular(); //técnico
            obj.r =r; //le mando al técnico mi información
            obj.inserta(n); 
            return obj.r; //regresa la informacion modificada
        }else
        {
            Nodo aux = busca(r,s[nivel]);
            if (aux!=null) 
            {
                aux.setAbj(inserta(aux.getAbj(), nivel+1, s, n)); 
            }
            //No puedo retornar aux, seimpre la r
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
            } else {
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
    
    public void desp(Nodo r, String s)
    {
        while(r!=null)
        {
            System.out.println(r.getEtq());
            desp(r.getAbj(), s+"\t"); //antes de pasar al siguiente nodo aplico la recursividad
            r=r.getSig();
        }
    }
}
