/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alexç
 */
public class Usuario {
    
    private int idUser;
    private String userName;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String contrasena;

    // Constructor vacío
    public Usuario() {}

    // Constructor completo (para crear/registrar)
    public Usuario(String userName, String nombre, String apellido,
                   String telefono, String email, String contrasena) {
        this.userName = userName;
        this.nombre   = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email    = email;
        this.contrasena = contrasena;
    }

    // Constructor con ID (para editar/mostrar)
    public Usuario(int idUser, String userName, String nombre, String apellido,
                   String telefono, String email, String contrasena) {
        this(userName, nombre, apellido, telefono, email, contrasena);
        this.idUser = idUser;
    }
    
    // Getters y Setters

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    @Override
    public String toString() {
        return nombre + " " + apellido + " (@" + userName + ")";
    }

}
