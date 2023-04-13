package in.ashokit.service.serviceimpl;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repositry.CitizenPlanRepo;
import in.ashokit.request.SearchRequest;
import in.ashokit.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private  CitizenPlanRepo citizenPlanRepo;


    @Override
    public List<String> getPlanNames() {
        return citizenPlanRepo.getPlanNames();
    }

    @Override
    public List<String> getPlanStatuses() {
        return citizenPlanRepo.getPlanStatus();
    }

    @Override
    public List<CitizenPlan> search(SearchRequest searchRequest) {
        CitizenPlan entity = new CitizenPlan();
        if(null != searchRequest.getPlanName() && !"".equals(searchRequest.getPlanName())){
            entity.setPlanName(searchRequest.getPlanName());
        }
        if(null != searchRequest.getPlanStatus() && !"".equals(searchRequest.getPlanStatus())){
            entity.setPlanStatus(searchRequest.getPlanStatus());
        }
        if(null != searchRequest.getGender() && !"".equals(searchRequest.getGender())){
            entity.setGender(searchRequest.getGender());
        }
        if(null != searchRequest.getPlanStartDate() && !"".equals(searchRequest.getPlanStartDate())){
            String startDate = searchRequest.getPlanStartDate();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
            LocalDate localDate = LocalDate.parse(startDate,formatter);
            entity.setPlanStartDate(localDate);
        }
        return citizenPlanRepo.findAll(Example.of(entity));
    }

    @Override
    public boolean exportExcel() {
        return false;
    }

    @Override
    public boolean exportPdf() {
        return false;
    }
}
