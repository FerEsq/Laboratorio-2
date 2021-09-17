
/* Nombre: Vista.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el xx.09.2021
 			  Modificado el xx.09.2021 */

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
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("          ✦ Bienvenid@ al simulador de memorias RAM ✦ \n");
		System.out.println(" - Por el momento, solo contamos con 2 tipos de memoria (SDR/DDR)");
        System.out.println(" - Recuerde darle doble enter al ingresar un dato (de ser necesario)");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }
    
    //Menu
    public int mostrarMenu()
    {
        int op = 0;
        System.out.println("¿Que opción desea ejecutar? (ingrese solo el número)");	
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
		System.out.println("11. Salir");

        op = scan.nextInt();
        return op;
    }

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

    public String pedirProgramas()
    {
        System.out.println("\nIngrese los números de los programas separados por una coma (n,n,n...):");
        scan.nextLine();
        return scan.nextLine();
    }

    public String pedirTipo()
    {
        System.out.println("\nIngrese el tipo de memoria RAM en mayúsculas (SDR/DDR):");
        scan.nextLine();
        return scan.nextLine().toUpperCase();
    }

    public int pedirTamanio()
    {
        System.out.println("\nIngrese el tamaño de la memoria (4/8/12/16/32/64):");
        return scan.nextInt();
    }

    public void mostrarTotal(int t)
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("La cantidad de memoria RAM total es: " + t + " MB");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void mostrarDisponible(int d)
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("La cantidad de memoria RAM disponible es: " + d + " MB");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void mostrarUso(int u)
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("La cantidad de memoria RAM en uso es: " + u + " MB");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

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
            System.out.println("\n~~~~~~~~~~~~~~~");
            for (int i = 0; i < c.length; i++)
            {
                System.out.println(c[i]);
            }
            System.out.println("~~~~~~~~~~~~~~~");
        }
    }

    public String pedirPrograma()
    {
        System.out.println("\nIngrese el programa en maýusculas y con sus respectivos espacios:");
        scan.nextLine();
        return scan.nextLine().toUpperCase();
    }

    public void mostrarPosicion(int[] p)
    {
        if (p.length == 0)
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

    public void mostrarEstado(int[] e)
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("- Bloques en uso " + e[0]);
        System.out.println("- Bloques vacíos " + e[1]);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
    }

    //Mensaje de despedida
    public void mostrarDespedida()
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Muchas gracias por utilizar nuestro simulador!!!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
}
