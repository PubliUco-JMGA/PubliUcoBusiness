package co.edu.uco.publiuco.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.assembler.concrete.EscritorPublicacionAssembler;
import co.edu.uco.publiuco.business.business.EscritorPublicacionBusiness;
import co.edu.uco.publiuco.business.domain.EscritorPublicacionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EscritorPublicacionEntity;
import co.edu.uco.publiuco.utils.UtilUUID;

public class EscritorPublicacionBusinessImpl implements EscritorPublicacionBusiness {

	DAOFactory daoFactory;

	public EscritorPublicacionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(EscritorPublicacionDomain domain) {
		UUID identificador;
		EscritorPublicacionEntity entityTmp;
		 List<EscritorPublicacionEntity> result;
		
		do {
			identificador = UtilUUID.generateNewUUID();
			entityTmp = EscritorPublicacionEntity.create().setIdentificador(identificador);
			result = daoFactory.getEscritorPublicacionDAO().read(entityTmp);
		}while(!result.isEmpty());
		
		final var domainToCreate = new EscritorPublicacionDomain(identificador,domain.getPublicacion(),domain.getEscritor(),domain.getTipo());
		
		final EscritorPublicacionEntity entity = EscritorPublicacionAssembler.getInstance().toEntityFromDomain(domainToCreate);
		daoFactory.getEscritorPublicacionDAO().create(entity);	

	}

	@Override
	public List<EscritorPublicacionDomain> list(EscritorPublicacionDomain domain) {
		final EscritorPublicacionEntity entity = EscritorPublicacionAssembler.getInstance().toEntityFromDomain(domain);

		final List<EscritorPublicacionEntity> resultEntityList = daoFactory.getEscritorPublicacionDAO().read(entity);

		return EscritorPublicacionAssembler.getInstance().toDomainFromEntityList(resultEntityList);
	
	}

	@Override
	public void modify(EscritorPublicacionDomain domain) {
		final EscritorPublicacionEntity entity = EscritorPublicacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEscritorPublicacionDAO().update(entity);

	}

	@Override
	public void drop(UUID domain) {
		daoFactory.getEscritorPublicacionDAO().delete(domain);

	}

}
