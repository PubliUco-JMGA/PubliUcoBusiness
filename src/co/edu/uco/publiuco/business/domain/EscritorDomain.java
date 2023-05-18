package co.edu.uco.publiuco.business.domain;

import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilUUID;

import java.util.UUID;

public final class EscritorDomain {
    private UUID identificador;
    private PersonaDomain datosPersona;
    private EstadoDomain estado;
    public static final EscritorDomain DEFAULT_OBJECT = new EscritorDomain();

    private EscritorDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setDatosPersona(PersonaDomain.getDefaultObject());
        setEstado(EstadoDomain.getDefaultObject());
    }
    public EscritorDomain(UUID identificador, PersonaDomain datosPersona, EstadoDomain estado) {
        super();
        setIdentificador(identificador);
        setDatosPersona(datosPersona);
        setEstado(estado);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public PersonaDomain getDatosPersona() {
        return datosPersona;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setDatosPersona(final PersonaDomain datosPersona) {
        this.datosPersona = UtilObject.getDefault(datosPersona, PersonaDomain.getDefaultObject());
    }


    private void setEstado(EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }
    public static EscritorDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
