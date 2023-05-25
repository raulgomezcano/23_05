package com.softtek.proyecto23_05.servicio;

import com.softtek.proyecto23_05.modelo.Cliente;
import com.softtek.proyecto23_05.modelo.Producto;
import com.softtek.proyecto23_05.repo.IClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServicioImp implements IClienteServicio{
    @Autowired
    private IClienteRepo repo;
    @Override
    public List<Cliente> obtenerTodosClientes() {return repo.findAll();}

    //Obtener de la tabla de Customers las columnas CustomerId, CompanyName, Pais Obtener los clientes cuyo pais sea Spain
    public List<String> obtenerClientes1() {
        List<Cliente> clientes = obtenerTodosClientes();
        List<String> lista = clientes.stream()
                .filter(cliente -> cliente.getPais().equals("Spain"))
                .map(cliente-> "ID: " + cliente.getId() + " Nombre empresa: " + cliente.getNombreEmpresa()
                        + " Pais: " + cliente.getPais())
                .collect(Collectors.toList());
        return lista;
    }

    //Obtener de la tabla de Customers las columnas CustomerId, CompanyName, Pais, Obtener los clientes cuyo pais comience con la letra U
    public List<String> obtenerClientes2() {
        List<Cliente> clientes = obtenerTodosClientes();
        List<String> lista = clientes.stream()
               .filter(cliente -> cliente.getPais().contains("U"))
               .map(cliente-> "ID: " + cliente.getId() + " Nombre empresa: " + cliente.getNombreEmpresa()
                        + " Pais: " + cliente.getPais())
               .collect(Collectors.toList());
        return lista;
    }

    //Obtener de la tabla de Customers las columnas CustomerId, CompanyName, Pais, Obtener los clientes cuyo pais comience con la letra U,S,A
    public List<String> obtenerClientes3() {
        List<Cliente> clientes = obtenerTodosClientes();
        List<String> lista = clientes.stream()
              .filter(cliente -> cliente.getPais().contains("U") || cliente.getPais().contains("S") || cliente.getPais().contains("A"))
              .map(cliente-> "ID: " + cliente.getId() + " Nombre empresa: " + cliente.getNombreEmpresa()
                        + " Pais: " + cliente.getPais())
              .collect(Collectors.toList());
        return lista;
    }

    //Obtener la información de la tabla de Clientes, Customerid, CompanyName, city, country ordenar por pais, ciudad de forma ascendente
    public List<String> obtenerClientes4() {
        List<Cliente> clientes = obtenerTodosClientes();
        List<String> lista = clientes.stream()
                .sorted(Comparator.comparing(Cliente::getPais)
                        .thenComparing(Comparator.comparing(Cliente::getCiudad)))
              .map(cliente-> "ID: " + cliente.getId() + " Nombre empresa: " + cliente.getNombreEmpresa()
                        + " Pais: " + cliente.getPais() + " Ciudad: " + cliente.getCiudad())
              .collect(Collectors.toList());
        return lista;
    }

    //Obtener los datos de los clientes(Customers) ordenados descendentemente por nombre(CompanyName) que se encuentren en la ciudad(city) de barcelona, Lisboa
    public List<String> obtenerClientes5() {
        List<Cliente> clientes = obtenerTodosClientes();
        List<String> lista = clientes.stream()
                .filter(cliente -> cliente.getCiudad().equals("Barcelona") || cliente.getCiudad().equals("Lisboa"))
              .sorted(Comparator.comparing(Cliente::getNombreEmpresa))
              .map(cliente-> "ID: " + cliente.getId() + " Nombre empresa: " + cliente.getNombreEmpresa()
                        + " Pais: " + cliente.getPais() + " Ciudad: " + cliente.getCiudad())
              .collect(Collectors.toList());
        return lista;
    }
}
