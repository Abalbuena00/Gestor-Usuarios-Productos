/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Usuario;
import Modelo.dbConnetion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexç
 */
public class UsuarioController {
    
    /** Registra un nuevo usuario en la base de datos. */
    public boolean insertar(Usuario u) {
        String sql = "INSERT INTO usuarios (UserName, Nombre, Apellido, Telefono, Email, Password) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = dbConnetion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, u.getUserName());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getApellido());
            ps.setString(4, u.getTelefono());
            ps.setString(5, u.getEmail());
            ps.setString(6, u.getContrasena());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar usuario: " + e.getMessage());
            return false;
        }
    }

    /** Devuelve todos los usuarios registrados. */
    public List<Usuario> listarTodos() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection con = dbConnetion.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Usuario(
                    rs.getInt("idUser"),
                    rs.getString("UserName"),
                    rs.getString("Nombre"),
                    rs.getString("Apellido"),
                    rs.getString("Telefono"),
                    rs.getString("Email"),
                    rs.getString("Password")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar usuarios: " + e.getMessage());
        }
        return lista;
    }

    /**
     * Verifica credenciales para el login.
     * Retorna el objeto Usuario si son válidas, null si no.
     */
    public Usuario login(String userName, String contrasena) {
        String sql = "SELECT * FROM usuarios WHERE UserName = ? AND Password = ?";
        try (Connection con = dbConnetion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, userName);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getInt("idUser"),
                    rs.getString("UserName"),
                    rs.getString("Nombre"),
                    rs.getString("Apellido"),
                    rs.getString("Telefono"),
                    rs.getString("Email"),
                    rs.getString("Password")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error en login: " + e.getMessage());
        }
        return null;
    }

    /** Actualiza los datos de un usuario existente. */
    public boolean actualizar(Usuario u) {
        String sql = "UPDATE usuarios SET UserName=?, Nombre=?, Apellido=?, " +
                     "Telefono=?, Email=? WHERE idUser=?";
        try (Connection con = dbConnetion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, u.getUserName());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getApellido());
            ps.setString(4, u.getTelefono());
            ps.setString(5, u.getEmail());
            ps.setInt(6,    u.getIdUser());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
            return false;
        }
    }

    /** Elimina un usuario por su ID. */
    public boolean eliminar(int idUser) {
        String sql = "DELETE FROM usuarios WHERE idUser = ?";
        try (Connection con = dbConnetion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idUser);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
            return false;
        }
    }

    /** Verifica si un userName ya existe (para evitar duplicados al registrarse). */
    public boolean existeUserName(String userName) {
        String sql = "SELECT idUser FROM usuarios WHERE UserName = ?";
        try (Connection con = dbConnetion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Error al verificar username: " + e.getMessage());
            return false;
        }
    }
    
}
