package com.cg.demo.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cg.demo.dto.EmpDto;
import com.cg.demo.entities.Emp;
import com.cg.demo.service.EmpService;

import jakarta.validation.Valid;

@Controller
public class EmpController {

    @Autowired
    private EmpService service;
    @GetMapping("/viewall")
    public String viewAll(Model model) {
        model.addAttribute("emps", service.getAll());
        return "viewall";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable int id, Model model) {
        Emp emp = service.getById(id);

        EmpDto dto = new EmpDto();
        BeanUtils.copyProperties(emp, dto);

        model.addAttribute("empDto", dto);
        return "edit";
    }
    @PostMapping("/save")
    public String saveEmp(@Valid @ModelAttribute("empDto") EmpDto dto,
                          BindingResult result,
                          RedirectAttributes ra) {

        if (dto.getEmpDoj() != null && dto.getEmpDoj().isBefore(java.time.LocalDate.now())) {
            result.rejectValue("empDoj", "", "Date must be today or future");
        }

        if (result.hasErrors()) {
            return "edit";
        }

        Emp emp = new Emp();
        BeanUtils.copyProperties(dto, emp);

        service.save(emp);
        ra.addFlashAttribute("msg", "Employee Edited");

        return "redirect:/viewall";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        service.delete(id);

        model.addAttribute("msg", "Employee Deleted");
        model.addAttribute("emps", service.getAll());

        return "viewall";
    }
}