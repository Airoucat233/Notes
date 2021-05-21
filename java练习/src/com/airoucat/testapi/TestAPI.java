package com.airoucat.testapi;

public class TestAPI {
    public static void main(String[]args){
        try {

            RestUtil restUtil = new RestUtil();

            String resultString = restUtil.load(
                    "http://www.anjismart.com:7770/QueryCodeService.asmx/QueryCode?code=425144174493800&aid=302",
                    "");

        } catch (Exception e) {

            // TODO: handle exception

            System.out.print(e.getMessage());

        }
    }
}



