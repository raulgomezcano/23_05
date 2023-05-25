package com.softtek.proyecto23_05;

import com.softtek.proyecto23_05.servicio.ClienteServicioImp;
import com.softtek.proyecto23_05.servicio.IClienteServicio;
import com.softtek.proyecto23_05.servicio.OrdenServicioImp;
import com.softtek.proyecto23_05.servicio.ProductoServicioImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Proyecto2305Application implements CommandLineRunner {
    @Autowired
    private ProductoServicioImp productoServicioImp;
    @Autowired
    private ClienteServicioImp clienteServicioImp;
    @Autowired
    private OrdenServicioImp ordenServicioImp;
    public static void main(String[] args) {
        SpringApplication.run(Proyecto2305Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        /*System.out.println("Select * from products");
        productoServicioImp.obtenerTodosProductos().forEach(System.out::println);*/
        /*System.out.println("Select * from clientes");
        clienteServicioImp.obtenerTodosClientes().forEach(System.out::println);
        System.out.println("Select * from ordenes");
        ordenServicioImp.obtenerTodosOrdenes().forEach(System.out::println);*/

        /*System.out.println("Obtener una consulta con Productid, productname, supplierid, categoryId, UnistsinStock, UnitPrice");
        productoServicioImp.obtenerProducto1().forEach(System.out::println);*/

        /*System.out.println("Crear una consulta para obtener el IdOrden, IdCustomer, Fecha de la orden de la tabla de ordenes.");
        ordenServicioImp.obtenerOrden1().forEach(System.out::println);*/

        /*System.out.println("Crear una consulta para obtener el OrderId, EmployeeId, Fecha de la orden.");
        ordenServicioImp.obtenerOrden2().forEach(System.out::println);*/

        /*System.out.println("Obtener una consulta con Productid, productname y valor del inventario, valor inventrio (UnitsinStock * UnitPrice)");
        productoServicioImp.obtenerProducto2().forEach(System.out::println);*/

        /*System.out.println("Cuanto vale el punto de reorden");
        productoServicioImp.obtenerProducto3().forEach(System.out::println);*/

        /*System.out.println("Mostrar una consulta con Productid, productname y precio, el nombre del producto debe estar en mayuscula");
        productoServicioImp.obtenerProducto4().forEach(System.out::println);*/

        /*System.out.println("Mostrar una consulta con Productid, productname y precio, el nombre del producto debe contener unicamente 10 caracteres");
        productoServicioImp.obtenerProducto5().forEach(System.out::println);*/

        /*System.out.println("Obtenre una consulta que muestre la longitud del nombre del producto");
        productoServicioImp.obtenerProducto6().forEach(System.out::println);*/

        /*System.out.println("Obtener una consulta de la tabla de productos que muestre el nombre en minúscula");
        productoServicioImp.obtenerProducto7().forEach(System.out::println);*/

        /*System.out.println("Mostrar una consulta con Productid, productname y precio, el nombre del producto debe contener unicamente 10 caracteres y se deben mostrar en mayúscula");
        productoServicioImp.obtenerProducto8().forEach(System.out::println);*/

        /*System.out.println("Obtener de la tabla de Customers las columnas CustomerId, CompanyName, Pais Obtener los clientes cuyo pais sea Spain");
        clienteServicioImp.obtenerClientes1().forEach(System.out::println);*/

        /*System.out.println("Obtener de la tabla de Customers las columnas CustomerId, CompanyName, Pais, Obtener los clientes cuyo pais comience con la letra U");
        clienteServicioImp.obtenerClientes2().forEach(System.out::println);*/

        /*System.out.println("Obtener de la tabla de Customers las columnas CustomerId, CompanyName, Pais, Obtener los clientes cuyo pais comience con la letra U,S,A");
        clienteServicioImp.obtenerClientes3().forEach(System.out::println);*/

        /*System.out.println("Obtener de la tabla de Productos las columnas productid, ProductName, UnitPrice cuyos precios esten entre 50 y 150");
        productoServicioImp.obtenerProducto9().forEach(System.out::println);*/

        /*System.out.println("Obtener de la tabla de Productos las columnas productid, ProductName, UnitPrice, UnitsInStock cuyas existencias esten entre 50 y 100");
        productoServicioImp.obtenerProducto10().forEach(System.out::println);*/

        /*System.out.println("Obtener las columnas OrderId, CustomerId, employeeid de la tabla de ordenes cuyos empleados sean 1, 4, 9");
        ordenServicioImp.obtenerOrden3().forEach(System.out::println);*/

        /*System.out.println("ORDENAR EL RESULTADO DE LA QUERY POR ALGUNA COLUMNA Obtener la información de la tabla de Products, Ordenarlos por Nombre del Producto de forma ascendente");
        productoServicioImp.obtenerProducto11().forEach(System.out::println);*/

        /*System.out.println("Obtener la información de la tabla de Products, Ordenarlos por Categoria de forma ascendente y por precio unitario de forma descendente");
        productoServicioImp.obtenerProducto12().forEach(System.out::println);*/

        /*System.out.println("Obtener la información de la tabla de Clientes, Customerid, CompanyName, city, country ordenar por pais, ciudad de forma ascendente");
        clienteServicioImp.obtenerClientes4().forEach(System.out::println);*/

        /*System.out.println("Obtener los productos productid, productname, categoryid, supplierid ordenar por categoryid y supplier únicamente mostrar aquellos cuyo precio esté entre 25 y 200");
        productoServicioImp.obtenerProducto13().forEach(System.out::println);*/

        /*System.out.println("Cuantos productos hay en la tabla de productos");
        System.out.println("Hay " + productoServicioImp.obtenerProducto14() + " productos");*/

        /*System.out.println("de la tabla de productos Sumar las cantidades en existencia ");
        System.out.println("Hay " + productoServicioImp.obtenerProducto15() + " cantidades en existencia ");*/

        /*System.out.println("Promedio de los precios de la tabla de productos");
        System.out.println("Precio promedio de la tabla de productos: " + productoServicioImp.obtenerProducto16());*/

        /*System.out.println("Obtener los datos de productos ordenados descendentemente por precio unitario de la categoría 1");
        productoServicioImp.obtenerProducto17().forEach(System.out::println);*/

        /*System.out.println("Obtener los datos de los clientes(Customers) ordenados descendentemente por nombre(CompanyName) que se encuentren en la ciudad(city) de barcelona, Lisboa");
        clienteServicioImp.obtenerClientes5().forEach(System.out::println);*/

        /*System.out.println("Obtener los datos de las ordenes, ordenados descendentemente por la fecha de la orden cuyo cliente(CustomerId) sea ALFKI");
        ordenServicioImp.obtenerOrden4().forEach(System.out::println);*/

        /*System.out.println("Obtener los datos de las ordenes ordenados ascendentemente por la fecha de la orden cuyo empleado sea 2 o 4");
        ordenServicioImp.obtenerOrden5().forEach(System.out::println);*/

        /*System.out.println("Obtener los productos cuyo precio están entre 30 y 60 ordenado por nombre");
        productoServicioImp.obtenerProducto18().forEach(System.out::println);*/

        /*System.out.println("OBTENER EL MAXIMO, MINIMO Y PROMEDIO DE PRECIO UNITARIO DE LA TABLA DE PRODUCTOS UTILIZANDO ALIAS");
        productoServicioImp.obtenerProducto19().forEach(System.out::println);*/

        /*System.out.println("Numero de productos por categoria");
        productoServicioImp.obtenerProducto20().forEach(System.out::println);*/

        /*System.out.println("Obtener el precio promedio por proveedor de la tabla de productos");
        productoServicioImp.obtenerProducto21().forEach(System.out::println);*/

        /*System.out.println("Obtener la suma de inventario (UnitsInStock) por SupplierID De la tabla de productos (Products)");
        productoServicioImp.obtenerProducto22().forEach(System.out::println);*/

        System.out.println("Contar las ordenes por cliente de la tabla de orders");
        ordenServicioImp.obtenerOrden6().forEach(System.out::println);
    }
}
