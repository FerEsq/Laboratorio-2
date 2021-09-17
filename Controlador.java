
/* Nombre: Controlador.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el xx.09.2021
 			  Modificado el xx.09.2021 */

//Import
import java.util.Scanner;
import java.io.File;  
import java.io.IOException;
import java.security.PublicKey;
import java.io.FileNotFoundException;  
import java.util.ArrayList;  

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

		Memoria RAM = new Memoria("DDR");
        /*String cad = "2,4,6";
        String[] pos;
        pos = cad.split(",");*/

        //RAM.leerArchivo();
        //RAM.ingresarProgramas(pos);
        
		//Mensajes de bienvenida	
		vista.mostrarInicio();	

        vista.mostrarProgramas(RAM.getProgramas());
				
		/*while (opcion != 11)
		{
			//Menú		
			opcion = vista.mostrarMenu();

			if (opcion == 1) //ingresar vehículo
			{
				int h = vista.pedirHoras();
				String p = vista.pedirPlaca();
				String ma = vista.pedirMarca();
				int mo = vista.pedirModelo();
				Vehiculo v = new Vehiculo(p, ma, mo, h);
				est.ingresarVehiculo(v);
				
			}

			if (opcion == 2) //retirar vehículo
			{
				String p1 = vista.pedirPlaca();
				est.retirarVehiculo(p1);
				
			}

			if (opcion == 3) //mostrar estadísticas
			{
				vista.mostrarStats(est.getPromedio(), est.getUtilizado(), est.getLleno(), est.getCaracteristica());
			}

			if (opcion == 11) //salir
			
			{
				vista.mostrarDespedida();
			}

			//Otra ocpión
			if (opcion > 11)
			{
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Esa opción no existe, intente de nuevo");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			}
		}*/
	}
}
