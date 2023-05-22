package co.edu.uco.publiuco.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.assembler.concrete.RespuestaReporteAssembler;
import co.edu.uco.publiuco.business.business.RespuestaReporteBusiness;
import co.edu.uco.publiuco.business.domain.RespuestaReporteDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.RespuestaReporteEntity;

public class RespuestaReporteBusinessImpl implements RespuestaReporteBusiness{
	DAOFactory daoFactory;

	public RespuestaReporteBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(RespuestaReporteDomain domain) {
		final RespuestaReporteEntity entity = RespuestaReporteAssembler.getInstance().toEntityFromDomain(domain);
		//daoFactory.getRespuestaReporteDAO().create(entity);

	}

	@Override
	public List<RespuestaReporteDomain> list(RespuestaReporteDomain domain) {
		final RespuestaReporteEntity entity = RespuestaReporteAssembler.getInstance().toEntityFromDomain(domain);

		//final List<RespuestaEntity> result = daoFactory.getRespuestaReporteDAO().read(entity);

		return null;
	}

	@Override
	public void modify(RespuestaReporteDomain domain) {
		final RespuestaReporteEntity entity = RespuestaReporteAssembler.getInstance().toEntityFromDomain(domain);
		//daoFactory.getRespuestaReporteDAO().update(entity);
	}

	@Override
	public void drop(UUID domain) {
		//daoFactory.getRespuestaReporteDAO().delete(domain);
	}
}
