package co.edu.uco.publiuco.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.assembler.concrete.AdministradorCategoriaAssembler;
import co.edu.uco.publiuco.business.assembler.concrete.PersonaAssembler;
import co.edu.uco.publiuco.business.business.AdministradorCategoriaBusiness;
import co.edu.uco.publiuco.business.domain.AdministradorCategoriaDomain;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.AdministradorCategoriaEntity;
import co.edu.uco.publiuco.utils.UtilUUID;

public class AdministradorCategoriaBusinessImpl implements AdministradorCategoriaBusiness {

	DAOFactory daoFactory;

	public AdministradorCategoriaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public final void register(AdministradorCategoriaDomain domain) {
		
		 UUID identificador;
		 AdministradorCategoriaEntity entityTmp;
		 List<AdministradorCategoriaEntity> result;
		
		do {
			identificador = UtilUUID.generateNewUUID();
			entityTmp = AdministradorCategoriaEntity.create().setIdentificador(identificador);
			result = daoFactory.getAdministradorCategoriaDAO().read(entityTmp);
		}while(!result.isEmpty());
		
		entityTmp = AdministradorCategoriaEntity.create().setPersona(PersonaAssembler.getInstance().toEntityFromDomain(domain.getPersona()));
		result = daoFactory.getAdministradorCategoriaDAO().read(entityTmp);
		
		if(!result.isEmpty()) {
			throw PubliucoBusisnessException.create("el usuario que desea crear ya existe. Por favor verifique los datos si es necesario");
		}	
		
		final var domainToCreate = new AdministradorCategoriaDomain(identificador,domain.getPersona(),domain.getEstado());
		
		final AdministradorCategoriaEntity entity = AdministradorCategoriaAssembler.getInstance().toEntityFromDomain(domainToCreate);
		daoFactory.getAdministradorCategoriaDAO().create(entity);	
		
		
		
	}

	@Override
	public final List<AdministradorCategoriaDomain> list(AdministradorCategoriaDomain domain) {
		final AdministradorCategoriaEntity entity = AdministradorCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);

		final List<AdministradorCategoriaEntity> result = daoFactory.getAdministradorCategoriaDAO().read(entity);

		return null;
	}

	@Override
	public final void modify(AdministradorCategoriaDomain domain) {
		final AdministradorCategoriaEntity entity = AdministradorCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getAdministradorCategoriaDAO().update(entity);

	}

	@Override
	public final void drop(UUID domain) {
		daoFactory.getAdministradorCategoriaDAO().delete(domain);

	}

}
