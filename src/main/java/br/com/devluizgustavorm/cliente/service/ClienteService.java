package br.com.devluizgustavorm.cliente.service;

import br.com.devluizgustavorm.cliente.dto.ClienteRequestDTO;
import br.com.devluizgustavorm.cliente.dto.ClienteResponseDTO;
import br.com.devluizgustavorm.cliente.model.Cliente;
import br.com.devluizgustavorm.cliente.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ClienteResponseDTO criarCliente(ClienteRequestDTO clienteRequestDTO){
        Cliente cliente = modelMapper.map(clienteRequestDTO, Cliente.class);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        ClienteResponseDTO clienteResponseDTO = modelMapper.map(clienteSalvo, ClienteResponseDTO.class);
        return clienteResponseDTO;
    }

    public List<ClienteResponseDTO> listarClientes(){
        List<Cliente> clienteList = (List<Cliente>)clienteRepository.findAll();
        List<ClienteResponseDTO> clienteResponseDTOList = new ArrayList<>();
        clienteList.forEach(cliente -> {
            ClienteResponseDTO clienteResponseDTO = modelMapper.map(cliente, ClienteResponseDTO.class);
            clienteResponseDTOList.add(clienteResponseDTO);
        });
        return clienteResponseDTOList;
    }

    public Cliente consultarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente consultarPorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    public void atualizarCliente(ClienteRequestDTO clienteRequestDTO, Long id) throws Exception {
        Cliente clienteBase = consultarPorId(id);
        if(clienteBase == null){
            throw new Exception("Cliete não encontrado.");
        }
        //Parse
        modelMapper.map(clienteRequestDTO, clienteBase);
        clienteRepository.save(clienteBase);

    }
}

