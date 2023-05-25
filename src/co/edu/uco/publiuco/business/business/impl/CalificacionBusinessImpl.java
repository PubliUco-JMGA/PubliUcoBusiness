package co.edu.uco.publiuco.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.assembler.concrete.CalificacionAssembler;
import co.edu.uco.publiuco.business.business.CalificacionBusiness;
import co.edu.uco.publiuco.business.domain.CalificacionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.CalificacionEntity;
import co.edu.uco.publiuco.utils.UtilUUID;

public class CalificacionBusinessImpl implements CalificacionBusiness {

	DAOFactory daoFactory;

	public CalificacionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(CalificacionDomain domain) {
		UUID identificador;
		 CalificacionEntity entityTmp;
		 List<CalificacionEntity> result;
		
		do {
			identificador = UtilUUID.generateNewUUID();
			entityTmp = CalificacionEntity.create().setIdentificador(identificador);
			result = daoFactory.getCalificacionDAO().read(entityTmp);
		}while(!result.isEmpty());
		
		final var domainToCreate = new CalificacionDomain(identificador,domain.getPublicacion(),domain.getLector(),domain.getFechaCalificacion(),domain.getCalificacion());
		
		final CalificacionEntity entity = CalificacionAssembler.getInstance().toEntityFromDomain(domainToCreate);
		daoFactory.getCalificacionDAO().create(entity);	
		
	}

	@Override
	public List<CalificacionDomain> list(CalificacionDomain domain) {
		final CalificacionEntity entity = CalificacionAssembler.getInstance().toEntityFromDomain(domain);

		final List<CalificacionEntity> resultEntityList = daoFactory.getCalificacionDAO().read(entity);

		return CalificacionAssembler.getInstance().toDomainFromEntityList(resultEntityList);
	
	}

	@Override
	public void modify(CalificacionDomain domain) {
		final CalificacionEntity entity = CalificacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getCalificacionDAO().update(entity);

	}

	@Override
	public void drop(UUID domain) {
		daoFactory.getCalificacionDAO().delete(domain);

	}

}
