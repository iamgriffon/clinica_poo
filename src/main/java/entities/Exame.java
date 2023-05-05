package entities;

import java.time.LocalDate;
import java.util.logging.Logger;
import java.util.logging.Level;
public class Exame extends Procedimento{
    private Logger logger = Logger.getLogger(Exame.class.getName());

    public Exame(){}

    public Exame(Consulta _consulta, LocalDate _data,
                 String _descritivo){
        try {
            this.consulta = _consulta;
            this.data = _data;
            this.descritivo = _descritivo;
        } catch (Exception err){
            this.consulta = new Consulta();
            this.data = LocalDate.now();
            this.descritivo = "";
            logger.log(Level.WARNING, "Ocorreu uma exceção – Valores padrões definidos");
        }
    }

    public void preescrever(){
        super.consultar();
    }

    public void mostrar(){
        System.out.println("EXAME\n===============");
        System.out.println("data="+this.data.toString());
        this.consulta.mostrar();
        System.out.println("descritivo="+this.descritivo);
    }
}
