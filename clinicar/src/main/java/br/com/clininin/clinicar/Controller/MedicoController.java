
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
import br.com.clininin.clinicar.Entity.Medico;
import br.com.clininin.clinicar.Service.MedicoService;
@Controller
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    public MedicoService medicoService;

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Medico medico) {
        // salva aluno
        medicoService.save(medico);

        return "redirect:/medicos/listar";
    }

    @GetMapping("/listar")
    public String listar(Model  model) {
        List<Medico> medicos = medicoService.findAll();
        model.addAttribute("medicos", medicos);
        return "Medico/listaMedico";
    }
    
    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("medico", new Medico());
        return "Medico/cadastroMedico";
    }

    @GetMapping("/excluir/{idMedico}")
    public String excluir(@PathVariable Integer idMedico) {
        medicoService.deleteById(idMedico);
        return "redirect:/medicos/listar";
    }
    
    @GetMapping("/editar/{idMedico}")
    public String editarForm(@PathVariable Integer idMedico, Model model) {
        Medico medico = medicoService.findById(idMedico);
        model.addAttribute("medico", medico);
        return "Medico/cadastroMedico";
    }
}
