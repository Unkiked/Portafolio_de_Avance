import DAO.PacienteCRUD;
import entidades.Paciente;
import DAO.DoctorCRUD;
import entidades.Doctor;
public class prueba {
    public static void main(String[] args) {

        PacienteCRUD crud = new PacienteCRUD();
        Paciente a = crud.buscarPacientePorId("000000");
        if(a==null)
            System.out.println("No se encontro el paciente");
        else
            System.out.println(a.getNombre()+ " " + a.getApPaterno()+ " "+ a.getApMaterno() );

        DoctorCRUD cru = new DoctorCRUD();
        Doctor b = cru.buscarDoctorPorId("000000");
        if(b==null)
            System.out.println("No se encontro el paciente");
        else
            System.out.println(b.getNombre()+ " " + b.getApPaterno()+ " "+ b.getApMaterno() );
    }
}
