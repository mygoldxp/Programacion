/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;
/**
 *
 * @author v6222
 */
public class Contrato {
    
    int codContrato;
    String contrato;
    double salarioBase;
    

    public Contrato() {
    }

    public Contrato(int codContrato, String contrato,double salarioBase) {
        this.codContrato = codContrato;
        this.contrato = contrato;
        this.salarioBase = salarioBase;
    }

    public int getCodContrato() {
        return codContrato;
    }

    public void setCodContrato(int codContrato) {
        this.codContrato = codContrato;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String Contrato) {
        this.contrato = Contrato;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

}
