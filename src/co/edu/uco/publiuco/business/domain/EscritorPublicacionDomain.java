package co.edu.uco.publiuco.business.domain;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilUUID;

import java.util.UUID;

public final class EscritorPublicacionDomain {
    private UUID identificador;
    private PublicacionDomain publicacion;
    private EscritorDomain escritor;
    private TipoEscritorDomain tipo;
    public static final EscritorPublicacionDomain DEFAULT_OBJECT = new EscritorPublicacionDomain();

    private EscritorPublicacionDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setPublicacion(PublicacionDomain.getDefaultObject());
        setEscritor(EscritorDomain.getDefaultObject());
        setTipo(TipoEscritorDomain.getDefaultObject());
    }

    public EscritorPublicacionDomain(UUID identificador, PublicacionDomain publicacion, EscritorDomain escritor, TipoEscritorDomain tipo) {
        super();
        setIdentificador(identificador);
        setPublicacion(publicacion);
        setEscritor(escritor);
        setTipo(tipo);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public PublicacionDomain getPublicacion() {
        return publicacion;
    }

    public EscritorDomain getEscritor() {
        return escritor;
    }

    public TipoEscritorDomain getTipo() {
        return tipo;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setPublicacion(final PublicacionDomain publicacion) {
        this.publicacion = UtilObject.getDefault(publicacion, PublicacionDomain.getDefaultObject());
    }

    private void setEscritor(final EscritorDomain escritor) {
        this.escritor = UtilObject.getDefault(escritor, EscritorDomain.getDefaultObject());
    }

    private void setTipo(final TipoEscritorDomain tipo) {
        this.tipo = UtilObject.getDefault(tipo, TipoEscritorDomain.getDefaultObject());
    }
    public static EscritorPublicacionDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
