package com.kevinkda.test.spring.boot.springbootrestfulcrud01.exception;

/**
 * @author Kevin KDA on 2020/6/29 00:32
 * @version 1.0.0
 * @project maven-test-01
 * @package com.kevinkda.test.spring.boot.springbootrestfulcrud01.exception
 * @classname UserNotException
 * @apiNote <p></p>
 * @since 1.0.0
 */
public class UserNotException extends RuntimeException {
    public UserNotException() {
        super("用户不存在");
    }
}
