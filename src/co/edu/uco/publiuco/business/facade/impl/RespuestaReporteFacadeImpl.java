package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.assembler.concrete.RespuestaReporteAssembler;
import co.edu.uco.publiuco.business.business.RespuestaReporteBusiness;
import co.edu.uco.publiuco.business.business.impl.RespuestaReporteBusinessImpl;
import co.edu.uco.publiuco.business.domain.RespuestaReporteDomain;
import co.edu.uco.publiuco.business.facade.RespuestaReporteFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.RespuestaReporteDTO;
import co.edu.uco.publiuco.utils.Messages;

public class RespuestaReporteFacadeImpl implements RespuestaReporteFacade{
	 private final DAOFactory daoFactory;
	 private final RespuestaReporteBusiness business;

	 public RespuestaReporteFacadeImpl() {
	        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
	        business = new RespuestaReporteBusinessImpl(daoFactory);
	 }
	 @Override
	    public void register(RespuestaReporteDTO dto) {
	        try {
	            daoFactory.initTransaction();
	            final RespuestaReporteDomain domain = RespuestaReporteAssembler.getInstance().toDomainFromDTO(dto);

	            business.register(domain);

	            daoFactory.commitTransaction();


	        } catch (final PubliucoException exception) {
	            daoFactory.rollbackTransaction();
	            throw exception;
	        } catch (final Exception exception) {
	            daoFactory.rollbackTransaction();
	            var userMessage = Messages.RespuestaReporteFacadeImplMessages.USER_MESSAGE_REGISTER;
	            var technicalMessage = Messages.RespuestaReporteFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

	            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
	        } finally {
	            daoFactory.closeConection();
	        }
	    }

	    @Override
	    public List<RespuestaReporteDTO> list(RespuestaReporteDTO dto) {
	        try {
	            daoFactory.initTransaction();
	            final RespuestaReporteDomain domainList = RespuestaReporteAssembler.getInstance().toDomainFromDTO(dto);

	            List<RespuestaReporteDomain> lista = business.list(domainList);

	            daoFactory.commitTransaction();

	            return RespuestaReporteAssembler.getInstance().toDTOFromDomainList(lista);


	        } catch (final PubliucoException exception) {
	            throw exception;
	        } catch (final Exception exception) {
	            var userMessage = Messages.RespuestaReporteFacadeImplMessages.USER_MESSAGE_LIST;
	            var technicalMessage = Messages.RespuestaReporteFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

	            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
	        } finally {
	            daoFactory.closeConection();

	        }
	    }

	    @Override
	    public void modify(RespuestaReporteDTO dto) {
	        try {
	            daoFactory.initTransaction();
	            final RespuestaReporteDomain domain = RespuestaReporteAssembler.getInstance().toDomainFromDTO(dto);

	            business.modify(domain);

	            daoFactory.commitTransaction();


	        } catch (final PubliucoException exception) {
	            daoFactory.rollbackTransaction();
	            throw exception;
	        } catch (final Exception exception) {
	            daoFactory.rollbackTransaction();
	            var userMessage = Messages.RespuestaReporteFacadeImplMessages.USER_MESSAGE_MODIFY;
	            var technicalMessage = Messages.RespuestaReporteFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

	            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
	        } finally {
	            daoFactory.closeConection();
	        }
	    }

	    @Override
	    public void drop(UUID dto) {
	        try {
	            daoFactory.initTransaction();

	            business.drop(dto);

	            daoFactory.commitTransaction();

	        } catch (final PubliucoException exception) {
	            daoFactory.rollbackTransaction();
	            throw exception;
	        } catch (final Exception exception) {
	            daoFactory.rollbackTransaction();
	            var userMessage = Messages.RespuestaReporteFacadeImplMessages.USER_MESSAGE_DROP;
	            var technicalMessage = Messages.RespuestaReporteFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

	            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
	        } finally {
	            daoFactory.closeConection();
	        }
	    }
}
