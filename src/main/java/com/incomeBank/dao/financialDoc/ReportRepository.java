package com.incomeBank.dao.financialDoc;

import com.incomeBank.model.financialDoc.ReportEntity;
import com.incomeBank.util.BaseDAOService;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class ReportRepository extends BaseDAOService<ReportEntity> {

    @Inject
    private EntityManager em;

    @Override
    public Class<ReportEntity> getClazz() {
        return ReportEntity.class;
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
