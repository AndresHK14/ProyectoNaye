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
public class ListaDobleCircular<T>
{

    Nodo r = null;

    /**
     * @return the r
     */
    public Nodo getR()
    {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(Nodo r)
    {
        this.r = r;
    }

    public void inserta(Nodo n)
    {
        if (n != null)
        {
            if (r == null)
            {  // Si la lista está vacía
                r = n;
                r.setSig(n);
                r.setAnt(n);
            } else
            {
                if (n.getEtq().compareTo(r.getSig().getEtq()) < 0 || n.getEtq().compareTo(r.getEtq()) > 0)
                {  // Insertar antes del primero o después del último
                    n.setSig(r.getSig());
                    n.setAnt(r);
                    r.getSig().setAnt(n);
                    r.setSig(n);

                    if (n.getEtq().compareTo(r.getEtq()) < 0)
                    {
                        r = n;  // Actualizar el nodo referencia si es necesario
                    }
                } else
                {
                    Nodo<T> aux = r.getSig();
                    boolean inserted = false;

                    do
                    {
                        if (aux.getEtq().compareTo(n.getEtq()) > 0)
                        {  // Encontrar la posición correcta
                            n.setSig(aux);
                            n.setAnt(aux.getAnt());
                            aux.getAnt().setSig(n);
                            aux.setAnt(n);
                            inserted = true;
                            break;  // Salir del bucle una vez insertado
                        }
                        aux = aux.getSig();
                    } while (aux != r.getSig() && !inserted);  // Evitar volver al inicio sin insertar

                    if (!inserted)
                    {  // Si no se insertó en el bucle, insertar al final
                        n.setSig(r.getSig());
                        n.setAnt(r);
                        r.getSig().setAnt(n);
                        r.setSig(n);
                    }
                }
            }
        }
    }

    public Nodo elimina(String etq)
    {
        Nodo<T> ne = null;

        if (r != null)
        {
            if (etq.compareTo(r.getSig().getEtq()) > 0 || etq.compareTo(r.getEtq()) > 0)
            {
                if (r.getSig().getEtq().equals(etq))
                {
                    ne = r.getSig();
                    r.setSig(ne.getSig());
                    r.getSig().setAnt(r);

                    //Era el primero, tambien el ultimo
                    if (r == ne)
                    {
                        r = null;
                    }

                    ne.setSig(null);
                    ne.setAnt(null);

                } else
                {
                    Nodo<T> aux = r.getSig();
                    boolean b = false;
                    while (aux != r && !b)
                    {
                        if (aux.getSig().getEtq().equals(etq))
                        {
                            ne = aux.getSig();
                            aux.setSig(ne.getSig());
                            aux.getSig().setAnt(aux);

                            if (r == ne)
                            {
                                r = aux;
                            }

                            ne.getAnt().setSig(r);
                            r.setAnt(ne.getAnt());

                            b = true;
                        } else if (etq.compareTo(aux.getSig().getEtq()) < 0)
                        {
                            System.out.println("Dato no encontrado");
                            break;
                        } else
                        {
                            aux = aux.getSig();
                        }
                    }
                }
            }
        }

        if (ne != null)
        {
            ne.setSig(null);
            ne.setAnt(null);
        }

        return ne;
    }

    public void desp()
    {
        if (r != null)
        {
            Nodo<T> aux = r.getSig();
            do
            {
                System.out.println(aux.getEtq());
                aux = aux.getSig();
            } while (aux != r.getSig());
        } else
        {
            System.out.println("no hay datos en la lista");
        }
    }

    public void despR()
    {
        if (r != null)
        {
            Nodo<T> aux = r;
            do
            {
                System.out.println(aux.getEtq());
                aux = aux.getAnt();
            } while (aux != r);
        } else
        {
            System.out.println("no hay datos en la lista");
        }
    }

    public Nodo busca(String etq)
    {
        if (r != null)
        {
            Nodo aux = r;
            do
            {
                if (aux.getEtq().equals(etq))
                {
                    return aux;
                }
                aux = aux.getSig();
            } while (aux != r);
        }
        return null;
    }

}
