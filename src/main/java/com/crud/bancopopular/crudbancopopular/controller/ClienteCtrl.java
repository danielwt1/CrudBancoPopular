package com.crud.bancopopular.crudbancopopular.controller;

import ch.qos.logback.core.net.server.Client;
import com.crud.bancopopular.crudbancopopular.controller.api.ClienteControllerApi;
import com.crud.bancopopular.crudbancopopular.model.dto.ClienteDTO;
import com.crud.bancopopular.crudbancopopular.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteCtrl implements ClienteControllerApi {

    private ClienteService clientService;

    @Autowired
    public ClienteCtrl(ClienteService clientService) {
        this.clientService = clientService;
    }

    @Override
    public List<ClienteDTO> findAll() {
        return this.clientService.findAll();
    }

    @Override
    public ResponseEntity<ClienteDTO> findById(Integer idUser) {
        ClienteDTO response =this.clientService.getClientById(idUser);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ClienteDTO> findClienteByIdCliente(Integer idCliente) {
        ClienteDTO response =this.clientService.findByIdcliente(idCliente);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ClienteDTO> createCliente(ClienteDTO clienteDTO) throws Exception {
        ClienteDTO response =this.clientService.create(clienteDTO);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ClienteDTO> updateClient(ClienteDTO clienteDTO) {
        ClienteDTO response =this.clientService.update(clienteDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(Integer idUser) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
