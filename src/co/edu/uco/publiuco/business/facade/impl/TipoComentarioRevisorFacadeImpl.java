package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.TipoComentarioRevisorAssembler;
import co.edu.uco.publiuco.business.business.TipoComentarioRevisorBusiness;
import co.edu.uco.publiuco.business.business.impl.TipoComentarioRevisorBusinessImpl;
import co.edu.uco.publiuco.business.domain.TipoComentarioRevisorDomain;
import co.edu.uco.publiuco.business.facade.TipoComentarioRevisorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoComentarioRevisorDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;

public final class TipoComentarioRevisorFacadeImpl implements TipoComentarioRevisorFacade {
    private final DAOFactory daoFactory;
    private final TipoComentarioRevisorBusiness business;

    public TipoComentarioRevisorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new TipoComentarioRevisorBusinessImpl(daoFactory);
    }

    @Override
    public void register(TipoComentarioRevisorDTO dto) {
        try {
            daoFactory.initTransaction();
            final TipoComentarioRevisorDomain domain = TipoComentarioRevisorAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.TipoComentarioRevisorFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.TipoComentarioRevisorFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }

    @Override
    public List<TipoComentarioRevisorDTO> list(TipoComentarioRevisorDTO dto) {
        try {
            daoFactory.initTransaction();
            final TipoComentarioRevisorDomain domainList = TipoComentarioRevisorAssembler.getInstance().toDomainFromDTO(dto);

            List<TipoComentarioRevisorDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return TipoComentarioRevisorAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.TipoComentarioRevisorFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.TipoComentarioRevisorFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();

        }
    }
}
