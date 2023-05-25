package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.SuscripcionPublicacionAssembler;
import co.edu.uco.publiuco.business.business.SuscripcionPublicacionBusiness;
import co.edu.uco.publiuco.business.business.impl.SuscripcionPublicacionBusinessImpl;
import co.edu.uco.publiuco.business.domain.SuscripcionPublicacionDomain;
import co.edu.uco.publiuco.business.facade.SuscripcionPublicacionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.SuscripcionPublicacionDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class SuscripcionPublicacionFacadeImpl implements SuscripcionPublicacionFacade {
    private final DAOFactory daoFactory;
    private final SuscripcionPublicacionBusiness business;

    public SuscripcionPublicacionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new SuscripcionPublicacionBusinessImpl(daoFactory) {
        };
    }

    @Override
    public void register(SuscripcionPublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final SuscripcionPublicacionDomain domain = SuscripcionPublicacionAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.SuscripcionPublicacionFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.SuscripcionPublicacionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<SuscripcionPublicacionDTO> list(SuscripcionPublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final SuscripcionPublicacionDomain domainList = SuscripcionPublicacionAssembler.getInstance().toDomainFromDTO(dto);

            List<SuscripcionPublicacionDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return SuscripcionPublicacionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.SuscripcionPublicacionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.SuscripcionPublicacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(SuscripcionPublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final SuscripcionPublicacionDomain domain = SuscripcionPublicacionAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.SuscripcionPublicacionFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.SuscripcionPublicacionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
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
            var userMessage = Messages.SuscripcionPublicacionFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.SuscripcionPublicacionFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
