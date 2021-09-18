
/* Nombre: Vista.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 16.09.2021
 			  Modificado el 17.09.2021 */

//Import
import java.util.Scanner;
import java.util.ArrayList;  

public class Vista
{
    //Propiedades
    Scanner scan = new Scanner(System.in);

    public Vista() //constructor
    {  

    }

    //Mensaje de bienvenida
    public void mostrarInicio()
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("           ✦ Bienvenid@ al simulador de memorias RAM ✦ \n");
		System.out.println(" - Por el momento, solo contamos con 2 tipos de memoria (SDR/DDR)");
        System.out.println(" - Recuerde darle doble enter al ingresar un dato (de ser necesario)");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    //Mensaje de despedida
    public void mostrarDespedida()
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Muchas gracias por utilizar nuestro simulador!!!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }
        
    /** 
     * @return int
     */
    //Menu
    public int mostrarMenu()
    {
        int op = 0;
        System.out.println("\n¿Que opción desea ejecutar? (ingrese solo el número)");	
		System.out.println("1. Inicializar simulador");
		System.out.println("2. Ingresar programas");
		System.out.println("3. Ver cantidad de memoria total");
        System.out.println("4. Ver cantidad de memoria disponible");
        System.out.println("5. Ver cantidad de memoria en uso");
        System.out.println("6. Ver programas en ejecución");
        System.out.println("7. Ver programas en cola");
        System.out.println("8. Ver posición de un programa");
        System.out.println("9. Ver estado de la memoria");
        System.out.println("10. Realizar un ciclo de reloj");
        System.out.println("11. Mostrar programas finalizados");
		System.out.println("12. Salir");
        op = scan.nextInt();
        return op;
    }
    
    /** 
     * @param prgs
     */
    //Mostrar programas instalados (archivo)
    public void mostrarProgramas(ArrayList<Programa> prgs)
    {
        System.out.println("\n~~~~~~~~~~~~~~~");
        for (int i = 0; i < prgs.size(); i++)
        {
            System.out.println(i + ": " + prgs.get(i).getNombre());
        }
        System.out.println("~~~~~~~~~~~~~~~");
    }

    // ------------------------------ Solicitar datos ------------------------------
    
    /** 
     * @return String
     */
    public String pedirProgramas()
    {
        System.out.println("\nIngrese los números de los programas separados por una coma (n,n,n...):");
        scan.nextLine();
        return scan.nextLine();
    }
    
    /** 
     * @return String
     */
    public String pedirTipo()
    {
        System.out.println("\nIngrese el tipo de memoria RAM en mayúsculas (SDR/DDR):");
        scan.nextLine();
        return scan.nextLine().toUpperCase();
    }
    
    /** 
     * @return int
     */
    public int pedirTamanio()
    {
        System.out.println("\nIngrese el tamaño de la memoria (4/8/12/16/32/64):");
        return scan.nextInt();
    }

    // -------------------------------------------------------------------------
    
    /** 
     * @param t
     */
    public void mostrarTotal(int t)
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("La cantidad de memoria RAM total es: " + t + " MB");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    /** 
     * @param d
     */
    public void mostrarDisponible(int d)
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("La cantidad de memoria RAM disponible es: " + d + " MB");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    /** 
     * @param u
     */
    public void mostrarUso(int u)
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("La cantidad de memoria RAM en uso es: " + u + " MB");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    /** 
     * @param e
     */
    public void mostrarEjecucion(String[] e)
    {
        if (e.length == 0)
        {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("No hay ningún programa en ejecución");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        else
        {
            System.out.println("\n~~~~~~~~~~~~~~~");
            for (int i = 0; i < e.length; i++)
            {
                System.out.println(e[i]);
            }
            System.out.println("~~~~~~~~~~~~~~~");
        }
    }
    
    /** 
     * @param c
     */
    public void mostrarCola(String[] c)
    {
        if (c.length == 0)
        {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("No hay ningún programa en la cola");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        else
        {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~");
            for (int i = 0; i < c.length; i++)
            {
                System.out.println(c[i]);
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~");
        }
    }
    
    /** 
     * @return String
     */
    public String pedirPrograma()
    {
        System.out.println("\nIngrese el programa en maýusculas y con sus respectivos espacios:");
        scan.nextLine();
        return scan.nextLine().toUpperCase();
    }
    
    /** 
     * @param p
     */
    public void mostrarPosicion(int[] p)
    {
        if (p == null)
        {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("El programa no se encuentra en ejecución");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        else
        {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("El programa se encuentra del bloque " + p[0] + " al bloque " + p[1]);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }
    
    /** 
     * @param e
     */
    public void mostrarEstado(int[] e)
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("- Bloques en uso " + e[0]);
        System.out.println("- Bloques vacíos " + e[1]);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
    }
    
    /** 
     * @param c
     */
    // ------------------------------ Agregados ------------------------------

    public void mostrarCiclo(int c) //mensaje que se muestra al realizar un ciclo
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Ciclo de reloj No." + c + " realizado con éxito");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    /** 
     * @param AL
     */
    public void mostrarFinalizados(ArrayList<Programa> AL) //nueva opción: mostrar programas finalizados
    {
        if (AL.isEmpty() == true)
        {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("No hay ningún programa finalizado");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        else
        {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~");
            for (int i = 0; i < AL.size(); i++)
            {
                System.out.println(AL.get(i).getNombre());
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~");
        }
    }

    public void mostrarOpcion() //Error al ingresar opción no existente
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Esa opción no existe, intente de nuevo");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    public void mostrarError() //Error al ingresar datos incorrectamente
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Error de ingreso de datos, vuelva a correr el programa");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }
}
