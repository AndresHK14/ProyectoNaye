/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package segundoparcialedd;

/**
 *
 * @author Nayeli
 */
public class PrbMultilistas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       Multilista ml = new Multilista();
       Nodo r = null;
       
       Nodo p1 = new Nodo(null,"México");
       Nodo p2 = new Nodo(null, "Alemania");
       Nodo p3 = new Nodo(null, "Grecia");
       Nodo p4 = new Nodo(null, "Colombia");
       
       Nodo e1 = new Nodo(null, "CDMX");
       Nodo e2 = new Nodo(null, "Berlin");
       Nodo e3 = new Nodo(null, "Atenas");
       Nodo e4 = new Nodo(null, "Medellin");
       
       Nodo esc1 = new Nodo(null, "Argos");
       Nodo esc2 = new Nodo(null, "Niños heroes");
       Nodo esc3 = new Nodo(null, "Justo cierra");
       Nodo esc4 = new Nodo(null, "ABC");
       
       String arr[]= new String[1];
       arr[0]="México";
       r = ml.inserta(r, 0, arr, p1);
       arr[0]="Alemania";
       r = ml.inserta(r, 0, arr, p2);
       arr[0]="Grecia";
       r = ml.inserta(r, 0, arr, p3);
       arr[0]="Colombia";
       r = ml.inserta(r, 0, arr, p4);
       
       String arr2[]= new String[2];
       arr2[0]="México";
       arr2[1]="CDMX";
       r = ml.inserta(r, 0, arr2, e1);
       arr2[0]="Alemania";
       arr2[1]="Berlin";
       r = ml.inserta(r, 0, arr2, e2);
       arr2[0]="Grecia";
       arr2[1]="Atenas";
       r = ml.inserta(r, 0, arr2, e3);
       arr2[0]="Colombia";
       arr2[1]="Medellin";
       r = ml.inserta(r, 0, arr2, e4);
       
       String arr3[]= new String[3];
       arr3[0]="México";
       arr3[1]="CDMX";
       r = ml.inserta(r, 0, arr3, esc1);
       r = ml.inserta(r, 0, arr3, esc2);
       r = ml.inserta(r, 0, arr3, esc3);
//       arr3[0]="Alemania";
//       arr3[1]="Berlin";
//       arr3[0]="Grecia";
//       arr3[1]="Atenas";
       arr3[0]="Colombia";
       arr3[1]="Medellin";
       r = ml.inserta(r, 0, arr3, esc4);
       
       ml.desp(r, "");
        System.out.println("");
       
    }
    
}
