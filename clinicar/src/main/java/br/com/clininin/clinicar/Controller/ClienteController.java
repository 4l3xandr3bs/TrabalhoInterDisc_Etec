
package br.com.clininin.clinicar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.clininin.clinicar.Entity.Cliente;
import br.com.clininin.clinicar.Service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    public ClienteService clienteService;

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Cliente cliente) {
        // salva aluno
        clienteService.save(cliente);

        return "redirect:/clientes/listar";
    }
    @GetMapping("/listar")
    public String listar(Model model) {
        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "Cliente/listaCliente";
    }

    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "Cliente/cadastroCliente";
    }

    @GetMapping("/excluir/{idCliente}")
    public String excluir(@PathVariable("idCliente") Integer idCliente) {
        clienteService.deleteById(idCliente);
        return "redirect:/clientes/listar";
    }

    @GetMapping("/editar/{idCliente}")
    public String editarForm(@PathVariable("idCliente") Integer idCliente, Model model) {
        Cliente cliente = clienteService.findById(idCliente);
        model.addAttribute("cliente", cliente);
        return "Cliente/cadastroCliente";
    }


}