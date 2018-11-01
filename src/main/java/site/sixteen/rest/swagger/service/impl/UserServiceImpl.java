package site.sixteen.rest.swagger.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import site.sixteen.rest.swagger.dto.UserDTO;
import site.sixteen.rest.swagger.pojo.User;
import site.sixteen.rest.swagger.service.UserService;
import site.sixteen.rest.swagger.vo.UserVO;

import java.util.Date;

/**
 * UserServiceImpl
 *
 * @author panhainan
 * @version 1.0
 * @description 用户业务逻辑层接口的实现
 * @date 2018/11/1 22:00
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserVO register(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user.setId(100000000000L);
        user.setRegistrationTime(new Date());
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }

    @Override
    public UserVO login(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }
}
