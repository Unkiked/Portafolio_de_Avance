import entidades.Doctor;
import entidades.Paciente;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ArrayList<Paciente> lista = new ArrayList<Paciente>();
        Paciente a = new Paciente();
        a.setId("000000");
        a.setNombre("Juanito");
        a.setApPaterno("Martinez");
        a.setApMaterno("Treviño");
        a.setSexo("Masculino");
        a.setPadecimiento("Dolor de espalda");

        Date fecha = new Date(25/11/2000);

        a.setFechaNacimiento(fecha);
        lista.add(a);
        try{
            FileOutputStream escribir =
                    new FileOutputStream("C:\\temp\\listaPacientes.txt");
            ObjectOutputStream miStream =
                    new ObjectOutputStream(escribir);
        miStream.writeObject(lista);
        miStream.close();
        //LEER lista desde archivo
            FileInputStream leer =
                    new FileInputStream("C:\\temp\\listaPacientes.txt");
            ObjectInputStream miStream2 =
                    new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Paciente> otraLista = (ArrayList<Paciente>)o;
            Paciente pruebaPaciente = otraLista.get(0);
            System.out.println(pruebaPaciente.getFechaNacimiento());
            miStream2.close();
        }catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        }catch(IOException e){
            System.out.println("Error E/S");
        }catch(ClassNotFoundException e){
            System.out.println("Error al leer lista de clase Pacientes");
        }
    }
}