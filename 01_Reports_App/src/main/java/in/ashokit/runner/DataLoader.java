package in.ashokit.runner;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repositry.CitizenPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private CitizenPlanRepo citizenPlanRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        citizenPlanRepo.deleteAll();

       //cash plan Data
        CitizenPlan citizenPlan1 = new CitizenPlan();
        citizenPlan1.setCitizenName("Raj");
        citizenPlan1.setPlanName("Cash");
        citizenPlan1.setGender("Male");
        citizenPlan1.setPlanStatus("Approved");
        citizenPlan1.setPlanStartDate(LocalDate.now());
        citizenPlan1.setPlanEndDate(LocalDate.now().plusMonths(6));
        citizenPlan1.setBenefitAmount(5000.00);

        CitizenPlan citizenPlan2 = new CitizenPlan();
        citizenPlan2.setCitizenName("Surya");
        citizenPlan2.setPlanName("Cash");
        citizenPlan2.setGender("Male");
        citizenPlan2.setPlanStatus("Denied");
        citizenPlan2.setDenialReason("Rental Income");

        CitizenPlan citizenPlan3 = new CitizenPlan();
        citizenPlan3.setCitizenName("Kavita");
        citizenPlan3.setPlanName("Cash");
        citizenPlan3.setGender("Female");
        citizenPlan3.setPlanStatus("Terminated");
        citizenPlan3.setPlanStartDate(LocalDate.now().minusMonths(4));
        citizenPlan3.setPlanEndDate(LocalDate.now().plusMonths(6));
        citizenPlan3.setBenefitAmount(5000.00);
        citizenPlan3.setTerminatedDate(LocalDate.now());
        citizenPlan3.setTerminationRsn("Employed");

        //Food
        CitizenPlan citizenPlan4 = new CitizenPlan();
        citizenPlan4.setCitizenName("John");
        citizenPlan4.setPlanName("Food");
        citizenPlan4.setGender("Male");
        citizenPlan4.setPlanStatus("Approved");
        citizenPlan4.setPlanStartDate(LocalDate.now());
        citizenPlan4.setPlanEndDate(LocalDate.now().plusMonths(6));
        citizenPlan4.setBenefitAmount(5000.00);

        CitizenPlan citizenPlan5 = new CitizenPlan();
        citizenPlan5.setCitizenName("Hero");
        citizenPlan5.setPlanName("Food");
        citizenPlan5.setGender("Male");
        citizenPlan5.setPlanStatus("Denied");
        citizenPlan5.setDenialReason("Due Income");

        CitizenPlan citizenPlan6 = new CitizenPlan();
        citizenPlan6.setCitizenName("July");
        citizenPlan6.setPlanName("Food");
        citizenPlan6.setGender("Female");
        citizenPlan6.setPlanStatus("Terminated");
        citizenPlan6.setPlanStartDate(LocalDate.now().minusMonths(4));
        citizenPlan6.setPlanEndDate(LocalDate.now().plusMonths(6));
        citizenPlan6.setBenefitAmount(5000.00);
        citizenPlan6.setTerminatedDate(LocalDate.now());
        citizenPlan6.setTerminationRsn("Self-Employed");

        //Medical Plane Data
        CitizenPlan citizenPlan7 = new CitizenPlan();
        citizenPlan7.setCitizenName("Samir");
        citizenPlan7.setPlanName("Medical");
        citizenPlan7.setGender("Male");
        citizenPlan7.setPlanStatus("Approved");
        citizenPlan7.setPlanStartDate(LocalDate.now());
        citizenPlan7.setPlanEndDate(LocalDate.now().plusMonths(6));
        citizenPlan7.setBenefitAmount(5000.00);

        CitizenPlan citizenPlan8 = new CitizenPlan();
        citizenPlan8.setCitizenName("Sucash");
        citizenPlan8.setPlanName("Medical");
        citizenPlan8.setGender("Male");
        citizenPlan8.setPlanStatus("Denied");
        citizenPlan8.setDenialReason("Property-Income");

        CitizenPlan citizenPlan9 = new CitizenPlan();
        citizenPlan9.setCitizenName("Rubica");
        citizenPlan9.setPlanName("Medical");
        citizenPlan9.setGender("Female");
        citizenPlan9.setPlanStatus("Terminated");
        citizenPlan9.setPlanStartDate(LocalDate.now().minusMonths(4));
        citizenPlan9.setPlanEndDate(LocalDate.now().plusMonths(6));
        citizenPlan9.setBenefitAmount(5000.00);
        citizenPlan9.setTerminatedDate(LocalDate.now());
        citizenPlan9.setTerminationRsn("Govt-Job");

        //Employment plan data
        CitizenPlan citizenPlan10 = new CitizenPlan();
        citizenPlan10.setCitizenName("Vijay");
        citizenPlan10.setPlanName("Employment");
        citizenPlan10.setGender("Male");
        citizenPlan10.setPlanStatus("Approved");
        citizenPlan10.setPlanStartDate(LocalDate.now());
        citizenPlan10.setPlanEndDate(LocalDate.now().plusMonths(6));
        citizenPlan10.setBenefitAmount(5000.00);

        CitizenPlan citizenPlan11 = new CitizenPlan();
        citizenPlan11.setCitizenName("Naseem");
        citizenPlan11.setPlanName("Employment");
        citizenPlan11.setGender("Male");
        citizenPlan11.setPlanStatus("Denied");
        citizenPlan11.setDenialReason("Property-Income");

        CitizenPlan citizenPlan12 = new CitizenPlan();
        citizenPlan12.setCitizenName("Sunita");
        citizenPlan12.setPlanName("Employment");
        citizenPlan12.setGender("Female");
        citizenPlan12.setPlanStatus("Terminated");
        citizenPlan12.setPlanStartDate(LocalDate.now().minusMonths(4));
        citizenPlan12.setPlanEndDate(LocalDate.now().plusMonths(6));
        citizenPlan12.setBenefitAmount(5000.00);
        citizenPlan12.setTerminatedDate(LocalDate.now());
        citizenPlan12.setTerminationRsn("Got lottery");


        List<CitizenPlan> list = Arrays.asList(citizenPlan1,citizenPlan2,citizenPlan3,citizenPlan4,citizenPlan5,citizenPlan6,citizenPlan7,citizenPlan8,citizenPlan9,citizenPlan10,citizenPlan11,citizenPlan12);
        citizenPlanRepo.saveAll(list);
    }
}
