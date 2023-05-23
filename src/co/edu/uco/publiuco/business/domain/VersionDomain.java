package co.edu.uco.publiuco.business.domain;

import co.edu.uco.publiuco.utils.*;

import java.time.LocalDateTime;
import java.util.UUID;

public final class VersionDomain {
    private UUID identificador;
    private VersionDomain versionAnterior;
    private boolean tieneVersionAnterior;
    private Integer numeroVersion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaUltimaModificacion;
    private String titulo;
    private String resumen;
    private String cuerpo;
    private EstadoDomain estado;

    public static final VersionDomain DEFAULT_OBJECT = new VersionDomain();


    private VersionDomain() {
        setIdentificador(UtilUUID.getDefaultValue());
        setVersionAnterior(getDefaultObject());
        setNumeroVersion(UtilNumber.getIntegerDefaultValue());
        setFechaCreacion(UtilDate.getDefaultValue());
        setFechaUltimaModificacion(UtilDate.getDefaultValue());
        setTitulo(UtilText.getDefaultValue());
        setResumen(UtilText.getDefaultValue());
        setCuerpo(UtilText.getDefaultValue());
        setEstado(EstadoDomain.getDefaultObject());
        setTieneVersionAnterior(UtilBoolean.getDefaultValue());
    }

    public VersionDomain(UUID identificador, VersionDomain versionAnterior, int numeroVersion,
    		LocalDateTime fechaCreacion, LocalDateTime fechaUltimaModificacion, String titulo, String resumen, String cuerpo, EstadoDomain estado,boolean tieneVersionAnterior) {
        setIdentificador(identificador);
        setVersionAnterior(versionAnterior);
        setNumeroVersion(numeroVersion);
        setFechaCreacion(fechaCreacion);
        setFechaUltimaModificacion(fechaUltimaModificacion);
        setTitulo(titulo);
        setResumen(resumen);
        setCuerpo(cuerpo);
        setEstado(estado);
        setTieneVersionAnterior(tieneVersionAnterior);
    }

    
    public boolean tieneVersionAnterior() {
		return tieneVersionAnterior;
	}

	private void setTieneVersionAnterior(boolean tieneVersionAnterior) {
		this.tieneVersionAnterior = UtilBoolean.getDefault(tieneVersionAnterior);
	}

	public UUID getIdentificador() {
        return identificador;
    }



    public VersionDomain getVersionAnterior() {
        return versionAnterior;
    }

    public Integer getNumeroVersion() {
        return numeroVersion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }


    private void setVersionAnterior(VersionDomain versionAnterior) {
    	if(tieneVersionAnterior()) {
            this.versionAnterior = UtilObject.getDefault(versionAnterior, getDefaultObject());
        }else {
			this.versionAnterior = (VersionDomain) UtilObject.getNullValue();
        }  
    }

    private void setNumeroVersion(final Integer numeroVersion) {
        this.numeroVersion = UtilNumber.getDefaultInt(numeroVersion);
    }

    private void setFechaCreacion(final LocalDateTime fechaCreacion) {
        this.fechaCreacion = UtilDate.getDefault(fechaCreacion);
    }

    private void setFechaUltimaModificacion(final LocalDateTime fechaUltimaModificacion) {
        this.fechaUltimaModificacion = UtilDate.getDefault(fechaUltimaModificacion);
    }

    private void setTitulo(final String titulo) {
        this.titulo = UtilText.applyTrim(titulo);
    }

    private void setResumen(final String resumen) {
        this.resumen = UtilText.applyTrim(resumen);
    }

    private void setCuerpo(final String cuerpo) {
        this.cuerpo = UtilText.applyTrim(cuerpo);
    }

    private void setEstado(final EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }
    public static VersionDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
