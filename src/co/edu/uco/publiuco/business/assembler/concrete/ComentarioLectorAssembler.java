package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.ComentarioLectorDomain;
import co.edu.uco.publiuco.dto.ComentarioLectorDTO;
import co.edu.uco.publiuco.entities.ComentarioLectorEntity;
import co.edu.uco.publiuco.utils.UtilObject;

import java.util.List;

public final class ComentarioLectorAssembler implements Assembler<ComentarioLectorDomain, ComentarioLectorDTO, ComentarioLectorEntity> {
    public static final ComentarioLectorAssembler INSTANCE = new ComentarioLectorAssembler();
    public static ComentarioLectorAssembler getInstance() { return INSTANCE; }
    private ComentarioLectorAssembler(){
        super();
    }
    @Override
    public ComentarioLectorDTO toDTOFromDomain(ComentarioLectorDomain domain) {
        return ComentarioLectorDTO.create().setIdentificador(domain.getIdentificador()).setLector(LectorAssembler.getInstance().toDTOFromDomain(domain.getLector()))
                .setComentarioPadre(!UtilObject.isNull(domain.getComentarioPadre()) ? ComentarioLectorAssembler.getInstance().toDTOFromDomain(domain.getComentarioPadre()):null).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()))
                .setCotenido(domain.getCotenido()).setFechaComentario(domain.getFechaComentario()).setPublicacion(PublicacionAssembler.getInstance().toDTOFromDomain(domain.getPublicacion()));
    }

    @Override
    public ComentarioLectorDomain toDomainFromDTO(ComentarioLectorDTO dto) {
        return new ComentarioLectorDomain(dto.getIdentificador(),LectorAssembler.getInstance().toDomainFromDTO(dto.getLector()), PublicacionAssembler.getInstance().toDomainFromDTO(dto.getPublicacion()),
        		!UtilObject.isNull(dto.getComentarioPadre()) ? ComentarioLectorAssembler.getInstance().toDomainFromDTO(dto.getComentarioPadre()):null, dto.getCotenido(),dto.getFechaComentario(),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()), dto.isTienePadre());
    }

    @Override
    public ComentarioLectorEntity toEntityFromDomain(ComentarioLectorDomain domain) {
        return new ComentarioLectorEntity(domain.getIdentificador(),LectorAssembler.getInstance().toEntityFromDomain(domain.getLector()),PublicacionAssembler.getInstance().toEntityFromDomain(domain.getPublicacion()),
        		!UtilObject.isNull(domain.getComentarioPadre()) ? ComentarioLectorAssembler.getInstance().toEntityFromDomain(domain.getComentarioPadre()):null, domain.getCotenido(),domain.getFechaComentario(), EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()), domain.isTienePadre());
    }

    @Override
    public ComentarioLectorDomain toDomainFromEntity(ComentarioLectorEntity entity) {
        return new ComentarioLectorDomain(entity.getIdentificador(),LectorAssembler.getInstance().toDomainFromEntity(entity.getLector()), PublicacionAssembler.getInstance().toDomainFromEntity(entity.getPublicacion()),
        		!UtilObject.isNull(entity.getComentarioPadre()) ? ComentarioLectorAssembler.getInstance().toDomainFromEntity(entity.getComentarioPadre()):null, entity.getCotenido(),entity.getFechaComentario(),
                EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()), entity.isTienePadre());
    }

    @Override
    public List<ComentarioLectorDomain> toDomainFromEntityList(List<ComentarioLectorEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
    }

    @Override
    public List<ComentarioLectorDomain> toDomainFromDTOList(List<ComentarioLectorDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();    }

    @Override
    public List<ComentarioLectorDTO> toDTOFromDomainList(List<ComentarioLectorDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();

    }
}
