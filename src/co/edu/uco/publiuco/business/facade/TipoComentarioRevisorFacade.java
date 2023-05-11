package co.edu.uco.publiuco.business.facade;

import co.edu.uco.publiuco.dto.EstadoDTO;
import co.edu.uco.publiuco.dto.TipoComentarioRevisorDTO;

import java.util.List;

public interface TipoComentarioRevisorFacade {

    List<TipoComentarioRevisorDTO> list(TipoComentarioRevisorDTO dto);

}
