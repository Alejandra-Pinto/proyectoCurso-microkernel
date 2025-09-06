package co.unicauca.microkernel.plugins.json;

import co.unicauca.microkernel.common.interfaces.IReportPlugin;
import co.unicauca.microkernel.common.entities.Project;
import java.util.List;

public class ReportJsonPlugin implements IReportPlugin{
    @Override
    public String generateReport(List<Project> data) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < data.size(); i++) {
            Project p = data.get(i);
            sb.append("  {\n");
            sb.append("    \"id\": \"").append(escape(p.getId())).append("\",\n");
            sb.append("    \"nombre\": \"").append(escape(p.getNombre())).append("\",\n");
            sb.append("    \"fechaFormatoA\": \"").append(escape(p.getFechaFormatoA())).append("\",\n");
            sb.append("    \"estudiante1\": ").append(toJsonValue(p.getEstudiante1())).append(",\n");
            sb.append("    \"estudiante2\": ").append(toJsonValue(p.getEstudiante2())).append(",\n");
            sb.append("    \"profesor\": ").append(toJsonValue(p.getProfesor())).append(",\n");
            sb.append("    \"tipo\": ").append(toJsonValue(p.getTipo())).append(",\n");
            sb.append("    \"programa\": ").append(toJsonValue(p.getPrograma())).append("\n");
            sb.append("  }");
            if (i < data.size() - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("]\n");
        return sb.toString();
    }

    private String escape(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\").replace("\"", "\\\""); // escapar comillas y backslash
    }

    private String toJsonValue(String s) {
        if (s == null) return "null";
        return "\"" + escape(s) + "\"";
    }
}
