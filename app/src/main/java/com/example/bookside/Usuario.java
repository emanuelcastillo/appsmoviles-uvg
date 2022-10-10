package com.example.bookside;

public class Usuario {
    private String Email;
    private String password;
    private String nombre;
    private String apellido;
    private int idRol;
    private int idEstado;
    private String pin;
    private String cuiusuairo;
    private int estadoCuenta;

    public Usuario(){
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(int estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public String getCuiusuairo() { return cuiusuairo; }

    public void setCuiusuairo(String cuiusuairo) { this.cuiusuairo = cuiusuairo; }
}
