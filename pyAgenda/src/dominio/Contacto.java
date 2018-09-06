/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author MARTIN
 */
public class Contacto {

    private long dni;
    private String nombre;
    private String apellido;
    private String correo;
    private Date fechaNac;
    private Telefono[] telefonos;

    public Contacto(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = "sin email";
        telefonos = new Telefono[1];
    }

    public Contacto(long dni, String nombre, String apellido, String correo, Date fechaNac, Telefono tel) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaNac = fechaNac;
        telefonos = new Telefono[1];
        telefonos[0] = tel;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        String aux = "Contacto{" + "dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", fechaNac=" + new SimpleDateFormat("dd/MM/yyyy").format(fechaNac) + '}';
        aux += "\nTelefonos:\n";
        for (Telefono x : telefonos) {
            aux += x.toString() + "\n";
        }
        return aux;
    }

    public void agregarTelefono(Telefono tel) {
        Telefono[] nuevo = new Telefono[telefonos.length + 1];
        for (int i = 0; i < telefonos.length; i++) {
            nuevo[i] = telefonos[i];
        }
        nuevo[telefonos.length] = tel;
        telefonos = nuevo;
    }

    public Telefono getTelefono(String buscado) {
        Telefono find = null;
        int i = buscarTelefono(buscado);
        if (i != -1) {
            find = telefonos[i];
        }

        return find;
    }

    public boolean modificarTelefono(String viejo, String nuevo, TipoTelefono nuevoTipo) {
        boolean aviso = false;
        int pos = buscarTelefono(viejo);
        if (pos != -1) {
            telefonos[pos].setNumero(nuevo);
            telefonos[pos].setTipo(nuevoTipo);
            aviso = true;
        }
        return aviso;
    }

    public boolean borrarTelefono(String nro) {
        boolean aviso = false;
        int pos = buscarTelefono(nro);
        if (pos != -1) {
            redimensionar(pos);
            aviso = true;
        }
        return aviso;
    }

    private int buscarTelefono(String nro) {
        int pos = -1;
        for (int i = 0; i < telefonos.length; i++) {
            //if(t.getNumero().comparetTo(buscado)==0)
            if (telefonos[i].getNumero().equals(nro)) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    private void redimensionar(int pos) {
        int j = 0;
        Telefono nuevo[] = new Telefono[telefonos.length - 1];
        for (int i = 0; i < telefonos.length; i++) {
            if (i != pos) {
                nuevo[j] = telefonos[i];
                j++;
            }
        }
        telefonos = nuevo;
    }

    public String infoCumple() {
        return this.nombre + ", " + this.apellido  + "|" + this.telefonos[0].getNumero();
    }
}
