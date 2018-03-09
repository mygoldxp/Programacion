package Modelo;

public class Asiento {
    private int numeroAsiento;
    private Boolean estado;
    private String compartimento;
    
    private Pasajero pasajero;
    private Vuelo vuelo;
    
    public void reservar(){}
    
    public void comprar(){}
    
    public boolean mostrarDisponibilidad(){
        return true;
    }
    
    public void desbloquear(){}

    public Asiento() {
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getCompartimento() {
        return compartimento;
    }

    public void setCompartimento(String compartimento) {
        this.compartimento = compartimento;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
    
    
}
