package com.incomeBank.service;

import com.incomeBank.entity.ReportEntity;
import com.incomeBank.repository.ReportRepository;
import com.incomeBank.util.Bundle;
import com.incomeBank.util.annotation.MessageBundle;
import com.incomeBank.util.annotation.WebProperties;
import com.incomeBank.ws.rest.util.FilterWrapper;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.*;

@Transactional
public class ReportService {

    @Inject
    private ReportRepository repository;

    @Inject
    @MessageBundle
    Bundle messageBundle;

    @Inject
    @WebProperties
    Bundle webBundle;

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
