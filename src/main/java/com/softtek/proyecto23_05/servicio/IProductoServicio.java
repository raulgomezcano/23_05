package com.softtek.proyecto23_05.servicio;

import com.softtek.proyecto23_05.modelo.Cliente;
import com.softtek.proyecto23_05.modelo.Orden;
import com.softtek.proyecto23_05.modelo.Producto;

import java.util.List;

public interface IProductoServicio {
    List<Producto> obtenerTodosProductos();
}
