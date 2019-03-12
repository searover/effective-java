package io.effective.mapper;

import io.effective.BaseMapper;
import io.effective.model.AmsUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AmsUserMapper extends BaseMapper<AmsUser> {
}