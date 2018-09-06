/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author MARTIN
 */
public class Telefono extends Object{
    private String numero;
    private TipoTelefono tipo;

    public Telefono(String numero) {
        
       
        this.numero = numero;
        // por defecto el teléfono es de tipo 3-Movil
        tipo = new TipoTelefono(3);
    }

    public Telefono(String numero, TipoTelefono tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoTelefono getTipo() {
        return tipo;
    }

    public void setTipo(TipoTelefono tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Nº: " + numero + "|"+ tipo.toString();
    }     
}
