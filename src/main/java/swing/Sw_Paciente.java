package swing;

import entities.Paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sw_Paciente extends JFrame{
    private JPanel panel_paciente;
    private JLabel lbl_title;
    private JTextArea txt_codigo;
    private JTextArea txt_nome;
    private JTextArea txt_cpf;
    private JTextArea txt_telefone;
    private JLabel lbl_codigo;
    private JLabel lbl_nome;
    private JLabel lbl_cpf;
    private JLabel lbl_telefone;
    private JComboBox cmb_sexo;
    private JLabel lbl_sexo;
    private JButton btn_gravar;
    private JLabel lbl_result;

    public Sw_Paciente(){
        cmb_sexo.addItem("Feminino");
        cmb_sexo.addItem("Maculino");

        setContentPane(panel_paciente);
        setTitle("Cadastro de Pacientes");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Paciente obj = new Paciente();

        btn_gravar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    obj.setNumero(Integer.parseInt(txt_codigo.getText()));
                    obj.setNome(txt_nome.getText());
                    obj.setCpf(txt_cpf.getText());
                    obj.setTelefone(txt_telefone.getText());
                    obj.setGenero(cmb_sexo.getSelectedItem().toString());
                    obj.mostrar();
                } catch (Exception ex) {
                    lbl_result.setText("Ocorreu um erro: " + ex.getMessage());
                }

            }
        });


    }


}
