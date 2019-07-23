package com.zx.shoppingcart.session.controller;

import com.zx.shoppingcart.session.model.Session;
import com.zx.shoppingcart.session.model.SessionManager;
import com.zx.shoppingcart.session.view.LoginRequest;
import com.zx.shoppingcart.user.model.User;
import com.zx.shoppingcart.user.model.UserDao;
import com.zx.shoppingcart.user.view.UserView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
public class SessionController {

    private static final String SESSION_TOKEN = "session_token";
    private static final String USER_ID = "user_id";

    private UserDao userDao;
    private SessionManager sessionsManager;

    public SessionController(UserDao userDao, SessionManager sessionManager) {
        this.userDao = userDao;
        this.sessionsManager = sessionManager;
    }

    /**
     * Login
     */
    @PostMapping("/session")
    public ResponseEntity login(HttpServletResponse response, @RequestBody LoginRequest login) {
        User user = userDao.getByName(login.getUsername());

        //如果用户不存在或密码不匹配
        if (user == null || !user.getPassword().equals(login.getPassword())) {
            if(user == null){
                System.out.println("null");
            }else {
                System.out.println(user.getPassword()+"    "+login.getPassword());
            }
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        // 添加Session，服务端维护在内存中（HashMap）
        String token = UUID.randomUUID().toString(); // 随机数
        sessionsManager.getSessions().put(user.getId(), new Session(user.getId(), token));

        // 设置cookie，返回给客户端
        response.addCookie(new Cookie(USER_ID, Long.toString(user.getId())));
        response.addCookie(new Cookie(SESSION_TOKEN, token));

        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * current user
     */
    @GetMapping("/current")
    public ResponseEntity<UserView> current(@CookieValue(name = USER_ID, defaultValue = "0") long userId, @CookieValue(name = SESSION_TOKEN, defaultValue = "") String token) {
        //因为user_id是从１开始的，所以默认值设为０
        //根据cookie中的user_id查找session
        Session session = sessionsManager.getSessions().get(userId);

        //如果session不存在或者验证码不匹配，返回错误
        if (session == null || !session.getToken().equals(token)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        // 认证成功
        User user = userDao.getById(session.getUserId());
        return new ResponseEntity<>(new UserView(user.getId(), user.getName()), HttpStatus.OK);
    }

    /**
     * Logout
     */
    @DeleteMapping("/session")
    public ResponseEntity logout(@CookieValue(name = USER_ID, defaultValue = "0") long userId, @CookieValue(name = SESSION_TOKEN, defaultValue = "") String token) {
        Session session = sessionsManager.getSessions().get(userId);

        if (session == null || !session.getToken().equals(token)) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }

        // 删除服务器上的Session信息，下次需要重新登录
        sessionsManager.getSessions().remove(userId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}

