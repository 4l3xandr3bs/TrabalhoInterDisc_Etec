package br.com.clininin.clinicar.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.clininin.clinicar.Entity.Medico;
public  interface  MedicoRepository  extends JpaRepository<Medico, Integer>{
    
}
