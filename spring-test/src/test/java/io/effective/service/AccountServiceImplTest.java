package io.effective.service;

import io.effective.mapper.AmsAccountMapper;
import io.effective.model.AmsAccount;
import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class AccountServiceImplTest {
    @MockBean
    private AmsAccountMapper mockAccountMapper;

    private AccountService accountService;
    private AmsAccount account;

    @Before
    public void setUp() throws Exception {
        accountService = new AccountServiceImpl(mockAccountMapper);
        account = new AmsAccount(1L, "test", new Date());
    }

    @Test
    public void check() {
        System.out.println("-------");
        val account = mockAccountMapper.selectByPrimaryKey(100000800000L);
        System.out.println(account);
        System.out.println(accountService);
        System.out.println("-------");
    }

    @Test
    public void whenValidName_thenAmsAccountShouldBeFound() {
        when(mockAccountMapper.selectByPrimaryKey(Mockito.anyLong())).thenReturn(account);
        val result = accountService.getAmsAccountById(Mockito.anyLong());
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(account.getId());
    }

}
