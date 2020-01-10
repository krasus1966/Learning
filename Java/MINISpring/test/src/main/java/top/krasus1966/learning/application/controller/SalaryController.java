package top.krasus1966.learning.application.controller;

import top.krasus1966.learning.application.service.SalaryService;
import top.krasus1966.learning.framework.beans.AutoWired;
import top.krasus1966.learning.framework.web.mvc.Controller;
import top.krasus1966.learning.framework.web.mvc.RequestMapping;
import top.krasus1966.learning.framework.web.mvc.RequestParam;

/**
 * @author Krasus1966
 * @date 2019/12/30 21:06
 **/
@Controller
public class SalaryController {

    @AutoWired
    private SalaryService salaryService;
    @RequestMapping("/get_salary.json")
    public Integer getSalary(@RequestParam("name") String name,@RequestParam("experience") String experience) {
        return salaryService.calSalary(Integer.parseInt(experience));
    }
}
