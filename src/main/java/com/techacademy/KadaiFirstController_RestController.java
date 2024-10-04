package com.techacademy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController_RestController {

    @GetMapping("/dayofweek/{date}")
    public String dispDayOfWeek(@PathVariable("date")String dateStr) {
        // 日付文字列から年・月・日を抽出
        String yearStr = dateStr.substring(0, 4);
        String monthStr = dateStr.substring(4, 6);
        String dayStr = dateStr.substring(6, 8);

        // 年・月・日をint型に変換
        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr) - 1; // Calenderの月は0から始まるため-1する
        int day = Integer.parseInt(dayStr);

        // Calendarオブジェクトを生成し、年月日を設定
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        // 曜日を取得（１：日曜日、２：月曜日、・・・７：土曜日）
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // 曜日を文字列に変換するロジック
        String[] dayOfWeekNames = {"", "Sunday", "Monday", "Tuesday","Wednesday","Thursday","Friday","Saturday"};

        // 曜日を返す
        return dayOfWeekNames[dayOfWeek];
    }

    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1,@PathVariable int val2) {
        int res =0;
        res = val1 + val2;
        return "計算結果：" + res;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1,@PathVariable int val2) {
        int res =0;
        res = val1 - val2;
        return "計算結果：" + res;
    }

    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1,@PathVariable int val2) {
        int res =0;
        res = val1 * val2;
        return "計算結果：" + res;
    }

    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1,@PathVariable int val2) {
        int res =0;
        res = val1 / val2;
        return "計算結果：" + res;
    }

}
