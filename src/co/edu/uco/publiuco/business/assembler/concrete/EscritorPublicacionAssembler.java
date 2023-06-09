package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.EscritorPublicacionDomain;
import co.edu.uco.publiuco.dto.EscritorPublicacionDTO;
import co.edu.uco.publiuco.entities.EscritorPublicacionEntity;

import java.util.List;

public final class EscritorPublicacionAssembler implements Assembler<EscritorPublicacionDomain, EscritorPublicacionDTO, EscritorPublicacionEntity> {
    public static final EscritorPublicacionAssembler INSTANCE = new EscritorPublicacionAssembler();
    public static EscritorPublicacionAssembler getInstance() { return INSTANCE; }
    private EscritorPublicacionAssembler(){
        super();
    }
    @Override
    public EscritorPublicacionDTO toDTOFromDomain(EscritorPublicacionDomain domain) {
        return EscritorPublicacionDTO.create().setIdentificador(domain.getIdentificador()).setPublicacion(PublicacionAssembler.getInstance().toDTOFromDomain(domain.getPublicacion()))
                .setEscritor(EscritorAssembler.getInstance().toDTOFromDomain(domain.getEscritor())).setTipo(TipoEscritorAssembler.getInstance().toDTOFromDomain(domain.getTipo()));
    }

    @Override
    public EscritorPublicacionDomain toDomainFromDTO(EscritorPublicacionDTO dto) {
        return new EscritorPublicacionDomain(dto.getIdentificador(),PublicacionAssembler.getInstance().toDomainFromDTO(dto.getPublicacion()),
                EscritorAssembler.getInstance().toDomainFromDTO(dto.getEscritor()), TipoEscritorAssembler.getInstance().toDomainFromDTO(dto.getTipo()));
    }

    @Override
    public EscritorPublicacionEntity toEntityFromDomain(EscritorPublicacionDomain domain) {
        return new EscritorPublicacionEntity(domain.getIdentificador(),PublicacionAssembler.getInstance().toEntityFromDomain(domain.getPublicacion()),
                EscritorAssembler.getInstance().toEntityFromDomain(domain.getEscritor()), TipoEscritorAssembler.getInstance().toEntityFromDomain(domain.getTipo()));
    }

    @Override
    public EscritorPublicacionDomain toDomainFromEntity(EscritorPublicacionEntity entity) {
        return new EscritorPublicacionDomain(entity.getIdentificador(),PublicacionAssembler.getInstance().toDomainFromEntity(entity.getPublicacion()),
                EscritorAssembler.getInstance().toDomainFromEntity(entity.getEscritor()), TipoEscritorAssembler.getInstance().toDomainFromEntity(entity.getTipo()));
    }

    @Override
    public List<EscritorPublicacionDomain> toDomainFromEntityList(List<EscritorPublicacionEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();

    }

    @Override
    public List<EscritorPublicacionDomain> toDomainFromDTOList(List<EscritorPublicacionDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();    }

    @Override
    public List<EscritorPublicacionDTO> toDTOFromDomainList(List<EscritorPublicacionDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();

    }
}
