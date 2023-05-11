package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.TipoIdentificacionAssembler;
import co.edu.uco.publiuco.business.business.TipoIdentificacionBusiness;
import co.edu.uco.publiuco.business.business.impl.TipoIdentificacionBusinessImpl;
import co.edu.uco.publiuco.business.domain.TipoIdentificacionDomain;
import co.edu.uco.publiuco.business.facade.TipoIdentificacionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoIdentificacionDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;

public final class TipoIdentificacionFacadeImpl implements TipoIdentificacionFacade {
    private final DAOFactory daoFactory;
    private final TipoIdentificacionBusiness business;

    public TipoIdentificacionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new TipoIdentificacionBusinessImpl(daoFactory);
    }


    @Override
    public List<TipoIdentificacionDTO> list(TipoIdentificacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final TipoIdentificacionDomain domainList = TipoIdentificacionAssembler.getInstance().toDomainFromDTO(dto);

            List<TipoIdentificacionDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return TipoIdentificacionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.TipoIdentificacionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.TipoIdentificacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();

        }
    }
}
