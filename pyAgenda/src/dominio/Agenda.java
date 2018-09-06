/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author MARTIN
 */
public class Agenda {

    private Contacto[] contactos;

    public Agenda() {
        contactos = null;
    }

    public Agenda(int tam) {
        contactos = new Contacto[tam];
    }

    @SuppressWarnings("empty-statement")
    public void agregar(Contacto unContacto) {
        if (contactos == null) {
            contactos = new Contacto[1];
            contactos[0] = unContacto;
        } else {
            int i;
            for (i = 0; i < contactos.length && contactos[i] != null; i++);
            if (i != contactos.length) {
                contactos[i] = unContacto;
            } else {
                redimensionar(unContacto);
            }
        }
    }

    public boolean eliminarContacto(long dni) {
        int pos = this.buscarContacto(dni);
        if (pos != -1) {
            redimensionar(pos);
        }
        return (pos != -1);
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

    public Contacto buscarPorTelefon(String telefonNro) {
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
            if (dias <= 7) {
                aux += x.infoCumple() + "|días: " + dias + "\n";
            }
        }
        return aux;
    }

    private int buscarContacto(long clave) {
        int pos = -1;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i].getDni() == clave) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    private void redimensionar(Contacto unContacto) {
        Contacto[] aux = new Contacto[contactos.length + 1];
        for (int i = 0; i < contactos.length; i++) {
            aux[i] = contactos[i];
        }
        aux[contactos.length] = unContacto;
        contactos = aux;
    }

    private long diferenciaDias(Date fechaNac) {
        Calendar hoy = Calendar.getInstance();
        Calendar cumple = Calendar.getInstance();

        hoy.set(2018, hoy.get(Calendar.MONTH), hoy.get(Calendar.DAY_OF_MONTH));
        cumple.set(2018, fechaNac.getMonth() - 1, fechaNac.getDay() - 1);

        return (hoy.getTimeInMillis() - cumple.getTimeInMillis() / (1000 * 60 * 60 * 24));
    }

    public String listarOrdenados() {
        String listado = "Sin contactos";
        
        if (contactos.length > 0) {
            listado = "";
            ordenarContactos();
            for (Contacto x : contactos) {
                listado += x.toString();
            }
        }
        return listado;
    }

    private void ordenarContactos() {
        Contacto aux = null;
        for (int i = 0; i < contactos.length - 1; i++) {
            for (int j = i + 1; j < contactos.length; j++) {
                if (contactos[i].getApellido().compareTo(contactos[j].getApellido()) > 0) {
                    aux = contactos[i];
                    contactos[i] = contactos[j];
                    contactos[j] = aux;
                }
            }
        }
    }

    private void redimensionar(int pos) {
        int j = 0;
        Contacto nuevo[] = new Contacto[contactos.length - 1];
        for (int i = 0; i < contactos.length; i++) {
            if (i != pos) {
                nuevo[j] = contactos[i];
                j++;
            }
        }
        contactos = nuevo;
    }
}
