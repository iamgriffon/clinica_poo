package entities;

import swing.Sw_Paciente;
import swing.Sw_medico;

import java.time.LocalDate;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Consulta  extends Agenda {
    private Integer id;
    private String motivo;
    private String historico;
    private Medico medico;
    private Paciente paciente;
    private LocalDate data;
    private String hora;

    private Logger logger = Logger.getLogger(Consulta.class.getName());

    public Consulta(Sw_Paciente paciente, Sw_medico medico){


    }

    public Consulta(){}

    public Consulta(LocalDate _data, String _hora,
                    Medico _medico, Paciente _paciente,
                    String _motivo, String _historico){
        try {
            this.data = _data;
            this.hora = _hora;
            this.medico = _medico;
            this.paciente = _paciente;
            this.motivo = _motivo;
            this.historico = _historico;
        }
        catch (Exception err) {
            this.data = LocalDate.now();
            this.hora = "";
            this.medico = new Medico();
            this.paciente = new Paciente();
            this.motivo = "";
            this.historico = "";
            logger.log(Level.WARNING, "Ocorreu uma exceção – Valores padrões definidos");
        }
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void marcar(String motivo, String historico, LocalDate data, String hora, Medico medico, Paciente paciente){
        setMotivo(motivo);
        setHistorico(historico);
        super.agendar(data, hora, medico, paciente);
    }
    public void cancelar(){
        super.desmarcar();
    }
    public void realizar(){
        //todo
    }
    public void atualizar(String motivo, String historico, LocalDate data, String hora, Medico medico, Paciente paciente){
        setMotivo(motivo);
        setHistorico(historico);
        super.agendar(data, hora, medico, paciente);
    }

    public void consultar() {
        System.out.println("Motivo: " + getMotivo());
        System.out.println("Historico: " + getHistorico());
        super.consultar();
    }

    public void mostrar(){
        System.out.println("consulta\n===============");
        System.out.println("data="+this.data.toString());
        System.out.println("hora="+this.hora);
        this.medico.mostrar();
        this.paciente.mostrar();
        System.out.println("motivo="+this.motivo);
        System.out.println("historico="+this.historico);
    }
}
