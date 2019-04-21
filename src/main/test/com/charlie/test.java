package com.charlie;


import org.junit.Test;

public class test {
    @Test
    public void test(){
        String bid = "0";
        if(bid==null||"".equals(bid)||Integer.valueOf(bid)==0){
            System.out.println("a");
        }else {
            System.out.println("b");
        }

    }

}
