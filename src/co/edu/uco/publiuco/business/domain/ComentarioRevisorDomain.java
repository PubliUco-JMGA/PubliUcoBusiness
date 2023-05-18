package co.edu.uco.publiuco.business.domain;

import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

import java.util.UUID;

public final class ComentarioRevisorDomain {
    private UUID identificador;
    private RevisorRevisionDomain revisorRevision;
    private TipoComentarioRevisorDomain tipo;
    private String contenido;
    public static final ComentarioRevisorDomain DEFAULT_OBJECT = new ComentarioRevisorDomain();

    public ComentarioRevisorDomain(UUID identificador, RevisorRevisionDomain revisorRevision, TipoComentarioRevisorDomain tipo, String contenido) {
        super();
        setIdentificador(identificador);
        setRevisorRevision(revisorRevision);
        setTipo(tipo);
        setContenido(contenido);

    }
    private ComentarioRevisorDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setRevisorRevision(RevisorRevisionDomain.getDefaultObject());
        setTipo(TipoComentarioRevisorDomain.getDefaultObject());
        setContenido(UtilText.getDefaultValue());

    }

    public UUID getIdentificador() {
        return identificador;
    }

    public RevisorRevisionDomain getRevisorRevision() {
        return revisorRevision;
    }

    public TipoComentarioRevisorDomain getTipo() {
        return tipo;
    }

    public String getContenido() {
        return contenido;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setRevisorRevision(final RevisorRevisionDomain revisorRevision) {
        this.revisorRevision = UtilObject.getDefault(revisorRevision, RevisorRevisionDomain.getDefaultObject());
    }

    private void setTipo(final TipoComentarioRevisorDomain tipo) {
        this.tipo = UtilObject.getDefault(tipo, TipoComentarioRevisorDomain.getDefaultObject());
    }

    private void setContenido(final String contenido) {
        this.contenido = UtilText.applyTrim(contenido);
    }
    public static ComentarioRevisorDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
