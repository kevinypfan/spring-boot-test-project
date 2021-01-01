package com.test.controller;

import io.rocketbase.mail.EmailTemplateBuilder;
import io.rocketbase.mail.config.TbConfiguration;
import io.rocketbase.mail.model.HtmlTextEmail;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {


    @GetMapping("/template")
    public String template() {
        TbConfiguration config = TbConfiguration.newInstance();
        config.getContent().setFull(true);

        HtmlTextEmail htmlTextEmail = EmailTemplateBuilder.builder()
                .header()
                .logo("{{logo_image}}").logoHeight(30)
                .and()
                .text("Welcome, {{name}}!").h1().center().and()
                .text("Thanks for trying [Product Name]. We’re thrilled to have you on board. To get the most out of [Product Name], do this primary next step:").and()
                .button("Do this Next", "http://localhost").blue().and()
                .text("For reference, here's your login information:").and()
                .attribute()
                .keyValue("Login Page", "{{login_url}}")
                .keyValue("Username", "{{username}}")
                .and()
                .html("If you have any questions, feel free to <a href=\"mailto:{{support_email}}\">email our customer success team</a>. (We're lightning quick at replying.) We also offer <a href=\"{{live_chat_url}}\">live chat</a> during business hours.",
                        "If you have any questions, feel free to email our customer success team\n" +
                                "(We're lightning quick at replying.) We also offer live chat during business hours.").and()
                .text("Cheers,\n" +
                        "The [Product Name] Team").and()
                .copyright("rocketbase").url("https://www.rocketbase.io").suffix(". All rights reserved.").and()
                .footerText("[Company Name, LLC]\n" +
                        "1234 Street Rd.\n" +
                        "Suite 1234").and()
                .footerImage("https://cdn.rocketbase.io/assets/loading/no-image.jpg").width(100).linkUrl("https://www.rocketbase.io").and()
                .build();

        return htmlTextEmail.getHtml();
    }
}
