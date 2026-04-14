/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Producto;
import Modelo.dbConnetion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexç
 */
public class ProductoController {
    
    /** Registra un nuevo producto. */
    public boolean insertar(Producto p) {
        String sql = "INSERT INTO productos_vieja (NombreProducto, MarcaProducto, CategoriaProducto, " +
                     "PrecioProducto, StockProducto) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = dbConnetion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getMarca());
            ps.setString(3, p.getCategoria());
            ps.setInt(4,    p.getPrecio());
            ps.setInt(5,    p.getStock());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar producto: " + e.getMessage());
            return false;
        }
    }

    /** Devuelve todos los productos del almacén. */
    public List<Producto> listarTodos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos_vieja";
        try (Connection con = dbConnetion.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Producto(
                    rs.getInt("idProducto"),
                    rs.getString("NombreProducto"),
                    rs.getString("MarcaProducto"),
                    rs.getString("CategoriaProducto"),
                    rs.getInt("PrecioProducto"),
                    rs.getInt("StockProducto")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar productos: " + e.getMessage());
        }
        return lista;
    }

    /** Actualiza un producto existente. */
    public boolean actualizar(Producto p) {
        String sql = "UPDATE productos_vieja SET NombreProducto=?, MarcaProducto=?, " +
                     "CategoriaProducto=?, PrecioProducto=?, StockProducto=? " +
                     "WHERE idProducto=?";
        try (Connection con = dbConnetion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getMarca());
            ps.setString(3, p.getCategoria());
            ps.setInt(4, p.getPrecio());
            ps.setInt(5, p.getStock());
            ps.setInt(6, p.getIdProducto());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar producto: " + e.getMessage());
            return false;
        }
    }

    /** Elimina un producto por su ID. */
    public boolean eliminar(int idProducto) {
        String sql = "DELETE FROM productos_vieja WHERE idProducto = ?";
        try (Connection con = dbConnetion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProducto);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar producto: " + e.getMessage());
            return false;
        }
    }
    
}
