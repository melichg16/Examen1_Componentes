package MainApp;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cifrar.CifrarConDependencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    static BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out= System.out;
    static ApplicationContext context = new ClassPathXmlApplicationContext("file:META-INF/beans.xml");
    static BeanFactory factory = context;
    static CifrarConDependencia test = (CifrarConDependencia) factory
            .getBean("CifrarConDependencia");

    static  CifrarConDependencia testV = (CifrarConDependencia) factory
            .getBean("CifrarConDependenciaV");

    public static void main(String[] args)throws IOException {
        boolean salir = false;
        do {
            MenuImpresion();
            int opcion = leerOpcion();
            salir = ejecutar(opcion);
        } while (!salir);



       /* System.out.println(test.runE());
        System.out.println(test.runD());

        System.out.println(testV.runE());
        System.out.println(testV.runD());*/


    }

    static void MenuImpresion() {
        out.println("1.Encripar texto con Cesar");
        out.println("2.Desencriptar texto con Cesar");
        out.println("3.Encripar texto con Vignere");
        out.println("4.Desencriptar texto con Vignere");
        out.println("5.Salir");
        out.println("--------------------");
    }//Fin del metodo del menu



    //Inicio del metodo de leerOpcion
    static int leerOpcion() throws IOException {
        out.print("Seleccione una opción: ");
        int opcion = Integer.parseInt(in.readLine());
        out.println(" ");
        return opcion;
    }//Fin del metodo de leerOpcion



    //Inicio del metodo de ejecutar
    static boolean ejecutar(int opcion) throws IOException {
        boolean salir = false;
        switch (opcion) {
            case 1:
              encriptarC();
                break;
            case 2:
                desencriptarC();
                break;
            case 3:
                encriptarV();
                break;
            case 4:
                desencriptarV();

                break;
            case 5:
                System.out.println("Bye");
                salir=true;
                break;
        }
        return salir;
    }//Fin del metodo de ejecutar

    private static void encriptarC() throws IOException {
        String texto;
        out.println("Ingrese el texto:");
        texto= in.readLine();
        System.out.println("El texto cifrado con el método César es:"+test.runE(texto));

    }

    private static void desencriptarC() throws IOException {
        String texto;
        out.println("Ingrese el texto:");
        texto= in.readLine();
        System.out.println("El texto descifrado con el método César es:"+test.runD(texto));
    }

    private static void encriptarV() throws IOException {
        String texto;
        out.println("Ingrese el texto:");
        texto= in.readLine();
        System.out.println("El texto cifrado con el método Vignere es:"+testV.runE(texto));
    }

    private static void desencriptarV() throws IOException {
        String texto;
        out.println("Ingrese el texto:");
        texto= in.readLine();
        System.out.println("El texto descifrado con el método Vignere es:"+testV.runD(texto));
    }
}
