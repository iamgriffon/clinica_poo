package entities;

import java.time.LocalDate;
import java.util.logging.Logger;
import java.util.logging.Level;
public class Recepcionista extends Funcionario {
     private String cpf;
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

    private Logger logger = Logger.getLogger(Recepcionista.class.getName());

    public Recepcionista(){}

    public Recepcionista(String _nome, String _cpf,
                         String _telefone, String _senha){
        try {
            setNome(_nome);
            setCpf(_cpf);
            setTelefone(_telefone);
            setSenha(_senha);
        }
        catch(Exception err){
            setNome("");
            setCpf("");
            setTelefone("");
            setSenha("");
            logger.log(Level.WARNING, "Ocorreu uma exceção – Valores padrões definidos");
        }
    }



    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



    public void acessar(){
        super.acessar();
        System.out.println("CPF: " + getCpf());
    }

    public void mostrar(){
        System.out.println("RECEPCIONISTA\n===============");
        System.out.println("nome="+getNome());
        System.out.println("cpf="+getCpf());
        System.out.println("telefone="+getTelefone());
        System.out.println("senha="+getSenha());
    }

    public void cadastrarPaciente(String cpf,
                                  String genero,
                                  String telefone,
                                  String nome) throws Exception {
        Paciente obj = new Paciente();
        obj.setCpf(cpf);
        obj.setGenero(genero);
        obj.setTelefone(telefone);
        obj.setNome(nome);
        logger.log(Level.INFO,"entities.Paciente cadastrado com sucesso!");
    }

    public Consulta marcarConsulta(Medico medico, Paciente paciente,
                               String hora, String motivo) {
        Consulta c1 = new Consulta(LocalDate.now(), hora,
                medico, paciente, motivo, "");
        logger.log(Level.INFO, "entities.Consulta marcada !!!");
        return c1;
    }
}
