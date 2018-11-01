package site.sixteen.rest.swagger.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * UserVO
 *
 * @author panhainan
 * @version 1.0
 * @description 用户视图对象
 * @date 2018/11/1 22:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    @ApiModelProperty(value = "昵称")
    private String nickname;
    @ApiModelProperty(value = "注册时间")
    private Date registrationTime;
}
