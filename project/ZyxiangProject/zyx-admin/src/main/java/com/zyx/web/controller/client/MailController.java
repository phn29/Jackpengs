package com.zyx.web.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
public class MailController {
    @Autowired
    JavaMailSenderImpl javaMailSender;
    @RequestMapping("/mail")
    public String sendMail()throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
        helper.setFrom("1433521287@qq.com");
        helper.setTo("1433521287@qq.com");
//        helper.setSubject(null);
        helper.setText("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "    <base target=\"_blank\"/>\n" +
                "    <style id=\"scrollbar\" type=\"text/css\">\n" +
                "        ::-webkit-scrollbar {\n" +
                "        width: 0 !important\n" +
                "        }\n" +
                "\n" +
                "        pre {\n" +
                "            white-space: pre-wrap !important;\n" +
                "            word-wrap: break-word !important;\n" +
                "            *white-space: normal !important\n" +
                "        }\n" +
                "    \n" +
                "        #letter img {\n" +
                "            max-width: 300px\n" +
                "        }\n" +
                "    </style>\n" +
                "    <style id=\"from-wrapstyle\" type=\"text/css\">\n" +
                "        #form-wrap {\n" +
                "            overflow: hidden;\n" +
                "            height: 447px;\n" +
                "            position: relative;\n" +
                "            top: 0px;\n" +
                "            transition: all 1s ease-in-out .3s;\n" +
                "            z-index: 0\n" +
                "        }\n" +
                "    </style>\n" +
                "    <style id=\"from-wraphoverstyle\" type=\"text/css\">\n" +
                "        #form-wrap:hover {\n" +
                "            height: 1300px;\n" +
                "            top: -200px\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div style=\"width: 730px;margin: 20px auto 0;height: 1000px;\">\n" +
                "    <div id=\"form-wrap\">\n" +
                "        <img src=\"https://cdn.jsdelivr.net/gh/Akilarlxh/Valine-Admin@v1.0/source/img/before.png\"\n" +
                "                             alt=\"before\"\n" +
                "                             style=\"position: absolute;bottom: 126px;left: 0px;background-repeat: no-repeat;width: 730px;height: 317px;z-index:-100\">\n" +
                "        <div style=\"position: relative;overflow: visible;height: 1500px;width: 500px;margin: 0px auto;transition: all 1s ease-in-out .3s;padding-top:200px;\">\n" +
                "            <form>\n" +
                "                <div style=\"background: white;width: 95%;max-width: 800px;margin: auto auto;border-radius: 5px;border: 1px solid;overflow: hidden;-webkit-box-shadow: 0px 0px 20px 0px rgba(0, 0, 0, 0.12);box-shadow: 0px 0px 20px 0px rgba(0, 0, 0, 0.18);\">\n" +
                "                    <img style=\"width:100%;overflow: hidden;\"\n" +
                "                         src=\"https://ae01.alicdn.com/kf/U5bb04af32be544c4b41206d9a42fcacfd.jpg\"/>\n" +
                "                    <div style=\"padding: 5px 20px;\"><br>\n" +
                "                        <div>\n" +
                "                            <h3 style=\"text-decoration: none; color: rgb(17,17,17); text-align: center;font-family: 华文新魏\">\n" +
                "                            来自<span style=\"color: #fa7a0a\">远方</span>的留言:</h3>\n" +
                "                        </div>\n" +
                "\n" +
                "                        <br>\n" +
                "                        <!--内容区域height:200px-->\n" +
                "                        <div id=\"letter\"\n" +
                "                             style=\"overflow:auto;height:285px;width:100%;display:block;word-break: break-all;word-wrap: break-word;\">\n" +
                "                            <div style=\"text-align: center; border-bottom: #ddd 1px solid;border-left: #ddd 1px solid;padding-bottom: 20px;background-color: #eee;margin: 15px 0px;padding-left: 20px;padding-right: 20px;border-top: #ddd 1px solid;border-right: #ddd 1px solid;padding-top: 20px;font-family: \"\n" +
                "                                 Arial\n" +
                "                            \", \"Microsoft YaHei\" , \"黑体\" , \"宋体\" , sans-serif;\">\n" +
                "                            <!--要显示的内容-->\n" +
                "                            <span style=\"color: #fc9b0a;font-family: 华文新魏\"> n\"+\n" +
                "                                                        我浑浑噩噩走过二十年， 做过天上仙， 受过万人谴， 以为甘甜苦楚全都尝过遍。 只有你回首一眼， 才知这是人间。</span>\n" +
                "                        </div>\n" +
                "\n" +
                "                        <div style=\"text-align: center;margin-top: 40px;\"><img\n" +
                "                                src=\"https://ae01.alicdn.com/kf/U0968ee80fd5c4f05a02bdda9709b041eE.png\" alt=\"hr\"\n" +
                "                                style=\"width:100%; margin:5px auto 5px auto; display: block;\"/><a\n" +
                "                                style=\"text-transform: uppercase;text-decoration: none;font-size: 12px;border: 2px solid #6c7575;color: #2f3333;padding: 10px;display: inline-block;margin: 10px auto 0;background-color: rgb(246, 214, 175);\"\n" +
                "                                target=\"_blank\" href=\"#\"></a>\n" +
                "                        </div>\n" +
                "                        <p style=\"font-size: 12px;text-align: center;color: #999;\">总有远方可以奔赴，总有阳光可以追寻！<br><a\n" +
                "                                style=\"text-decoration:none; color:rgb(30,171,234)\" href=\"http://127.0.0.1:8080\">@\n" +
                "                            远方@小栈</a>\n" +
                "                        </p>\n" +
                "\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </form>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <img src=\"https://cdn.jsdelivr.net/gh/Akilarlxh/Valine-Admin@v1.0/source/img/after.png\" alt=\"after\"\n" +
                "         style=\"position: absolute;bottom: -2px;left: 0;background-repeat: no-repeat;width: 730px;height: 259px;z-index:100\">\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>",true);
        javaMailSender.send(mimeMessage);
        return "简单邮件发送成功！";
    }
}
