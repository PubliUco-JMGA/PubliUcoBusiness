package co.edu.uco.publiuco.business.facade;

import co.edu.uco.publiuco.dto.EstadoDTO;
import co.edu.uco.publiuco.dto.TipoRelacionInstitucionDTO;

import java.util.List;

public interface TipoRelacionInstitucionFacade {

    List<TipoRelacionInstitucionDTO> list(TipoRelacionInstitucionDTO dto);

}
