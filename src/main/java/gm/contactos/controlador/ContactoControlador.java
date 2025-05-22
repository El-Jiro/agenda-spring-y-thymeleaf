package gm.contactos.controlador;

import gm.contactos.modelo.Contacto;
import gm.contactos.servicio.ContactoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ContactoControlador {

    private static final Logger logger = LoggerFactory.getLogger(ContactoControlador.class);
    private static final String nl = System.lineSeparator();

    @Autowired
    private ContactoServicio contactoServicio;

    //Definimos la url a procesar
    @GetMapping("/")
    public String inicializar(ModelMap model){

        //Recuperamos los contactos de la base de datos
        List<Contacto> contactos = contactoServicio.listarContactos();
        //Los imprimimos en consola
        logger.info(nl);
        contactos.forEach((contacto)->{
            logger.info(contacto.toString());
        });
        //Compartimos la información con la vista
        model.put("contactos", contactos);
        //devolvemos la vista de index
        return "index"; //index.html
    }

}
