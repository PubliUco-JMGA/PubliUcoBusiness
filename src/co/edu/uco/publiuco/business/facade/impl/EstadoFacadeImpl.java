package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoAssembler;
import co.edu.uco.publiuco.business.business.EstadoBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoBusinessImpl;
import co.edu.uco.publiuco.business.domain.EstadoDomain;
import co.edu.uco.publiuco.business.facade.EstadoFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;

public class EstadoFacadeImpl implements EstadoFacade {

    private DAOFactory daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
    private final EstadoBusiness business;
    public EstadoFacadeImpl(){
        daoFactory = daoFactory.getFactory(Factory.POSTGRESQL);
        business = new EstadoBusinessImpl(daoFactory);
    }
    @Override
    public void register(EstadoDTO dto) {
        try{
            daoFactory.initTransaction();

            EstadoDomain domain = EstadoAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);
            daoFactory.commitTransaction();

        }catch (PubliucoException e){
            daoFactory.cancelTransaction();
            throw e;
        }catch (final Exception exception){
            daoFactory.cancelTransaction();
            var userMessage = Messages.EstadoFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.EstadoFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliucoBusisnessException.create(technicalMessage,userMessage,exception);
        }finally {
            daoFactory.closeConection();
        }
    }

    @Override
    public List<EstadoDTO> list(EstadoDTO dto) {
        try{
            daoFactory.initTransaction();

            EstadoDomain domain = EstadoAssembler.getInstance().toDomainFromDTO(dto);

            business.list(domain);
            daoFactory.commitTransaction();

        }catch (PubliucoException e){
            daoFactory.cancelTransaction();
            throw e;
        }catch (final Exception exception){
            daoFactory.cancelTransaction();
            var userMessage = Messages.EstadoFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.EstadoFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

            throw PubliucoBusisnessException.create(technicalMessage,userMessage,exception);
        }finally {
            daoFactory.closeConection();
        }
        return null;
    }

    @Override
    public void modify(EstadoDTO dto) {
        try{
            daoFactory.initTransaction();

            EstadoDomain domain = EstadoAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);
            daoFactory.commitTransaction();

        }catch (PubliucoException e){
            daoFactory.cancelTransaction();
            throw e;
        }catch (final Exception exception){
            daoFactory.cancelTransaction();
            var userMessage = Messages.EstadoFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.EstadoFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

            throw PubliucoBusisnessException.create(technicalMessage,userMessage,exception);
        }finally {
            daoFactory.closeConection();
        }
    }

    @Override
    public void drop(EstadoDTO dto) {
        try{
            daoFactory.initTransaction();

            EstadoDomain domain = EstadoAssembler.getInstance().toDomainFromDTO(dto);

            business.drop(domain);
            daoFactory.commitTransaction();

        }catch (PubliucoException e){
            daoFactory.cancelTransaction();
            throw e;
        }catch (final Exception exception){
            daoFactory.cancelTransaction();
            var userMessage = Messages.EstadoFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.EstadoFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliucoBusisnessException.create(technicalMessage,userMessage,exception);
        }finally {
            daoFactory.closeConection();
        }
    }
}
