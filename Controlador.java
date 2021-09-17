
/* Nombre: Controlador.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 16.09.2021
 			  Modificado el xx.09.2021 */

//Import
import java.util.Scanner;
import java.io.File;  
import java.io.IOException;
import java.security.PublicKey;
import java.io.FileNotFoundException;  
import java.util.ArrayList;  
import java.lang.NullPointerException;
import java.util.InputMismatchException;
import java.lang.NumberFormatException;

//Clase Controlador
class Controlador
{	
	/** 
	 * @param args
	 */
	public static void main(String[] args)
	{
        int opcion = 0;
        Vista vista = new Vista();
		Memoria RAM = null;
        
		//Mensajes de bienvenida
        vista.mostrarInicio();	
				
		while (opcion != 11)
		{
			//Menú        	
            try  
            {  
                opcion = vista.mostrarMenu();

                if (opcion == 1) //inicializar simulador (crear RAM)
                {
                    String type = vista.pedirTipo();
                    if (type.equals("SDR"))
                    {
                        int size = vista.pedirTamanio();
                        RAM = new Memoria(type, size);
                    }
                    else if (type.equals("DDR"))
                    {
                        RAM = new Memoria(type);
                    }			
                }

                if (opcion == 2) //ingresar programas
                {
                    try
                    {
                        vista.mostrarProgramas(RAM.getProgramas());
                        String cadena = vista.pedirProgramas();
                        String[] select = cadena.split(",");
                        try
                        {
                            RAM.ingresarProgramas(select);
                        }
                        catch (NumberFormatException e)
                        {
                            System.out.println("Ingrese los programas en el formato indicado. Porfavor inténtelo de nuevo. \n");
                        }
                        
                    }
                    catch (NullPointerException e)
                    {
                        System.out.println("Primero debe inicializar el simulador. Porfavor inténtelo de nuevo. \n");
                    }
                }

                if (opcion == 3) //RAM total
                {
                    vista.mostrarTotal(RAM.getTotal());
                }

                if (opcion == 4) //RAM disponible
                {
                    vista.mostrarDisponible(RAM.getDisponible());
                }

                if (opcion == 5) //RAM en uso
                {
                    vista.mostrarUso(RAM.getUso());
                }

                if (opcion == 6) //programas en ejecución
                {
                    vista.mostrarEjecucion(RAM.getEjecucion());
                }

                if (opcion == 7) //programas en cola
                {
                    vista.mostrarCola(RAM.getCola());
                }

                if (opcion == 8) //posición de un programa
                {
                    String name = vista.pedirPrograma();
                    vista.mostrarPosicion(RAM.getPosicion(name));
                }

                if (opcion == 9) //estado de la memoria
                {
                    vista.mostrarEstado(RAM.getEstado());
                }

                if (opcion == 10) //ciclo de reloj
                {
                    System.out.println("Seguimos trabajando en ello ;)");
                }

                if (opcion == 11) //salir
                {
                    vista.mostrarDespedida();
                }

                //Otra ocpión
                if (opcion > 11)
                {
                    vista.mostrarOpcion();
                }
            }
            catch (InputMismatchException e)
            {
                vista.mostrarError();
                break;
            }
		}
	}
}
