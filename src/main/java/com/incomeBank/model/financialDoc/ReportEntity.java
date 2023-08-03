/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incomeBank.model.financialDoc;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author a_khalighi
 */

@Entity
@Data
@Table(name = "REPORT")
public class ReportEntity implements Serializable {

    @Id
    @Column(name = "DOCID")
    private String rowId;

    @Column(name = "ACC_CODE")
    private String accountCode;

    @Column(name = "AMT")
    private BigDecimal debtAmount;
}
