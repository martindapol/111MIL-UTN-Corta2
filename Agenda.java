/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.Dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MARTIN
 */
public class Agenda {

    private List <Contacto>contactos;

    public Agenda() {
        contactos = null;
    }

    public Agenda(int tam) {
        contactos = new ArrayList<Contacto>(tam);
       
    }

    @SuppressWarnings("empty-statement")
    public void agregar(Contacto unContacto) {
     contactos.add(unContacto);
    }

    public Contacto buscarPorDni(long dni) {
        for (Contacto x : contactos) {
            if (x.getDni() == dni) {
                return x;
            }
        }
        return null;
    }

    public Contacto buscarPorNombre(String nombre) {
        for (Contacto x : contactos) {
            if (x.getNombre().equals(nombre)) {
                return x;
            }
        }
        return null;
    }

    public Contacto buscarPorTelefon(int telefonNro) {
        for (Contacto x : contactos) {
            if (x.getTelefono(telefonNro) != null) {
                return x;
            }
        }
        return null;
    }

    public String listarProximosCumple() {
        String aux = "Listado de cumpleañeros\n";
        for (Contacto x : contactos) {
            long dias = diferenciaDias(x.getFechaNac());
            if ( dias <= 7) {
                aux += x.infoCumple() + "|días: "  + dias  +  "\n";
            }
        }
     return aux;
    }

    private long diferenciaDias(Date fechaNac) {
        Calendar hoy = Calendar.getInstance();
        Calendar cumple = Calendar.getInstance();
        
        hoy.set(2018,hoy.get(Calendar.MONTH),hoy.get(Calendar.DAY_OF_MONTH));
        cumple.set(2018, fechaNac.getMonth()-1, fechaNac.getDay()-1);
        
        return (hoy.getTimeInMillis()-cumple.getTimeInMillis()/(1000*60*60*24));
    }
}
