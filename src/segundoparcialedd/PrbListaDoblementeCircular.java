/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundoparcialedd;

/**
 *
 * @author Nayeli
 */
public class PrbListaDoblementeCircular 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ListaDobleCircular obj = new ListaDobleCircular();
        
        Nodo n1 =new Nodo(null, "B");
        Nodo n2 =new Nodo(null, "C");
        Nodo n3 =new Nodo(null, "D");
        Nodo n4 =new Nodo(null, "A");
        

        obj.inserta(n1);
        obj.inserta(n2);
        obj.inserta(n3);
        obj.inserta(n4);
       
        System.out.println("Lista ascendente:");
        obj.desp();
        System.out.println("Lista descendente:");
        obj.despR();

        // Verificar si la lista está ordenada antes de eliminar un dato
        System.out.println("************************");
        Nodo ne = obj.elimina("D");
        
        if(ne != null)
        {
            System.out.println("Dato eliminado = " + ne.getEtq());
        }
        else
        {
            System.out.println("El dato no se encontró para eliminar.");
        }

        // Mostrar la lista después de eliminar el dato y verificar si está ordenada
        System.out.println("Lista ascendente después de eliminar:");
        obj.desp();
        System.out.println("Lista descendente después de eliminar:");
        obj.despR();

    }
    
}
