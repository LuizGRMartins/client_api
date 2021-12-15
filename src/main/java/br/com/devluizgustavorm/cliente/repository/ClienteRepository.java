package br.com.devluizgustavorm.cliente.repository;

import br.com.devluizgustavorm.cliente.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long >{

    public Cliente findByEmail(String email);

}
