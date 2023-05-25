package co.edu.uco.publiuco.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.assembler.concrete.AdministradorCategoriaAssembler;
import co.edu.uco.publiuco.business.assembler.concrete.CategoriaAssembler;
import co.edu.uco.publiuco.business.assembler.concrete.PersonaAssembler;
import co.edu.uco.publiuco.business.business.CategoriaBusiness;
import co.edu.uco.publiuco.business.domain.AdministradorCategoriaDomain;
import co.edu.uco.publiuco.business.domain.CategoriaDomain;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.AdministradorCategoriaEntity;
import co.edu.uco.publiuco.entities.CalificacionEntity;
import co.edu.uco.publiuco.entities.CategoriaEntity;
import co.edu.uco.publiuco.utils.UtilUUID;

public class CategoriaBusinessImpl implements CategoriaBusiness {

	DAOFactory daoFactory;

	public CategoriaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(CategoriaDomain domain) {

		 
		
	}

	@Override
	public List<CategoriaDomain> list(CategoriaDomain domain) {
		final CategoriaEntity entity = CategoriaAssembler.getInstance().toEntityFromDomain(domain);

		final List<CategoriaEntity> resultEntityList = daoFactory.getCategoriaDAO().read(entity);

		return CategoriaAssembler.getInstance().toDomainFromEntityList(resultEntityList);
	}

	@Override
	public void modify(CategoriaDomain domain) {
		final CategoriaEntity entity = CategoriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getCategoriaDAO().update(entity);

	}

	@Override
	public void drop(UUID domain) {
		daoFactory.getCategoriaDAO().delete(domain);

	}

}
