package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.RespuestaReporteDomain;
import co.edu.uco.publiuco.dto.RespuestaReporteDTO;
import co.edu.uco.publiuco.entities.RespuestaReporteEntity;

public class RespuestaReporteAssembler implements Assembler<RespuestaReporteDomain,RespuestaReporteDTO,RespuestaReporteEntity>{

	public static final RespuestaReporteAssembler INSTANCE = new RespuestaReporteAssembler();
    public static RespuestaReporteAssembler getInstance() { return INSTANCE; }
    private RespuestaReporteAssembler(){
        super();
    }
	@Override
	public RespuestaReporteDTO toDTOFromDomain(RespuestaReporteDomain domain) {
		return RespuestaReporteDTO.create().setIdentificador(domain.getIdentificador()).setAdministradorCategoria(CategoriaAdministradorCategoriaAssembler.getInstance().toDTOFromDomain(domain.getAdministradorCategoria()))
				.setFechaRespuestaReporte(domain.getFechaRespuestaReporte()).setJustificacion(domain.getJustificacion()).setReporte(ReporteAssembler.getInstance().toDTOFromDomain(domain.getReporte()))
				.setVeredicto(EstadoAssembler.getInstance().toDTOFromDomain(domain.getVeredicto()));
	}

	@Override
	public RespuestaReporteDomain toDomainFromDTO(RespuestaReporteDTO dto) {
		return new RespuestaReporteDomain(dto.getIdentificador(),ReporteAssembler.getInstance().toDomainFromDTO(dto.getReporte()),
				CategoriaAdministradorCategoriaAssembler.getInstance().toDomainFromDTO(dto.getAdministradorCategoria()),dto.getFechaRespuestaReporte(), dto.getJustificacion(), EstadoAssembler.getInstance().toDomainFromDTO(dto.getVeredicto()));
	}

	@Override
	public RespuestaReporteEntity toEntityFromDomain(RespuestaReporteDomain domain) {
		return new RespuestaReporteEntity(domain.getIdentificador(),ReporteAssembler.getInstance().toEntityFromDomain(domain.getReporte()),
				CategoriaAdministradorCategoriaAssembler.getInstance().toEntityFromDomain(domain.getAdministradorCategoria()),domain.getFechaRespuestaReporte(), domain.getJustificacion(), EstadoAssembler.getInstance().toEntityFromDomain(domain.getVeredicto()));
	}

	@Override
	public RespuestaReporteDomain toDomainFromEntity(RespuestaReporteEntity entity) {
		return new RespuestaReporteDomain(entity.getIdentificador(),ReporteAssembler.getInstance().toDomainFromEntity(entity.getReporte()),
				CategoriaAdministradorCategoriaAssembler.getInstance().toDomainFromEntity(entity.getAdministradorCategoria()),entity.getFechaRespuestaReporte(), entity.getJustificacion(), EstadoAssembler.getInstance().toDomainFromEntity(entity.getVeredicto()));
	}

	@Override
	public List<RespuestaReporteDomain> toDomainFromEntityList(List<RespuestaReporteEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<RespuestaReporteDomain> toDomainFromDTOList(List<RespuestaReporteDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();    
	}

	@Override
	public List<RespuestaReporteDTO> toDTOFromDomainList(List<RespuestaReporteDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}

}
