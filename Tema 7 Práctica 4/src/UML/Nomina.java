/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import UML.Abstracto.Cuotas;
import java.text.DecimalFormat;


/**
 *
 * @author v6222
 */
public class Nomina{
    int cod, mes,dias;
    Empleado empleado;
    double salarioBaseC, extra, forzosa, incentivo, coutaPatronal, cuotaObrera, neto, cuotaExtra, cuotaForzosa ;
    
    public Nomina() {
    }

    public Nomina(int cod, int mes, int dias, Empleado empleado, Cuotas couta, double salarioBaseC, double extra, double forzosa, double incentivo, double coutaPatronal, double cuotaObrera, double neto, double cuotaExtra, double cuotaForzosa) {
        this.cod = cod;
        this.mes = mes;
        this.dias = dias;
        this.empleado = empleado;
        this.salarioBaseC = salarioBaseC;
        this.extra = extra;
        this.forzosa = forzosa;
        this.incentivo = incentivo;
        this.coutaPatronal = coutaPatronal;
        this.cuotaObrera = cuotaObrera;
        this.neto = neto;
        this.cuotaExtra = cuotaExtra;
        this.cuotaForzosa = cuotaForzosa;
    }



        
    public void calcNomina(){
        valores();
        patronal();
        obrera();
        
        neto = (super.getIrpf()/(c.getIrpf()/100)) - cuotaObrera;
    }

    public void valores(){
        super.setIrpf((salarioBaseC + incentivo + (extra*cuotaExtra) + (forzosa*cuotaForzosa))*(c.getIrpf()/100));
        super.setSalarioBase(salarioBaseC + (salarioBaseC/6)+ incentivo);
        salarioBaseC = super.getSalarioBase() + (extra*cuotaExtra) + (forzosa*cuotaForzosa);
    }

    public void patronal(){
        super.seteContingenciasComunes(super.getSalarioBase()*(c.geteContingenciasComunes()/100));
        super.setAtep(salarioBaseC*(c.getAtep()/100));
        super.seteDesempleo(salarioBaseC*(c.geteDesempleo()/100));
        super.seteFP(salarioBaseC*(c.geteFP()/100));
        super.setFogasa(salarioBaseC*(c.getFogasa()/100));
        super.seteHorasExtras((extra*cuotaExtra)*(c.geteHorasExtras()/100));
        super.seteExtraFuerza((forzosa*cuotaForzosa)*(c.geteExtraFuerza()/100));
        coutaPatronal = super.geteContingenciasComunes() + super.getAtep() + super.geteDesempleo() + super.geteFP() + super.getFogasa() + super.geteHorasExtras() + super.geteExtraFuerza();
    }

    public void obrera(){
        super.setContingenciasComunes(super.getSalarioBase()*(c.getContingenciasComunes()/100));
        super.setDesempleao(salarioBaseC*(c.getDesempleao()/100));
        super.setFp(salarioBaseC*(c.getFp()/100));
        super.setHorasExtras((extra*cuotaExtra)*(c.getHorasExtras()/100));
        super.setExtraFuerza((forzosa*cuotaForzosa)*(c.getExtraFuerza()/100));
        cuotaObrera = super.getContingenciasComunes() + super.getDesempleao() + super.getFp() + super.getHorasExtras() + super.getExtraFuerza() + super.getIrpf();
    }
    
    public String datoBasicoNomina(){
        DecimalFormat forma = new DecimalFormat("0.00");
        return " ---> " + this.getCod() + ": Mes " + mes + ", número de días " + dias + ", Total Devengado "+ forma.format((super.getIrpf()/(c.getIrpf()/100))) + "€, Total Neto: " + forma.format(getNeto()) + "€.\n";
    }
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }


    public double getSalarioBaseC() {
        return salarioBaseC;
    }

    public void setSalarioBaseC(double salarioBaseC) {
        this.salarioBaseC = salarioBaseC;
    }

    public double getExtra() {
        return extra;
    }

    public void setExtra(double extra) {
        this.extra = extra;
    }

    public double getForzosa() {
        return forzosa;
    }

    public void setForzosa(double forzosa) {
        this.forzosa = forzosa;
    }

    public double getIncentivo() {
        return incentivo;
    }

    public void setIncentivo(double incentivo) {
        this.incentivo = incentivo;
    }

    public double getCoutaPatronal() {
        return coutaPatronal;
    }

    public void setCoutaPatronal(double coutaPatronal) {
        this.coutaPatronal = coutaPatronal;
    }

    public double getCuotaObrera() {
        return cuotaObrera;
    }

    public void setCuotaObrera(double cuotaObrera) {
        this.cuotaObrera = cuotaObrera;
    }

    public double getNeto() {
        return neto;
    }

    public void setNeto(double neto) {
        this.neto = neto;
    }

    @Override
    public int getCodContrato() {
        return codContrato;
    }

    @Override
    public void setCodContrato(int codContrato) {
        this.codContrato = codContrato;
    }

    @Override
    public String getContrato() {
        return contrato;
    }

    @Override
    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    @Override
    public double getSalarioBase() {
        return salarioBase;
    }

    @Override
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public double getContingenciasComunes() {
        return contingenciasComunes;
    }

    @Override
    public void setContingenciasComunes(double contingenciasComunes) {
        this.contingenciasComunes = contingenciasComunes;
    }

    @Override
    public double geteContingenciasComunes() {
        return eContingenciasComunes;
    }

    @Override
    public void seteContingenciasComunes(double eContingenciasComunes) {
        this.eContingenciasComunes = eContingenciasComunes;
    }

    @Override
    public double getDesempleao() {
        return desempleao;
    }

    @Override
    public void setDesempleao(double desempleao) {
        this.desempleao = desempleao;
    }

    @Override
    public double geteDesempleo() {
        return eDesempleo;
    }

    @Override
    public void seteDesempleo(double eDesempleo) {
        this.eDesempleo = eDesempleo;
    }

    @Override
    public double getFp() {
        return fp;
    }

    @Override
    public void setFp(double fp) {
        this.fp = fp;
    }

    @Override
    public double geteFP() {
        return eFP;
    }

    @Override
    public void seteFP(double eFP) {
        this.eFP = eFP;
    }

    @Override
    public double getHorasExtras() {
        return horasExtras;
    }

    @Override
    public void setHorasExtras(double horasExtras) {
        this.horasExtras = horasExtras;
    }

    @Override
    public double geteHorasExtras() {
        return eHorasExtras;
    }

    @Override
    public void seteHorasExtras(double eHorasExtras) {
        this.eHorasExtras = eHorasExtras;
    }

    @Override
    public double getExtraFuerza() {
        return extraFuerza;
    }

    @Override
    public void setExtraFuerza(double extraFuerza) {
        this.extraFuerza = extraFuerza;
    }

    @Override
    public double geteExtraFuerza() {
        return eExtraFuerza;
    }

    @Override
    public void seteExtraFuerza(double eExtraFuerza) {
        this.eExtraFuerza = eExtraFuerza;
    }

    @Override
    public double getAtep() {
        return atep;
    }

    @Override
    public void setAtep(double atep) {
        this.atep = atep;
    }

    @Override
    public double getFogasa() {
        return fogasa;
    }

    @Override
    public void setFogasa(double fogasa) {
        this.fogasa = fogasa;
    }

    @Override
    public double getIrpf() {
        return irpf;
    }

    @Override
    public void setIrpf(double irpf) {
        this.irpf = irpf;
    }

    public Contrato getC() {
        return c;
    }

    public void setC(Contrato c) {
        this.c = c;
    }

    public double getCuotaExtra() {
        return cuotaExtra;
    }

    public void setCuotaExtra(double cuotaExtra) {
        this.cuotaExtra = cuotaExtra;
    }

    public double getCuotaForzosa() {
        return cuotaForzosa;
    }

}
