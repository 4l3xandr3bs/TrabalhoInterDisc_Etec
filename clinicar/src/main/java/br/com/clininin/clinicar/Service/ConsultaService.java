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

    // Constructor injection — Spring will provide the dependencies
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

    /**
     * Checks if a medico is available at the requested date/time using a slot duration.
     * Returns true if available.
     */
    public boolean isMedicoAvailable(Integer medicoId, LocalDateTime requestedDateTime, Duration slotDuration) {
        if (medicoId == null || requestedDateTime == null || slotDuration == null) {
            return false;
        }

        LocalDateTime start = requestedDateTime;
        LocalDateTime end = requestedDateTime.plus(slotDuration);

        // Uses repository method findByMedico_IdMedicoAndDatahoraConsultaBetween if present
        // If your repository method has a different name, update accordingly.
        List<Consulta> overlapping = consultaRepository.findByMedico_IdMedicoAndDatahoraConsultaBetween(medicoId, start, end.minusNanos(1));
        return overlapping == null || overlapping.isEmpty();
    }

    /**
     * Map DTO-like ConsultaDisp to entity and save. This method resolves medico/client entities.
     */
    public Consulta saveFromDisp(ConsultaDisp disp) {
        if (disp == null) throw new IllegalArgumentException("ConsultaDisp is null");

        // Resolve medico and cliente using their services (they return null if not found)
        Medico medico = medicoService.findById(disp.getMedicoId());
        Cliente cliente = clienteService.findById(disp.getClienteId());

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
