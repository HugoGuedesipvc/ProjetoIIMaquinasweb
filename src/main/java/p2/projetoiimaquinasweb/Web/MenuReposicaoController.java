package p2.projetoiimaquinasweb.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuReposicaoController {

    @GetMapping("/menu-reposicao")
    public String showMenuReposicaoPage() {
        return "menu-reposicao";
    }
}
