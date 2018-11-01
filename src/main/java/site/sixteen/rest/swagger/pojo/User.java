package site.sixteen.rest.swagger.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * User
 *
 * @author panhainan
 * @version 1.0
 * @description 用户实体
 * @date 2018/11/1 22:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String username;
    private String password;
    private String nickname;
    private Date registrationTime;
}
