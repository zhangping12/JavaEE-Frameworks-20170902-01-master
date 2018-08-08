package demo;


import model.User;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisSession;

import java.util.List;

public class MyBatisTest {

    private static void createUserViaXml() { // 推荐
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(false)) {
            sqlSession.insert("user.create", new User(null, "Tom", "123"));
            sqlSession.commit(); // 手动提交：事务处理
//            sqlSession.rollback();
        }
    }

    private static int modifyUser() {
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            return sqlSession.update("user.modify", new User(1, "汤姆", "aaa"));
        }
    }

    private static int remove() {
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            User user = new User();
            user.setId(3);
            return sqlSession.delete("user.remove", user);
        }
    }

    // DQL: select
    private static List<User> queryAll() {
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(false)){
            return sqlSession.selectList("user.queryAll");
        }
    }
    
    private static User queryById() {
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(false)){
            return sqlSession.selectOne("user.queryById", 5);
//            List<User> users = sqlSession.selectList("user.queryById", 1);
//            if (users.size() == 1) {
//                return users.get(0);
//            } else {
//                return null;
//            }
        }
    }

    public static void main(String[] args) {

        // DML: insert update delete
//        createUserViaXml();
//        createUserViaInterface();
//        modifyUser();

//        int i = remove();
//        System.out.println(i); // ?

        // 1. parameterType = "model.User"
        // 2. int: affected rows

//        List<User> users = queryAll();
//        for (User user : users) {
//            System.out.println(user);
//        }

        User user = queryById();
        System.out.println(user);
    }
}