package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;
import co.edu.uco.publiuco.business.assembler.concrete.EstadoAssembler;
import co.edu.uco.publiuco.business.domain.EstadoDomain;
import co.edu.uco.publiuco.business.business.EstadoBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoBusinessImpl;
import co.edu.uco.publiuco.business.facade.EstadoFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoDTO;
import co.edu.uco.publiuco.utils.Messages.EstadoFacadeImplMessages;

public final class EstadoFacadeImpl implements EstadoFacade{

	private final DAOFactory daoFactory;
	private final EstadoBusiness business;
	
	public EstadoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new EstadoBusinessImpl(daoFactory);
	}


	@Override
	public List<EstadoDTO> list(EstadoDTO dto) {
		try {
			daoFactory.initTransaction();
			final EstadoDomain domainList = EstadoAssembler.getInstance().toDomainFromDTO(dto);
			
			List<EstadoDomain> lista = business.list(domainList); 
			
			daoFactory.commitTransaction();
			
			return EstadoAssembler.getInstance().toDTOFromDomainList(lista);
		
			
		} catch (final PubliucoException exception) {
			throw exception;
		} catch (final Exception exception) {
			var userMessage = EstadoFacadeImplMessages.USER_MESSAGE_LIST;
			var technicalMessage = EstadoFacadeImplMessages.TECHNICAL_MESSAGE_LIST;
			
			throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}
	

}
