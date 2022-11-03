package com.crud.bancopopular.crudbancopopular.controller.api;

import ch.qos.logback.core.net.server.Client;
import com.crud.bancopopular.crudbancopopular.model.dto.ClienteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/Cliente/")
public interface ClienteControllerApi {
    @GetMapping("listAll")
    List<ClienteDTO> findAll();
    @GetMapping("findById/{idUser}")
    ResponseEntity<ClienteDTO> findById(@PathVariable(name = "idUser")Integer idUser);
    @GetMapping("findByIdCliente/{idCliente}")
    ResponseEntity<ClienteDTO> findClienteByIdCliente(@PathVariable(name = "idCliente")Integer idCliente);
    @PostMapping("create")
    ResponseEntity<ClienteDTO> createCliente(@Valid @RequestBody ClienteDTO clienteDTO) throws Exception;
    @PutMapping("update")
    ResponseEntity<ClienteDTO> updateClient(@Valid @RequestBody ClienteDTO clienteDTO);
    @DeleteMapping("delete/{idUser}")
   ResponseEntity<Void> delete(@PathVariable(name = "idUser")Integer idUser);
}
