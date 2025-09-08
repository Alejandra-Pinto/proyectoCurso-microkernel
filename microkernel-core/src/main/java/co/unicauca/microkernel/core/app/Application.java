package co.unicauca.microkernel.core.app;

import co.unicauca.microkernel.common.entities.Project;
import co.unicauca.microkernel.core.service.ProjectService;
import co.unicauca.microkernel.core.service.ReportService;
import co.unicauca.microkernel.core.plugin.ReportPluginManager;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {

    public static void main(String[] args) {
         //Inicializar el plugin manager con la ruta base de la aplicación.
        String basePath = getBaseFilePath();
        try {
            // Inicializar el plugin manager
            //String basePath = "src/main/resources/";
            ReportPluginManager.init(basePath);

            Scanner sc = new Scanner(System.in);

            // Crear servicio de proyectos
            ProjectService projectService = new ProjectService();

            // Preguntar cuántos proyectos quiere ingresar el usuario
            System.out.print("Digite el numero de los proyectos desea registrar: ");
            int numProyectos = Integer.parseInt(sc.nextLine());

            for (int i = 1; i <= numProyectos; i++) {
                System.out.println("\n--- Proyecto " + i + " ---");
                System.out.print("ID del proyecto: ");
                String id = sc.nextLine();

                System.out.print("Nombre del proyecto: ");
                String nombre = sc.nextLine();

                System.out.print("Fecha de inicio (dd/mm/yyyy): ");
                String fecha = sc.nextLine();

                System.out.print("Estudiante 1: ");
                String estudiante1 = sc.nextLine();

                System.out.print("Estudiante 2 (opcional, presione Enter si no hay): ");
                String estudiante2 = sc.nextLine();
                if (estudiante2.isEmpty()) {
                    estudiante2 = null;
                }

                System.out.print("Director: ");
                String director = sc.nextLine();

                System.out.print("Tipo de proyecto (Investigacion, Practica Profesional, etc.): ");
                String tipo = sc.nextLine();

                System.out.print("Programa: ");
                String programa = sc.nextLine();

                // Crear y agregar proyecto
                projectService.addProject(new Project(id, nombre, fecha,
                        estudiante1, estudiante2, director, tipo, programa));
            }

            // Crear servicio de reportes
            ReportService reportService = new ReportService(projectService);

            // Preguntar en qué formato quiere el reporte
            System.out.print("\nIngrese el formato del reporte (html, json, xml, etc.): ");
            String formato = sc.nextLine().toLowerCase();

            System.out.println("\n=== REPORTE GENERADO EN FORMATO " + formato.toUpperCase() + " ===");
            System.out.println(reportService.generateReport(formato));

            sc.close();

        } catch (Exception e) {
            System.err.println("Error al inicializar la aplicacion: " + e.getMessage());
        }
    }
    
    /**
     * Obtiene la ruta base donde está corriendo la aplicación, sin importar que
     * sea desde un archivo .class o desde un paquete .jar.
     *
     */
    private static String getBaseFilePath() {
        try {
            String path = Application.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            path = URLDecoder.decode(path, "UTF-8"); //This should solve the problem with spaces and special characters.
            File pathFile = new File(path);
            if (pathFile.isFile()) {
                path = pathFile.getParent();
                
                if (!path.endsWith(File.separator)) {
                    path += File.separator;
                }
                
            }

            return path;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, "Error al eliminar espacios en la ruta del archivo", ex);
            return null;
        }
    }
}