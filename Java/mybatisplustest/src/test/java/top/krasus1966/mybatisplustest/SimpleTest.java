package top.krasus1966.mybatisplustest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.krasus1966.mybatisplustest.dao.UserMapper;
import top.krasus1966.mybatisplustest.pojo.User;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void select() {
        List<User> list = userMapper.selectList(null);
        Assert.assertEquals(5, list.size());
        list.forEach(System.out::println);
    }

    @Test
    public void insert() {
        User user = new User();
        user.setAge(21);
        user.setManagerId(1088248166370832335L);
        user.setCreateTime(LocalDateTime.now());
        user.setRealName("向下");
        user.setEmail("xx@baomidou.com");
        user.setRemark("我是一个备注");
        int rows = userMapper.insert(user);
        System.out.println("影响记录数:" + rows);
    }

    @Test
    public void selectById() {
        User user = userMapper.selectById(1094590409767661570L);
        System.out.println(user);
    }

    @Test
    public void selectByIds() {
        List<Long> idList = Arrays.asList(1094590409767661570L, 1094592041087729666L);
        List<User> userList = userMapper.selectBatchIds(idList);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectByMap() {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("name","王天风");
        columnMap.put("age",25);
        userMapper.selectByMap(columnMap);
        List<User> userList = userMapper.selectByMap(columnMap);
        userList.forEach(System.out::println);
    }

    /**
     * 1.名字中包含雨并且年龄小于40
     * name like '%雨%' and age <40
     */
    @Test
    public void selectByWrapper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //QueryWrapper<User> query = Wrappers.<User>query();
        queryWrapper.like("name","雨").lt("age",40);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * 4.创建日期为2019年2月14日并且直属上级为名字为王姓
     * date_format(create_time,'%Y-%m-%d') and manager_id in (select id from user where name like '王%')
     */
    @Test
    public void selectByWrapper4(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.apply("date_format(create_time,'%Y-%m-%d') ={0}","2019-02-14")
                .inSql("manager_id","select user_id from mp_user where name like '王%'");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectByWrapper5(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.likeRight("name","王").and(ws->ws.lt("age",40).or().isNotNull("email"));
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectByWrapperEntity(){
        User whereUser = new User();
        whereUser.setRealName("刘宏宇");
        whereUser.setAge(43);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>(whereUser);
        //queryWrapper.likeRight("name","王").and(ws->ws.lt("age",40).or().isNotNull("email"));
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectByWrapperAllEq(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        Map<String,Object> param = new HashMap<String,Object>();
        //queryWrapper.likeRight("name","王").and(ws->ws.lt("age",40).or().isNotNull("email"));
        param.put("name","王天风");
        param.put("age",null);
        //queryWrapper.allEq(param,false);
        queryWrapper.allEq((k,v)->!k.equals("name"),param);

        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectByWrapperMaps(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name","雨").lt("age",40);

        List<User> userList = userMapper.selectList(queryWrapper);
        List<Map<String,Object>> userList2 = userMapper.selectMaps(queryWrapper);

        // userList.forEach(System.out::println);
        userList2.forEach(System.out::println);
    }

    @Test
    public void selectByWrapperMaps2(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.select("avg(age) avg_age","min(age) min_age","max(age) amx_age").groupBy("manager_id").having("sum(age)<{0}",500);
        List<Map<String,Object>> userList = userMapper.selectMaps(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectByWrapperObjs(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name","雨").lt("age",40);
        List<Object> userList = userMapper.selectObjs(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void deleteById(){
        int rows = userMapper.deleteById(1182471144310124545L);
        System.out.println(rows);
    }

    @Test
    public void selects(){
        List<User> list= userMapper.selectList(null);
        list.forEach(System.out::println);
    }
}

