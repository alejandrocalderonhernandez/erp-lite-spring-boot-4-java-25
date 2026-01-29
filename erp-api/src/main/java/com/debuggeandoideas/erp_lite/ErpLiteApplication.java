package com.debuggeandoideas.erp_lite;

import com.debuggeandoideas.erp_lite.domain.entities.order.OrderId;
import com.debuggeandoideas.erp_lite.domain.shared.Email;
import com.debuggeandoideas.erp_lite.domain.shared.Money;
import com.debuggeandoideas.erp_lite.persistence.mail.adapter.GmailAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Currency;

@SpringBootApplication
public class ErpLiteApplication implements CommandLineRunner {

    @Autowired
    private GmailAdapter gmailAdapter;

    public static void main(String[] args) {
        SpringApplication.run(ErpLiteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Email email =  Email.of("debuggeandoideas@gmail.com");
        OrderId orderId = OrderId.generate();
        String orderNumber = "2SD-1234-909";
        Money money = Money.of(new BigDecimal("2999.98"), Currency.getInstance("USD"));
        String customerName = "Alejandro Calderon";
        int itemsCount = 10;

        this.gmailAdapter.sendMail(
                email, orderId, orderNumber, money, customerName, itemsCount
        );

    }
}
