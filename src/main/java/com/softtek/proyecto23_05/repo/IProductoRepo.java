package com.softtek.proyecto23_05.repo;

import com.softtek.proyecto23_05.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductoRepo extends JpaRepository<Producto, Integer> {

}
