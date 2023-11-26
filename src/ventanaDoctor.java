import DAO.DoctorCRUD;
import entidades.Doctor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaDoctor extends JFrame{
    private JPanel miPanel;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtApPaterno;
    private JTextField txtApMaterno;
    private JTextField txtEspecialidad;
    private JTextField txtExp;
    private JButton btnBuscar;
    private JButton btnAgregar;
    private JButton btnGuardar;
    private JButton btnEliminar;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblApPaterno;
    private JLabel lblApMaterno;
    private JLabel lblEspecialidad;
    private JLabel lblExp;

    public ventanaDoctor() {
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //buscar doctores
                DoctorCRUD crud = new DoctorCRUD();
                Doctor a = crud.buscarDoctorPorId(txtId.getText());

                if(a == null){
                    JOptionPane.showMessageDialog(miPanel,"No se encontró el doctor");
                }else{
                    txtId.setText(a.getId());
                    txtNombre.setText(a.getNombre());
                    txtApPaterno.setText(a.getApPaterno());
                    txtApMaterno.setText(a.getApMaterno());
                    txtEspecialidad.setText(String.valueOf(a.getEspecialidad()));
                    txtExp.setText(String.valueOf(a.getAñosExp()));
                }
            }
        });
    }
    public static void main(String[] args) {
        ventanaDoctor v = new ventanaDoctor();
        v.setContentPane(v.miPanel);
        v.setSize(500,500);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }
}
