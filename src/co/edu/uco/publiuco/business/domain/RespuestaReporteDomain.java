package co.edu.uco.publiuco.business.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.publiuco.utils.UtilDate;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

public class RespuestaReporteDomain {
	private UUID identificador;
	private ReporteDomain reporte;
	private CategoriaAdministradorCategoriaDomain administradorCategoria;
	private LocalDateTime fechaRespuestaReporte;
	private String justificacion;
	private EstadoDomain veredicto;
	 public static final RespuestaReporteDomain DEFAULT_OBJECT = new RespuestaReporteDomain();
	
	private RespuestaReporteDomain() {
		setIdentificador(UtilUUID.getDefaultValue());
		setAdministradorCategoria(CategoriaAdministradorCategoriaDomain.getDefaultObject());
		setReporte(ReporteDomain.getDefaultObject());
		setFechaRespuestaReporte(UtilDate.getDefaultValue());
		setJustificacion(UtilText.getDefaultValue());
		setVeredicto(EstadoDomain.getDefaultObject());
	}
	public RespuestaReporteDomain(UUID identificador, ReporteDomain reporte,
			CategoriaAdministradorCategoriaDomain administradorCategoria, LocalDateTime fechaRespuestaReporte,
			String justificacion, EstadoDomain veredicto) {
		setIdentificador(identificador);
		setReporte(reporte);
		setAdministradorCategoria(administradorCategoria);
		setFechaRespuestaReporte(fechaRespuestaReporte);
		setJustificacion(justificacion);
		setVeredicto(veredicto);
	}
	public UUID getIdentificador() {
		return identificador;
	}
	private void setIdentificador(UUID identificador) {
		this.identificador = identificador;
	}
	public ReporteDomain getReporte() {
		return reporte;
	}
	private void setReporte(ReporteDomain reporte) {
		this.reporte = reporte;
	}
	public CategoriaAdministradorCategoriaDomain getAdministradorCategoria() {
		return administradorCategoria;
	}
	private void setAdministradorCategoria(CategoriaAdministradorCategoriaDomain administradorCategoria) {
		this.administradorCategoria = administradorCategoria;
	}
	public LocalDateTime getFechaRespuestaReporte() {
		return fechaRespuestaReporte;
	}
	private void setFechaRespuestaReporte(LocalDateTime fechaRespuestaReporte) {
		this.fechaRespuestaReporte = fechaRespuestaReporte;
	}
	public String getJustificacion() {
		return justificacion;
	}
	private void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}
	public EstadoDomain getVeredicto() {
		return veredicto;
	}
	private void setVeredicto(EstadoDomain veredicto) {
		this.veredicto = veredicto;
	}
	public static RespuestaReporteDomain create (){
        return new RespuestaReporteDomain();
    }
	public static RespuestaReporteDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
	
	
	
}
