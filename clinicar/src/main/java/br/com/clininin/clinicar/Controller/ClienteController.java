
package br.com.clininin.clinicar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.clininin.clinicar.Entity.Cliente;
import br.com.clininin.clinicar.Service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    public ClienteService clienteService;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "medico/listaMedico";
    }

    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "curso/formularioMedico";
    }

    @GetMapping("/excluir/{idCliente}")
    public String excluir(@PathVariable Integer idMedico) {
        clienteService.deleteById(idMedico);
        return "redirect:/clientes/listar";
    }

    @GetMapping("/editar/{idCliente}")
    public String editarForm(@PathVariable Integer idCliente, Model model) {
        Cliente cliente = clienteService.findById(idCliente);
        model.addAttribute("cliente", cliente);
        return "cliente/formularioMedico";
    }


}