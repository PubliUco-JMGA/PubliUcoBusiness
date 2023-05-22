package co.edu.uco.publiuco.business.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.dto.RespuestaReporteDTO;

public interface RespuestaReporteFacade {
	void register(RespuestaReporteDTO dto);

    List<RespuestaReporteDTO> list(RespuestaReporteDTO dto);

    void modify(RespuestaReporteDTO dto);

    void drop(UUID dto);
}
