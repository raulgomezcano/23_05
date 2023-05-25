package com.softtek.proyecto23_05.servicio;

import com.softtek.proyecto23_05.modelo.Orden;
import com.softtek.proyecto23_05.modelo.Producto;
import com.softtek.proyecto23_05.repo.IOrdenRepo;
import com.softtek.proyecto23_05.repo.IProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductoServicioImp implements IProductoServicio{
    @Autowired
    private IProductoRepo repoProducto;
    @Override
    public List<Producto> obtenerTodosProductos() {return repoProducto.findAll();}

    //Obtener una consulta con Productid, productname, supplierid, categoryId, UnistsinStock, UnitPrice
    public List<String> obtenerProducto1(){
        List<Producto> productos = obtenerTodosProductos();
        List<String> lista = productos.stream()
                .map(producto-> "ID: " + producto.getId() + " Nombre: " + producto.getNombre() +
                        " Proveedor: " + producto.getProveedor() + " Categoria: " + producto.getCategoria() +
                        " Unidades en existencia: " + producto.getUnidadesExistencia() +
                        " Precio unitario: " + producto.getPrecioUnitario())
                .collect(Collectors.toList());
        return lista;
    }

    //Obtener una consulta con Productid, productname y valor del inventario, valor inventrio (UnitsinStock * UnitPrice)
    public List<String> obtenerProducto2(){
        List<Producto> productos = obtenerTodosProductos();
        List<String> lista = productos.stream()
                .map(producto-> "ID: " + producto.getId() + " Nombre: " + producto.getNombre() +
                        " Valor de inventario: " + (producto.getUnidadesExistencia()*producto.getPrecioUnitario()))
        .collect(Collectors.toList());
        return lista;
    }

    //Cuanto vale el punto de reorden
    public List<String> obtenerProducto3(){
        List<Producto> productos = obtenerTodosProductos();
        List<String> lista = productos.stream()
                .map(producto-> "Punto de reorden (unit_price * reorder_level): "
                        +((producto.getNivelOrdenar() != null ? producto.getNivelOrdenar() : 0)*(producto.getPrecioUnitario())))
                .collect(Collectors.toList());
        return lista;
    }

    //Mostrar una consulta con Productid, productname y precio, el nombre del producto debe estar en mayuscula
    public List<String> obtenerProducto4(){
        List<Producto> productos = obtenerTodosProductos();
        List<String> lista = productos.stream()
                .map(producto-> "ID: " + producto.getId() + " Nombre: " + producto.getNombre().toUpperCase() +
                        " Precio unitario: " + producto.getPrecioUnitario()).collect(Collectors.toList());
        return lista;
    }

    //Mostrar una consulta con Productid, productname y precio, el nombre del producto debe contener unicamente 10 caracteres
    public List<String> obtenerProducto5(){
        List<Producto> productos = obtenerTodosProductos();
        List<String> lista = productos.stream()
               .map(producto-> "ID: " + producto.getId() + " Nombre: " + producto.getNombre().substring(0, Math.min(producto.getNombre().length(), 10)) +
                        " Precio unitario: " + producto.getPrecioUnitario())
                .collect(Collectors.toList());
        return lista;
    }

    //Obtener una consulta que muestre la longitud del nombre del producto
    public List<String> obtenerProducto6(){
        List<Producto> productos = obtenerTodosProductos();
        List<String> lista = productos.stream()
                .map(producto-> " Nombre: " + producto.getNombre() +
                        " Longitud: " + producto.getNombre().length())
                .collect(Collectors.toList());
        return lista;
    }

    //Obtener una consulta de la tabla de productos que muestre el nombre en minúscula
    public List<String> obtenerProducto7(){
        List<Producto> productos = obtenerTodosProductos();
        List<String> lista = productos.stream()
              .map(producto-> "Nombre en minúscula: " + producto.getNombre().toLowerCase())
              .collect(Collectors.toList());
        return lista;
    }

    //Mostrar una consulta con Productid, productname y precio, el nombre del producto debe contener unicamente 10 caracteres y se deben mostrar en mayúscula
    public List<String> obtenerProducto8(){
        List<Producto> productos = obtenerTodosProductos();
        List<String> lista = productos.stream()
              .map(producto-> "ID: " + producto.getId() + " Nombre: " + producto.getNombre()
                      .substring(0, Math.min(producto.getNombre().length(), 10)).toUpperCase() +
                        " Precio unitario: " + producto.getPrecioUnitario())
              .collect(Collectors.toList());
        return lista;
    }

    //Obtener de la tabla de Productos las columnas productid, ProductName, UnitPrice cuyos precios esten entre 50 y 150
    public List<String> obtenerProducto9() {
        List<Producto> productos = obtenerTodosProductos();
        List<String> lista = productos.stream()
                .filter(producto -> producto.getPrecioUnitario() >= 50 && producto.getPrecioUnitario() <= 150)
                .map(producto -> "ID: " + producto.getId() +
                        " Nombre: " + producto.getNombre() +
                        " Precio unitario: " + producto.getPrecioUnitario())
                .collect(Collectors.toList());
        return lista;
    }

    //Obtener de la tabla de Productos las columnas productid, ProductName, UnitPrice, UnitsInStock cuyas existencias esten entre 50 y 100
    public List<String> obtenerProducto10() {
        List<Producto> productos = obtenerTodosProductos();
        List<String> lista = productos.stream()
               .filter(producto -> producto.getUnidadesExistencia() >= 50 && producto.getUnidadesExistencia() <= 100)
               .map(producto -> "ID: " + producto.getId() +
                        " Nombre: " + producto.getNombre() +
                        " Unidades en existencia: " + producto.getUnidadesExistencia() +
                        " Precio unitario: " + producto.getPrecioUnitario())
               .collect(Collectors.toList());
        return lista;
    }

    //ORDENAR EL RESULTADO DE LA QUERY POR ALGUNA COLUMNA Obtener la información de la tabla de Products, Ordenarlos por Nombre del Producto de forma ascendente
    public List<String> obtenerProducto11() {
        List<Producto> productos = obtenerTodosProductos();
        List<String> lista = productos.stream()
                .sorted(Comparator.comparing(Producto::getNombre))
                .map(producto -> "ID: " + producto.getId() +
                        " Nombre: " + producto.getNombre() +
                        " Precio unitario: " + producto.getPrecioUnitario())
                .collect(Collectors.toList());
        return lista;
    }

    //Obtener la información de la tabla de Products, Ordenarlos por Categoria de forma ascendente y por precio unitario de forma descendente
    public List<String> obtenerProducto12() {
        List<Producto> productos = obtenerTodosProductos();
        List<String> lista = productos.stream()
                .sorted(Comparator.comparing(Producto::getCategoria)
                        .thenComparing(Comparator.comparingDouble(Producto::getPrecioUnitario).reversed()))
                .map(producto -> "ID: " + producto.getId() + " Nombre: " + producto.getNombre() +
                        " Categoria: " + producto.getCategoria() + " Precio unitario: " + producto.getPrecioUnitario())
                .collect(Collectors.toList());
        return lista;
    }

    //Obtener los productos productid, productname, categoryid, supplierid ordenar por categoryid y supplier únicamente mostrar aquellos cuyo precio esté entre 25 y 200
    public List<String> obtenerProducto13() {
        List<Producto> productos = obtenerTodosProductos();
        List<String> lista = productos.stream()
                .filter(producto -> producto.getPrecioUnitario() >= 25 && producto.getPrecioUnitario() <= 200)
              .sorted(Comparator.comparing(Producto::getCategoria)
                      .thenComparing(Comparator.comparing(Producto::getProveedor)))
              .map(producto -> "ID: " + producto.getId() + " Nombre: " + producto.getNombre() +
                        " Categoria: " + producto.getCategoria() + " Proveedor: " + producto.getProveedor()
                      + " Precio unitario: " + producto.getPrecioUnitario())
              .collect(Collectors.toList());
        return lista;
    }

    //Cuantos productos hay en la tabla de productos
    public int obtenerProducto14(){
        return obtenerTodosProductos().size();
    }

    //de la tabla de productos Sumar las cantidades en existencia
    public int obtenerProducto15(){
        List<Producto> productos = obtenerTodosProductos();
        return productos.stream().mapToInt(producto -> producto.getUnidadesExistencia()).sum();
    }

    //Promedio de los precios de la tabla de productos
    public double obtenerProducto16(){
        List<Producto> productos = obtenerTodosProductos();
        return productos.stream().mapToDouble(producto -> producto.getPrecioUnitario()).average().orElse(0);
    }

    //Obtener los datos de productos ordenados descendentemente por precio unitario de la categoría 1
    public List<String> obtenerProducto17(){
        List<Producto> productos = obtenerTodosProductos();
        List<String> lista = productos.stream()
                .filter(producto -> producto.getCategoria() == 1)
              .sorted(Comparator.comparingDouble(Producto::getPrecioUnitario).reversed())
              .map(producto -> "ID: " + producto.getId() +
                        " Nombre: " + producto.getNombre() +
                        " Categoria: " + producto.getCategoria() + " Precio unitario: " + producto.getPrecioUnitario())
              .collect(Collectors.toList());
        return lista;
    }

    //Obtener los productos cuyo precio están entre 30 y 60 ordenado por nombre
    public List<String> obtenerProducto18(){
        List<Producto> productos = obtenerTodosProductos();
        List<String> lista = productos.stream()
               .filter(producto -> producto.getPrecioUnitario() >= 30 && producto.getPrecioUnitario() <= 60)
             .sorted(Comparator.comparing(Producto::getNombre))
             .map(producto -> "ID: " + producto.getId() +
                        " Nombre: " + producto.getNombre() +
                        " Precio unitario: " + producto.getPrecioUnitario())
             .collect(Collectors.toList());
        return lista;
    }

    //OBTENER EL MAXIMO, MINIMO Y PROMEDIO DE PRECIO UNITARIO DE LA TABLA DE PRODUCTOS UTILIZANDO ALIAS
    public List<String> obtenerProducto19() {
        List<Producto> productos = obtenerTodosProductos();
        double maxPrecio = productos.stream()
                .mapToDouble(Producto::getPrecioUnitario)
                .max()
                .orElse(0.0);
        double minPrecio = productos.stream()
                .mapToDouble(Producto::getPrecioUnitario)
                .min()
                .orElse(0.0);
        double promedioPrecio = productos.stream()
                .mapToDouble(Producto::getPrecioUnitario)
                .average()
                .orElse(0.0);
        List<String> lista = new ArrayList<>();
        lista.add("Precio máximo: " + String.format("%.2f", maxPrecio));
        lista.add("Precio mínimo: " + String.format("%.2f", minPrecio));
        lista.add("Precio promedio: " + String.format("%.2f", promedioPrecio));
        return lista;
    }

    //Numero de productos por categoria
    public List<String> obtenerProducto20() {
        List<Producto> productos = obtenerTodosProductos();
        Map<Short, Long> countByCategoria = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria, Collectors.counting()));

        List<String> lista = countByCategoria.entrySet().stream()
                .map(entry -> "Categoría: " + entry.getKey() + ", Cantidad: " + entry.getValue())
                .collect(Collectors.toList());

        return lista;
    }

    //Obtener el precio promedio por proveedor de la tabla de productos
    public List<String> obtenerProducto21() {
        List<Producto> productos = obtenerTodosProductos();
        Map<Short, Double> avgPriceByProveedor = productos.stream()
                .collect(Collectors.groupingBy(Producto::getProveedor, Collectors.averagingDouble(Producto::getPrecioUnitario)));

        List<String> lista = avgPriceByProveedor.entrySet().stream()
                .map(entry -> "Proveedor: " + entry.getKey() + ", Precio promedio: " + entry.getValue())
                .collect(Collectors.toList());

        return lista;
    }

    //Obtener la suma de inventario (UnitsInStock) por SupplierID De la tabla de productos (Products)
    public List<String> obtenerProducto22() {
        List<Producto> productos = obtenerTodosProductos();
        Map<Short, Integer> inventarioPorSupplier = productos.stream()
                .collect(Collectors.groupingBy(Producto::getProveedor, Collectors.summingInt(Producto::getUnidadesExistencia)));

        List<String> lista = inventarioPorSupplier.entrySet().stream()
                .map(entry -> "SupplierID: " + entry.getKey() +
                        " Suma de inventario: " + entry.getValue())
                .collect(Collectors.toList());

        return lista;
    }



}
