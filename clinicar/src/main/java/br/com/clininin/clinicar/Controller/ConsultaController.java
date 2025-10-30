package br.com.clininin.clinicar.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.clininin.clinicar.Entity.Consulta;
import br.com.clininin.clinicar.Service.ConsultaService;
@Controller
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    public ConsultaService consultaService;

   

    @GetMapping("/listar")
    public String listar(Model  model) {
        List<Consulta> consultas = consultaService.findAll();
        model.addAttribute("consultas", consultas);
        return "consulta/listaConsultas";
    }
    
    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("consulta", new consulta());
        return "consulta/cadastroConsulta";
    }

    @GetMapping("/excluir/{idConsulta}")
    public String excluir(@PathVariable Integer idConsulta) {
        consultaService.deleteById(idMedico);
        return "redirect:/consultas/listar";
    }
    
    @GetMapping("/editar/{idConsulta}")
    public String editarForm(@PathVariable Integer idConsulta, Model model) {
        consulta consulta = consultaService.findById(idConsulta);
        model.addAttribute("consulta", consulta);
        return "medico/cadastroConsulta";
    }
}