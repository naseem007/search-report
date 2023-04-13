package in.ashokit.service;

import in.ashokit.request.SearchRequest;
import in.ashokit.entity.CitizenPlan;

import java.util.List;

public interface ReportService {

 public List<String> getPlanNames();
 public List<String> getPlanStatuses();
 public List<CitizenPlan> search(SearchRequest searchRequest);
 public boolean exportExcel();
 public boolean exportPdf();
}
