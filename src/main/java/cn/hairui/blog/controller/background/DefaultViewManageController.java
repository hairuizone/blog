package cn.hairui.blog.controller.background;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 * <h2>请添加说明
 * </h2>
 * <ol>请添加详细说明
 * </ol>
 *
 * <h2>修改历史
 * </h2>
 * <ol>如有修改，请添加修改历史
 * </ol>
 *
 * </p>
 *
 * @author laoganbu
 * @version V1.0
 * @date 2019/6/27 13:50
 */
@Controller
@RequestMapping(value = "/manage")
public class DefaultViewManageController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String backgroundHomePage() {
        return "background/index";
    }

    @RequestMapping(value = "/calendar", method = RequestMethod.GET)
    public String calendar() {
        return "background/calendar";
    }



}
