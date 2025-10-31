  
package br.com.clininin.clinicar.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.clininin.clinicar.Entity.Cliente;
public  interface  ClienteRepository  extends JpaRepository<Cliente, Integer>{
    
}