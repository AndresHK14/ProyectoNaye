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
public class TablaHash
{
    private ArbolBinario arr[]= new ArbolBinario[26];
 
    public TablaHash()
    {
        for (int i = 0; i < arr.length; i++)
        {
            arr[i]= new ArbolBinario();
        }
    }
    
    public void inserta(NodoArbol n)
    {
        if (n!=null)
        {
            int pos =n.getEtq().trim().toUpperCase().charAt(0)-65;
            arr[pos].setR(arr[pos].inserta(arr[pos].getR(), n));
            System.out.println("se inserto correctamente");
        } else
        {
            System.out.println("no se puede insertar");
        }
    }
    
    public NodoArbol busca(String et)
    {
        if(et.isEmpty())
        {
            System.out.println("error... la cadena esta vacia");
            return null;
        } else
        {
            int pos =et.trim().toUpperCase().charAt(0)-65;
            return  arr[pos].busca(arr[pos].getR(), et);
        }
    }
}
