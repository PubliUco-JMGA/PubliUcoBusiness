package co.edu.uco.publiuco.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.domain.ObservacionRevisionDomain;

public interface ObservacionRevisionBusiness {

	void register(ObservacionRevisionDomain domain);

	List<ObservacionRevisionDomain> list(ObservacionRevisionDomain domain);

	void modify(ObservacionRevisionDomain domain);

	void drop(UUID domain);

}
