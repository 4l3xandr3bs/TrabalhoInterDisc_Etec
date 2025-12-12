package br.com.clininin.clinicar.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.clininin.clinicar.Entity.Cliente;
import br.com.clininin.clinicar.Entity.Consulta;
import br.com.clininin.clinicar.Entity.Medico;
import br.com.clininin.clinicar.Service.ClienteService;
import br.com.clininin.clinicar.Service.ConsultaService;
import br.com.clininin.clinicar.Service.MedicoService;
import br.com.clininin.clinicar.dto.ConsultaDisp;
@Controller
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    public ConsultaService consultaService;
    @Autowired
    public ClienteService clienteService;
    @Autowired
    public MedicoService medicoService;
    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("consulta", new ConsultaDisp(null, null, null, null));
        List<Consulta> consultas = consultaService.findAll();
        model.addAttribute("medicos", medicoService.findAll());
        List<Medico> medicos = medicoService.findAll();
        model.addAttribute("clientes", clienteService.findAll());
        List<Cliente> clientes = clienteService.findAll();
        return "Consulta/cadastroConsulta";
    }
@GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("consultas", consultaService.findAll());
    return "Consulta/listaConsulta";
    }

    @GetMapping("/editar/{idConsulta}")
    public String editarForm(@PathVariable("idConsulta") Integer idConsulta, Model model) {
        Consulta consulta = consultaService.findById(idConsulta);
        model.addAttribute("consulta", consultaService.findAll());
        Medico medico = medicoService.findById(idConsulta);
        model.addAttribute("medico", medicoService.findAll());
        Cliente cliente = clienteService.findById(idConsulta);
        model.addAttribute("cliente", clienteService.findAll());
        return "Consulta/cadastroConsulta";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Consulta Consulta) {
       
        consultaService.save(Consulta);

        return "redirect:/consultas/listar";
    }
    
    @GetMapping("/excluir/{idConsulta}")
    public String excluir(@PathVariable("idConsulta") Integer idConsulta) {
        consultaService.deleteById(idConsulta);
        medicoService.deleteById(idConsulta);
        clienteService.deleteById(idConsulta);
        return "redirect:/consultas/listar";
    }
}