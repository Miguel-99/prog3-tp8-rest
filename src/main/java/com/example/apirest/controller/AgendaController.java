package com.example.apirest.controller;

import com.example.apirest.model.Agenda;
import com.example.apirest.service.IAgendaService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/agendas")
@CrossOrigin(origins = "*")
public class AgendaController {

    @Autowired
    private IAgendaService agendaService;

    @GetMapping
    public String getAllAgendas(Model model) {
        model.addAttribute("agendas",agendaService.findAllAgenda());
        return "agenda";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> getAllAgendas(@PathVariable Integer id) throws NotFoundException {
        return ResponseEntity.ok(agendaService.findOneAgenda(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAgenda(@PathVariable Integer id) throws NotFoundException {
        agendaService.deleteAgenda(id);
        return new ResponseEntity<>("Sucessfully deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAgenda(@PathVariable Integer id, @RequestBody Agenda agendaRequest) throws NotFoundException {
        Agenda agendaResponse = agendaService.updateAgenda(id, agendaRequest);
        return new ResponseEntity<>(agendaResponse, HttpStatus.OK);
    }

    @GetMapping("/create")
    public String createAgenda(Model model) throws Exception {
//        return new ResponseEntity<>(agendaService.createAgenda(agendaRequest), HttpStatus.OK);
        return "formCreateAgenda";
    }
}
