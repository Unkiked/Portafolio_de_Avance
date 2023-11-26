import DAO.PacienteCRUD;
import entidades.Paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaPaciente extends JFrame{
    private JPanel miPanel;
    private JTextField txtId;
    private JLabel lblId;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JTextField txtApPaterno;
    private JLabel lblApPaterno;
    private JTextField txtApMaterno;
    private JLabel lblApMaterno;
    private JLabel lblFechaNac;
    private JTextField txtFechaNac;
    private JLabel lblPadecimiento;
    private JTextField txtPadecimiento;
    private JLabel lblSexo;
    private JComboBox cmbSexo;
    private JButton btnBuscar;
    private JButton btnAgregar;
    private JButton btnGuardar;
    private JButton btnEliminar;

    public ventanaPaciente() {
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //buscar pacientes
                PacienteCRUD crud = new PacienteCRUD();
                Paciente a = crud.buscarPacientePorId(txtId.getText());

                if(a == null){
                    JOptionPane.showMessageDialog(miPanel,"No se encontró el paciente");
                }else{
                    txtId.setText(a.getId());
                    txtNombre.setText(a.getNombre());
                    txtApPaterno.setText(a.getApPaterno());
                    txtApMaterno.setText(a.getApMaterno());
                    txtFechaNac.setText(String.valueOf(a.getFechaNacimiento()));
                    txtPadecimiento.setText(a.getPadecimiento());
                }
            }
        });
    }

    public static void main(String[] args) {
        ventanaPaciente v = new ventanaPaciente();
        v.setContentPane(v.miPanel);
        v.setSize(500,500);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }
}
