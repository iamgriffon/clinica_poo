package swing;

import dao.impl.MedicoDAO;
import entities.Medico;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sw_medico extends JFrame{

    private JLabel lbl_nome;
    private JTextArea txt_codigo;
    private JTextArea txt_nome;
    private JLabel lbl_cpf;
    private JTextArea txt_cpf;
    private JLabel lbl_telefone;
    private JTextArea txt_telefone;
    private JComboBox cmb_sexo;
    private JButton btn_gravar;
    private JLabel lbl_result;
    private JPanel Jpanel;
    private JLabel lbl_title;
    private JLabel lbl_codigo;

    public Sw_medico(){
        setContentPane(Jpanel);
        setTitle("Cadastro de Medicos");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Medico obj = new Medico();

        btn_gravar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    obj.setSenha(txt_codigo.getText());
                    obj.setNome(txt_nome.getText());
                    obj.setCrm(txt_cpf.getText());
                    obj.setTelefone(txt_telefone.getText());
                    MedicoDAO medico = new MedicoDAO();
                    medico.insert(obj);
                    obj.mostrar();
                } catch (Exception ex) {
                    lbl_result.setText("Ocorreu um erro: " + ex.getMessage());
                }

            }
        });


    }
}
