package gm.contactos.controlador;

import gm.contactos.modelo.Contacto;
import gm.contactos.servicio.ContactoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditarControlador {

    private final Logger logger = LoggerFactory.getLogger(EditarControlador.class);
    private final String nl = System.lineSeparator();

    @Autowired
    private ContactoServicio contactoServicio;

    //Añadimos la anotación GetMapping para procesar la petición y especificamos el url /editar con el parámetro id entre llaves
    @GetMapping("/editar/{id}")
    //Añadimos la anotación PathVariable para recuperar el id de la petición y lo guardamos en la variable idContacto
    public String inicializar(@PathVariable(value = "id") int idContacto, ModelMap model){

        //Recuperamos el contacto de la base de datos mediante su id
        Contacto contacto = contactoServicio.buscarContactoPorId(idContacto);
        //Lo imprimimos en consola
        logger.info(nl);
        logger.info("Contacto seleccionado: {}", contacto.toString());
        //Lo compartimos con la vista
        model.put("contacto", contacto);

        //Regresamos la vista de editar
        return "editar";
    }

    //Creamos un método para procesar el formulario
    @PostMapping("/editar")
    //Añadimos la anotación ModelAttribute para que se cree automáticamente el objeto contacto con lso datos del formulario
    public String editar(@ModelAttribute("contacto") Contacto contacto){

        //Imprimimos el contacto en consola
        logger.info(nl);
        logger.info("Contacto a editar: {}", contacto.toString());

        //Lo guardamos en la base de datos
        contactoServicio.guardarContacto(contacto);

        //redirigimos hacia la url de inicio
        return "redirect:/";
    }


}
