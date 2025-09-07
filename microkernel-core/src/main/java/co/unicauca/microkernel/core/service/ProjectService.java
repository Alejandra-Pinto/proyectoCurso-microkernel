package co.unicauca.microkernel.core.service;

import co.unicauca.microkernel.common.entities.Project;
import java.util.ArrayList;
import java.util.List;

public class ProjectService {
    private final List<Project> projects;

    public ProjectService() {
        this.projects = new ArrayList<>();
    }

    /**
     * Agrega un proyecto a la lista
     */
    public void addProject(Project project) {
        this.projects.add(project);
    }

    /**
     * Devuelve todos los proyectos cargados
     */
    public List<Project> getAll() {
        return new ArrayList<>(projects); // se devuelve copia para evitar modificaciones externas
    }

    /**
     * Limpia todos los proyectos (opcional)
     */
    public void clear() {
        this.projects.clear();
    }
}
