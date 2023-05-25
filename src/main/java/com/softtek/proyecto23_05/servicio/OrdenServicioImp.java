package com.softtek.proyecto23_05.servicio;

import com.softtek.proyecto23_05.modelo.Orden;
import com.softtek.proyecto23_05.repo.IOrdenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrdenServicioImp implements IOrdenServicio{
    @Autowired
    private IOrdenRepo repo;
    @Override
    public List<Orden> obtenerTodasOrdenes() {return repo.findAll();
    }

    //Crear una consulta para obtener el IdOrden, IdCustomer, Fecha de la orden de la tabla de ordenes.
    public List<String> obtenerOrden1(){
        List<Orden> ordenes = obtenerTodasOrdenes();
        List<String> lista = ordenes.stream()
                .map(orden-> "ID: " + orden.getId() + " IDCustomer: " + orden.getCliente() +
                        " Fecha de orden: " + orden.getFechaOrden())
                .collect(Collectors.toList());
        return lista;
    }
    //Crear una consulta para obtener el OrderId, EmployeeId, Fecha de la orden.
    public List<String> obtenerOrden2(){
        List<Orden> ordenes = obtenerTodasOrdenes();
        List<String> lista = ordenes.stream()
                .map(orden-> "ID: " + orden.getId() + " EmployeeID: " + orden.getEmpleado() +
                        " Fecha de orden: " + orden.getFechaOrden())
                .collect(Collectors.toList());
        return lista;
    }

    //Obtener las columnas OrderId, CustomerId, employeeid de la tabla de ordenes cuyos empleados sean 1, 4, 9
    public List<String> obtenerOrden3() {
        List<Orden> ordenes = obtenerTodasOrdenes();
        List<Integer> empleadosPermitidos = Arrays.asList(1, 4, 9);
        List<String> lista = ordenes.stream()
                .filter(orden -> empleadosPermitidos.contains(orden.getEmpleado()))
                .map(orden -> "ID: " + orden.getId() +
                        " CustomerID: " + orden.getCliente() +
                        " EmployeeID: " + orden.getEmpleado())
                .collect(Collectors.toList());
        return lista;
    }

    //Obtener los datos de las ordenes, ordenados descendentemente por la fecha de la orden cuyo cliente(CustomerId) sea ALFKI
    public List<String> obtenerOrden4() {
        List<Orden> ordenes = obtenerTodasOrdenes();
        List<String> lista = ordenes.stream()
              .filter(orden -> orden.getCliente().equals("ALFKI"))
                .sorted(Comparator.comparing(Orden::getFechaOrden).reversed())
              .map(orden -> "ID: " + orden.getId() +
                        " CustomerID: " + orden.getCliente() +
                        " EmployeeID: " + orden.getEmpleado())
              .collect(Collectors.toList());
        return lista;
    }

    //Obtener los datos de las ordenes ordenados ascendentemente por la fecha de la orden cuyo empleado sea 2 o 4
    public List<String> obtenerOrden5() {
        List<Orden> ordenes = obtenerTodasOrdenes();
        List<String> lista = ordenes.stream()
              .filter(orden -> orden.getEmpleado().equals(Short.valueOf("2")) || orden.getEmpleado().equals(Short.valueOf("4")))
              .sorted(Comparator.comparing(Orden::getFechaOrden))
              .map(orden -> "ID: " + orden.getId() + " CustomerID: " + orden.getCliente()
                       + " EmployeeID: " + orden.getEmpleado() + " Fecha orden: " + orden.getFechaOrden())
              .collect(Collectors.toList());
        return lista;
    }

    //Contar las ordenes por cliente de la tabla de orders
    public List<String> obtenerOrden6() {
        List<Orden> ordenes = obtenerTodasOrdenes();
        Map<String, Long> conteoPorCliente = ordenes.stream()
                .collect(Collectors.groupingBy(Orden::getCliente, Collectors.counting()));

        List<String> lista = conteoPorCliente.entrySet().stream()
                .map(entry -> "Cliente: " + entry.getKey() + " Número de órdenes: " + entry.getValue())
                .collect(Collectors.toList());

        return lista;
    }

}
