package br.com.clininin.clinicar.Service;
import org.springframework.stereotype.Service;

import br.com.clininin.clinicar.Entity.Consulta;
import br.com.clininin.clinicar.Repository.ConsultaRepository;
@Service
public class ConsultaService {
  
    private ConsultaRepository consultaRepository;

    public Consulta save(Consulta consulta){
        return consultaRepository.save(consulta);
    }
    
    public List<Consulta> findAll(){
        return consultaRepository.findAll();
    }

    public void deleteById(Integer idConsulta){
        consultaRepository.deleteById(idConsulta);
    }

    public Consulta findById(Integer idConsulta) {
        return consultaRepository.findById(idConsulta).orElse(null);
    }
}
}