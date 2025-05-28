package gm.contactos.controlador;

import gm.contactos.modelo.Contacto;
import gm.contactos.servicio.ContactoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.MessageFormat;

@Controller
public class AgregarControlador {

    private final Logger logger = LoggerFactory.getLogger(AgregarControlador.class);
    private final String nl = System.lineSeparator();

    //Inyectamos una instancia de ContactoServicio
    @Autowired
    private ContactoServicio contactoServicio;

    //Procesamos la petición get hacia la url /agregar
    @GetMapping("/agregar")
    public String inicializar(){
        return "agregar"; //regresamos la vista homónima
    }

    //Procesamos la petición post hacia /agregar
    @PostMapping("/agregar")
    /*
     * Recibimos un objeto de tipo Contacto y le añadimos la anotación ModelAttribute para que
     * se cree automaticamenté con los datos del formulario*/

    public String agregar(@ModelAttribute("contactoForm")Contacto contacto){
        //Imprimimos un salto de línea y el objeto contacto
        logger.info(nl);
        logger.info("Contacto a agregar: {}", contacto.toString());
        //guardamos el objeto en la base de datos
        contactoServicio.guardarContacto(contacto);
        //Redirigimos al path "/" para que se recargue la página de inicio y se actualice automáticamente la tabla
        return "redirect:/";
    }
}
