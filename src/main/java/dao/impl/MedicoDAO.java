package dao.impl;

import config.DataSourceConfig;
import dao.DAO;
import entities.Medico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicoDAO implements DAO<Medico, String> {

    private DataSourceConfig conexao = new DataSourceConfig();

    public MedicoDAO(){
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
    public Boolean insert(Medico obj){
        conexao.conectar();
        String Sql = "insert into medico(crm,nome,telefone, senha, especialidade) values(?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setString(1, obj.getCrm());
            stmt.setString(2, obj.getNome());
            stmt.setString(3, obj.getTelefone());
            stmt.setString(4, obj.getSenha());
            stmt.setString(5, obj.getEspecialidade());
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
    public Boolean update(Medico obj){
        conexao.conectar();
        String Sql = "update medico set nome = ?, set telefone = ?, set senha = ?, set especialidade = ? where crm = ?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getTelefone());
            stmt.setString(3, obj.getSenha());
            stmt.setString(4, obj.getEspecialidade());
            stmt.setString(5, obj.getCrm());
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
    public Boolean delete(String crm){
        conexao.conectar();
        String Sql = "delete from medico where crm = ?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{

            stmt.setString(1, crm);
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
    public Medico select(String crm){
        conexao.conectar();
        String Sql = "select * from medico where crm=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setString(1, crm);
            ResultSet retorno = stmt.executeQuery();
            if(!retorno.isClosed()){
                Medico obj = new Medico();
                obj.setCrm(retorno.getString("crm"));
                obj.setNome(retorno.getString("nome"));
                obj.setTelefone(retorno.getString("telefone"));
                obj.setSenha(retorno.getString("senha"));
                obj.setEspecialidade(retorno.getString("especialidade"));
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
