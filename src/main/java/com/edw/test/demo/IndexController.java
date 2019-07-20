package com.edw.test.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <pre>
 *  com.edw.test.demo.IndexController
 * </pre>
 *
 * @author Muhammad Edwin < emuhamma at redhat dot com >
 * 20 July 2019 16:42
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public HashMap get() {
        return new HashMap(){{
            put("Message", "Hello World");
        }};
    }

}
