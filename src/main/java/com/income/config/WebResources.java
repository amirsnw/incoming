package com.income.config;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.income.annotation.MessageBundle;
import com.income.annotation.WebProperties;
import com.income.util.Bundle;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class WebResources {

    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    @Produces
    public EntityManager produceEntityManager() {
        return em;
    }

    @Inject
    @WebProperties
    private Bundle webProperties;

    @Resource(lookup = "datasources/coreaccountDS")
    private DataSource dataSource;

    @Produces
    public DataSource getDataSource() {
        return dataSource;
    }

    @Produces
    public Logger produceJavaLogger() {
        return Logger.getAnonymousLogger();
    }

    @Produces
    @WebProperties
    @ApplicationScoped
    public Bundle produceDevAppProps() {
        return new Bundle(ResourceBundle.getBundle("dev-web"));
    }

    @Produces
    @MessageBundle
    @Named("WebMessages")
    @ApplicationScoped
    public Bundle produceMessageBundle() {
        return new Bundle(ResourceBundle.getBundle("messages/WebMessages",
                new Locale(webProperties.getProperty("application.locale"))));
    }
}
