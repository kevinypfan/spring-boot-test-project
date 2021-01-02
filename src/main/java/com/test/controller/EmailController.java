package com.test.controller;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import io.rocketbase.mail.EmailTemplateBuilder;
import io.rocketbase.mail.config.TbConfiguration;
import io.rocketbase.mail.model.HtmlTextEmail;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EmailController {


    @GetMapping("/template")
    public String template() throws IOException {
        TbConfiguration config = TbConfiguration.newInstance();
        config.getContent().setFull(true);

        HtmlTextEmail htmlTextEmail = EmailTemplateBuilder.builder()
                .header()
                .logo("{{logoImage}}").logoHeight(30)
                .and()
                .text("{{subject}}").h1().center().and()
                .text("親愛的 {{legalName}} 您好：").h2().and()
                .text("您註冊的會員帳號為：{{username}}").and()
                .text("請以此作為登入帳號，日後將以此信箱與您聯絡。").and()
                .text("提醒您：請點選以下的完成認證鍵，以完成Email驗證程序。").and()
                .button("點選以完成認證", "{{verifyLink}}").blue().and()
                .html("若是上述驗證功能連結失效：請直接前往下列網址，完成註冊 <a href=\"{{verifyLink}}\">{{verifyLink}}</a>",
                        "若是上述驗證功能連結失效：請直接前往下列網址，完成註冊 {{verifyLink}}").and()
                .copyright("傑嶶科技").url("https://www.jway.com.tw/").suffix(". All rights reserved.").and()
                .footerText("[公司名稱, {{companyName}}]\n" +
                        "{{companyAddress}}").and()
                .build();

        Map<String, String> parameterMap = new HashMap<>();

        parameterMap.put("logoImage", "https://www.jway.com.tw/_nuxt/img/JWY.122abfd.png");
        parameterMap.put("subject", "帳號啟用認證信");
        parameterMap.put("legalName", "范振哲");
        parameterMap.put("username", "kevinypfan");
        parameterMap.put("verifyLink", "https://www.google.com/search?q=test&oq=test&aqs=chrome..69i57j0i433j69i60l3j69i65l3.2247j1j4&sourceid=chrome&ie=UTF-8");
        parameterMap.put("companyName", "居安心科技檢驗股份有限公司");
        parameterMap.put("companyAddress", "台中市大里區國光路二段 751 號");

        Handlebars handlebars = new Handlebars();

        Template template = null;
        template = handlebars.compileInline(htmlTextEmail.getHtml());
        String templateString = template.apply(parameterMap);

        return templateString;

    }
}
