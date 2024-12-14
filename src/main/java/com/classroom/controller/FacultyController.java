package com.classroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classroom.entity.Faculty;
import com.classroom.service.FacultyService;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping
    public List<Faculty> getAllFaculty() {
        return facultyService.getallFaculty();
    }

    @GetMapping("/{id}")
    public Faculty getFacultyById(@PathVariable Long id) {
        return facultyService.getFacultyById(id);
    }

    @PostMapping("/insertfaculty")
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        facultyService.createFaculty(faculty);
        return faculty;
    }

    @PutMapping("/{id}")
    public Faculty updateFaculty(@PathVariable Long id, @RequestBody Faculty facultyDetails) {
        Faculty faculty = facultyService.getFacultyById(id);
        if (faculty != null) {
            faculty.setName(facultyDetails.getName());
            faculty.setEmail(facultyDetails.getEmail());
            faculty.setDepartmentId(facultyDetails.getDepartmentId());
            facultyService.updateFaculty(faculty);
        }
        return faculty;
    }

    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
    }
}



