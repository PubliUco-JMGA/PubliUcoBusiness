package co.edu.uco.publiuco.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.assembler.concrete.EscritorAssembler;
import co.edu.uco.publiuco.business.business.EscritorBusiness;
import co.edu.uco.publiuco.business.domain.EscritorDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EscritorEntity;
import co.edu.uco.publiuco.utils.UtilUUID;

public class EscritorBusinessImpl implements EscritorBusiness {

	DAOFactory daoFactory;

	public EscritorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(EscritorDomain domain) {
		UUID identificador;
		EscritorEntity entityTmp;
		 List<EscritorEntity> result;
		
		do {
			identificador = UtilUUID.generateNewUUID();
			entityTmp = EscritorEntity.create().setIdentificador(identificador);
			result = daoFactory.getEscritorDAO().read(entityTmp);
		}while(!result.isEmpty());
		
		final var domainToCreate = new EscritorDomain(identificador,domain.getDatosPersona(),domain.getEstado());
		
		final EscritorEntity entity = EscritorAssembler.getInstance().toEntityFromDomain(domainToCreate);
		daoFactory.getEscritorDAO().create(entity);	
	
	}

	@Override
	public List<EscritorDomain> list(EscritorDomain domain) {
		final EscritorEntity entity = EscritorAssembler.getInstance().toEntityFromDomain(domain);

		final List<EscritorEntity> resultEntityList = daoFactory.getEscritorDAO().read(entity);

		return EscritorAssembler.getInstance().toDomainFromEntityList(resultEntityList);
	
	}

	@Override
	public void modify(EscritorDomain domain) {
		final EscritorEntity entity = EscritorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEscritorDAO().update(entity);

	}

	@Override
	public void drop(UUID domain) {
		daoFactory.getEscritorDAO().delete(domain);

	}

}
