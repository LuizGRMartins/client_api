package br.com.devluizgustavorm.cliente.controller;

import br.com.devluizgustavorm.cliente.dto.ClienteRequestDTO;
import br.com.devluizgustavorm.cliente.dto.ClienteResponseDTO;
import br.com.devluizgustavorm.cliente.model.Cliente;
import br.com.devluizgustavorm.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ClienteResponseDTO criarCliente(@RequestBody ClienteRequestDTO clienteRequestDTO){
        ClienteResponseDTO clienteSalvo = clienteService.criarCliente(clienteRequestDTO);
        return clienteSalvo;
    }

    @GetMapping
    public List<ClienteResponseDTO> listarClientes(){
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public Cliente consultarPorId(@PathVariable Long id){
        return clienteService.consultarPorId(id);
    }

    @GetMapping("/email/{email}")
    public Cliente consultarPorEmail(@PathVariable String email){
        return clienteService.consultarPorEmail(email);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCliente(@PathVariable Long id, @RequestBody ClienteRequestDTO clienteRequestDTO) throws Exception {
        clienteService.atualizarCliente(clienteRequestDTO, id);
    }

}
