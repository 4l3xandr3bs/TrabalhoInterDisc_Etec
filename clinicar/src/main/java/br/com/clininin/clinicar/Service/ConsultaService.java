package br.com.clininin.clinicar.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;


import org.springframework.stereotype.Service;

import br.com.clininin.clinicar.Entity.Cliente;
import br.com.clininin.clinicar.Entity.Consulta;
import br.com.clininin.clinicar.Entity.Medico;
import br.com.clininin.clinicar.Repository.ConsultaRepository;
import br.com.clininin.clinicar.dto.ConsultaDisp;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final MedicoService medicoService;
    private final ClienteService clienteService;

   
    public ConsultaService(ConsultaRepository consultaRepository,
                           MedicoService medicoService,
                           ClienteService clienteService) {
        this.consultaRepository = consultaRepository;
        this.medicoService = medicoService;
        this.clienteService = clienteService;
    }

    public Consulta save(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public void deleteById(Integer idConsulta) {
        consultaRepository.deleteById(idConsulta);
    }

    public Consulta findById(Integer idConsulta) {
        return consultaRepository.findById(idConsulta).orElse(null);
    }

    public boolean isMedicoAvailable(Integer idMedico, LocalDateTime requestedDateTime, Duration slotDuration) {
        if (idMedico == null || requestedDateTime == null || slotDuration == null) {
            return false;
        }

        LocalDateTime start = requestedDateTime;
        LocalDateTime end = requestedDateTime.plus(slotDuration);


        List<Consulta> overlapping = consultaRepository.findByMedico_IdMedicoAndDatahoraConsultaBetween(idMedico, start, end.minusNanos(1));
        return overlapping == null || overlapping.isEmpty();
    }

  
    public Consulta saveFromDisp(ConsultaDisp disp) {
        if (disp == null) throw new IllegalArgumentException("ConsultaDisp is null");

    
        Medico medico = medicoService.findById(disp.getIdMedico());
        Cliente cliente = clienteService.findById(disp.getIdCliente());

        if (medico == null || cliente == null) {
            throw new IllegalArgumentException("Médico ou Cliente não encontrado");
        }

        Consulta consulta = new Consulta();
        consulta.setDatahoraConsulta(disp.getDatahoraConsulta());
        consulta.setTipoConsulta(disp.getTipoConsulta());
        consulta.setMedico(medico);
        consulta.setCliente(cliente);

        return consultaRepository.save(consulta);
    }

}
