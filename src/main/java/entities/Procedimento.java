package entities;

import java.time.LocalDate;

public abstract class Procedimento {
    protected Integer id;
    protected Consulta consulta;
    protected LocalDate data;
    protected String descritivo;

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescritivo() {
        return descritivo;
    }

    public void setDescritivo(String descritivo) {
        this.descritivo = descritivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void consultar(){
        System.out.println("entities.Consulta: " + getConsulta());
        System.out.println("Data: " + getData());
        System.out.println("Descritivo: " + getDescritivo());
    }

}
