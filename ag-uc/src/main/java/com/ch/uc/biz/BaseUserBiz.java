package com.ch.uc.biz;

import com.ch.common.biz.BaseBiz;
import com.ch.uc.entity.BaseUser;
import com.ch.uc.exception.BaseException;
import com.ch.uc.mapper.BaseUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/8/3.
 */
@Service
@Transactional
public class BaseUserBiz extends BaseBiz<BaseUserMapper,BaseUser>{


    @Override
    public BaseUser selectById(Object id) {
        throw new BaseException("Test Global Execption!",40010);
    }
}
