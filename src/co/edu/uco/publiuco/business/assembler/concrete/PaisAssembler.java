package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.PaisDomain;
import co.edu.uco.publiuco.dto.PaisDTO;
import co.edu.uco.publiuco.entities.PaisEntity;

import java.util.List;

public final class PaisAssembler implements Assembler<PaisDomain, PaisDTO, PaisEntity> {
    public static final PaisAssembler INSTANCE = new PaisAssembler();
    public static PaisAssembler getInstance() { return INSTANCE; }
    private PaisAssembler(){
        super();
    }
    @Override
    public PaisDTO toDTOFromDomain(PaisDomain domain) {
        return PaisDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setIndicadorPais(domain.getIndicadorPais());
    }

    @Override
    public PaisDomain toDomainFromDTO(PaisDTO dto) {
        return new PaisDomain(dto.getIdentificador(), dto.getNombre(), dto.getIndicadorPais());
    }

    @Override
    public PaisEntity toEntityFromDomain(PaisDomain domain) {
        return new PaisEntity(domain.getIdentificador(), domain.getNombre(), domain.getIndicadorPais());
    }

    @Override
    public PaisDomain toDomainFromEntity(PaisEntity entity) {
        return new PaisDomain(entity.getIdentificador(), entity.getNombre(), entity.getIndicadorPais());
    }

    @Override
    public List<PaisDomain> toDomainFromEntityList(List<PaisEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();

    }

    @Override
    public List<PaisDomain> toDomainFromDTOList(List<PaisDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();    }

    @Override
    public List<PaisDTO> toDTOFromDomainList(List<PaisDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();

    }
}
