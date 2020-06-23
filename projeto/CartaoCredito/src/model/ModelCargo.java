
package model;


public class ModelCargo {
    private int idCargo;
    private String Nome;
    private double salario;
    private String tempoTrabalho;

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTempoTrabalho() {
        return tempoTrabalho;
    }

    public void setTempoTrabalho(String tempoTrabalho) {
        this.tempoTrabalho = tempoTrabalho;
    }
    
}
