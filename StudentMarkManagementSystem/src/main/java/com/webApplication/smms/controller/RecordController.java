package com.webApplication.smms.controller;

import com.webApplication.smms.model.Entries;
import com.webApplication.smms.model.Records;
import com.webApplication.smms.repository.EntryRepository;
import com.webApplication.smms.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tables")
public class RecordController {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private EntryRepository entryRepository;

    @GetMapping
    public String getAllTables(Model model) {
        List<Records> tables = recordRepository.findAll();
        model.addAttribute("tables", tables);
        return "index";  // Your HTML page
    }

    @PostMapping("/create")
    public String createTable(@RequestParam("name") String tableName, @RequestParam List<String> columns) {
        Records record = new Records();
        record.setName(tableName);
        recordRepository.save(record);

        // Add columns and rows to the table (if necessary)
        for (String column : columns) {
            Entries entry = new Entries();
            entry.setStudentName("Sample Name");
            entry.setTotal(0.0);
            entry.setRecord(entry.getRecord());
            entryRepository.save(entry);
        }

        return "redirect:/tables";
    }

    @PostMapping("/addRow")
    public String addRow(@RequestParam("tableId") Long tableId) {
        Records record = recordRepository.findById(tableId).orElseThrow();
        Entries entry = new Entries();
        entry.setStudentName("New Student");
        entry.setTotal(0.0);
        entry.setRecord(entry.getRecord());
        entryRepository.save(entry);
        return "redirect:/tables";
    }

    @PostMapping("/delete/{tableId}")
    public String deleteTable(@PathVariable Long tableId) {
        recordRepository.deleteById(tableId);
        return "redirect:/tables";
    }

    @PostMapping("/editRow/{rowId}")
    public String editRow(@PathVariable Long rowId, @RequestParam("studentName") String studentName, @RequestParam("total") Double total) {
        Entries entry = entryRepository.findById(rowId).orElseThrow();
        entry.setStudentName(studentName);
        entry.setTotal(total);
        entryRepository.save(entry);
        return "redirect:/tables";
    }

    @PostMapping("/deleteRow/{rowId}")
    public String deleteRow(@PathVariable Long rowId) {
        entryRepository.deleteById(rowId);
        return "redirect:/tables";
    }
}

