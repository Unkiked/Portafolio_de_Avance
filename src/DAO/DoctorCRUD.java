package DAO;

import entidades.Doctor;
import entidades.Paciente;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DoctorCRUD {

    public Doctor buscarDoctorPorId(String id){
        //obtener lista de Doctores desde el archivo
        try{
            FileInputStream leer =
                    new FileInputStream("C:\\temp\\listaDoctores.txt");
            ObjectInputStream miStream2 =
                    new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Doctor> otraLista = (ArrayList<Doctor>)o;
            for(Doctor a: otraLista){
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
