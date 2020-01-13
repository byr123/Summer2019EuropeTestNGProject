package com.cybertek.tests.day17_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {


    @Test
    public void readExcelFile(){

        //create an object from ExcelUtil
        //it accepts 2 arguments
        //Argument 1: location of the file (path)
        //Argument 2: sheet that we want to open (sheetName)

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx", "QA3-short");

        //How many rows in the sheet
        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());

        //How many columns in the sheet
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());

        //get all column names
        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames());

        List<Map<String, String>> dataList = qa3short.getDataList();
        //System.out.println(dataList.get(0).get("firstname"));  // to get special firstname

        //print them one by one for each row
        for (Map<String,String> onerow : dataList) {
            System.out.println(onerow);
        }

        //get all data in 2D Array
        String[][] dataArray = qa3short.getDataArray();

        //print the Array
        System.out.println(Arrays.deepToString(dataArray));
    }
}
