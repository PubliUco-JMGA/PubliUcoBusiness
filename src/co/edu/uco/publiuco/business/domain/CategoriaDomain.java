package co.edu.uco.publiuco.business.domain;

import co.edu.uco.publiuco.utils.UtilBoolean;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

import java.util.UUID;

public final class CategoriaDomain {
    private UUID identificador;
    private CategoriaDomain categoriaPadre;
    private boolean tienePadre;
    private String nombre;
    private String descripcion;
    private EstadoDomain estado;
    public static final CategoriaDomain DEFAULT_OBJECT = new CategoriaDomain();

    private CategoriaDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setCategoriaPadre(CategoriaDomain.getDefaultObject());
        setNombre(UtilText.getDefaultValue());
        setDescripcion(UtilText.getDefaultValue());
        setEstado(EstadoDomain.getDefaultObject());
        setTienePadre(UtilBoolean.getDefaultValue());
    }

    public CategoriaDomain(UUID identificador, CategoriaDomain categoriaPadre, String nombre, String descripcion, EstadoDomain estado,boolean tienePadre) {
        super();
        setIdentificador(identificador);
        setCategoriaPadre(categoriaPadre);
        setNombre(nombre);
        setDescripcion(descripcion);
        setEstado(estado);
        setTienePadre(tienePadre);
    }

    
    public boolean tienePadre() {
		return tienePadre;
	}

	private void setTienePadre(boolean tienePadre) {
		this.tienePadre = UtilBoolean.getDefault(tienePadre);
	}

	public UUID getIdentificador() {
        return identificador;
    }

    public CategoriaDomain getCategoriaPadre() {
        return categoriaPadre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

     private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
     }

    private void setCategoriaPadre(final CategoriaDomain categoriaPadre) {
    	if(tienePadre()) {
            this.categoriaPadre = UtilObject.getDefault(categoriaPadre, getDefaultObject());
        }else {
			this.categoriaPadre = (CategoriaDomain) UtilObject.getNullValue();
        } 
    }

    private void setNombre(final String nombre) {
        this.nombre = UtilText.applyTrim(nombre);
    }

    private void setDescripcion(final String descripcion) {
        this.descripcion = UtilText.applyTrim(descripcion);
    }

    private void setEstado(EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }
    public static CategoriaDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
