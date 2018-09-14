package com.ch.uc.rest;

import com.ch.common.rest.BaseController;
import com.ch.uc.biz.BaseUserBiz;
import com.ch.uc.entity.BaseUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/27.
 */
@RestController
@RequestMapping("/user")
public class UserRest extends BaseController<BaseUserBiz,BaseUser>{
}
