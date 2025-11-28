package br.com.clininin.clinicar.Repository;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.clininin.clinicar.Entity.Consulta;
public  interface  ConsultaRepository  extends JpaRepository<Consulta, Integer>{
    List<Consulta> findByMedico_IdMedicoAndDatahoraConsultaBetween(Integer medicoId, LocalDateTime start, LocalDateTime end);
}
