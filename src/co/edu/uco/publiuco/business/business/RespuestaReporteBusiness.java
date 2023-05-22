package co.edu.uco.publiuco.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.domain.RespuestaReporteDomain;

public interface RespuestaReporteBusiness {
	void register(RespuestaReporteDomain domain);

	List<RespuestaReporteDomain> list(RespuestaReporteDomain domain);

	void modify(RespuestaReporteDomain domain);

	void drop(UUID domain);
}
