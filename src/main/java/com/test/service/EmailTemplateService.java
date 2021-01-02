package com.test.service;


import io.rocketbase.mail.EmailTemplateBuilder;
import io.rocketbase.mail.model.HtmlTextEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailTemplateService {

//    maintenance_notify

    public HtmlTextEmail signupVerifyNotify() {
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

        return htmlTextEmail;
    }



    public HtmlTextEmail signupNotify() {
        HtmlTextEmail htmlTextEmail = EmailTemplateBuilder.builder()
                .header()
                .logo("{{logoImage}}").logoHeight(30)
                .and()
                .text("{{subject}}").h1().center().and()
                .text("親愛的 {{legalName}} 您好：").h2().and()
                .text("您註冊的會員帳號為：{{username}}").and()
                .text("請以此作為登入帳號，日後將以此信箱與您聯絡。").and()
                .copyright("傑嶶科技").url("https://www.jway.com.tw/").suffix(". All rights reserved.").and()
                .footerText("[公司名稱, {{companyName}}]\n" +
                        "{{companyAddress}}").and()
                .build();

        return htmlTextEmail;
    }


    public HtmlTextEmail loginNotify() {
        HtmlTextEmail htmlTextEmail = EmailTemplateBuilder.builder()
                .header()
                .logo("{{logoImage}}").logoHeight(30)
                .and()
                .text("{{subject}}").h1().center().and()
                .text("親愛的客戶你好：").h2().and()
                .text("你於 {{timestamp}} 成功登入，如非你本人操作，請儘速與我們連繫，我們將竭誠為你服務！").and()
                .text("提醒你！為保障你的權益，請不要將你的「使用者代號」與「密碼」交付任何人或其他網站，務必謹慎保管個人資料。").and()
                .text("\n\n\n注意︰本郵件是由系統自動發送，請勿直接回覆。").and()
                .build();

        return htmlTextEmail;
    }

    public HtmlTextEmail loginFailNotify() {
        HtmlTextEmail htmlTextEmail = EmailTemplateBuilder.builder()
                .header()
                .logo("{{logoImage}}").logoHeight(30)
                .and()
                .text("{{subject}}").h1().center().and()
                .text("親愛的客戶你好：").h2().and()
                .text("你於 {{timestamp}} 於本行行動銀行嘗試進行登入作業，且使用者名稱輸入錯誤已累積{{wrongPasswordCount}}次。").and()
                .text("提醒你！為保障你的權益，請不要將你的「使用者代號」與「密碼」交付任何人或其他網站，務必謹慎保管個人資料。").and()
                .text("\n\n\n注意︰使用者名稱連續錯誤 3次，系統將自動暫停使用權限。").and()
                .build();

        return htmlTextEmail;
    }

    public HtmlTextEmail forgotPasswordRequest() {
        HtmlTextEmail htmlTextEmail = EmailTemplateBuilder.builder()
                .header()
                .logo("{{logoImage}}").logoHeight(30)
                .and()
                .text("{{subject}}").h1().center().and()
                .text("親愛的 {{legalName}} 您好：").h2().and()
                .text("您的會員帳號為：{{username}}").and()
                .text("您最近要求重設帳戶的密碼。使用下面的按鈕進行更改。\n" +
                        "\n").and()

                .button("點選以完成認證", "{{updatePasswordLink}}").blue().and()
                .html("若是上述驗證功能連結失效：請直接前往下列網址，完成註冊 <a href=\"{{updatePasswordLink}}\">{{updatePasswordLink}}</a>",
                        "若是上述驗證功能連結失效：請直接前往下列網址，完成註冊 {{updatePasswordLink}}").and()
                .text("如果您沒有要求，請忽略此電子郵件。\n" +
                        "\n" +
                        "除非您訪問上面的鏈接並創建一個新密碼，否則您的密碼不會更改。").and()
                .copyright("傑嶶科技").url("https://www.jway.com.tw/").suffix(". All rights reserved.").and()
                .footerText("[公司名稱, {{companyName}}]\n" +
                        "{{companyAddress}}").and()
                .build();

        return htmlTextEmail;
    }

    public HtmlTextEmail updatePasswordNotify() {
        HtmlTextEmail htmlTextEmail = EmailTemplateBuilder.builder()
                .header()
                .logo("{{logoImage}}").logoHeight(30)
                .and()
                .text("{{subject}}").h1().center().and()
                .text("親愛的 {{legalName}} 您好：").h2().and()
                .text("您的密碼已成功更改。").and()
                .copyright("傑嶶科技").url("https://www.jway.com.tw/").suffix(". All rights reserved.").and()
                .footerText("[公司名稱, {{companyName}}]\n" +
                        "{{companyAddress}}").and()
                .build();

        return htmlTextEmail;
    }

    public HtmlTextEmail memberLockNotify() {
        HtmlTextEmail htmlTextEmail = EmailTemplateBuilder.builder()
                .header()
                .logo("{{logoImage}}").logoHeight(30)
                .and()
                .text("{{subject}}").h1().center().and()
                .text("親愛的 {{legalName}} 您好：").h2().and()
                .text("您的帳號已鎖定，請聯絡管理員協助解鎖。").and()
                .copyright("傑嶶科技").url("https://www.jway.com.tw/").suffix(". All rights reserved.").and()
                .footerText("[公司名稱, {{companyName}}]\n" +
                        "{{companyAddress}}").and()
                .build();

        return htmlTextEmail;
    }

    public HtmlTextEmail memberActiveNotify() {
        HtmlTextEmail htmlTextEmail = EmailTemplateBuilder.builder()
                .header()
                .logo("{{logoImage}}").logoHeight(30)
                .and()
                .text("{{subject}}").h1().center().and()
                .text("親愛的 {{legalName}} 您好：").h2().and()
                .text("您的會員帳號為：{{username}}").and()
                .text("帳號已重新啟用，您可以繼續使用此帳號。").and()
                .copyright("傑嶶科技").url("https://www.jway.com.tw/").suffix(". All rights reserved.").and()
                .footerText("[公司名稱, {{companyName}}]\n" +
                        "{{companyAddress}}").and()
                .build();

        return htmlTextEmail;
    }

    public HtmlTextEmail approvalNotify() {
        HtmlTextEmail htmlTextEmail = EmailTemplateBuilder.builder()
                .header()
                .logo("{{logoImage}}").logoHeight(30)
                .and()
                .text("{{subject}}").h1().center().and()
                .text("感謝您對本公司的愛待，此為問題結案通知。").h2().and()
                .text("案件編號：{{idTickets}}").and()
                .text("客戶名稱：{{legalName}}").and()
                .text("問題主旨：{{title}}").and()
                .text("詳細描述：{{closedContent}}").and()
                .text("帳號已重新啟用，您可以繼續使用此帳號。").and()
                .copyright("傑嶶科技").url("https://www.jway.com.tw/").suffix(". All rights reserved.").and()
                .footerText("[公司名稱, {{companyName}}]\n" +
                        "{{companyAddress}}").and()
                .build();

        return htmlTextEmail;
    }
}
