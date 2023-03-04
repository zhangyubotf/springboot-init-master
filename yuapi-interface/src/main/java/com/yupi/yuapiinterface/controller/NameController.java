package com.yupi.yuapiinterface.controller;

import com.yupi.yuapiclientsdk.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import static com.yupi.yuapiclientsdk.utils.signUtil.gensign;
/**
 * Name :API
 */

@RestController( )
@RequestMapping("/name")
public class NameController {



    @GetMapping("/")
    public  String getNameByGet(String name ){

        return "GET  你的名字，瓦达西瓦："+name;
    }


    @PostMapping("/")
    public  String getNameByGPost(@RequestParam String name){

        return "POST 你的名字，瓦达西瓦："+name;
    }

    @PostMapping("/user")
    public  String getUserByGPost(@RequestBody User user, HttpServletRequest request){
        String accessKey = request.getHeader("accessKey");
        String body = request.getHeader("body");
        //可以用map存随机数  这里先不做校验
        String nonce = request.getHeader("nonce");
        String sign = request.getHeader("sign");
        //时间戳不超过多长时间  这里也不加验证
        String timestamp = request.getHeader("timestamp");
        if (!"yupi".equals(accessKey)){
            throw  new RuntimeException("无权限");
        }
        //这里的第一个参数  因为本来就是服务器签发的  可以由服务器去查询出来
        //即通过客户端口传递一部分参数和最终签证，服务端获得另一部分参数用以获得签证
        //然后在进行对比
        String abcdefg = gensign("abcdefg", body);
        if (!abcdefg.equals(sign)){
            throw  new RuntimeException("无权限");

        }
        return "POST user的名字，瓦达西瓦："+user.getUserName();
    }
}
