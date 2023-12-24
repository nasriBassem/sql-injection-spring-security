package com.sql.injection;

import com.sql.injection.database.AccountDAO;
import com.sql.injection.database.AccountDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"test"})
public class SqlInjectionApplicationTest {
    @Autowired
    private AccountDAO accountDAO ;

    @Test
    public void givenAVulnerableMethod_whenValidCustomerId_thenReturnSingleAccount(){
        List<AccountDTO> accounts = accountDAO.unsafeGetAllAccountByAccountID("C1");
        assertThat(accounts).isNotNull();
        assertThat(accounts).isNotEmpty();
        assertThat(accounts).hasSize(1);
    }
}
