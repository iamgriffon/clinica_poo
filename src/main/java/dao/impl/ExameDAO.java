package dao.impl;

import config.DataSourceConfig;
import dao.DAO;
import entities.Exame;
import entities.Receita;
import entities.Recepcionista;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ExameDAO implements DAO<Exame, Integer> {

    private DataSourceConfig conexao = new DataSourceConfig();

    public ExameDAO(){
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
    public Boolean insert(Exame obj){
        conexao.conectar();
        String Sql = "insert into exame(id_consulta,data_exame,descritivo) values(?,?,?)";
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
    public Boolean update(Exame obj){
        conexao.conectar();
        String Sql = "update exame set id_consulta = ?, set data_exame = ?, set descritivo = ? where id = ?";
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
        String Sql = "delete from exame where id = ?";
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
    public Exame select(Integer id){
        conexao.conectar();
        String Sql = "select * from exame where id=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, id);
            ResultSet retorno = stmt.executeQuery();
            if(!retorno.isClosed()){
                Exame obj = new Exame();
                obj.getConsulta().setId(retorno.getInt("id_consulta"));
                obj.setId(retorno.getInt("id"));
                obj.setData(LocalDate.parse(retorno.getString("data_exame")));
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
