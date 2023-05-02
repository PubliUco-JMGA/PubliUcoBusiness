package co.edu.uco.publiuco.business.business;

import co.edu.uco.publiuco.business.domain.EstadoDomain;

import java.util.List;

public interface EstadoBusiness {
    void register(EstadoDomain domain);
    List<EstadoDomain> list(EstadoDomain domain);
    void modify(EstadoDomain domain);
    void drop(EstadoDomain domain);
}
