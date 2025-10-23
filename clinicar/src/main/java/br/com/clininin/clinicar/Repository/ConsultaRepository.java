package br.com.clininin.clinicar.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.clininin.clinicar.Entity.Consulta;
public  interface  ConsultaRepository  extends JpaRepository<Consulta, Integer>{
    
}
