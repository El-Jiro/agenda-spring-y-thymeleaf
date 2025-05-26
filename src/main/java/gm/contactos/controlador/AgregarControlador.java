package gm.contactos.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgregarControlador {

    @GetMapping("/agregar")
    public String inicializar(){
        return "agregar";
    }
}
