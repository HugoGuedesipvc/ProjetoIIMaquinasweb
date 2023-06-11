package p2.projetoiimaquinasweb.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import p2.projetoiimaquinasweb.DAO.Login;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("email") String email, @RequestParam("nif") String nif, Model model) {
        Login.LoginUser(email, nif);
        
        if (Login.getSessao() != null) {
            return "redirect:/menu-reposicao";
        } else {
            model.addAttribute("error", "Credenciais inválidas. Por favor, tente novamente.");
            return "login";
        }
    }
}
