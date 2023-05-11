package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.TipoEstadoAssembler;
import co.edu.uco.publiuco.business.business.TipoEstadoBusiness;
import co.edu.uco.publiuco.business.business.impl.TipoEstadoBusinessImp;
import co.edu.uco.publiuco.business.domain.TipoEstadoDomain;
import co.edu.uco.publiuco.business.facade.TipoEstadoFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoEstadoDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;

public final class TipoEstadoFacadeImpl implements TipoEstadoFacade {
    private final DAOFactory daoFactory;
    private final TipoEstadoBusiness business;

    public TipoEstadoFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new TipoEstadoBusinessImp(daoFactory);
    }


    @Override
    public List<TipoEstadoDTO> list(TipoEstadoDTO dto) {
        try {
            daoFactory.initTransaction();
            final TipoEstadoDomain domainList = TipoEstadoAssembler.getInstance().toDomainFromDTO(dto);

            List<TipoEstadoDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return TipoEstadoAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.TipoEstadoFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.TipoEstadoFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();

        }
    }
}
