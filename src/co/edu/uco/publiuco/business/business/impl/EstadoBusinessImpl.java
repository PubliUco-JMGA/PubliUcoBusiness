package co.edu.uco.publiuco.business.business.impl;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoAssembler;
import co.edu.uco.publiuco.business.business.EstadoBusiness;
import co.edu.uco.publiuco.business.domain.EstadoDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoEntity;

import java.util.List;

public final class EstadoBusinessImpl implements EstadoBusiness {
    private DAOFactory daoFactory;
    public EstadoBusinessImpl(final DAOFactory factory){
        this.daoFactory = daoFactory;
    }
    @Override
    public final void register(final EstadoDomain domain) {
        EstadoEntity entity = EstadoAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getEstado().create(entity);
    }

    @Override
    public final List<EstadoDomain> list(final EstadoDomain domain) {

        final EstadoEntity entity = EstadoAssembler.getInstance()
                .toEntityFromDomain(domain);

        List<EstadoEntity> resultEntityList = daoFactory.getEstado()
                .read(entity);

        return EstadoAssembler.getInstance().toDomainFromEntityList(resultEntityList);
    }
    @Override
    public final void modify(final EstadoDomain domain) {

    }

    @Override
    public final void drop(final EstadoDomain domain) {

    }
}
