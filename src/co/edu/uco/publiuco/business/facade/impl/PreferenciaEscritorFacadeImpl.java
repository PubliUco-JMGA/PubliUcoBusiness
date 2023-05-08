package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.PreferenciaEscritorAssembler;
import co.edu.uco.publiuco.business.business.PreferenciaEscritorBusiness;
import co.edu.uco.publiuco.business.business.impl.PreferenciaEscritorBusinessImpl;
import co.edu.uco.publiuco.business.domain.PreferenciaEscritorDomain;
import co.edu.uco.publiuco.business.facade.PreferenciaEscritorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.PreferenciaEscritorDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class PreferenciaEscritorFacadeImpl implements PreferenciaEscritorFacade {
    private final DAOFactory daoFactory;
    private final PreferenciaEscritorBusiness business;

    public PreferenciaEscritorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new PreferenciaEscritorBusinessImpl(daoFactory);
    }

    @Override
    public void register(PreferenciaEscritorDTO dto) {
        try {
            daoFactory.initTransaction();
            final PreferenciaEscritorDomain domain = PreferenciaEscritorAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PreferenciaEscritorFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.PreferenciaEscritorFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }

    @Override
    public List<PreferenciaEscritorDTO> list(PreferenciaEscritorDTO dto) {
        try {
            daoFactory.initTransaction();
            final PreferenciaEscritorDomain domainList = PreferenciaEscritorAssembler.getInstance().toDomainFromDTO(dto);

            List<PreferenciaEscritorDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return PreferenciaEscritorAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.LectorFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.LectorFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();

        }
    }

    @Override
    public void modify(PreferenciaEscritorDTO dto) {
        try {
            daoFactory.initTransaction();
            final PreferenciaEscritorDomain domain = PreferenciaEscritorAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PreferenciaEscritorFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.PreferenciaEscritorFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.PreferenciaEscritorFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.PreferenciaEscritorFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }
}
