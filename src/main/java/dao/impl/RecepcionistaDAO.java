package dao.impl;

import config.DataSourceConfig;
import dao.DAO;
import entities.Medico;
import entities.Recepcionista;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecepcionistaDAO implements DAO<Recepcionista, String> {

    private DataSourceConfig conexao = new DataSourceConfig();

    public RecepcionistaDAO(){
        try{
            if(this.conexao.conectar()){
                System.out.println("Banco de dados conectado !!");
            }
        }
        catch(Exception err){
            System.err.println(err.getMessage());
        }
        finally{
            conexao.descontecar();
        }
    }

    @Override
    public Boolean insert(Recepcionista obj){
        conexao.conectar();
        String Sql = "insert into recepcionista(cpf,nome,telefone, senha) values(?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setString(1, obj.getCpf());
            stmt.setString(2, obj.getNome());
            stmt.setString(3, obj.getTelefone());
            stmt.setString(4, obj.getSenha());

            return stmt.execute();
        }
        catch(SQLException err){
            System.err.println(err.getMessage());
            return false;
        }
        finally{
            conexao.descontecar();
        }
    }

    @Override
    public Boolean update(Recepcionista obj){
        conexao.conectar();
        String Sql = "update recepcionista set nome = ?, set telefone = ?, set senha = ? where cpf = ?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getTelefone());
            stmt.setString(3, obj.getSenha());
            stmt.setString(4, obj.getCpf());
            return stmt.execute();
        }
        catch(SQLException err){
            System.err.println(err.getMessage());
            return false;
        }
        finally{
            conexao.descontecar();
        }
    }

    @Override
    public Boolean delete(String cpf){
        conexao.conectar();
        String Sql = "delete from recepcionista where cpf = ?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{

            stmt.setString(1, cpf);
            return stmt.execute();
        }
        catch(SQLException err){
            System.err.println(err.getMessage());
            return false;
        }
        finally{
            conexao.descontecar();
        }
    }

    @Override
    public Recepcionista select(String cpf){
        conexao.conectar();
        String Sql = "select * from recepcionista where cpf=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setString(1, cpf);
            ResultSet retorno = stmt.executeQuery();
            if(!retorno.isClosed()){
                Recepcionista obj = new Recepcionista();
                obj.setCpf(retorno.getString("cpf"));
                obj.setNome(retorno.getString("nome"));
                obj.setTelefone(retorno.getString("telefone"));
                obj.setSenha(retorno.getString("senha"));
                return obj;
            } else {
                return null;
            }
        }
        catch(SQLException err){
            System.err.println(err.getMessage());
            return null;
        }
        finally{
            conexao.descontecar();
        }
    }

}
