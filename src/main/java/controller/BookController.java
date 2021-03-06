package controller;

import model.Book;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import util.MyBatisSession;

@Controller
@RequestMapping("book")
public class BookController extends BaseController {

    @RequestMapping("create")
    private String create(Book book) {
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            sqlSession.insert("book.create", book);
        }
        System.out.println(session.getAttribute("user"));
        return queryAll();
    }

    @RequestMapping("queryAll")
    private String queryAll() {
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(false)) {
            session.setAttribute("books", sqlSession.selectList("book.queryAll"));
        }
        return "redirect:/home.jsp";
    }

    @RequestMapping("queryById/{id}") // path variable
    private String queryById(@PathVariable int id) {
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(false)) {
            session.setAttribute("book", sqlSession.selectOne("book.queryById", id));
        }
        return "redirect:/edit.jsp";
    }

    @RequestMapping("update")
    private String update(Book book) {
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            sqlSession.update("book.update", book);
        }
        return queryAll();
    }

    @RequestMapping("remove/{id}")
    private String remove(@PathVariable int id) {
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(true)){
            sqlSession.delete("book.remove", id);
        }
        return queryAll();
    }
}
