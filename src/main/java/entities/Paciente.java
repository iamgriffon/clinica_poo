package entities;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Paciente {
    private String nome;
    private String cpf;
    private String telefone;
    private String genero;
    private int numero;
    private Logger logger = Logger.getLogger(Paciente.class.getName());

    public Paciente(){

    }
    public Paciente(String _nome, String _cpf, String _telefone,
                    String _genero, int _numero) {
        try {
            this.nome = _nome;
            this.telefone = _telefone;
            this.genero = _genero;
            this.cpf = _cpf;
            this.numero = _numero;
        } catch(Exception err){
            this.nome = "";
            this.telefone = "";
            this.genero = "";
            this.cpf = "";
            this.numero = 0;
            logger.log(Level.WARNING, "Ocorreu uma exceção – Valores padrões definidos");
        }
    }

    public String nomeCompleto(){
        String ret = "";
        try{
            ret = this.nome.toUpperCase() + ","+ this.telefone +","+
                 this.genero +","+ this.cpf + ","+
                 this.numero;
        }
        catch (Exception erro){
            ret = "Objeto Vazio, verifique";
            System.out.println(erro.getMessage());
        }
        return ret;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws Exception  {
        if(cpf==null || cpf.length()!=11){
            throw new Exception("cpf invalido !!");
        } else {
            this.cpf = cpf;
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int text) {
        this.numero = numero;
    }

    public void cadastrar(){
        //TODO
    }
    public void consultar() {
        //TODO
    }

    public void mostrar(){
        System.out.println("PACIENTE\n===============");
        System.out.println("nome="+this.nome);
        System.out.println("cpf="+this.cpf);
        System.out.println("telefone="+this.telefone);
        System.out.println("genero"+this.genero);
        System.out.println("numero"+this.numero);
    }

}
