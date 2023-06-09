package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.TipoEstadoDomain;
import co.edu.uco.publiuco.dto.TipoEstadoDTO;
import co.edu.uco.publiuco.entities.TipoEstadoEntity;

import java.util.List;

public final class TipoEstadoAssembler implements Assembler<TipoEstadoDomain, TipoEstadoDTO, TipoEstadoEntity> {
    public static final TipoEstadoAssembler INSTANCE = new TipoEstadoAssembler();
    public static TipoEstadoAssembler getInstance() { return INSTANCE; }
    private TipoEstadoAssembler(){
        super();
    }
    @Override
    public TipoEstadoDTO toDTOFromDomain(TipoEstadoDomain domain) {
        return TipoEstadoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public TipoEstadoDomain toDomainFromDTO(TipoEstadoDTO dto) {
        return new TipoEstadoDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
    }

    @Override
    public TipoEstadoEntity toEntityFromDomain(TipoEstadoDomain domain) {
        return new TipoEstadoEntity(domain.getIdentificador(),domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public TipoEstadoDomain toDomainFromEntity(TipoEstadoEntity entity) {
        return new TipoEstadoDomain(entity.getIdentificador(),entity.getNombre(), entity.getDescripcion());
    }

    @Override
    public List<TipoEstadoDomain> toDomainFromEntityList(List<TipoEstadoEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
    }

    @Override
    public List<TipoEstadoDomain> toDomainFromDTOList(List<TipoEstadoDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();    }

    @Override
    public List<TipoEstadoDTO> toDTOFromDomainList(List<TipoEstadoDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();

    }
}
