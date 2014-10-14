package dpawebservices.dpa_rest_services;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletResponse;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import dpawebservices.pojo.Company;

@RestController
public class CompanyController {

	private static final String template = "Hello, %s!";

	public static final List<Company> companiesList = Arrays.asList(
			new Company("Uber", "Transportation"), new Company("CVS",
					"Pharmacy"), new Company("Orange", "Telecom"), new Company(
					"BostonDynamics", "Robotics"), new Company("Tesla",
					"Transportation"), new Company("Areva", "Energy"));

	public static final List<String> companyNameList = Arrays.asList("Uber",
			"CVS", "BostonDynamics", "Tesla", "Areva");

	@RequestMapping(value = "/companies", method = RequestMethod.GET)
	private ResponseEntity<List<Company>> getAllCompanies() {

		return new ResponseEntity<List<Company>>(companiesList, HttpStatus.OK);

	}

	@RequestMapping(value = "/getCompany", method = RequestMethod.GET)
	private ResponseEntity<Company> getCompanyDetails(
			@RequestParam(value = "name", required = false, defaultValue = "Company not found") String name) {

		Company com = new Company(name, "");
		if (!name.equals("Company not found")) {

			com.setIndustry("Technology");
		}
		return new ResponseEntity<Company>(com, HttpStatus.OK);

	}

	@RequestMapping(value = "/companyNames", method = RequestMethod.GET)
	private List<String> getAllCompanyNames() {

		return companyNameList;

	}

	@RequestMapping(value = "/addCompany", method = RequestMethod.POST)
	private ResponseEntity<Company> createCompany(@RequestBody Company com) {

		System.out.println("--" + com.getCompanyName());
		System.out.println("--" + com.getIndustry());
		Company company = new Company(com.getCompanyName(), com.getIndustry()
				+ " INC");
		return new ResponseEntity<Company>(company, HttpStatus.CREATED);
		// {"companyName":"tesst"}
		// {"companyName":"tesst", "industry": "Techp"}
	}

	@RequestMapping(value = "/addCompanies", method = RequestMethod.POST)
	private ResponseEntity<Company> createCompanies(
			@RequestBody List<Company> com) {

		System.out.println("--->>" + com.size());

		for (Company company : com) {
			System.out.println("--" + company.getCompanyName());
			System.out.println("--" + company.getIndustry());
		}

		return new ResponseEntity("New Companies added", HttpStatus.CREATED);

		// [{"companyName":"tesst"},{"companyName":"tess22t"}]

	}

	@RequestMapping(value = "/home.html", method = RequestMethod.GET)
	private ModelAndView  getCompanyDetails(ServletResponse res) {

		System.out.println(res);
		ModelAndView mv = new ModelAndView("redirect:/WebContent/WEB-INF/static/home.html");
		return mv;

	}
}
