package co.edu.uco.publiuco.business.facade;

import co.edu.uco.publiuco.business.domain.EstadoDomain;
import co.edu.uco.publiuco.dto.EstadoDTO;

import java.util.List;

public interface EstadoFacade {
    void register(EstadoDTO dto);
    List<EstadoDTO> list(EstadoDTO dto);
    void modify(EstadoDTO dto);
    void drop(EstadoDTO dto);
}
