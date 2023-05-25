package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.TipoEstadoAssembler;
import co.edu.uco.publiuco.business.business.TipoEstadoBusiness;
import co.edu.uco.publiuco.business.domain.TipoEstadoDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.TipoEstadoEntity;

public class TipoEstadoBusinessImp implements TipoEstadoBusiness {

	private DAOFactory daoFactory;
	
	public TipoEstadoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoEstadoDomain> list(TipoEstadoDomain domain) {
		final TipoEstadoEntity entity = TipoEstadoAssembler.getInstance().toEntityFromDomain(domain);

		final List<TipoEstadoEntity> resultEntityList = daoFactory.getTipoEstadoDAO().read(entity);

		return TipoEstadoAssembler.getInstance().toDomainFromEntityList(resultEntityList);
	}



}
