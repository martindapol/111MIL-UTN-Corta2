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
public class TipoTelefono {
    private int codigo;
    private String descripcion;

    public TipoTelefono(int codigo) {
        this.codigo = codigo;
        descripcion = elegirDescripcion(codigo);

    }

    public TipoTelefono(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "" + codigo + "-" + descripcion;
    }

    private String elegirDescripcion(int codigo) {
        String desc = null;
        switch (codigo) {
            case 1:
                desc = "Casa";
                break;
            case 2:
                desc = "Trabajo";
                break;
            case 3:
                desc = "Móvil";
                break;
            case 4:
                desc = "Principal";
                break;
            case 5:
                desc = "Otro";
                break;
        }
        return desc;
    }

}
