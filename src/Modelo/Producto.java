/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alexç
 */
public class Producto {
    
    private int idProducto;
    private String nombre;
    private String marca;
    private String categoria;
    private int precio;
    private int stock;

    public Producto() {}

    public Producto(String nombre, String marca, String categoria,
                    int precio, int stock) {
        this.nombre    = nombre;
        this.marca     = marca;
        this.categoria = categoria;
        this.precio    = precio;
        this.stock     = stock;
    }

    public Producto(int idProducto, String nombre, String marca,
                    String categoria, int precio, int stock) {
        this(nombre, marca, categoria, precio, stock);
        this.idProducto = idProducto;
    }
    
    // Getters y Setters

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    @Override
    public String toString() {
        return nombre + " - " + marca + " ($" + precio + ")";
    }
}
