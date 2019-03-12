package io.effective.service;

import io.effective.dto.Customer;
import io.effective.model.AmsAccount;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AccountService {

    @Transactional
    AmsAccount create(AmsAccount account);

    AmsAccount getAmsAccountById(long id);

    List<AmsAccount> list(long[] ids);

    List<Customer> getCustomers(String opsUserId);
}
