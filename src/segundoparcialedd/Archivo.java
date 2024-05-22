/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segundoparcialedd;

/**
 *
 * @author Nayeli
 */
public class Archivo 
{
    private String nombre;
    private String extencion;
    private String fecha;
    private String autor;
    private char tipo;
    private int tamanio;
    private String ruta;
    
    public Archivo(String nombre, String extencion, String fecha, String autor, char tipo, int tamanio, String ruta)
    {
        this.autor = autor;
        this.extencion = extencion;
        this.fecha = fecha;
        this.nombre = nombre;
        this.ruta = ruta;
        this.tamanio = tamanio;
        this.tipo = tipo;
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() 
    {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    /**
     * @return the extencion
     */
    public String getExtencion() 
    {
        return extencion;
    }

    /**
     * @param extencion the extencion to set
     */
    public void setExtencion(String extencion) 
    {
        this.extencion = extencion;
    }

    /**
     * @return the fecha
     */
    public String getFecha() 
    {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) 
    {
        this.fecha = fecha;
    }

    /**
     * @return the autor
     */
    public String getAutor() 
    {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) 
    {
        this.autor = autor;
    }

    /**
     * @return the tipo
     */
    public char getTipo() 
    {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(char tipo) 
    {
        this.tipo = tipo;
    }

    /**
     * @return the tamanio
     */
    public int getTamanio() 
    {
        return tamanio;
    }

    /**
     * @param tamanio the tamanio to set
     */
    public void setTamanio(int tamanio) 
    {
        this.tamanio = tamanio;
    }

    /**
     * @return the ruta
     */
    public String getRuta() 
    {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) 
    {
        this.ruta = ruta;
    }
}
