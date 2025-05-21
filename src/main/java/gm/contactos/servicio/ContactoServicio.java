package gm.contactos.servicio;

import gm.contactos.modelo.Contacto;
import gm.contactos.repositorio.ContactoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContactoServicio implements IContactoServicio{

    @Autowired
    private ContactoRepositorio contactoRepositorio;

    @Override
    public List<Contacto> listarContactos() {
        List<Contacto> contactos = contactoRepositorio.findAll();
        return contactos;
    }

    @Override
    public Contacto buscarContactoPorId(Integer idContacto) {
        Contacto contacto = contactoRepositorio.findById(idContacto).orElse(null);
        return contacto;
    }

    @Override
    public void guardarContacto(Contacto contacto) {
        contactoRepositorio.save(contacto);
    }

    @Override
    public void eliminarContacto(Integer idContacto) {
        contactoRepositorio.deleteById(idContacto);
    }
}
