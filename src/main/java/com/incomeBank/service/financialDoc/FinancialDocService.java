package com.incomeBank.service.financialDoc;

import com.incomeBank.dao.financialDoc.FinancialDocDAOService;
import com.incomeBank.util.Bundle;
import com.incomeBank.util.annotation.MessageBundle;
import com.incomeBank.util.annotation.WebProperties;
import com.incomeBank.ws.rest.util.FilterWrapper;

import javax.inject.Inject;
import java.util.*;

public class FinancialDocService {

    @Inject
    private FinancialDocDAOService financialDAOService;

    @Inject
    @MessageBundle
    Bundle messageBundle;

    @Inject
    @WebProperties
    Bundle webBundle;

    public Map<String, Object> getAll (FilterWrapper filterWrapper, Integer start, Integer limit) {

        Map<String, Object> map = new HashMap<>();
        try {
            map.put("list", financialDAOService.search(filterWrapper, start, limit));
            map.put("total", financialDAOService.getCount(filterWrapper));
        } catch (Exception ex) {
            throw ex;
        }

        return map;
    }
}
