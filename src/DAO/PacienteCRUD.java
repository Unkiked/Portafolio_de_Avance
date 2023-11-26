package DAO;

import entidades.Paciente;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class PacienteCRUD {

    public Paciente buscarPacientePorId(String id){
        //obtener lista de pacientes desde el archivo
        try{
            FileInputStream leer =
                    new FileInputStream("C:\\temp\\listaPacientes.txt");
            ObjectInputStream miStream2 =
                    new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Paciente> otraLista = (ArrayList<Paciente>)o;
            for(Paciente a: otraLista){
                if(a.getId().equals(id)){
                    return a;
                }
            }
            //salimos del for
            miStream2.close();
            return null;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
