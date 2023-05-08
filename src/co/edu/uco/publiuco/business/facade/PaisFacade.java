package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.PaisDTO;

import java.util.List;
import java.util.UUID;

public interface PaisFacade {
    void register(PaisDTO dto);

    List<PaisDTO> list(PaisDTO dto);

}
