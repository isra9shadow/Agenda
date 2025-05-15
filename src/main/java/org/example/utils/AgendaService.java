package org.example.utils;

import org.example.models.Contacto;

import java.util.ArrayList;
import java.util.List;

public class AgendaService {
    private final List<Contacto> contactosAgenda = new ArrayList<>();

    public void addContact(Contacto contacto) {
        contactosAgenda.add(contacto);
    }

    public List<Contacto> getContactos() {
        return contactosAgenda;
    }
}