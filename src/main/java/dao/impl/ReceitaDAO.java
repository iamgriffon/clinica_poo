package dao.impl;

import config.DataSourceConfig;
import dao.DAO;
import entities.Receita;
import entities.Recepcionista;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReceitaDAO implements DAO<Receita, Integer> {

    private DataSourceConfig conexao = new DataSourceConfig();

    public ReceitaDAO(){
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
    public Boolean insert(Receita obj){
        conexao.conectar();
        String Sql = "insert into receita(id_consulta,data_receita,descritivo) values(?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, obj.getConsulta().getId());
            stmt.setString(2, obj.getData().toString());
            stmt.setString(3, obj.getDescritivo());

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
    public Boolean update(Receita obj){
        conexao.conectar();
        String Sql = "update receita set id_consulta = ?, set data_receita = ?, set descritivo = ? where id = ?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, obj.getConsulta().getId());
            stmt.setString(2, obj.getData().toString());
            stmt.setString(3, obj.getDescritivo());
            stmt.setInt(4, obj.getId());
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
    public Boolean delete(Integer id){
        conexao.conectar();
        String Sql = "delete from receita where id = ?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{

            stmt.setInt(1, id);
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
    public Receita select(Integer id){
        conexao.conectar();
        String Sql = "select * from receita where id=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, id);
            ResultSet retorno = stmt.executeQuery();
            if(!retorno.isClosed()){
                Receita obj = new Receita();
                obj.getConsulta().setId(retorno.getInt("id_consulta"));
                obj.setId(retorno.getInt("id"));
                obj.setData(LocalDate.parse(retorno.getString("data_receita")));
                obj.setDescritivo(retorno.getString("descritivo"));
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
