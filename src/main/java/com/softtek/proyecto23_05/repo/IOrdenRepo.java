package com.softtek.proyecto23_05.repo;

import com.softtek.proyecto23_05.modelo.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdenRepo extends JpaRepository<Orden, Integer> {
}
