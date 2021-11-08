package top.ycshang.java.basic.proxy;

/**
 * @program: java-basic
 * @description: 执行动态代理
 * @author: ycshang
 * @create: 2021-11-08 22:33
 **/
public class Client {
    public static void main(String[] args) {
        //真实角色
        UserService userService = new UserServiceImpl();
        ProxyInvocationHandler pth = new ProxyInvocationHandler();
        // 代理角色
        pth.setTarget(userService);
        UserService proxy = (UserService) pth.getProxy();
        proxy.update();
    }
}