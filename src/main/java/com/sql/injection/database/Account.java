package com.sql.injection.database;

import lombok.Data;

import java.math.BigDecimal;
import javax.persistence.*;
import java.io.Serializable;

import javax.persistence.Id;



/**
 * Account Table
 *
 * @author NASRI Bassem
 */
@Entity
@Table(name = "Accounts")
@Data
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String customerId;
    private String accNumber;
    private String branchId;
    private BigDecimal balance;
}
