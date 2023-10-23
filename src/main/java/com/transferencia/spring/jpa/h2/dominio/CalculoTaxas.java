package com.transferencia.spring.jpa.h2.dominio;

public class CalculoTaxas {

    public float calculaTaxa = 0.0F;
    Integer dataTranferencia = 0;
    float zero = 3.0F;
    float umADez = 12.0F;
    float onzeAVintePercent = 12.0F;
    float VinteATrintaPercent = 6.9F;
    float TrintaPercent = 4.7F;
    float quarentaAcinquentaPercent = 4.7F;

    public CalculoTaxas() {
    }


    public float CalculoTaxas(float calculaTaxa ,String dataTranferencia) {
        this.calculaTaxa = calculaTaxa;
        this.dataTranferencia = Integer.parseInt(dataTranferencia);
        switch (this.dataTranferencia){
            case 0:
                this.calculaTaxa = this.zero;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                this.calculaTaxa = this.umADez;
                break;
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
                this.calculaTaxa = this.calculaTaxa * this.onzeAVintePercent/100;
                break;

            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
                this.calculaTaxa = this.calculaTaxa * this.VinteATrintaPercent/100;
                break;

            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
                this.calculaTaxa = this.calculaTaxa * this.TrintaPercent/100;
                break;
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
                this.calculaTaxa = this.calculaTaxa * quarentaAcinquentaPercent/100;
                break;


        }

        System.out.println(this.calculaTaxa);
        return this.calculaTaxa;
    }
}
