package ru.itgirl.firstspringproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

//@RestController означает, что класс описывает конечную точку, которая должна быть доступна через веб
//@GetMapping("/hello") означает, что метод hello() будет использоваться для ответа на запросы,
// отправленные на адрес http://localhost:8080/hello
// в запросе должно быть значение name, иначе будет использовано дефолтное значение

enum DayOfWeek {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

@RestController
public class FirstController {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/dayOfWeek")
    public String dayOfWeek(@RequestParam(value = "name", defaultValue = "MONDAY") DayOfWeek name) {
        String dayOfWeekInRussian = "Понедельник";
        try {
            switch (name) {
                case MONDAY:
                    dayOfWeekInRussian = "Понедельник";
                    break;
                case TUESDAY:
                    dayOfWeekInRussian = "Вторник";
                    break;
                case WEDNESDAY:
                    dayOfWeekInRussian = "Среда";
                    break;
                case THURSDAY:
                    dayOfWeekInRussian = "Четрверг";
                    break;
                case FRIDAY:
                    dayOfWeekInRussian = "Пятница";
                    break;
                case SATURDAY:
                    dayOfWeekInRussian = "Суббота";
                    break;
                case SUNDAY:
                    dayOfWeekInRussian = "Воскресенье";
                    break;

            }
            return String.format("Сегодня %s!", dayOfWeekInRussian);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "неверное название дня недели");
        }
    }

}
