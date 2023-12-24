package com.sql.injection.database;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AccountDTO {
    private String customerId;
    private String accNumber;
    private String branchId;
    private BigDecimal balance;
}
