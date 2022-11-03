package com.crud.bancopopular.crudbancopopular.service.impl;

import ch.qos.logback.core.net.server.Client;
import com.crud.bancopopular.crudbancopopular.exception.FechaIngresoErrorException;
import com.crud.bancopopular.crudbancopopular.exception.ResourceNotFoundException;
import com.crud.bancopopular.crudbancopopular.exception.SolicitudException;
import com.crud.bancopopular.crudbancopopular.model.Cliente;
import com.crud.bancopopular.crudbancopopular.model.dto.ClienteDTO;
import com.crud.bancopopular.crudbancopopular.repository.ClienteRepository;
import com.crud.bancopopular.crudbancopopular.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clientRepo;
    private ModelMapper mapper;
    @Autowired
    public ClienteServiceImpl( ClienteRepository clientRepo,ModelMapper mapper) {
        this.clientRepo = clientRepo;
        this.mapper = mapper;
    }

    @Override
    public List<ClienteDTO> findAll() {
        List<Cliente> listClient = this.clientRepo.findAll();

        return listClient.stream().map( elem -> this.mapper.map(elem,ClienteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO getClientById(int id) {
        Cliente response = this.clientRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No se encuentra informacion con el ID : "+id));
        return this.mapper.map(response,ClienteDTO.class);
    }

    @Override
    public ClienteDTO create(ClienteDTO clienteDTO) {
        LocalDate fechaActu = LocalDate.now();

        if(!fechaActu.isBefore(clienteDTO.getFecha())){
            throw new FechaIngresoErrorException("La fecha debe ser mayor o igual a la fecha actual");
        }
        if(this.clientRepo.existsByIdCliente(clienteDTO.getId_cliente())){
            throw  new SolicitudException("Ya hay un cliente registrado con este ID ");
        }


        Cliente clientSave = this.mapper.map(clienteDTO,Cliente.class);
        Cliente responseCliente = this.clientRepo.save(clientSave);

        return this.mapper.map(responseCliente,ClienteDTO.class);
    }

    @Override
    public ClienteDTO update(ClienteDTO clienteDTO) {
        LocalDate fechaActu = LocalDate.now();
        if(!fechaActu.isBefore(clienteDTO.getFecha())){
            throw new FechaIngresoErrorException("La fecha debe ser mayor o igual a la fecha actual");
        }

        Cliente response = this.clientRepo.findById(clienteDTO.getId_cliente())
                .orElseThrow(()-> new ResourceNotFoundException("No se encuentra informacion con el ID : "+clienteDTO.getId_cliente()));
        Cliente clienteSave = this.mapper.map(clienteDTO,Cliente.class);
        clienteSave.setId(response.getId());

        return this.mapper.map(this.clientRepo.save(clienteSave),ClienteDTO.class);
    }

    @Override
    public void delete(Integer id) {
        Cliente response = this.clientRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No se encuentra informacion con el ID : "+id));
        this.clientRepo.delete(response);
    }

    @Override
    public boolean ExistByIdcliente(Integer id) {
        return this.clientRepo.existsByIdCliente(id);
    }

    @Override
    public ClienteDTO findByIdcliente(int id) {

        return this.mapper.map(this.clientRepo.findClienteByIdCliente(id),ClienteDTO.class);
    }
}
