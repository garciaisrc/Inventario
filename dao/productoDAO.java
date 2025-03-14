/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendainve.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import tiendainve.dto.ProductDTO;

/**
 *
 * @author Garcia
 */
public class productoDAO extends conectionDB {

    private final static String SQL_INSERT = "insert into product(codigo,nombre,cantidad,precio,fechaCompra,comprador,marca)value(?,?,?,?,?,?,?)";
    private final static String SQL_UPDATE = "update product set nombre=?,cantidad=?,precio=?,fechaCompra=?,comprador=?,marca=? where codigo=?";
    private final static String SQL_DELETE = "delete from product where codigo=?";
    private final static String SQL_SELECT = "select * from product where nombre=?";
    private final static String SQL_SELECTALL = "select * from product";

    public productoDAO() {
        super();

    }

    public void crear(ProductDTO dto) throws Exception {
        PreparedStatement ps = null;
        ps = conn.prepareStatement(SQL_INSERT);
        ps.setInt(1, dto.getCodigo());
        ps.setString(2, dto.getNombre());
        ps.setInt(3, dto.getCantidad());
        ps.setDouble(4, dto.getPrecio());
        ps.setDate(5, dto.getFechaCompra());
        ps.setString(6, dto.getComprador());
        ps.setString(7, dto.getMarca());
        ps.executeUpdate();
        cerrar(ps);
    }
      public void actualizar(ProductDTO dto) throws Exception {
        PreparedStatement ps = null;
        ps = conn.prepareStatement(SQL_UPDATE);
        ps.setString(1, dto.getNombre());
        ps.setInt(2, dto.getCantidad());
        ps.setDouble(3, dto.getPrecio());
        ps.setDate(4, dto.getFechaCompra());
        ps.setString(5, dto.getComprador());
        ps.setString(6, dto.getMarca());
        ps.setInt(7, dto.getCodigo());
        ps.executeUpdate();
        cerrar(ps);
    }
        public void eliminar(ProductDTO dto) throws Exception {
        PreparedStatement ps = null;
        ps = conn.prepareStatement(SQL_DELETE);
        ps.setString(1, dto.getNombre());
        ps.executeUpdate();
        cerrar(ps);
    }
        public ProductDTO buscar(ProductDTO dto) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ps= conn.prepareStatement(SQL_SELECT);
        ps.setString(1, dto.getNombre());
        rs=ps.executeQuery(SQL_INSERT);
        if(rs.next()){
        dto.setCodigo(rs.getInt("codigo"));
        dto.setNombre(rs.getString("nombre"));
        dto.setCantidad(rs.getInt("cantidad"));
        dto.setPrecio(rs.getDouble("precio"));
        dto.setFechaCompra(rs.getDate("fechaCompra"));
        dto.setComprador(rs.getString("comprador"));
        dto.setMarca(rs.getString("marca"));
        }else
            return null;
        return dto;
    }
        
        public List listageneral()throws Exception{
        List lista =new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ProductDTO dto;
        ps = conn.prepareStatement(SQL_SELECTALL);
        rs=ps.executeQuery();
        while(rs.next()){
           dto = new ProductDTO();
           dto.setCodigo(rs.getInt("codigo"));
           dto.setNombre(rs.getString("nombre"));
           dto.setCantidad(rs.getInt("cantidad"));
           dto.setPrecio(rs.getDouble("precio"));
           dto.setFechaCompra(rs.getDate("fechaCompra"));
           dto.setComprador(rs.getString("comprador"));
           dto.setMarca(rs.getString("marca"));
           lista.add(dto);
        
        }
        return lista;
        }
    

}
