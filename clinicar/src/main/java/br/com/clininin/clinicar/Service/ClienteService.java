package br.com.clininin.clinicar.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clininin.clinicar.Entity.Cliente;
import br.com.clininin.clinicar.Repository.ClienteRepository;
@Service
public class ClienteService {
    @Autowired 
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente ){
        return clienteRepository.save(cliente);
  
    }
    
    public List<Cliente> findAll(){
      return clienteRepository.findAll();
    }
     public void deleteById(Integer idCliente){
        clienteRepository.deleteById(idCliente);
      }
      public Cliente findById(Integer idCliente){
          return clienteRepository.findById(idCliente).orElse(null);
      };
}