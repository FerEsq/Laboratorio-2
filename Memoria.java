
/* Nombre: Memoria.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 16.09.2021
 			  Modificado el 17.09.2021 */

//import
import java.util.Scanner;
import java.io.File;  
import java.io.IOException;
import java.security.PublicKey;
import java.io.FileNotFoundException;  
import java.util.ArrayList;     
import java.io.FileWriter;
import java.lang.IndexOutOfBoundsException;
import java.util.function.Predicate;

public class Memoria 
{
    private File archivo = new File("Programas.txt");
    private ArrayList <Programa> programas = new ArrayList<Programa>();
    private ArrayList <Programa> ejecucion = new ArrayList<Programa>();
    private ArrayList <Programa> cola = new ArrayList<Programa>();
    private ArrayList <Programa> select = new ArrayList<Programa>(); //se agrego un array para guardar los programas seleccionados por el usuario
    private ArrayList <Programa> finalizados = new ArrayList<Programa>(); //se agrego un array para mostrar los programas finalizados
    private String[] datos; //se agrego un array para almacenar los datos de los programas del archivo
    private String tipo;
    private int tamanio;
    private int bloques;
    private int contador; //se agregó un contador para los bloques vacios
    private int ciclos; //se agrego un contador de ciclos de reloj

    //Se implementaron dos constructores para hacer uso correcto de la sobrecarga
    public Memoria(String ti, int ta) //constructor memoria SDR
    {
        tipo = ti;
        tamanio = ta;
        bloques = (tamanio * 1024) / 64;
        contador = bloques;
        ciclos = 0;
        //al crear una nueva memoria se reinicia todo
        ejecucion.clear();
        cola.clear();
        select.clear();
        finalizados.clear();
    }

    public Memoria(String ti) // constructor memoria DDR
    {
        tipo = ti;
        tamanio = 4;
        bloques = 64;
        contador = bloques;
        ciclos = 0;
        //al crear una nueva memoria se reinicia todo
        ejecucion.clear();
        cola.clear();
        select.clear();
        finalizados.clear();
    }

    private void leerArchivo() 
    {
        //validación
        try 
        {    
            programas.clear(); //limpiar arraylist de seleccionados (los programas se reemplazan) 
            Scanner lector = new Scanner(archivo); //leer archivo
            while (lector.hasNextLine()) //analizar archivo linea poe linea
            {
                datos = lector.nextLine().split(",");
                
                 //convertir datos del archivo a objetos de clase Programa
                Programa p = new Programa(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2]));
                programas.add(p);
            }
            lector.close(); //cerrar archivo
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Error de lectura del archivo");
        }
    }
    
    /** 
     * @return ArrayList
     */
    //se agregó un método que devuelve los programas instalados para mostrarlos en pantalla
    public ArrayList getProgramas() //obtener programas instalados
    {
        leerArchivo();
        return programas;
    }
    
    /** 
     * @param prg
     */
    public void ingresarProgramas(String[] prg) //ingresar programas seleccionados por el usuario a la ram
    {
        //validación
        try
        {
            select.clear(); //limpiar arraylist de seleccionados (los programas se reemplazan)

            for(int i = 0; i < prg.length; i++) //ingresar programas seleccionadas al array select
            {
                select.add( programas.get(Integer.parseInt(prg[i])) );
            }

            for (int i = 0; i < select.size(); i++) //recorrer array select
            {
                if (contador > 0) //si aun hay bloques vacios
                {
                    if (contador >= select.get(i).getBloques()) //si el programa cabe en la memoria
                    {
                        select.get(i).setEjecutadoT();
                        ejecucion.add(select.get(i)); //ingresar programa a array de ejecutados
                        contador = contador - select.get(i).getBloques(); //restar los bloques que ocupa 
                    }
                    else //si el programa no cabe
                    {
                        cola.add(select.get(i)); //se ingresa a la cola
                    }
                }
                else //si ya no hay bloques vacios
                {
                    cola.add(select.get(i)); //se ingresa a la cola
                }
            }      
        }
        catch (IndexOutOfBoundsException e) //error
         {
            System.out.println("Alguno de los programas que ha ingresado no se encuentra instalado. Porfavor inténtelo de nuevo.");
         }
    }
    
    /** 
     * @return int
     */
    public int getTotal() //total de memoria en MB
    {
        return tamanio * 1024;
    }
    
    /** 
     * @return int
     */
    public int getDisponible() //memoria disponible en MB
    {
        int d = contador * 64;        
        return d;
    }
    
    /** 
     * @return int
     */
    public int getUso() //memoria en uso en MB
    {
        int u = (bloques - contador) * 64;
        return u;
    }
    
    /** 
     * @return String[]
     */
    public String[] getEjecucion()  
    {
        String[] prgs = new String[ejecucion.size()]; //vector con los nombres de los programas
        for (int i = 0; i < ejecucion.size(); i++)
        {
            prgs[i] = ejecucion.get(i).getNombre(); //agregar nombres al vector
        }
        return prgs; //devolver
    }

    
    /** 
     * @return String[]
     */
    public String[] getCola() 
    {
        String[] prgs = new String[cola.size()]; //vector con los nombres de los programas
        for (int i = 0; i < cola.size(); i++)
        {
            prgs[i] = cola.get(i).getNombre(); //agregar nombres al vector
        }
        return prgs; //devolver
    }
    
    /** 
     * @param name
     * @return int[]
     */
    public int[] getPosicion(String name) 
    {
        int p = -1; //posicion del programa
        int c = 0; //contador de bloques
        int[] posi = new int[2]; //array con bloque inicial y bloque final

        for (int i = 0; i < ejecucion.size(); i++) //Recorrer array ejecucion
        {
            if ((ejecucion.get(i).getNombre()).equals(name)) //buscar el programa
            {
                p = i; //guardar su posicion
            }
        }
        if (p == -1) //si no se encuentra el programa
        {
            return null; //vector vacio
        }
        else //sí si se encuentra el programa
        {
            for (int i = 0; i < p; i++)
            {
                c = c + ejecucion.get(i).getBloques(); //bloque inicial
            }
            posi[0] = c;
            posi[1] = c + ejecucion.get(p).getBloques(); //bloque final
            return posi; //devolver
        }
    }
    
    /** 
     * @return int[]
     */
    public int[] getEstado() //estado de la memoria
    {
        int[] espacios = new int[2]; 
        espacios[0] = bloques - contador; //en uso
        espacios[1] = contador; //vacios
        return espacios;
    }

    public void makeCiclo()
    {
        ciclos++;
        setTamanio();
        Predicate<Programa> con = p -> (p.getCiclos() == 0); //si ya no le quedan ciclos
        Predicate<Programa> con2 = pr -> (pr.getEjecutado() == true); //si ya esta siendo ejecutado

        System.out.println("Antes: " + contador);

        //eliminar programas finalizados
        for (int i = 0; i < ejecucion.size(); i++)
        {
            ejecucion.get(i).setCiclos(); //restarle un ciclo a cada uno

            if (con.test(ejecucion.get(i)) == true) //si ya no le quedan ciclos (ciclos = 0)
            {
                contador = contador + ejecucion.get(i).getBloques(); //se agregan sus bloques al contador
                ejecucion.get(i).setEjecutadoF(); //se cambia su estado (no ejecutado)
                finalizados.add(ejecucion.get(i)); //se agrega al array de finalizados
            }
        }
        ejecucion.removeIf(con); //se remueven los programas finalizados del array de ejecución

        for (int i = 0; i < cola.size(); i++) //recorrer array 
        {
            if (contador > 0) //si aun hay bloques vacios
            {
                if (contador >= cola.get(i).getBloques()) //si el programa cabe en la memoria
                {
                    cola.get(i).setEjecutadoT(); //se cambia su estado (ejecutado)
                    ejecucion.add(cola.get(i)); //ingresar programa a array de ejecutados
                    contador = contador - cola.get(i).getBloques(); //restar los bloques que ocupa 
                }
            }
            else //si ya no hay bloques vacios
            {
                break;
            }
        }
        cola.removeIf(con2); //se remueven los programas ejecutados de la cola
        System.out.println("Después: " + contador);
    }
    
    /** 
     * @return ArrayList
     */
    //se agregó un método que devuelve los programas finalizados para mostrarlos en pantalla
    public ArrayList getFinalizados() //obtener programas finalizados
    {
        return finalizados;
    }
    
    /** 
     * @return int
     */
    //se agregó un método que devuelve la cantidad de ciclos de reloj realizados para mostrarlos en pantalla
    public int getCiclos()
    {
        return ciclos;
    }

    private void setTamanio()
    {
        if (tipo.equals("DDR"))
        {
            if (cola.size() != 0) //si la cola no esta vacia
            {
                tamanio = tamanio * 2;
                bloques = bloques * 2;
                contador = bloques / 2;
            }
            else if (cola.size() == 0 && contador >= bloques / 2 && tamanio != 4) //si la cola esta vacia, hay muchos bloques vacios y el tamaño no es el minimo
            {
                tamanio = tamanio / 2;
                bloques = bloques / 2;
                contador = contador - bloques / 2;
            }
        }
    }
}
