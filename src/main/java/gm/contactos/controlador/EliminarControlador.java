package gm.contactos.controlador;

import gm.contactos.servicio.ContactoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EliminarControlador {

    @Autowired
    public ContactoServicio contactoServicio;

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") int idContacto){
        contactoServicio.eliminarContacto(idContacto);
        return "redirect:/";
    }
}
