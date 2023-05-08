package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.PaisAssembler;
import co.edu.uco.publiuco.business.business.PaisBusiness;
import co.edu.uco.publiuco.business.business.impl.PaisBusinessImpl;
import co.edu.uco.publiuco.business.domain.PaisDomain;
import co.edu.uco.publiuco.business.facade.PaisFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.PaisDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;

public final class PaisFacadeImpl implements PaisFacade {
    private final DAOFactory daoFactory;
    private final PaisBusiness business;

    public PaisFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new PaisBusinessImpl(daoFactory);
    }


    @Override
    public void register(PaisDTO dto) {
        try {
            daoFactory.initTransaction();
            final PaisDomain domain = PaisAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PaisFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.PaisFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }

    @Override
    public List<PaisDTO> list(PaisDTO dto) {
        try {
            daoFactory.initTransaction();
            final PaisDomain domainList = PaisAssembler.getInstance().toDomainFromDTO(dto);

            List<PaisDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return PaisAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.PaisFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.PaisFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();

        }
    }

}
