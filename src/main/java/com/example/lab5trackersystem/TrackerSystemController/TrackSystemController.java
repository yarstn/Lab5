package com.example.lab5trackersystem.TrackerSystemController;
import com.example.lab5trackersystem.ApiMessage.ApiMessage;
import com.example.lab5trackersystem.Model.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/track-system")
public class TrackSystemController {
 ArrayList<Project> project = new ArrayList<>();
 @GetMapping("/projects")
   public ArrayList<Project> getProject() {
       return project;
   }
@PostMapping("/add")
   public ApiMessage addProject(@RequestBody Project project) {
       this.project.add(project);
       return new ApiMessage("Project added");
   }
    @PutMapping("/update/{index}")
    public ApiMessage updateProject(@PathVariable int index, @RequestBody Project updatedProject) {
        if (index >= 0 && index < getProject().size()) {
            Project projectToUpdate = getProject().get(index);
            projectToUpdate.setId(updatedProject.getId());
            projectToUpdate.setTitle(updatedProject.getTitle());
            projectToUpdate.setDescription(updatedProject.getDescription());
            projectToUpdate.setStatus(updatedProject.getStatus());
            return new ApiMessage("Project updated");
        } else {
            return new ApiMessage("Project not found");
        }
    }
    @DeleteMapping("/delete/{index}")
    public ApiMessage deleteProject(@PathVariable int index) {
        if(index >= 0 && index < getProject().size()) {
            this.project.remove(index);
            return new ApiMessage("Project deleted");
        }
        return new ApiMessage("Project not found");
    }

    @PutMapping("/status/{id}")
    public ApiMessage getProjectStatus(@PathVariable int id) {
        for (Project p : project) {
            if (p.getId() == id) {
                if (p.getStatus().equals("done")) {
                    p.setStatus("not done");
                } else {
                    p.setStatus("done");
                }
                return new ApiMessage("Status Changed");
            }
        }
        return new ApiMessage("Project not found");
    }
    @GetMapping("/search/{title}")
    public ApiMessage searchProject(@PathVariable String title){
     for (Project p : project) {
         if (p.getTitle().equals(title)) {
         return new ApiMessage("Project found");
         }}
         return new ApiMessage("Project not found");
         }

    @GetMapping("/co-name/{name}")
    public List<Project> getProjectCoName(@PathVariable String name) {
        return project.stream().filter(p -> p.getCompanyName().equals(name)).collect(Collectors.toList());
    }


}
