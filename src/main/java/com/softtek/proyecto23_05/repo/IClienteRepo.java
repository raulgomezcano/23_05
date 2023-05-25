package com.softtek.proyecto23_05.repo;

import com.softtek.proyecto23_05.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepo extends JpaRepository<Cliente, String> {
}
