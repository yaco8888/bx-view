package com.bx.portrait.system;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bx.portrait.admin.entity.Admin;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * session帮助类
 */
@Slf4j
@Component
public class SessionUtils {
    private static final String ADMIN_NAME = "adminName";

	/**
	 * 获取登录的用户名称
	 */
	public static String getAdminName() {
		return getSession().getAttribute(ADMIN_NAME) == null ? "" :
                getSession().getAttribute(ADMIN_NAME).toString();
	}

	/**
	 * 登录验证成功保存session
	 */
	public static void setAdminUser(String adminUser) {
		getSession().setAttribute(ADMIN_NAME, adminUser);
	}

	/**
	 * 获取用户信息
	 **/
	public static Admin getAdmin() {
		return new Admin().selectOne(new LambdaQueryWrapper<>(Admin.class)
                .eq(Admin::getAdminUser, ADMIN_NAME));
	}

	/**
	 * 删除session
	 */
	public static void removeSession() {
		getSession().removeAttribute(ADMIN_NAME);
	}

    /**
     * 获取session对象
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

	/**
	 * 获取request对象
	 */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return (HttpServletRequest) attrs.getRequest();
    }

}
