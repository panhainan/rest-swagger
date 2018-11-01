package site.sixteen.rest.swagger.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.sixteen.rest.swagger.dto.UserDTO;
import site.sixteen.rest.swagger.service.UserService;
import site.sixteen.rest.swagger.vo.UserVO;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * UserController
 *
 * @author panhainan
 * @version 1.0
 * @description 用户控制器
 * @date 2018/11/1 22:00
 */
@RestController
@RequestMapping(value = "/user", produces = APPLICATION_JSON_VALUE)
@Api("用户接口")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    private UserVO register(UserDTO userDTO) {
        log.info("用户注册：{}", userDTO);
        return userService.register(userDTO);
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    private UserVO login(UserDTO userDTO) {
        log.info("用户登录：{}", userDTO);
        return userService.register(userDTO);
    }
}
