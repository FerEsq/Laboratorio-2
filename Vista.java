
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
        System.out.println(" - Recuerde que el tamaño inicial de una memoria DDR es de 4 GB");
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
        for (int i = 0; i < prgs.size(); i++)
        {
            System.out.println(i + ": " + prgs.get(i).getNombre());
        }

    }

    // ------------------------------ Solicitar datos ------------------------------







    /** 
     * @return int
     */
    public int pedirHoras() 
    {
        System.out.println("\nIngrese las horas que ha estado el vehículo en el parqueo:");
        return scan.nextInt();
    }
    
    /** 
     * @return String
     */
    public String pedirPlaca()
    {
        System.out.println("\nIngrese la placa del vehículo:");
        scan.nextLine();
        return scan.nextLine();
    }
    
    /** 
     * @return String
     */
    public String pedirMarca()
    {
        System.out.println("\nIngrese la marca del vehículo:");
        return scan.nextLine();
    }
    
    /** 
     * @return int
     */
    public int pedirModelo()
    {
        System.out.println("\nIngrese el modelo del vehículo:");
        return scan.nextInt();
    }

    
    /** 
     * @param p
     * @param m
     * @param r
     * @param c
     */
    //Mostrar las estadísticas
    public void mostrarStats(Double p, int m, int r, String c)
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(" * El promedio de tiempo de uso del parqueo es de: " + p + " horas");
        System.out.println(" * El parqueo que más se utiliza es el número: " + m);
        System.out.println(" * Cuando el parqueo está lleno, se rechazan: " + r + " vehículos");
        System.out.println(" * Los parqueos más utilizados son de tamaño: " + c);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    //Mensaje de despedida
    public void mostrarDespedida()
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Muchas gracias por utilizar nuestro simulador!!!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
}
