package co.edu.uco.publiuco.business.domain;

import co.edu.uco.publiuco.utils.UtilDate;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public final class ReporteDomain {
    private UUID identificador;
    private LectorDomain lector;
    private ComentarioLectorDomain comentario;
    private String razon;
    private TipoReporteDomain tipo;
    private LocalDateTime fechaReporte;
    private EstadoDomain estado;
    public static final ReporteDomain DEFAULT_OBJECT = new ReporteDomain();

    private ReporteDomain() {
        setIdentificador(UtilUUID.getDefaultValue());
        setLector(LectorDomain.getDefaultObject());
        setComentario(ComentarioLectorDomain.getDefaultObject());
        setRazon(UtilText.getDefaultValue());
        setTipo(TipoReporteDomain.getDefaultObject());
        setFechaReporte(UtilDate.getDefaultValue());
        setEstado(EstadoDomain.getDefaultObject());
    }

    public ReporteDomain(UUID identificador, LectorDomain lector, ComentarioLectorDomain comentario, String razon, TipoReporteDomain tipo, LocalDateTime fechaReporte,EstadoDomain estado) {
        setIdentificador(identificador);
        setLector(lector);
        setComentario(comentario);
        setRazon(razon);
        setTipo(tipo);
        setFechaReporte(fechaReporte);
        setEstado(estado);
    }
    
    public EstadoDomain getEstado() {
		return estado;
	}

	private void setEstado(EstadoDomain estado) {
		this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
	}

	public UUID getIdentificador() {
        return identificador;
    }

    public LectorDomain getLector() {
        return lector;
    }

    public ComentarioLectorDomain getComentario() {
        return comentario;
    }

    public String getRazon() {
        return razon;
    }

    public TipoReporteDomain getTipo() {
        return tipo;
    }

    public LocalDateTime getFechaReporte() {
        return fechaReporte;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setLector(final LectorDomain lector) {
        this.lector = UtilObject.getDefault(lector, LectorDomain.getDefaultObject());
    }

    private void setComentario(final ComentarioLectorDomain comentario) {
        this.comentario = UtilObject.getDefault(comentario, ComentarioLectorDomain.getDefaultObject());
    }

    private void setRazon(final String razon) {
        this.razon = UtilText.applyTrim(razon);
    }

    private void setTipo(final TipoReporteDomain tipo) {
        this.tipo = UtilObject.getDefault(tipo, TipoReporteDomain.getDefaultObject());
    }

    private void setFechaReporte(final LocalDateTime fechaReporte) {
        this.fechaReporte = UtilDate.getDefault(fechaReporte);
    }
    public static ReporteDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
