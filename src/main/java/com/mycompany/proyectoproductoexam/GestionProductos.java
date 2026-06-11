/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoproductoexam;
import java.util.ArrayList;
/**
 *
 * @author Diego Calix
 */
public class GestionProductos 
{
    private final ArrayList<Producto> listaProductos;

    
    public GestionProductos() 
    {
        this.listaProductos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) 
    {
        listaProductos.add(producto);
        System.out.println("Producto agregado con exito!");
    }

    public void mostrarProductos()
    {
        if (listaProductos.isEmpty())
        {
            System.out.println("No hay productos registrados en el inventario para mostrar.");
            return;
        }
        System.out.println("\n    LISTA DE PRODUCTOS   ");
        for (Producto p : listaProductos) {
            System.out.println(p);
        }
    }

    public Producto buscarPorCodigo(String codigo)
    {
        for (Producto p : listaProductos) 
        {
            if (p.getCodigo().equalsIgnoreCase(codigo)) 
            {
                return p;
            }
        }
        return null;
    }

    public boolean eliminarProducto(String codigo) 
    {
        Producto p = buscarPorCodigo(codigo);
        if (p != null) {
            listaProductos.remove(p);
            return true;
        }
        return false;
    }

    public boolean actualizarProducto(String codigo, String nuevoNombre, String nuevaCategoria,
            double nuevoPrecio, int nuevaCantidad) 
    {
        Producto p = buscarPorCodigo(codigo);
        if (p != null) {
            p.setNombre(nuevoNombre);
            p.setCategoria(nuevaCategoria);
            p.setPrecio(nuevoPrecio);
            p.setCantidad(nuevaCantidad);
            return true;
        }
        return false;
    }

    public int contarProductos()
    {
        return listaProductos.size();
    }

    public double calcularValorTotal() 
    {
        double total = 0;
        for (Producto p : listaProductos)
        {
            total += p.getPrecio() * p.getCantidad();
        }
        return total;
    }

    public Producto obtenerProductoMasCaro()
    {
        if (listaProductos.isEmpty()) return null;
        
        Producto masCaro = listaProductos.get(0);
        for (Producto p : listaProductos) {
            if (p.getPrecio() > masCaro.getPrecio()) {
                masCaro = p;
            }
        }
        return masCaro;
    }

    public Producto obtenerProductoMasBarato() 
    {
        if (listaProductos.isEmpty()) return null;

        Producto masBarato = listaProductos.get(0);
        for (Producto p : listaProductos) 
        {
            if (p.getPrecio() < masBarato.getPrecio()) 
            {
                masBarato = p;
            }
        }
        return masBarato;
    }
}
