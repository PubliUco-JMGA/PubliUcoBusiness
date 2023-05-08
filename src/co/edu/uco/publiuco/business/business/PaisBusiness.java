package co.edu.uco.publiuco.business.business;

import co.edu.uco.publiuco.business.domain.PaisDomain;

import java.util.List;

public interface PaisBusiness {
    void register(PaisDomain domain);

    List<PaisDomain> list(PaisDomain domain);

}
