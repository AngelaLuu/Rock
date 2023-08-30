package co.edu.sena.rocks.repository;

import co.edu.sena.rocks.bean.Administrador;
import co.edu.sena.rocks.utiil.UseConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//UserRepository_impl
public class AdministradorRepositoryImpl implements Repository<Administrador> {
    private String sql = null;

    @Override
    public List<Administrador> listAllObj() throws SQLException {
        sql = "select id, nombre,correo,documento,tipo_rol,image " +
                "from Administrador  order by nombre,documento ";
        List<Administrador>Administradors = new ArrayList<>();
        try (Connection conn = UseConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Administrador a = createObj(rs);
                Administradors.add(a);
            } //while

        } //try
        return Administradors;
    } //listAllObj

    @Override
    public Administrador byIdOBj(Integer id) throws SQLException {
        sql = "select id, nombre,correo,documento,tipo_rol " + "from Administrador where id= ?";
        Administrador Administrador = null;

        try (Connection conn = UseConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt( 1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Administrador = createObj(rs);
                }
            } //try
        } return Administrador;
    } //byIdObj

    @Override
    public Integer saveObj(Administrador Administrador) throws SQLException {

        int rowsAffected = 0;

        if (Administrador.getId() != null && Administrador.getId() > 0) {
            sql = "update Administrador set nombre=?,correo=?,documento=?,tipo_rol=?)" + "where id=?";
        } else {
            sql = "insert into Administrador(nombre,correo,documento,tipo_rol)" + "values (upper(?),upper(?),upper(?),upper(?))";
        }
        try (Connection conn = UseConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, Administrador.getNombre());
            ps.setString(2, Administrador.getCorreo());
            ps.setInt(3,Administrador.getDocumento());
            ps.setString(4,Administrador.getTipo_rol());
            if (Administrador.getId() != null && Administrador.getId() > 0) {
                ps.setInt(5, Administrador.getId());
            }
            rowsAffected = ps.executeUpdate();
        }
        return rowsAffected;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql="delete from Administrador where id=?";
        try (Connection conn = UseConnectionPool.getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }
    }

    @Override
    public Administrador createObj(ResultSet rs) throws SQLException {
        Administrador Administrador = new Administrador();
        Administrador.setId(rs.getInt("id"));
        Administrador.setNombre(rs.getString("nombre"));
        Administrador.setCorreo(rs.getString("correo"));
        Administrador.setDocumento(rs.getInt("documento"));
        Administrador.setTipo_rol(rs.getString("tipo_rol"));
        return Administrador;
    } //createObj
}


