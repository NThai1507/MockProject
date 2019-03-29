package fa.appcode.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import fa.appcode.entities.Candidate;
import fa.appcode.entities.History;
import fa.appcode.service.CandidateProfileService;
import fa.appcode.service.PhuocCandidateService;
import fa.appcode.service.HistoryService;

@Controller
public class PhuocController {

	@Autowired

	CandidateProfileService candidateProfileService;

	@Autowired
	HistoryService historyService;

	@Autowired
	private PhuocCandidateService candidateService;

	@Autowired
	ServletContext context;

	static String filePath;

	Set<History> histories;

	/**
	 * this is method is controller.
	 * 
	 * @return
	 */
	@PostMapping("/UploadFile")
	@ResponseBody
	public String uploadFile(MultipartHttpServletRequest request) {

		String pathSaveFile ="C:\\Users\\HAINT_53\\Desktop\\MockFinal\\HN_FR_JAVA_18_09_AdminBoard_G2/src/main/webapp/resources/cv/";

		Iterator<String> listNames = request.getFileNames();
		MultipartFile mpf = request.getFile(listNames.next());

		File fileSave = new File(pathSaveFile + mpf.getOriginalFilename());
		filePath = pathSaveFile + mpf.getOriginalFilename();
		try {
			mpf.transferTo(fileSave);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}

	/**
	 * this is method is controller.
	 * 
	 * @return
	 */
	@PostMapping(value = "/save")
	@ResponseBody
	public void save(@RequestBody Candidate candidate, HttpServletRequest request) {
		try {
			int genAccount = candidateProfileService.findDuplicateAccount(candidate.getCandidateProfile().getAccount());
			if (genAccount != 0) {
				candidate.getCandidateProfile().setAccount(candidate.getCandidateProfile().getAccount() + genAccount);
			}
			for (History history : candidate.getHistories()) {
				history.setDates(new Date());
				break;
			}
			candidate.getCandidateProfile().setCv(filePath);
			candidate.getCandidateProfile().setType("Candidate");
			candidate.setStatus("New");
			boolean check = candidateService.save(candidate);
			if (check == true) {
				@SuppressWarnings("unused")
				String message = "Create Successfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * this is method is controller.
	 * 
	 * @return
	 */
	@PostMapping(value = "/findCurrentBiggestId")
	@ResponseBody
	public int findCurrentBiggestId() throws Exception {
		int candidateProfileId = candidateProfileService.findCurrentBiggestId();
		return candidateProfileId;

	}

	@PostMapping(value = "/findDuplicateAccount")
	@ResponseBody
	public int findDuplicateAccount(@RequestBody String account) throws Exception {
		int genAccount = candidateProfileService.findDuplicateAccount(account);
		return genAccount;
	}

}
