package co.unicauca.microkernel.core.app;

import co.unicauca.microkernel.common.entities.Project;
import co.unicauca.microkernel.core.service.ProjectService;
import co.unicauca.microkernel.core.service.ReportService;
import co.unicauca.microkernel.core.plugin.ReportPluginManager;

public class Application {

    public static void main(String[] args) {
        try {
            // Inicializar el plugin manager
            String basePath = "src/resources/";
            ReportPluginManager.init(basePath);

            // Crear servicio de proyectos y cargar datos desde el main
            ProjectService projectService = new ProjectService();
            projectService.addProject(new Project("101", "Sistema de Deteccion de Plagas con IA",
                    "15/05/2025", "Ana Perez", "Luis Gomez",
                    "Dr. Juan Torres", "Investigacion", "Sistemas"));

            projectService.addProject(new Project("205", "Automatizacion de Riego por Sensores",
                    "20/06/2025", "Sofia Rojas", null,
                    "Ing. Carlos Mendez", "Practica Profesional", "Electronica"));

            projectService.addProject(new Project("310", "Robot de Limpieza Autonomo",
                    "30/07/2025", "Jorge Arias", "Diana Castro",
                    "Dr. Laura Velez", "Investigacion", "Automatica"));

            // Crear servicio de reportes usando el servicio de proyectos
            ReportService reportService = new ReportService(projectService);

            System.out.println("Reporte en formato HTML:");
            System.out.println(reportService.generateReport("html"));

            System.out.println("\nReporte en formato JSON:");
            System.out.println(reportService.generateReport("json"));

        } catch (Exception e) {
            System.err.println("Error al inicializar la aplicacion: " + e.getMessage());
        }
    }
}
