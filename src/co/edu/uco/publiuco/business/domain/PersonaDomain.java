package co.edu.uco.publiuco.business.domain;

import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

import java.util.UUID;

public final class PersonaDomain {
    private UUID identificador;
    private TipoIdentificacionDomain tipoIdentificacionDTO;
    private String numeroIdentificacion;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String correoElectronico;
    private PaisDomain paisTelefono;
    private String numeroTelefono;
    private EstadoDomain estado;
    private TipoRelacionInstitucionDomain relacionInstitucion;
    public static final PersonaDomain DEFAULT_OBJECT = new PersonaDomain();

    private PersonaDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setTipoIdentificacionDTO(TipoIdentificacionDomain.getDefaultObject());
        setNumeroIdentificacion(UtilText.getDefaultValue());
        setPrimerNombre(UtilText.getDefaultValue());
        setSegundoNombre(UtilText.getDefaultValue());
        setPrimerApellido(UtilText.getDefaultValue());
        setSegundoApellido(UtilText.getDefaultValue());
        setCorreoElectronico(UtilText.getDefaultValue());
        setPaisTelefono(PaisDomain.getDefaultObject());
        setNumeroTelefono(UtilText.getDefaultValue());
        setEstado(EstadoDomain.getDefaultObject());
    }

    public PersonaDomain(UUID identificador, TipoIdentificacionDomain tipoIdentificacionDTO, String numeroIdentificacion, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correoElectronico, PaisDomain paisTelefono, String numeroTelefono, EstadoDomain estado, TipoRelacionInstitucionDomain relacionInstitucion) {
        super();
        setIdentificador(identificador);
        setTipoIdentificacionDTO(tipoIdentificacionDTO);
        setNumeroIdentificacion(numeroIdentificacion);
        setPrimerNombre(primerNombre);
        setSegundoNombre(segundoNombre);
        setPrimerApellido(primerApellido);
        setSegundoApellido(segundoApellido);
        setCorreoElectronico(correoElectronico);
        setPaisTelefono(paisTelefono);
        setNumeroTelefono(numeroTelefono);
        setRelacionInstitucion(relacionInstitucion);
        setEstado(estado);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public TipoIdentificacionDomain getTipoIdentificacionDTO() {
        return tipoIdentificacionDTO;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public PaisDomain getPaisTelefono() {
        return paisTelefono;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    public TipoRelacionInstitucionDomain getRelacionInstitucion() {
        return relacionInstitucion;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setTipoIdentificacionDTO(final TipoIdentificacionDomain tipoIdentificacionDTO) {
        this.tipoIdentificacionDTO = UtilObject.getDefault(tipoIdentificacionDTO, TipoIdentificacionDomain.getDefaultObject());
    }

    private void setNumeroIdentificacion(final String numeroIdentificacion) {
        this.numeroIdentificacion = UtilText.applyTrim(numeroIdentificacion);
    }

    private void setPrimerNombre(final String primerNombre) {
        this.primerNombre = UtilText.applyTrim(primerNombre);
    }

    private void setSegundoNombre(final String segundoNombre) {
        this.segundoNombre = UtilText.applyTrim(segundoNombre);
    }

    private void setPrimerApellido(final String primerApellido) {
        this.primerApellido = UtilText.applyTrim(primerApellido);
    }

    private void setSegundoApellido(final String segundoApellido) {
        this.segundoApellido = UtilText.applyTrim(segundoApellido);
    }

    private void setCorreoElectronico(final String correoElectronico) {
        this.correoElectronico = UtilText.applyTrim(correoElectronico);
    }

    private void setPaisTelefono(final PaisDomain paisTelefono) {
        this.paisTelefono = UtilObject.getDefault(paisTelefono, PaisDomain.getDefaultObject());
    }

    private void setNumeroTelefono(final String numeroTelefono) {
        this.numeroTelefono = UtilText.applyTrim(numeroTelefono);
    }

    private void setEstado(EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }

    private void setRelacionInstitucion(TipoRelacionInstitucionDomain relacionInstitucion) {
        this.relacionInstitucion = UtilObject.getDefault(relacionInstitucion, TipoRelacionInstitucionDomain.getDefaultObject());
    }
    public static PersonaDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
