package entities;

import java.time.LocalDate;
import java.util.logging.Logger;
import java.util.logging.Level;
public class Agenda {
    protected LocalDate data;
    protected String hora;
    protected Medico medico;
    protected Paciente paciente;
    private Logger logger = Logger.getLogger(Agenda.class.getName());

    public Agenda(){}

    public Agenda(LocalDate _data, String _hora, Medico _medico,
                  Paciente _paciente){
        try {
            this.data = _data;
            this.hora = _hora;
            this.medico = _medico;
            this.paciente = _paciente;
        }
        catch(Exception err){
            this.data = LocalDate.now();
            this.hora = "";
            this.medico  = new Medico();
            this.paciente = new Paciente();
            logger.log(Level.WARNING, "Ocorreu uma exceção – Valores padrões definidos");
        }
    }


    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void consultar(){
        System.out.println("Data: " + getData());
        System.out.println("Hora: " + getHora());
        System.out.println("entities.Medico: " + getMedico());
        System.out.println("entities.Paciente: " + getPaciente());
    }

    public void mostrar(){
        System.out.println("AGENDA\n===============");
        System.out.println("data="+this.data.toString());
        System.out.println("hora="+this.hora);
        this.medico.mostrar();
        this.paciente.mostrar();
    }

    public void agendar(LocalDate data, String hora, Medico medico, Paciente paciente) {
        setData(data);
        setHora(hora);
        setMedico(medico);
        setPaciente(paciente);
    }

    public void desmarcar() {
        setData(null);
        setHora(null);
        setMedico(null);
        setPaciente(null);
    }
}
