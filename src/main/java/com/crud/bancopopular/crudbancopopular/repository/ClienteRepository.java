package com.crud.bancopopular.crudbancopopular.repository;

import com.crud.bancopopular.crudbancopopular.model.Cliente;
import com.crud.bancopopular.crudbancopopular.model.dto.ClienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    boolean existsByIdCliente(int idCliente);
    Cliente findClienteByIdCliente(int idCliente);
}
