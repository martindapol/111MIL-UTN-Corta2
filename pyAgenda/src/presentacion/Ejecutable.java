/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import dominio.Agenda;
import dominio.Contacto;
import dominio.Telefono;
import dominio.TipoTelefono;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author MARTIN
 */
public class Ejecutable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        int op;
        do {
            System.out.println("Menú de opciones----------");
            System.out.println("1-Agregar un nuevo contacto\n"
                    + "2-Actualizar los datos de un contacto\n"
                    + "3-Eliminar un contacto cargado por equivocación\n"
                    + "4-Buscar un contacto por dni\n"
                    + "5-Buscar un contacto por número de teléfono\n"
                    + "6-Buscar un contacto por nombre\n"
                    + "7-Listar todos los contactos ordenados alfabéticamente\n"
                    + "8-Listar los contactos con fecha de nacimiento próximos a la fecha del día\n"
                    + "9-Salir");
            System.out.println("Elija una opción: ");
            op = input.nextInt();

            switch (op) {

                case 1: {
                    int dni, dia, mes, anio, tipoTel;
                    String nom, ape, email,telefono ;
                    System.out.println("Nuevo contacto...");
                    System.out.println("Ingrese dni: ");
                    dni = input.nextInt();
                    System.out.println("Ingrese nombre: ");
                    nom = input2.next();
                    System.out.println("Ingrese apellido: ");
                    ape = input2.next();
                    System.out.println("Ingrese fecha de nacimiento. [Formato dd/MM/yyyy]: ");
                    dia = input.nextInt();
                    mes = input.nextInt();
                    anio = input.nextInt();
                    System.out.println("Ingrese correo electrónico: ");
                    email = input2.next();
                    System.out.println("Ingrese número de teléfono: ");
                    telefono = input2.next();
                  
                    do{
                        System.out.println("Ingrese tipo de teléfono Valor en [1..5]: ");
                        tipoTel = input.nextInt();
                    }while(tipoTel<1 || tipoTel>5);
                    Calendar cal = Calendar.getInstance();
                    cal.set(anio, mes, dia);
                    Contacto nuevo = new Contacto(dni, nom, ape,email,cal.getTime(),new Telefono(telefono, new TipoTelefono(tipoTel)));
                    agenda.agregar(nuevo);
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    System.out.println("Ingrese dni del contacto a borrar: ");
                    long dni = input.nextLong();
                    
                    if(agenda.eliminarContacto(dni))
                        System.out.println("Contacto eliminado!");
                    else
                        System.out.println("No se encontró el contacto dni: " + dni);
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
                    break;
                }
                case 6: {
                    break;
                }
                case 7: {
                    System.out.println("AGENDA:");
                    System.out.println(agenda.listarOrdenados());
                    break;
                }
                case 8: {
                    break;
                }
                case 9: {
                    System.out.println("Hasta luego....!");
                    break;
                }
                default: {
                    System.out.println("Opción incorrecta!");
                }
            }

        } while (op != 9);

    }
}