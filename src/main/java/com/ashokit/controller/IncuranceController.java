package com.ashokit.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.dto.IncuranceDTO;
import com.ashokit.entity.IncuranceEntity;
import com.ashokit.export.IncuranceExcelExport;
import com.ashokit.export.IncurancePDFExport;
import com.ashokit.repository.IncuranceRepository;
import com.ashokit.request.model.IncuranceRequestModel;
import com.ashokit.response.model.IncuranceResponseModel;
import com.ashokit.service.IncuranceService;
import com.lowagie.text.DocumentException;

@RestController
@RequestMapping("/inc")
public class IncuranceController {

	@Autowired
	IncuranceService incuranceService;

	@GetMapping("/getall")
	public List<IncuranceRequestModel> getAllDetails() {
		List<IncuranceDTO> storedReturnVlaue = incuranceService.getAllDetails2();
		ModelMapper modelMapper = new ModelMapper();
		Type listType = new TypeToken<List<IncuranceRequestModel>>() {
		}.getType();
		List<IncuranceRequestModel> returnValue = modelMapper.map(storedReturnVlaue, listType);
		return returnValue;
	}

	@PostMapping("/save")
	public String saveIncuranceData(@RequestBody IncuranceRequestModel incuranceDetails) {
		IncuranceDTO incDTO = new IncuranceDTO();
		BeanUtils.copyProperties(incuranceDetails, incDTO);
		IncuranceDTO storedIncDTO = incuranceService.createIncurance(incDTO);

		return "Save";
	}

	// http://localhost:8080/inc/byplanname?planName=sdfsdf
	@GetMapping(path = "/byplanname")
	public List<IncuranceRequestModel> getDetailsByPlanName(@RequestParam(value = "planName") String planName) {
		List<IncuranceDTO> storedReturnVlaue = incuranceService.getDetailsByPlanName(planName);
		ModelMapper modelMapper = new ModelMapper();
		Type listType = new TypeToken<List<IncuranceRequestModel>>() {
		}.getType();
		List<IncuranceRequestModel> returnValue = modelMapper.map(storedReturnVlaue, listType);
		return returnValue;
	}

	// http://localhost:8080/inc/byplanstatus?planStatus=sdfsdf
	@GetMapping(path = "/byplanstatus")
	public List<IncuranceRequestModel> getDetailsByPlanStatus(@RequestParam(value = "planStatus") String planStatus) {
		List<IncuranceDTO> storedReturnVlaue = incuranceService.getDetailsByPlanStatus(planStatus);
		ModelMapper modelMapper = new ModelMapper();
		Type listType = new TypeToken<List<IncuranceRequestModel>>() {
		}.getType();
		List<IncuranceRequestModel> returnValue = modelMapper.map(storedReturnVlaue, listType);
		return returnValue;
	}

	// http://localhost:8080/inc/byplanname-planstatus?planName=sdfsdf&&planStatus
	// =kdkmgdfm

	@GetMapping(path = "/byplanname-planstatus")
	public List<IncuranceRequestModel> getDetailByPNamePStatus(@RequestParam(value = "planName") String planName,
			@RequestParam(value = "planStatus") String planStatus) {

		List<IncuranceDTO> storedReturnVlaue = incuranceService.getDetailByPlanNameAndPlanStatus(planName, planStatus);
		return null;
	}

	// ---------->Export in Excel Methods below there <----------
	// http://localhost:8080/inc/export   { All Data }
	@GetMapping("/all-excel-export")
	public String exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headervalue = "attachment; filename=Incurance_info.xlsx";

		response.setHeader(headerKey, headervalue);
		// List<IncuranceEntity> list = incRepository.findAll();
		List<IncuranceDTO> storedReturnVlaue = incuranceService.getAllDetails2();

		IncuranceExcelExport exp = new IncuranceExcelExport(storedReturnVlaue);
		exp.export(response);
		return "Export Successfully";
	}

	// http://localhost:8080/inc/exel-export?planName=SNAP
	@GetMapping("/exel-export")
	public String exportToExcelByPlanName(@RequestParam(value = "planName") String planName,
			HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headervalue = "attachment; filename=Incurance_info.xlsx";

		response.setHeader(headerKey, headervalue);
		// List<IncuranceEntity> list = incRepository.findAll();
		List<IncuranceDTO> storedReturnVlaue = incuranceService.getDetailsByPlanName(planName);

		IncuranceExcelExport exp = new IncuranceExcelExport(storedReturnVlaue);
		exp.export(response);
		return "Export Successfully";
	}

	// http://localhost:8080/inc/exel-export?planStatus=Approved
	@GetMapping("/exel-export/byplanStatus")
	public String exportToExcelByPlanStatus(@RequestParam(value = "planStatus") String planStatus,
			HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headervalue = "attachment; filename=Incurance_info.xlsx";

		response.setHeader(headerKey, headervalue);
		// List<IncuranceEntity> list = incRepository.findAll();
		List<IncuranceDTO> storedReturnVlaue = incuranceService.getDetailsByPlanStatus(planStatus);

		IncuranceExcelExport exp = new IncuranceExcelExport(storedReturnVlaue);
		exp.export(response);
		return "Export Successfully";
	}

	// ---------->Export in PDF Methods below there<----------
	 //http://localhost:8080/inc/export/pdf   { All Data }
	@GetMapping("/pdf-export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        List<IncuranceDTO> storedReturnVlaue = incuranceService.getAllDetails2();
        IncurancePDFExport exporter = new IncurancePDFExport(storedReturnVlaue);
        exporter.export(response);
         
    }

}
