package co.unicauca.microkernel.core.app;

import co.unicauca.microkernel.core.service.ReportService;
import co.unicauca.microkernel.core.plugin.ReportPluginManager;

public class Application {

    public static void main(String[] args) {
        try {
            // Inicializar el plugin manager con la ruta base donde está el archivo plugin.properties
            // Ejemplo: si el archivo está en src/main/resources, se pasa esa ruta
            String basePath = "src/resources/"; 
            ReportPluginManager.init(basePath);

            ReportService reportService = new ReportService();

            System.out.println("Reporte en formato HTML:");
            System.out.println(reportService.generateReport("html"));

            System.out.println("\nReporte en formato JSON:");
            System.out.println(reportService.generateReport("json"));

        } catch (Exception e) {
            System.err.println("Error al inicializar la aplicación: " + e.getMessage());
        }
    }
}
