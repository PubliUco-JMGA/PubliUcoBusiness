package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.VersionDomain;
import co.edu.uco.publiuco.dto.VersionDTO;
import co.edu.uco.publiuco.entities.VersionEntity;
import co.edu.uco.publiuco.utils.UtilObject;

import java.util.List;

public final class VersionAssembler implements Assembler<VersionDomain, VersionDTO, VersionEntity> {
    public static final VersionAssembler INSTANCE = new VersionAssembler();
    public static VersionAssembler getInstance() { return INSTANCE; }
    private VersionAssembler(){
        super();
    }
    @Override
    public VersionDTO toDTOFromDomain(VersionDomain domain) {
        return VersionDTO.create().setIdentificador(domain.getIdentificador()).setNumeroVersion(domain.getNumeroVersion())
                .setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado())).setCuerpo(domain.getCuerpo())
                .setFechaCreacion(domain.getFechaCreacion())
                .setResumen(domain.getResumen()).setTitulo(domain.getTitulo()).setFechaUltimaModificacion(domain.getFechaUltimaModificacion()).setVersionAnterior(!UtilObject.isNull(domain.getVersionAnterior()) ? VersionAssembler.getInstance().toDTOFromDomain(domain.getVersionAnterior()):null);
    }

    @Override
    public VersionDomain toDomainFromDTO(VersionDTO dto) {
        return new VersionDomain(dto.getIdentificador(),!UtilObject.isNull(dto.getVersionAnterior()) ? VersionAssembler.getInstance().toDomainFromDTO(dto.getVersionAnterior()):null,
                dto.getNumeroVersion(),dto.getFechaCreacion(),dto.getFechaUltimaModificacion(),dto.getTitulo(),dto.getResumen(),dto.getCuerpo(),
                EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()), dto.isTieneVersionAnterior());
    }

    @Override
    public VersionEntity toEntityFromDomain(VersionDomain domain) {
        return new VersionEntity(domain.getIdentificador(),!UtilObject.isNull(domain.getVersionAnterior()) ? VersionAssembler.getInstance().toEntityFromDomain(domain.getVersionAnterior()):null,
                domain.getNumeroVersion(),domain.getFechaCreacion(),domain.getFechaUltimaModificacion(),domain.getTitulo(),domain.getResumen(),domain.getCuerpo(),
                EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()), domain.isTieneVersionAnterior());
    }

    @Override
    public VersionDomain toDomainFromEntity(VersionEntity entity) {
        return new VersionDomain(entity.getIdentificador(),!UtilObject.isNull(entity.getVersionAnterior()) ? VersionAssembler.getInstance().toDomainFromEntity(entity.getVersionAnterior()):null,
                entity.getNumeroVersion(),entity.getFechaCreacion(),entity.getFechaUltimaModificacion(),entity.getTitulo(), entity.getResumen(),entity.getCuerpo(),
                EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()), entity.isTieneVersionAnterior());
    }

    @Override
    public List<VersionDomain> toDomainFromEntityList(List<VersionEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();

    }

    @Override
    public List<VersionDomain> toDomainFromDTOList(List<VersionDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();    }

    @Override
    public List<VersionDTO> toDTOFromDomainList(List<VersionDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();

    }
}
