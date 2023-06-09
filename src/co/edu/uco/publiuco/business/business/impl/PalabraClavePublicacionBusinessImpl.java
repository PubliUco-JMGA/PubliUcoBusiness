package co.edu.uco.publiuco.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.assembler.concrete.PalabraClavePublicacionAssembler;
import co.edu.uco.publiuco.business.business.PalabraClavePublicacionBusiness;
import co.edu.uco.publiuco.business.domain.PalabraClavePublicacionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.PalabraClavePublicacionEntity;

public class PalabraClavePublicacionBusinessImpl implements PalabraClavePublicacionBusiness {

	DAOFactory daoFactory;

	public PalabraClavePublicacionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(PalabraClavePublicacionDomain domain) {
		final PalabraClavePublicacionEntity entity = PalabraClavePublicacionAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getPalabraClavePublicacionDAO().create(entity);

	}

	@Override
	public List<PalabraClavePublicacionDomain> list(PalabraClavePublicacionDomain domain) {
		final PalabraClavePublicacionEntity entity = PalabraClavePublicacionAssembler.getInstance()
				.toEntityFromDomain(domain);

		final List<PalabraClavePublicacionEntity> result = daoFactory.getPalabraClavePublicacionDAO().read(entity);

		return null;
	}

	@Override
	public void modify(PalabraClavePublicacionDomain domain) {
		final PalabraClavePublicacionEntity entity = PalabraClavePublicacionAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getPalabraClavePublicacionDAO().update(entity);

	}

	@Override
	public void drop(UUID domain) {
		daoFactory.getPalabraClavePublicacionDAO().delete(domain);

	}

}
