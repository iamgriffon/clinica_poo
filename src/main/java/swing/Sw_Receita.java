package swing;

import entities.Consulta;
import entities.Receita;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Sw_Receita extends JFrame {

    private JPanel Jpanel;
    private JLabel lbl_title;
    private JLabel lbl_nome;
    private JTextArea txt_nome;
    private JLabel lbl_codigo;
    private JLabel lbl_cpf;
    private JTextArea txt_descritivo;
    private JLabel lbl_telefone;
    private JTextArea txt_codigo;
    private JTextArea txt_data;
    private JButton btn_gravar;
    private JLabel lbl_result;
    private JLabel lbl_nome_medico;
    private JLabel lbl_nome_paciente;
    private JPanel panel_receita;

    public Sw_Receita(Consulta consulta){
        setContentPane(panel_receita);
        while(consulta.getMedico().getNome() != null && consulta.getPaciente().getNome() != null){
            panel_receita.setVisible(true);
        }
        setTitle("Cadastro de Medicos");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Receita obj = new Receita();

        btn_gravar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    lbl_nome_medico.setText(consulta.getMedico().getNome());
                    lbl_nome_paciente.setText(consulta.getPaciente().getNome());
                    obj.setDescritivo(txt_descritivo.getText());
                    obj.setData(LocalDate.parse(txt_data.getText()));
                    obj.mostrar();
                } catch (Exception ex) {
                    lbl_result.setText("Ocorreu um erro: " + ex.getMessage());
                }

            }
        });


    }
}
