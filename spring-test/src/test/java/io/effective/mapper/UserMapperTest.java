package io.effective.mapper;

import io.effective.model.AmsAccount;
import io.effective.model.AmsUser;
import lombok.val;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.Date;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserMapperTest {
    @Autowired
    AmsUserMapper userMapper;
    @Autowired
    AmsAccountMapper accountMapper;

    @Test
    public void saveUserTest() {
        val id = 100000933270L;
        val account = accountMapper.selectOneByExample(Example.builder(AmsAccount.class)
                .where(Sqls.custom().andEqualTo(AmsAccount.ID, id)).build());
        assertThat(account).isNotNull();
        val user = new AmsUser();
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setAccountId(account.getId());
        user.setName("test");
        user.setPassword(RandomString.make());
        user.setSecretKey(new byte[]{1, 0});
        user.setSrn(RandomString.make());
        user.setCreatedAt(new Date());
        user.setCreatedBy("");
        userMapper.insertSelective(user);
    }
}
