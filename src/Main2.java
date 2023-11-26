import entidades.Doctor;
import entidades.Paciente;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Main2 {
    public static void main(String[] args) {

        ArrayList<Doctor> lista = new ArrayList<Doctor>();
        Doctor a = new Doctor();
        a.setId("000000");
        a.setNombre("Roberto");
        a.setApPaterno("Costa");
        a.setApMaterno("Pérez");
        a.setEspecialidad("Neurología");
        a.setAñosExp(12);

        lista.add(a);
        try{
            FileOutputStream escribir =
                    new FileOutputStream("C:\\temp\\listaDoctores.txt");
            ObjectOutputStream miStream =
                    new ObjectOutputStream(escribir);
        miStream.writeObject(lista);
        miStream.close();
        //LEER lista desde archivo
            FileInputStream leer =
                    new FileInputStream("C:\\temp\\listaDoctores.txt");
            ObjectInputStream miStream2 =
                    new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Doctor> otraLista = (ArrayList<Doctor>)o;
            Doctor pruebaDoctor = otraLista.get(0);
            System.out.println(pruebaDoctor.getAñosExp());
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