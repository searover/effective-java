package io.effective.mapper;

import io.effective.BaseMapper;
import io.effective.model.AmsAccount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AmsAccountMapper extends BaseMapper<AmsAccount> {
}