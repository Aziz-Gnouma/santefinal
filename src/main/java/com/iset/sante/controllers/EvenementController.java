package com.iset.sante.controllers;


import com.iset.sante.entities.*;
import com.iset.sante.service.ConsulationService;
import com.iset.sante.service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class EvenementController {

    @Autowired
    private EvenementService EvenementService;


   private ConsulationService consulationService;
    // display list of events
    @GetMapping("/admin/home")
    public String viewHomePage(Model model) {
        return findPaginated(1, "id", "asc", model);
    }



    @GetMapping("/showNewEventForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
            Evenement evenement = new Evenement();
        model.addAttribute("evenement", evenement);
        return "new_event";
    }
    // cons controller *****************************************************************************



    @PostMapping("/saveEvent")
    public String saveEvent(@ModelAttribute("evenement") Evenement evenement
            , @RequestParam("time") String date ,
                            ModelMap modelMap ) throws ParseException {
        // save evenement to database
        //conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date Time = dateformat.parse(String.valueOf(date));
        evenement.setTimeme(Time);

        EvenementService.saveEvent(evenement);
        return "redirect:/admin/home";
    }
    @PostMapping("/saveReponse")
    public String saveReponse (@ModelAttribute("reponse") reponse reponse,
                          Model model) {

        EvenementService.saveRep(reponse);
        return "consultation";
    }
    @GetMapping("/showNewRep")
    public String showNewrep(Model model) {
        // create model attribute to bind form data
        reponse reponse = new reponse();
        model.addAttribute("reponse", reponse);
        return "reponse";
    }
    @PostMapping("/saveConsulation")
    public String saveConsulation(@ModelAttribute("appointment") Appointment appointment,
                                  @RequestParam("time") String date,
                                  ModelMap modelMap) throws ParseException {
        // Conversion de la date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date time = dateFormat.parse(date);
        appointment.setTime(time);

        EvenementService.saveConsulation(appointment);
        return "redirect:/";
    }

    @RequestMapping("/showconsnow")
    public String showok(ModelMap modelMap) {
        modelMap.addAttribute("appointment", new Appointment());
        return "new_cons";
    }
    @RequestMapping("/saveProduit")
    public String saveProduit( Appointment appointment,
                              BindingResult bindingResult,
                              ModelMap modelMap) throws ParseException {


        if (bindingResult.hasErrors()) {

            EvenementService.saveConsulation(appointment);

            return "redirect:/";
        }
         EvenementService.saveConsulation(appointment);

        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {

        // get event from the service
        Evenement evenement = EvenementService.getEvenementById(id);

        // set event as a model attribute to pre-populate the form
        model.addAttribute("evenement", evenement);
        return "update_event";
    }

    @GetMapping("/deleteEvenement/{id}")
    public String deleteEvenement(@PathVariable (value = "id") long id) {

        // call delete event method
        this.EvenementService.deleteEvenementById(id);
        return "redirect:/admin/home";
    }

    @GetMapping("/deleteCons/{id}")
    public String deleteCons(@PathVariable (value = "id") long id) {

        // call delete event method
        this.EvenementService.deleteConsById(id);
        return "redirect:/admin/cons";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Evenement> page = EvenementService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Evenement> listEvenement = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listEvenement", listEvenement);
        return "adminhome";

    }




    @RequestMapping("/evenement/home")
    public String listeProduits(ModelMap modelMap)
    {
        List<Evenement> Evenement = EvenementService.getAllEvenement();
        modelMap.addAttribute("Evenement", Evenement);
        return "userhome";
    }

    @RequestMapping("/admin/cons")
    public String listAppointment(ModelMap modelMap)
    {
        List<Appointment> Appointment = EvenementService.getAllConsulation();
        modelMap.addAttribute("Appointment", Appointment);
        return "admincons";
    }

    @RequestMapping("/")
    public String listeevents(ModelMap modelMap)
    {
        List<Evenement> Evenement = EvenementService.getAllEvenement();
        modelMap.addAttribute("Evenement", Evenement);
        return "index";
    }
    @RequestMapping("/listePsycons")
    public String listePsycons(ModelMap modelMap)
    {
        List<reponse> reponse = EvenementService.getAllreponse();
        modelMap.addAttribute("reponse", reponse);
        return "psyReponse";
    }




    @RequestMapping("/saveAct")
    public String saveAct(@Valid Action action,
                              BindingResult bindingResult,
                              ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            return "userhome";
        }
        Action saveAct = EvenementService.saveAct(action);

        return "userhome";
    }

    @PostMapping("/saveEventAct")
    public String saveEventAct(@ModelAttribute("action") Action action
          ,
                            ModelMap modelMap ) throws ParseException {

        EvenementService.saveAct(action);
        return "redirect:/admin/home";
    }
//**********


    }
