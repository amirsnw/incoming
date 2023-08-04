package com.income.repository;

import com.income.entity.ReportEntity;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class ReportRepository extends BaseRepository<ReportEntity> {

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
