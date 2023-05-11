package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.TipoRevisionAssembler;
import co.edu.uco.publiuco.business.business.TipoRevisionBusiness;
import co.edu.uco.publiuco.business.business.impl.TipoRevisionBusinessImpl;
import co.edu.uco.publiuco.business.domain.TipoRevisionDomain;
import co.edu.uco.publiuco.business.facade.TipoRevisionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoRevisionDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;

public final class TipoRevisionFacadeImpl implements TipoRevisionFacade {
    private final DAOFactory daoFactory;
    private final TipoRevisionBusiness business;

    public TipoRevisionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new TipoRevisionBusinessImpl(daoFactory);
    }

    @Override
    public List<TipoRevisionDTO> list(TipoRevisionDTO dto) {
        try {
            daoFactory.initTransaction();
            final TipoRevisionDomain domainList = TipoRevisionAssembler.getInstance().toDomainFromDTO(dto);

            List<TipoRevisionDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return TipoRevisionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.TipoRevisionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.TipoRevisionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();

        }
    }
}
