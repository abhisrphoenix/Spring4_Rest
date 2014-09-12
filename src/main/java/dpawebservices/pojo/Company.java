package dpawebservices.pojo;

import java.io.Serializable;

/**
 * @author abhilash
 *
 */

public class Company implements Serializable {

	private static final long serialVersionUID = -6216077237793388824L;

	private String companyName;

	private String industry;

	public Company(String companyName, String industry) {

		this.companyName = companyName;
		this.industry = industry;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Company() {

	}
}
