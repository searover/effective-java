package io.effective.dao;

import io.effective.dto.Customer;
import io.effective.model.AmsAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AmsAccountDao {
    List<Customer> findCustomersByOpsUserId(@Param("opsUserId") String id);

    AmsAccount getAccountByName(long id);

    void updateAccountName(@Param("id") long id, @Param("name") String name);
}
