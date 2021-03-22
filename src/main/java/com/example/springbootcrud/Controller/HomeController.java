package com.example.springbootcrud.Controller;

import com.example.springbootcrud.Model.Children;
import com.example.springbootcrud.Model.User;
import com.example.springbootcrud.Model.WaitingList;
import com.example.springbootcrud.Service.IChildrenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    int updateId;
    @Autowired
    IChildrenService iChildrenService;



    @GetMapping( "/home")
    public String Home(Model model) {
        List<Children> childrenList = iChildrenService.fetchAll();
        model.addAttribute("childrenList", childrenList);
        return "home/index";

    }
    @GetMapping( "/waitingList")
    public String WaitingListInfo(Model model) {
        List<WaitingList> waitingLists = iChildrenService.fetchWaitingList();
        model.addAttribute("waitingLists", waitingLists);
        return "home/waitingList";

    }

    @GetMapping( "/phoneList")
    public String Phone(Model model) {
        List<Children> phoneList = iChildrenService.fetchInfo();
        model.addAttribute("phoneList", phoneList);
        return "home/phone";

    }


    @PostMapping("/create")
    public String create(@ModelAttribute Children children) {
        iChildrenService.addChildren(children);
        return "redirect:/home";
    }
    @PostMapping("/createList")
    public String createList(@ModelAttribute WaitingList waitingList) {
        iChildrenService.addWaitingList(waitingList);
        return "redirect:/waitingList";
    }
    @PostMapping("/updateHome")
    public String saveEmployee(@ModelAttribute("children") Children children) {

        iChildrenService.updateChildren(children);
        return "redirect:/updateHome";
    }
    @PostMapping("/delete")
    public String deleteMe(@ModelAttribute("children") Children children) {

        this.iChildrenService.deleteChildren(children.getId());
        return "redirect:/updateHome";
    }

    @GetMapping("/delete/{id}")
    public String deleteMe(@PathVariable(value = "id") int id){
        iChildrenService.deleteChildren(id);
        return("redirect:/updateHome");
    }

    @GetMapping("/updateHome/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") int id, Model md) {
        System.out.println(id);
        // get employee from the service
        Children children = iChildrenService.fetchSingleChild(id);

        // set employee as a model attribute to pre-populate the form
        md.addAttribute("children", children);
        return "home/update";
    }






/*

    @PostMapping("/delete")
    public String Delete(@ModelAttribute Children children) {
        iChildrenService.deleteChildren(children.getId());
        return "redirect:/home";
    }

 */
    @GetMapping("/addWaitingList")
    public String AddWaitingList(){
        return("home/addWaitingList");
    }


    @GetMapping("/")
    public String Login(){
        return "home/login";
    }




    @GetMapping("/addChild")
     public String AddChild(){
        return("home/addChild");
    }
    @GetMapping("/updateHome")
    public String Update(Model model){
        List<Children> childrenList = iChildrenService.fetchAll();
        model.addAttribute("childrenList", childrenList);
        return("home/updateHome");
    }
    @GetMapping("/schedule")
    public String MakeSchedule(){
        return("home/schedule");
    }
    @GetMapping("/dashboard")
    public String back(){
        return("home/welcome");
    }
    @GetMapping("/appointment")
    public String appointment(){
        return("home/appointment");
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute User user) {

        if ((user.getUserName().equals("Sandra")) && (user.getPassword().equals("sandra123"))) {
            ModelAndView modelAndView = new ModelAndView("home/welcome");

            return modelAndView;

        } else {
            ModelAndView modelAndView1 = new ModelAndView("home/login");

            return modelAndView1;
        }
    }



}