package co.edu.uco.publiuco.business.business;


import co.edu.uco.publiuco.business.domain.EstadoDomain;

import java.util.List;
import java.util.UUID;

public interface EstadoBusiness {

	List<EstadoDomain> list(EstadoDomain domain);

}
