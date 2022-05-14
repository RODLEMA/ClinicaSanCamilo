import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Main {
    static BaseDeDatos bd = new BaseDeDatos();

    public static void main(String[] args) {
        Bienvenida();
        clearScreen();
        inicioSesion();
    }


    private static void Bienvenida() {
        bd.inicializar();
        Scanner in = new Scanner(System.in);

        System.out.println("Hola! Bienvenido a Clinica San Camilo");
        System.out.println("Por favor, ingrese nombre y apellido");

        String entrada = in.nextLine();

        System.out.println("Hola " + entrada + " Bienvenido!!");
        System.out.println("Presione enter para continuar");
        entrada = in.nextLine();

    }


    //INICIO DE SESION
    public static void inicioSesion() {
        Scanner in = new Scanner(System.in);
        boolean inicioExitoso = false;
        Usuario user = new Usuario();
        while (inicioExitoso != true) {
            System.out.println("Por favor ingrese nombre de usuario: ");
            String userName = in.nextLine();
            System.out.print("Por favor ingrese contraseña: ");
            String password = in.nextLine();
            user = bd.buscarUsuario(userName);
            if(user != null && password.equals(user.password)){
                inicioExitoso = true;
            }
            else{
                System.out.println("Usuario no encontrado, por favor intente nuevamente. ");
            }

        }
        if(user.type == 1) {
            menuMedico(user);
        }
        else{
            menuAdmin(user);
        }
    }

    //PARA LIMPIAR PANTALLA
    private static void clearScreen() {
            System.out.print("\033[H\033[2J");
            System.out.flush();
    }

    //MENU ADMINISTRADOR
    private static void menuAdmin(Object buscarAdministativo) {
    }

    //MENU MEDICO
    private static void menuMedico(Usuario user) {
        System.out.println("Por favor elija una opcion: ");
        System.out.println("1. Agenda: ");
        System.out.println("2. Historia Clinica Paciente ");
        Scanner in = new Scanner(System.in);
        int opcion = in.nextInt();
        switch (opcion){
            case 1-> mostrarAgenda(user);
            default-> System.out.println("Opcion invalida. ");
        }
    }
    private static void mostrarAgenda(Usuario user){
        Agenda agenda = bd.buscarAgenda(user);
        for (int i=0; i<agenda.citas.size(); i++){
            Cita cita = agenda.citas.get(i);
            System.out.println("Dia: " + cita.dia);
            System.out.println("Horario: " + cita.horario);
            System.out.println("Nombre de paciente: " + cita.paciente.nombre + " " + cita.paciente.apellido);
            System.out.println("Prepaga: " + cita.paciente.prepaga);
        }
    }
}





