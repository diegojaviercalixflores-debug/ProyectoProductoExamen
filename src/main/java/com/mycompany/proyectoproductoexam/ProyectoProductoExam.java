/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectoproductoexam;
import java.util.Scanner;
/**
 *
 * @author Diego Calix
 */
public class ProyectoProductoExam {
    
    public static void main(String[] args) {
        
      GestionProductos gestion = new GestionProductos();
        try (Scanner scanner = new Scanner(System.in)){
        int opcion = 0;

        do {
            System.out.println("\n    SISTEMA DE GESTION DE PRODUCTOS   ");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Actualizar producto");
            System.out.println("5. Mostrar estadisticas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un numero valido.");
                continue;
            }

            switch (opcion) {
                case 1 -> {
                    System.out.println("\n   AGREGAR PRODUCTO   ");
                    System.out.print("Codigo: ");
                    String codigo = scanner.nextLine();
                    
                    
                    if (gestion.buscarPorCodigo(codigo) != null) {
                        System.out.println("Error: Ya existe un producto con ese codigo.");
                        break;
                    }

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = Double.parseDouble(scanner.nextLine());
                    System.out.print("Cantidad: ");
                    int cantidad = Integer.parseInt(scanner.nextLine());

                    Producto nuevoProducto = new Producto(codigo, nombre, categoria, precio, cantidad);
                    gestion.agregarProducto(nuevoProducto);
              }

                case 2 -> gestion.mostrarProductos();

                case 3 -> {
                    System.out.println("\n  ELIMINAR PRODUCTO  ");
                        
                        
                        if (gestion.contarProductos() == 0) {
                            System.out.println("No hay productos ingresados en el sistema para poder eliminar.");
                            break;
                        }
                        
                        System.out.print("Ingrese el codigo del producto a eliminar: ");
                        String codEliminar = scanner.nextLine();
                        if (gestion.eliminarProducto(codEliminar)) {
                            System.out.println("Producto eliminado correctamente.");
                        } else {
                            System.out.println("Producto no encontrado.");
                        }
                        break;
              }

                case 4 -> {
                    if (gestion.contarProductos() == 0) {
                            System.out.println("No hay productos ingresados en el sistema para poder actualizar.");
                            break; 
                        }
                    
                    System.out.println("\n   ACTUALIZAR PRODUCTO   ");
                    System.out.print("Ingrese el codigo del producto a modificar: ");
                    String codActualizar = scanner.nextLine();
                    
                    if (gestion.buscarPorCodigo(codActualizar) != null) {
                        System.out.print("Nuevo Nombre: ");
                        String nNombre = scanner.nextLine();
                        System.out.print("Nueva Categoria: ");
                        String nCategoria = scanner.nextLine();
                        System.out.print("Nuevo Precio: ");
                        double nPrecio = Double.parseDouble(scanner.nextLine());
                        System.out.print("Nueva Cantidad: ");
                        int nCantidad = Integer.parseInt(scanner.nextLine());

                        gestion.actualizarProducto(codActualizar, nNombre, nCategoria, nPrecio, nCantidad);
                        System.out.println("Producto actualizado con exito.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
              }

                case 5 -> {
                    System.out.println("\n   ESTADISTICAS DEL INVENTARIO   ");
                    System.out.println("Total de productos registrados: " + gestion.contarProductos());
                    System.out.println("Valor total del inventario: L." + gestion.calcularValorTotal());
                    
                    Producto caro = gestion.obtenerProductoMasCaro();
                    Producto barato = gestion.obtenerProductoMasBarato();
                    
                    if (caro != null && barato != null) {
                        System.out.println("Producto mas caro: " + caro.getNombre() + " (L." + caro.getPrecio() + ")");
                        System.out.println("Producto mas barato: " + barato.getNombre() + " (L." + barato.getPrecio() + ")");
                    } else {
                        System.out.println("Aun no hay productos registrados para generar estadisticas.");
                    }
              }

                case 6 -> System.out.println("Saliendo del sistema...");

                default -> System.out.println("Opcion no valida. Intente de nuevo.");
            }
        } while (opcion != 6);

        }
    }
}
