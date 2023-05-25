package co.edu.uco.publiuco.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.assembler.concrete.ComentarioLectorAssembler;
import co.edu.uco.publiuco.business.business.ComentarioLectorBusiness;
import co.edu.uco.publiuco.business.domain.ComentarioLectorDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.ComentarioLectorEntity;
import co.edu.uco.publiuco.utils.UtilUUID;

public class ComentarioLectorBusinessImpl implements ComentarioLectorBusiness {

	DAOFactory daoFactory;

	public ComentarioLectorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(ComentarioLectorDomain domain) {
		UUID identificador;
		ComentarioLectorEntity entityTmp;
		 List<ComentarioLectorEntity> result;
		
		do {
			identificador = UtilUUID.generateNewUUID();
			entityTmp = ComentarioLectorEntity.create().setIdentificador(identificador);
			result = daoFactory.getComentarioLectorDAO().read(entityTmp);
		}while(!result.isEmpty());
		
		final var domainToCreate = new ComentarioLectorDomain(identificador,domain.getLector(),domain.getPublicacion(),domain.getComentarioPadre(),domain.getCotenido(),domain.getFechaComentario(),domain.getEstado(), domain.tienePadre());
		
		final ComentarioLectorEntity entity = ComentarioLectorAssembler.getInstance().toEntityFromDomain(domainToCreate);
		daoFactory.getComentarioLectorDAO().create(entity);	

	}

	@Override
	public List<ComentarioLectorDomain> list(ComentarioLectorDomain domain) {
		ComentarioLectorEntity entity = ComentarioLectorAssembler.getInstance().toEntityFromDomain(domain);

		final List<ComentarioLectorEntity> resultEntityList = daoFactory.getComentarioLectorDAO().read(entity);

		return ComentarioLectorAssembler.getInstance().toDomainFromEntityList(resultEntityList);
	
	}

	@Override
	public void modify(ComentarioLectorDomain domain) {
		final ComentarioLectorEntity entity = ComentarioLectorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getComentarioLectorDAO().update(entity);

	}

	@Override
	public void drop(UUID domain) {
		daoFactory.getComentarioLectorDAO().delete(domain);

	}

}
