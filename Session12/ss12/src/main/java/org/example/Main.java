package org.example;


import org.example.bai01.LoginHospital;
import org.example.bai02.UpdatePatient;
import org.example.bai03.SearchSurgery;
import org.example.bai04.Result;
import org.example.bai04.ResultTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        bai1
//        LoginHospital.hospitalLogin("toandeptrai", "123456");
//        LoginHospital.hospitalLogin("toan", "12345");

//        bai2
//        UpdatePatient.update("P002", 37.0, 85);

//        bai3
//        SearchSurgery.search("S001");

//        bai4
        List<Result> results = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("Nhập id kết quar: ");
            String id = sc.nextLine();
            System.out.println("Nhập kết quả: ");
            String res = sc.nextLine();

            results.add(new Result(id, res));
        }

        ResultTest.enterResult(results);
    }
}