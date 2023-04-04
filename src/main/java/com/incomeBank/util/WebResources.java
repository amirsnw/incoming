package com.incomeBank.util;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.incomeBank.util.annotation.MessageBundle;
import com.incomeBank.util.annotation.WebProperties;

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

    // start : comment for deploy on weblogic 12.2
    /*@Produces
    @WebProperties
    @DevelopmentConfig
    @ApplicationScoped
    public Bundle produceDevAppProps() {
        ResourceBundle bundle = ResourceBundle.getBundle("dev-web");
        return new Bundle(bundle);
    }

    @Produces
    @WebProperties
    @SnapshotConfig
    @ApplicationScoped
    public Bundle produceSnapshotProps() {
        return new Bundle(ResourceBundle.getBundle("snapshot-web"));
    }

    @Produces
    @WebProperties
    @StageConfig
    @ApplicationScoped
    public Bundle produceStageProps() {
        return new Bundle(ResourceBundle.getBundle("stage-web"));
    }

    @Produces
    @WebProperties
    @TestConfig
    @ApplicationScoped
    public Bundle produceTestProps() {
        return new Bundle(ResourceBundle.getBundle("test-web"));
    }
    // end : comment for deploy on weblogic 12.2

    @Produces
    @WebProperties
    // comment for deploy on weblogic 12.2
    @ProductionConfig
    @ApplicationScoped
    public Bundle produceProdAppProps() {
        return new Bundle(ResourceBundle.getBundle("prod-web"));
    }*/

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
