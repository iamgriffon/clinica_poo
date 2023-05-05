package entities;

import java.time.LocalDate;
import java.util.logging.Logger;
import java.util.logging.Level;
public class Medico extends  Funcionario {
    private String especialidade;
    private String crm;
    private String nome;
    private String telefone;
    private String senha;

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getTelefone() {
        return telefone;
    }

    @Override
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    @Override
    public void setSenha(String senha) {
        this.senha = senha;
    }

    private Logger logger = Logger.getLogger(Medico.class.getName());

    public Medico(){};
    public Medico(String _nome, String _telefone,
                  String _especialidade, String _crm, String _senha){
        try {
            setNome(_nome);
            setTelefone(_telefone);
            setEspecialidade(_especialidade);
            setCrm(_crm);
            setSenha(_senha);
        }
        catch(Exception err){
            setNome("");
            setTelefone("");
            setEspecialidade("");
            setCrm("");
            setSenha("");
            logger.log(Level.WARNING, "Ocorreu uma exceção – Valores padrões definidos");
        }

    }



    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }


    public void acessar(){
        super.acessar();
        System.out.println("CRM: " + getCrm());
        System.out.println("Especialidade: " + getEspecialidade());
    }

    public void mostrar(){
        System.out.println("MEDICO\n===============");
        System.out.println("nome="+getNome());
        System.out.println("crm="+getCrm());
        System.out.println("telefone="+getTelefone());
        System.out.println("especialidade="+getEspecialidade());
        System.out.println("senha="+getSenha());
    }

    public void preescrever(Consulta consulta, String descritivo){
        Receita r1 = new Receita();
        r1.setDescritivo(descritivo);
        r1.setData(LocalDate.now());
        r1.setConsulta(consulta);
        logger.log(Level.INFO,"entities.Receita cadastrada com sucesso");
    }

    public void solicitarExame(Consulta consulta, String descritivo){
        Exame r1 = new Exame();
        r1.setDescritivo(descritivo);
        r1.setData(LocalDate.now());
        r1.setConsulta(consulta);
        logger.log(Level.INFO,"entities.Exame cadastrado com sucesso");
    }
}
