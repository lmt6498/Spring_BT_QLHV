package controllers;

import dao.SelectStudent;
import models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.ClassesService;
import services.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    StudentService studentService = new StudentService();
    ClassesService classesService =new ClassesService();

    @RequestMapping("/show")
    public String show(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        List<Student> list = SelectStudent.seclect();
        request.setAttribute("list", list);
        return "/views/students/ShowStudent.jsp";
    }

    @GetMapping("/edit")
    public String showEdit(HttpServletRequest request){
        int index = Integer.parseInt(request.getParameter("index"));
        request.setAttribute("student", studentService.list.get(index));
        request.setAttribute("listDp", classesService.listDP);
        return "/views/students/EditStudent.jsp";
    }
    @GetMapping("/create")
    public String showCreate(HttpServletRequest request) {
        request.setAttribute("listDp", classesService.listDP);

        return "/views/students/CreateStudent.jsp";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int index) throws SQLException, ClassNotFoundException {
        studentService.delete(index);
        return "redirect:/show";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Student student) throws SQLException, ClassNotFoundException {
        studentService.edit(student);
        return "redirect:/show";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Student student) throws SQLException, ClassNotFoundException {
        studentService.save(student);
        return "redirect:/show";
    }

    @PostMapping("/find")
    public String findByName(HttpServletRequest request) {
        String findName = request.getParameter("findName");
        ArrayList<Student> students = new ArrayList<>();
        for (Student s:studentService.list
        ) {
            if (s.getName().contains(findName)){
                students.add(s);
            }
        }
        request.setAttribute("list", students);
        return "/views/students/SearchStudent.jsp";
    }
}
