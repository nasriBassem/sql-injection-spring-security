package com.sql.injection.database;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
    private DataSource dataSource;
    private EntityManager entityManager;

    public AccountDAO(final DataSource dataSource, final EntityManager entityManager){
        this.dataSource = dataSource ;
        this.entityManager=entityManager;
    }

    /**
     * Return all accounts owned by a given customer,given his/her external id
     *
     * @return List<AccountDTO> list off account
     */
    public List<AccountDTO> unsafeGetAllAccountByAccountID(final String customerId) {
        String sql = "select " + "customer_id,acc_number,branch_id,balance from Accounts where customer_id = '" + customerId + "'";
        try (Connection connection = dataSource.getConnection(); ResultSet resultSet = connection.createStatement().executeQuery(sql)) {
            List<AccountDTO>  accounts = new ArrayList<>();
            while (resultSet.next()) {
                AccountDTO acc = AccountDTO.builder().
                        customerId(resultSet.getString("customer_id"))
                        .branchId(resultSet.getString("branch_id"))
                        .accNumber(resultSet.getString("acc_number"))
                        .balance(resultSet.getBigDecimal("balance")).build();
                accounts.add(acc);
            }
            return accounts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
