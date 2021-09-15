
/* Nombre: Programa.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el xx.09.2021
 			  Modificado el xx.09.2021 */

public class Programa 
{
    //atributos
    private String nombre;
    private int espacio;
    private int ciclos;
    private int bloques;

    public Programa(String n, int e, int c) //constructor
    {
        nombre = n;
        espacio = e;
        ciclos = c;

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
    
    public String getNombre() //obtener nombre
    {
        return nombre;
    }

    public int getEspacio() //obtener espacio
    {
        return espacio;
    }

    public int getCiclos() //obtener ciclos
    {
        return ciclos;
    }

    public int getBloques() //obtener bloques
    {
        return bloques;
    }

    public void setCiclos() //restar un ciclo
    {
        ciclos--;
    }

}
