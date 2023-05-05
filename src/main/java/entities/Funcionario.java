package entities;

public abstract class Funcionario {
    private String nome;
    private String telefone;
    private String senha;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return "************";
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void acessar(){
        System.out.println("Nome: " + getNome());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("senha" + getSenha());
    }

}
