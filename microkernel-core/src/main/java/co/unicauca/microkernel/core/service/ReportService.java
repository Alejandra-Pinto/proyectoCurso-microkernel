package co.unicauca.microkernel.core.service;

import co.unicauca.microkernel.common.entities.Project;
import co.unicauca.microkernel.common.interfaces.IReportPlugin;
import co.unicauca.microkernel.core.plugin.ReportPluginManager;
import java.util.List;

public class ReportService {
    private ReportPluginManager pluginManager;
    private ProjectService projectService;

    public ReportService() {
        this.pluginManager = ReportPluginManager.getInstance();
        this.projectService = new ProjectService();
    }

    /**
     * Genera el reporte usando el plugin indicado por su tipo (ej: "html", "json").
     *
     * @param reportType tipo de reporte a generar
     * @return contenido del reporte o mensaje de error
     */
    public String generateReport(String reportType) {
        try {
        IReportPlugin plugin = pluginManager.getReportPlugin(reportType);
        if (plugin == null) {
            return "Error: plugin no encontrado -> " + reportType;
        }

        List<Project> data = projectService.getAll();
        return plugin.generateReport(data);

        } catch (Exception e) {
            return "Error al generar el reporte -> " + e.getMessage();
        }
    }
}
