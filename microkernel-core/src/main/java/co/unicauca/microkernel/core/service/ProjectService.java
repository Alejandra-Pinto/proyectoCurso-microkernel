package co.unicauca.microkernel.core.service;

import co.unicauca.microkernel.common.entities.Project;
import java.util.ArrayList;
import java.util.List;

public class ProjectService {
    public List<Project> getAll() {
        List<Project> list = new ArrayList<>();

        list.add(new Project("101", "Sistema de Deteccion de Plagas con IA", "15/05/2025",
                "Ana Perez", "Luis Gomez", "Dr. Juan Torres", "Investigacien", "Sistemas"));

        list.add(new Project("205", "Automatizacien de Riego por Sensores", "20/06/2025",
                "Sofia Rojas", null, "Ing. Carlos Mendez", "Practica Profesional", "Electronica"));

        list.add(new Project("310", "Robot de Limpieza Autonomo", "30/07/2025",
                "Jorge Arias", "Diana Castro", "Dr. Laura Velez", "Investigacion", "Automatica"));

        return list;
    }
}
