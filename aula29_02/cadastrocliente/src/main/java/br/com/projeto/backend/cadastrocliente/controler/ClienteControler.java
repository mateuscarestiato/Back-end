package br.com.projeto.backend.cadastrocliente.controler;

import br.com.projeto.backend.cadastrocliente.model.Cliente;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.ArrayList;

@Controller
@RequestMapping("/cliente")
public class ClienteControler {

    private static ArrayList<Cliente> repositorio = new ArrayList<>();

    @GetMapping("/listar")
    public String listarCliente(Model model){

        model.addAttribute("listaCliente",repositorio);

        return "listar-cliente";
    }

    @GetMapping("/adicionar")
    public String adicionar(Cliente cliente){
        return "salvar";
    }
    @PostMapping("/salvar")
    public String salvar(Cliente cliente){
        int id =1;
        if (repositorio.size()>0){
            Cliente ultimo = repositorio.get(repositorio.size() -1);
            id = ultimo.getId() +1;
        }
        cliente.setId(id);
        repositorio.add(cliente);
        return "redirect:/cliente/listar";
    }
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id")int id){
        Cliente clienteASerExcluir = null;
        for (Cliente item : repositorio){
            if(item.getId()==id){
                clienteASerExcluir = item;
            }
        }
        repositorio.remove(clienteASerExcluir);
        return "redirect:/cliente/listar";
    }

}
