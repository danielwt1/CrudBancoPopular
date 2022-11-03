package com.crud.bancopopular.crudbancopopular.service;

import com.crud.bancopopular.crudbancopopular.model.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {

    List<ClienteDTO> findAll();
    ClienteDTO getClientById(int id);
    ClienteDTO  create(ClienteDTO clienteDTO);
    ClienteDTO update(ClienteDTO clienteDTO);
    void delete(Integer id);
    boolean ExistByIdcliente(Integer id);
    ClienteDTO findByIdcliente(int id);

}
