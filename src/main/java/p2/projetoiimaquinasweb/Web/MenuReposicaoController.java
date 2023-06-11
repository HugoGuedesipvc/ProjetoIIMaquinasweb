package p2.projetoiimaquinasweb.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import p2.projetoiimaquinasweb.DAO.Login;
import p2.projetoiimaquinasweb.DAO.ReposicaoMaquinasDAO;
import p2.projetoiimaquinasweb.Classes.Reposicao_Maquinas;

import java.util.List;

@Controller
public class MenuReposicaoController {

    private ReposicaoMaquinasDAO reposicaoMaquinasDAO;

    @Autowired
    public MenuReposicaoController(ReposicaoMaquinasDAO reposicaoMaquinasDAO) {
        this.reposicaoMaquinasDAO = reposicaoMaquinasDAO;
    }

    @GetMapping("/menu-reposicao")
    public String showMenuReposicaoPage(Model model) {
        int idUtilizador = Login.getSessao().getId_utilizador();
        List<Reposicao_Maquinas> reposicoesMaquinas = reposicaoMaquinasDAO.getReposicoesMaquinasPorUtilizador(idUtilizador);

        model.addAttribute("reposicoesMaquinas", reposicoesMaquinas);

        return "menu-reposicao";
    }
}
