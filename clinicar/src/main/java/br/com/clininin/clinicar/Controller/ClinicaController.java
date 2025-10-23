package br.com.clininin.clinicar.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping; 
@Controller
@RequestMapping("/clinicar")
public class ClinicaController {
    @GetMapping
    public String index(Model model){
        //retorna a pagina index.html
        return "index";
    }
}
