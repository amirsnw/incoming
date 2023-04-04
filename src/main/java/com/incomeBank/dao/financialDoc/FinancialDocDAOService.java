package com.incomeBank.dao.financialDoc;

import com.incomeBank.model.financialDoc.FinancialDoc;
import com.incomeBank.util.BaseDAOService;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class FinancialDocDAOService extends BaseDAOService<FinancialDoc> {

    @Inject
    private EntityManager em;

    @Override
    public Class<FinancialDoc> getClazz() {
        return FinancialDoc.class;
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
