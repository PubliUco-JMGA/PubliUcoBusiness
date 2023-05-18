package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.ComentarioRevisorDomain;
import co.edu.uco.publiuco.dto.ComentarioRevisorDTO;
import co.edu.uco.publiuco.entities.ComentarioRevisorEntity;

import java.util.List;

public final class ComentarioRevisorAssembler implements Assembler<ComentarioRevisorDomain, ComentarioRevisorDTO, ComentarioRevisorEntity> {
    public static final ComentarioRevisorAssembler INSTANCE = new ComentarioRevisorAssembler();
    public static ComentarioRevisorAssembler getInstance() { return INSTANCE; }
    private ComentarioRevisorAssembler(){
        super();
    }
    @Override
    public ComentarioRevisorDTO toDTOFromDomain(ComentarioRevisorDomain domain) {
        return ComentarioRevisorDTO.create().setIdentificador(domain.getIdentificador()).setContenido(domain.getContenido())
                .setTipo(TipoComentarioRevisorAssembler.getInstance().toDTOFromDomain(domain.getTipo()))
                .setRevisorRevision(RevisorRevisionAssembler.getInstance().toDTOFromDomain(domain.getRevisorRevision()));
    }

    @Override
    public ComentarioRevisorDomain toDomainFromDTO(ComentarioRevisorDTO dto) {
        return new ComentarioRevisorDomain(dto.getIdentificador(),RevisorRevisionAssembler.getInstance().toDomainFromDTO(dto.getRevisorRevision()),
                TipoComentarioRevisorAssembler.getInstance().toDomainFromDTO(dto.getTipo()), dto.getContenido());
    }

    @Override
    public ComentarioRevisorEntity toEntityFromDomain(ComentarioRevisorDomain domain) {
        return new ComentarioRevisorEntity(domain.getIdentificador(), RevisorRevisionAssembler.getInstance().toEntityFromDomain(domain.getRevisorRevision()), TipoComentarioRevisorAssembler.getInstance().toEntityFromDomain(domain.getTipo()),
                domain.getContenido());
    }

    @Override
    public ComentarioRevisorDomain toDomainFromEntity(ComentarioRevisorEntity entity) {
        return new ComentarioRevisorDomain(entity.getIdentificador(),RevisorRevisionAssembler.getInstance().toDomainFromEntity(entity.getRevisorRevision()),TipoComentarioRevisorAssembler.getInstance().toDomainFromEntity(entity.getTipo()), entity.getContenido());
    }

    @Override
    public List<ComentarioRevisorDomain> toDomainFromEntityList(List<ComentarioRevisorEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();

    }

    @Override
    public List<ComentarioRevisorDomain> toDomainFromDTOList(List<ComentarioRevisorDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();    }

    @Override
    public List<ComentarioRevisorDTO> toDTOFromDomainList(List<ComentarioRevisorDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();

    }
}
