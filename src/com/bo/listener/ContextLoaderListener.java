package com.bo.listener;

import com.bo.entity.Character;
import com.bo.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/10/4
 * @Version 1.0
 **/
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    /**
     * 初始化
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("容器启动");
        List<User> userList = new ArrayList<>(3);
        User[] users = {
                new User(1, "aaa@qq.com", "47bce5c74f589f4867dbd57e9ca9f808", "TeTu", "avatar1.jpg", "南京", LocalDate.of(2019, 10, 1)),
                new User(2, "bbb@qq.com", "08f8e0260c64418510cefb2b06eee5cd", "TeDa", "avatar2.jpg", "武汉", LocalDate.of(2019, 10, 2)),
                new User(3, "ccc@qq.com", "9df62e693988eb4e1e1444ece0578579", "TeXin", "avatar3.jpg", "天津", LocalDate.of(2019, 10, 3))
        };
        userList = Arrays.asList(users);

        //创建并生成人物数据列表
        List<Character> characterList = new ArrayList<>(10);
        Character[] characters = {
                new Character(1, "character1.jpg", "穆罕默德", "阿拉伯", "他象征着伊斯兰教，被穆斯林认为是所有的先知中的最后一位。社会改革家、外交官、商人、伊斯兰 哲学家、演说家、立法者、军事和政治领袖。"),
                new Character(2, "character2.jpg", "艾萨克·牛顿", "英国", "物理学家、数学家、天文学家、哲学家、炼金术士和基督教神学家。其万有引力定律和运动定律导致了牛顿力学的发展。"),
                new Character(3, "character3.jpg", "耶稣", "罗马帝国", "基督教的核心人物，唯一真神上帝所赐下的独生爱子，在世上传讲上帝的真理，基督耶稣。"),
                new Character(4, "character4.jpg", "释迦牟尼", "古印度", "古印度思想家，哲学家。佛教创始人，被尊称为佛陀。"),
                new Character(5, "character5.jpg", "孔子", "鲁国", "掌握中国的思想家，哲学家，儒家思想的创始人，哲学戒律强烈影响中国、韩国（韩国儒学）、日本（江户道学）、越南和印尼（印尼儒教）。"),
                new Character(6, "character6.jpg", "保罗", "罗马帝国", "基督教最杰出的一位使徒，他在巴勒斯坦和保罗书信中传讲基督教，这将是新约圣经不可分割的的一部分。"),
                new Character(7, "character7.jpg", "蔡伦", "东汉", "被视为纸张和造纸术的最佳改良者。"),
                new Character(8, "character8.jpg", "约翰内斯·古腾堡", "神圣罗马帝国", "德国发明家，改良了印刷机。"),
                new Character(9, "character9.jpg", "克里斯托弗·哥伦布", "意大利", "意大利航海家，和探险家。他的远航导致了新大陆的发现。"),
                new Character(10, "character10.jpg", "阿尔伯特·爱因斯坦", "德国", "德国物理学家，因相对论和公式E = mc2而著名。")
        };
        characterList = Arrays.asList(characters);

        //获取全局变量
        ServletContext servletContext = sce.getServletContext();
        //设置全局变量属性，将用户和人物列表数据计入，整个应用可以共享
        servletContext.setAttribute("userList", userList);
        servletContext.setAttribute("characterList", characterList);
    }

    /**
     * 销毁方法
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("容器销毁");
    }
}