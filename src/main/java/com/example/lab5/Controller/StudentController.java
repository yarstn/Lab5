package com.example.lab5.Controller;
import com.example.lab5.ApiResponse.ApiResponse;
import com.example.lab5.Model.Student;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    ArrayList<Student> students = new ArrayList<Student>();
//Student st1 = new Student("yara",25,"bachelore",true);
//Student st2 = new Student("Najd",26,"master",false);
//Student st3 = new Student("Sara",29,"master",false);
//Student st4 = new Student("Nasser",35,"diploma",true);
@GetMapping("/students")
public ArrayList<Student> getStudents() {
    return students;
}
@PostMapping("/add")
public ApiResponse addStudent(@RequestBody Student student) {
    students.add(student);
    return new ApiResponse("Students added successfully " ) ;
}
@PutMapping("/update")
    public ApiResponse updateStudent(int index,Student student) {
 if (index >= 0 && index < students.size()) {
     students.set(index, student);
     return new ApiResponse("Students updated successfully " ) ;
 }
 return new ApiResponse("Students not updated  " ) ;
    }

    @DeleteMapping("/delete/{index}")
    public String deleteStudent(@PathVariable int index) {
        if (index >= 0 && index < students.size()) {
            students.remove(index);
        }
            return "Index out of bounds";
    }
    @GetMapping("/name/{index}")
    public String getName(@PathVariable int index) {
    if (index >= 0 && index < students.size()) {
        return students.get(index).getName();
    }else  {
    return "Invalid index";}
    }
    @GetMapping("/age/{index}")
    public int getAge(@PathVariable int index) {
if (index >= 0 && index < students.size()) {
return students.get(index).getAge();
}else {
    return 0;
}
    }
    @GetMapping("/college/degree/{index}")
    public String getDegree(@PathVariable int index) {
       if (index >= 0 && index < students.size()) {
           return students.get(index).getDegree();
       }else {
           return "Invalid index";
       }
    }

    @GetMapping("/study/status/{index}")
    public boolean getStatus(@PathVariable int index) {
    if (index >= 0 && index < students.size()) {
        return students.get(index).isStatus();
    }else {
        return false;
    }
    }




}
