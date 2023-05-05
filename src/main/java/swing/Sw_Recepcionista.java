package swing;

import dao.impl.ReceitaDAO;
import dao.impl.RecepcionistaDAO;
import entities.Recepcionista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sw_Recepcionista extends JFrame{
    private JLabel lbl_title;
    private JLabel lbl_nome;
    private JTextArea txt_nome;
    private JLabel lbl_codigo;
    private JLabel lbl_cpf;
    private JTextArea txt_cpf;
    private JLabel lbl_telefone;
    private JTextArea txt_codigo;
    private JTextArea txt_telefone;
    private JButton btn_gravar;
    private JLabel lbl_result;
    private JPanel painel_recepcionista;

    public Sw_Recepcionista(){
        setContentPane(painel_recepcionista);
        setTitle("Cadastro de Medicos");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Recepcionista obj = new Recepcionista();

        btn_gravar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    obj.setSenha(txt_codigo.getText());
                    obj.setNome(txt_nome.getText());
                    obj.setCpf(txt_cpf.getText());
                    obj.setTelefone(txt_telefone.getText());
                    RecepcionistaDAO dao = new RecepcionistaDAO();
                    dao.insert(obj);
                    obj.mostrar();
                } catch (Exception ex) {
                    lbl_result.setText("Ocorreu um erro: " + ex.getMessage());
                }

            }
        });


    }
}
