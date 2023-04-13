package in.ashokit.controller;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.request.SearchRequest;
import in.ashokit.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ReportController {
    @Autowired
    private  ReportService reportService;



    @PostMapping("/search")
    public String handleSearch(@ModelAttribute("search") SearchRequest search, Model model){
        List<CitizenPlan> plans = reportService.search(search);
        model.addAttribute("plans", plans);
        init(model);
        return "index";
    }
    @GetMapping("/")
    public String indexPage(Model model){
        model.addAttribute("search", new SearchRequest());
        init(model);

        return "index";
    }

    private void init(Model model) {
        model.addAttribute("names", reportService.getPlanNames());
        model.addAttribute("status", reportService.getPlanStatuses());
    }
}
