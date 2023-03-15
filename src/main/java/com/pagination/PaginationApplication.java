package com.pagination;

import com.pagination.entities.User;
import com.pagination.repository.PagingAndSortingRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@ComponentScan
@SpringBootApplication
public class PaginationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(PaginationApplication.class, args);

        PagingAndSortingRepo pagingAndSortingRepo = applicationContext.getBean(PagingAndSortingRepo.class);

        List<User> userList = getUserList();
        //If there is no records in database then insert some records

        System.out.println("Sort by Name & Age----------------------------------------------------");
        pagingAndSortingRepo.findAll(Sort.by("name").and(Sort.by("age").ascending())).forEach(System.out::println);
        System.out.println("Sort by Age----------------------------------------------------");
        pagingAndSortingRepo.findAll(Sort.by(Order.desc("age"))).forEach(System.out::println);
        System.out.println("Sort by Name----------------------------------------------------");
        pagingAndSortingRepo.findAll(Sort.by(Direction.ASC, "name")).forEach(System.out::println);
        System.out.println("Pagination----------------------------------------------------");
        System.out.println("1st Page with 10 records.....");
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("age").and(Sort.by("name")));
        pagingAndSortingRepo.findAll(pageRequest).get().forEach(System.out::println);
        System.out.println("2nd Page with 10 records.....");
        PageRequest pageRequest2 = PageRequest.of(1, 10);
        pagingAndSortingRepo.findAll(pageRequest2).get().forEach(System.out::println);

    }

    private static List<User> getUserList() {
        List<User> userList = new ArrayList<User>();

        userList.add(new User("KKumar", 33, LocalDate.of(1988, Month.DECEMBER, 16)));
        userList.add(new User("KK", 30, LocalDate.of(1990, Month.MARCH, 10)));
        userList.add(new User("SK", 21, LocalDate.of(1999, Month.FEBRUARY, 28)));
        userList.add(new User("BK", 31, LocalDate.of(1991, Month.JUNE, 20)));
        userList.add(new User("MK", 35, LocalDate.of(1988, Month.OCTOBER, 27)));
        userList.add(new User("TK", 36, LocalDate.of(1990, Month.FEBRUARY, 18)));
        userList.add(new User("CK", 18, LocalDate.of(1992, Month.APRIL, 10)));
        userList.add(new User("DK", 45, LocalDate.of(1993, Month.AUGUST, 20)));
        userList.add(new User("FK", 29, LocalDate.of(1988, Month.JUNE, 20)));
        userList.add(new User("GK", 19, LocalDate.of(1981, Month.JUNE, 28)));
        userList.add(new User("LK", 25, LocalDate.of(1983, Month.OCTOBER, 23)));
        userList.add(new User("OK", 23, LocalDate.of(1988, Month.DECEMBER, 24)));
        userList.add(new User("EK", 56, LocalDate.of(1989, Month.SEPTEMBER, 18)));
        userList.add(new User("JK", 33, LocalDate.of(1985, Month.MAY, 19)));
        userList.add(new User("QK", 39, LocalDate.of(1980, Month.JUNE, 23)));
        userList.add(new User("AK", 44, LocalDate.of(1990, Month.AUGUST, 31)));
        userList.add(new User("BK", 45, LocalDate.of(1977, Month.JULY, 30)));
        userList.add(new User("XK", 49, LocalDate.of(1976, Month.OCTOBER, 25)));
        userList.add(new User("BK", 37, LocalDate.of(1988, Month.AUGUST, 31)));
        userList.add(new User("MK", 38, LocalDate.of(1986, Month.MARCH, 29)));
        userList.add(new User("FK", 16, LocalDate.of(1959, Month.SEPTEMBER, 28)));
        userList.add(new User("XK", 32, LocalDate.of(1959, Month.SEPTEMBER, 29)));
        userList.add(new User("ZK", 34, LocalDate.of(1959, Month.SEPTEMBER, 20)));

        return userList;
    }
}