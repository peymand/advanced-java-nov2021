package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Book;
import entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.StudentService;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @Autowired
    ObjectMapper mapper;


    @RequestMapping("/register-page.do")
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/student-register.do")
    public String doRegister(@RequestBody Student student , @RequestParam String bookTextVar , @RequestHeader String dummy) throws SQLException, JsonProcessingException {
        Book book = mapper.readValue(bookTextVar, Book.class);
        student.setBook(book);
        service.save(student);
        return "redirect:student-list-page.do";
    }
    @RequestMapping("/student-list-page.do")
    public String getAll(Model model) throws SQLException {
        List<Student> all = service.getAll();
        model.addAttribute("list",all);
        return "student-list";
    }

    @RequestMapping(value = "/dummy", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Student dummy(){
        return new Student();
    }

}
