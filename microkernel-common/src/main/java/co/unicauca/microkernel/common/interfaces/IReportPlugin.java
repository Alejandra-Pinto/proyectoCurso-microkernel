package co.unicauca.microkernel.common.interfaces;
import java.util.List;
import co.unicauca.microkernel.common.entities.Project;

public interface IReportPlugin {
    String generateReport(List<Project> data);
}
