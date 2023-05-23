package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.business.TipoEstadoBusiness;
import co.edu.uco.publiuco.business.domain.TipoEstadoDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;

public class TipoEstadoBusinessImp implements TipoEstadoBusiness {

	private DAOFactory daoFactory;
	
	public TipoEstadoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoEstadoDomain> list(TipoEstadoDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}



}
