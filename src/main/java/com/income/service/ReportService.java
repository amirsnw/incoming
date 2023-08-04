package com.income.service;

import com.income.dto.FilterWrapper;
import com.income.entity.ReportEntity;
import com.income.repository.ReportRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.WebApplicationException;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class ReportService {

    @Inject
    private ReportRepository repository;

    public Map<String, Object> getAll (FilterWrapper filterWrapper, Integer start, Integer limit) {

        Map<String, Object> map = new HashMap<>();
        try {
            map.put("list", repository.search(filterWrapper, start, limit));
            map.put("total", repository.getCount(filterWrapper));
        } catch (Exception ex) {
            throw ex;
        }

        return map;
    }

    public ReportEntity create (ReportEntity reportEntity) {
        return repository.save(reportEntity);
    }
}
