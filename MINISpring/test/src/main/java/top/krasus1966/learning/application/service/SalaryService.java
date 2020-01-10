package top.krasus1966.learning.application.service;

import top.krasus1966.learning.framework.beans.Bean;

/**
 * @author Krasus1966
 * @date 2019/12/30 22:26
 **/
@Bean
public class SalaryService {

    public Integer calSalary(Integer experience){
        return experience * 5000;
    }
}
