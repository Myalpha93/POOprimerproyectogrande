package com.sanabria;

import com.sanabria.excepciones.ErrorValidacion;

public class Cliente {
    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    //diferencia entre publica y privada. privada solo donde se declara
    //privada utilizamos getid y cosas asi que nos permite controlar los accesos
    //validaciones o modificaciones
    //protegida se usa aqui y en clases que se heredan

    public Cliente(String id, String nombre, String apellido){

    }
    //getter utilizado para devolver informacion o datos
    //setter utilizado para modificar el estado de mi objeto, modificar una propiedad
    // correo, nombre, apellido, etc.

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
    //void no devuelve nada,
    //throws Exception: se le dice al compilador que el metodo puede devolver una excepcion
    public void setId(String id) throws Exception {
        if (id.length()!=13) {
            throw new ErrorValidacion("El numero de identidad debe contener 13 caracteres");
        }
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String nombreCompleto(){
        return this.nombre + " " + this.apellido;
    }

    public void setTelefono(String telefono)throws ErrorValidacion {
        // expresiones regulares es para encontrar patrones en el texto
        // el telefono por ejemplo 4 digitos un guion y 4 digitos
        if (!telefono.matches("/(^\\+504\\s?)?[0-9]{4}\\-[0-9]{4}/gm")){
            throw new ErrorValidacion("El numero de telefono es invalido");
        }
        this.telefono = telefono;
    }
    // aplicar una expresion regular para el correo electronico
    //

    public void setEmail(String email)throws ErrorValidacion {
        if (!email.matches("^[a-zA-Z0-9._-]+@[a-zA-Z]+\\.([a-zA-Z]{2,3})")){
            throw new ErrorValidacion("El numero de correo es invalido");
        }
        this.email = email;
    }
}
