package gm.contactos.servicio;

import gm.contactos.modelo.Contacto;

import java.util.List;

public interface IContactoServicio {

    List<Contacto> listarContactos();

    Contacto buscarContactoPorId(Integer idContacto);

    void guardarContacto(Contacto contacto);

    void eliminarContacto(Integer idContacto);
}
