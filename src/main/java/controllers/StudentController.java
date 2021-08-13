package controllers;

import dao.SelectStudent;
import models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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
    public ModelAndView show() throws SQLException, ClassNotFoundException {
        List<Student> list = SelectStudent.seclect();
        ModelAndView modelAndView = new ModelAndView("show","lists",list);

        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable int id, Model model){
        ModelAndView modelAndView = new ModelAndView("edit","listDp", classesService.listDP);
        model.addAttribute("student",studentService.list.get(id));
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(Model model) {
        ModelAndView modelAndView = new ModelAndView("create","listDp", classesService.listDP);
        model.addAttribute("student",new Student());
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id) throws SQLException, ClassNotFoundException {
        studentService.delete(id);
        return "redirect:/show";
    }

    @PostMapping("/edit")
    public String edit(Student student) throws SQLException, ClassNotFoundException {
        studentService.edit(student);
        return "redirect:/show";
    }

    @PostMapping("/create")
    public String create(Student student) throws SQLException, ClassNotFoundException {
        studentService.save(student);
        return "redirect:/show";
    }

    @PostMapping("/find")
    public ModelAndView findByName(@RequestParam String findName) {

        ArrayList<Student> students = new ArrayList<>();
        for (Student s:studentService.list
        ) {
            if (s.getName().contains(findName)){
                students.add(s);
            }
        }
        ModelAndView modelAndView = new ModelAndView("search","students",students);
        return modelAndView;
    }
}
