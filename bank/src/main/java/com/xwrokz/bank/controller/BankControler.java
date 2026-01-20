package com.xwrokz.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class BankControler {

    @GetMapping("/bankName")
    public String bankName(@RequestParam String bankName){
        System.out.println("Bank name=="+ bankName);
        return "bankName";
    }

    @GetMapping("/accountHolderName")
    public String accountHolderName(@RequestParam String userName){
        System.out.println( "Account Holder name=="+ userName);
        return "accountHolderName";
    }
    @GetMapping("/accountNumber")
    public String accountNumber(@RequestParam String number){
        System.out.println("Account Number=="+number);
        return "accountNumber";
    }

    @GetMapping("/addharNumber")
    public String addharNumber(@RequestParam String addharNumber){
        System.out.println("addhar Number=="+addharNumber);
        return "addharNumber";
    }

    @GetMapping("/branch")
    public String branch(@RequestParam String branch){
        System.out.println("Account Branch=="+branch);
        return "branch";
    }

    @GetMapping("/fatherName")
    public String fatherName(@RequestParam String fatherName){
        System.out.println("Father Name=="+fatherName);
        return "fatherName";
    }

    @GetMapping("/ifscCode")
    public String ifscCode(@RequestParam String code){
        System.out.println("Account Number=="+code);
        return "ifscCode";
    }

    @GetMapping("/location")
    public String location(@RequestParam String location){
        System.out.println("Location=="+location);
        return "location";
    }

    @GetMapping("/panCardNumber")
    public String panCardNumber(@RequestParam String pan){
        System.out.println("Pan Card Number=="+pan);
        return "panCardNumber";
    }

    @GetMapping("/phNumber")
    public String phNumber(@RequestParam String phNumber){
        System.out.println("Phone Number=="+phNumber);
        return "phNumber";
    }

}
