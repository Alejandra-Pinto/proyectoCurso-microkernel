package co.unicauca.microkernel.plugins.html;

import co.unicauca.microkernel.common.interfaces.IReportPlugin;
import co.unicauca.microkernel.common.entities.Project;
import java.util.List;

public class HtmlReportPlugin implements IReportPlugin{

    @Override
    public String generateReport(List<Project> data) {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n<html lang=\"es\">\n<head>\n   <meta charset=\"UTF-8\">\n   <title>Reporte de Proyectos de Grado</title>\n</head>\n<body>\n");
        sb.append("    <h1>Reporte de Proyectos de Grado</h1>\n");
        sb.append("    <table border=\"1\">\n        <thead>\n            <tr>\n");
        sb.append("                <th>ID</th>\n                <th>Nombre del Proyecto</th>\n                <th>Fecha aprobacion formato A</th>\n                <th>Estudiante(s)</th>\n                <th>Profesor</th>\n                <th>Tipo</th>\n                <th>Programa</th>\n");
        sb.append("            </tr>\n        </thead>\n        <tbody>\n");
        for (Project p : data) {
            sb.append("            <tr>\n");
            sb.append("                <td>").append(p.getId()).append("</td>\n");
            sb.append("                <td>").append(escapeHtml(p.getNombre())).append("</td>\n");
            sb.append("                <td>").append(p.getFechaFormatoA()).append("</td>\n");
            sb.append("                <td>").append(escapeHtml(joinStudents(p))).append("</td>\n");
            sb.append("                <td>").append(escapeHtml(p.getProfesor())).append("</td>\n");
            sb.append("                <td>").append(escapeHtml(p.getTipo())).append("</td>\n");
            sb.append("                <td>").append(escapeHtml(p.getPrograma())).append("</td>\n");
            sb.append("            </tr>\n");
        }
        sb.append("        </tbody>\n    </table>\n</body>\n</html>\n");
        return sb.toString();
    }

    // método auxiliar para evitar caracteres especiales simples
    private String escapeHtml(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }

    private String joinStudents(Project p) {
        String s1 = p.getEstudiante1();
        String s2 = p.getEstudiante2();
        if (s2 == null || s2.trim().isEmpty()) {
            return s1;
        }
        return s1 + ", " + s2;
    }

}
