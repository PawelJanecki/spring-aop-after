package com.spring.aopdemo;

import com.spring.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> accounts = null;

        try {
            // add a boolean flag to simualte exceptions
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception exc) {
            System.out.println("\n\nMain Program... caught exception: " + exc);
        }

        // display the accounts
        System.out.println("\nMain Program: AfterThrowingDemoApp");
        System.out.println("----");

        System.out.println(accounts);

        System.out.println("\n");

        // close the context
        context.close();
    }
}
