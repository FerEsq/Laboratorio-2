
/* Nombre: Programa.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 14.09.2021
 			  Modificado el 17.09.2021 */

public class Programa 
{
    //atributos
    private String nombre;
    private int espacio;
    private int ciclos;
    private int bloques;
    private boolean ejecutado; //se agregó una bandera para verificar si el programa estaba siendo ejecutado o no

    public Programa(String n, int e, int c) //constructor
    {
        nombre = n;
        espacio = e;
        ciclos = c;
        ejecutado = false;

        //calcular número de bloques que ocupará el programa
        if (espacio % 64 != 0)
        {
            bloques = (espacio / 64) + 1;
        }
        else
        {
            bloques = espacio / 64;
        }
    }
        
    /** 
     * @return String
     */
    public String getNombre() //obtener nombre
    {
        return nombre;
    }
    
    /** 
     * @return int
     */
    public int getEspacio() //obtener espacio
    {
        return espacio;
    }
    
    /** 
     * @return int
     */
    public int getCiclos() //obtener ciclos
    {
        return ciclos;
    }
    
    /** 
     * @return int
     */
    public int getBloques() //obtener bloques
    {
        return bloques;
    }

    public void setCiclos() //restar un ciclo
    {
        ciclos--;
    }
    
    /** 
     * @return boolean
     */
    //Se agregaron tres métodos para el atributo de ejecutado (un getter y dos setters)
    public boolean getEjecutado() //obtener ejecutado
    {
        return ejecutado;
    }

    public void setEjecutadoT() //cambia el valor de ejecutado a true
    {
        ejecutado = true;
    }

    public void setEjecutadoF() //cambia el valor de ejecutado a false
    {
        ejecutado = false;
    }

}
