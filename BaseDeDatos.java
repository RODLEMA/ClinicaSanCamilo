import java.util.*;

public class BaseDeDatos {
    public static HashMap<String, Usuario> users;
    public static HashMap<String, Agenda> agendas;
    public static HashMap<Integer, Paciente> pacientes;
    public static void inicializar(){
        users = new HashMap<String, Usuario>();
        pacientes = new HashMap<Integer, Paciente>();
        users.put("RLEMA", new Usuario ("RLEMA", "1111", 1));
        users.put("JPEREZ", new Usuario ("JPEREZ", "2222", 1));
        users.put("PMEDINA", new Usuario ("PMEDINA", "3333", 1));
        users.put("CALBERTO", new Usuario ("CALBERTO", "4444", 2));
        users.put("JLAFITE", new Usuario ("JLAFITE", "5555", 2));
        users.put("MDELCARMEN", new Usuario ("MDELCARMEN", "6666", 2));
        pacientes.put(33123123, new Paciente("CARLOS", 33,"MARTINEZ", 33123123, "OSDE"));
        pacientes.put(26124124, new Paciente("JUAN", 42,"FRANCO", 26124124, "SWISS MEDICAL"));
        pacientes.put(15125125, new Paciente("JOAQUIN", 55,"ROBERTO", 15125125, "GALENO"));
        List <Cita> citas = new ArrayList<>();
        Cita cita1 = new Cita("12:00", "15/05/2022", pacientes.get(33123123));
        Cita cita2 = new Cita("12:00", "15/05/2022", pacientes.get(26124124));
        Cita cita3 = new Cita("12:00", "15/05/2022", pacientes.get(15125125));
        ArrayList<Cita> lista1 = new ArrayList<>();
        ArrayList<Cita> lista2 = new ArrayList<>();
        ArrayList<Cita> lista3 = new ArrayList<>();
        lista1.add(cita1);
        lista2.add(cita2);
        lista3.add(cita3);
        agendas = new HashMap<String, Agenda>();
        agendas.put("RLEMA", new Agenda(lista1));
        agendas.put("JPEREZ", new Agenda(lista2));
        agendas.put("PMEDINA", new Agenda(lista3));
    }
    public Usuario buscarUsuario(String userName){
        return users.get(userName);
    }

    public Agenda buscarAgenda(Usuario user) {
        return agendas.get(user.userName);


    }
}