package site.sixteen.rest.swagger.service;

import site.sixteen.rest.swagger.dto.UserDTO;
import site.sixteen.rest.swagger.vo.UserVO;

/**
 * UserService
 *
 * @author panhainan
 * @version 1.0
 * @description 用户业务逻辑层接口
 * @date 2018/11/1 22:00
 */
public interface UserService {

    /**
     * 用户注册
     *
     * @param userDTO 用户数据传输对象
     * @return UserVO 用户视图对象
     */
    UserVO register(UserDTO userDTO);

    /**
     * 用户登录
     *
     * @param userDTO 用户数据传输对象
     * @return UserVO 用户视图对象
     */
    UserVO login(UserDTO userDTO);
}
