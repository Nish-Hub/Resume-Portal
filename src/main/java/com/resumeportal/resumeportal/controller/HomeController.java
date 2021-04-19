package com.resumeportal.resumeportal.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.resumeportal.resumeportal.models.Education;
import com.resumeportal.resumeportal.models.Job;
import com.resumeportal.resumeportal.models.UserProfile;
import com.resumeportal.resumeportal.repository.UserProfileRepository;

@Controller
public class HomeController {

	/*
	 * @Autowired UserDetailsService userDetailsService;
	 */

	@Autowired
	UserProfileRepository userProfileRepository;

	@PostConstruct
	public void post() {

		/*
		 * Invocation of init method failed; nested exception is
		 * org.hibernate.LazyInitializationException: failed to lazily initialize a
		 * collection of role: com.resumeportal.resumeportal.models.UserProfile.jobs,
		 * could not initialize proxy - no Session
		 */
		// this.home();
	}

	@GetMapping("/")
	public String home() {

		List<String> responsibilities1 = Arrays.asList(
				"Provides financial information to management by researching and analyzing accounting data; preparing reports.",
				"Prepares asset, liability, and capital account entries by compiling and analyzing account information.",
				"Documents financial transactions by entering account information.",
				"Recommends financial actions by analyzing accounting options.");
		
		List<String> responsibilities2 = Arrays.asList(
				"Summarizes current financial status by collecting information; preparing balance sheet, profit and loss statement, and other reports.",
				"Substantiates financial transactions by auditing documents.",
				"Maintains accounting controls by preparing and recommending policies and procedures.",
				"Reconciles financial discrepancies by collecting and analyzing account information.");

		// TODO: Need to use the password also

		// Spring security invokes UserDetailsService internally hence no need to call
		// it
		// explicitly
		// return userDetailsService.loadUserByUsername(username).getUsername();
		UserProfile userProfile1 = new UserProfile();
		userProfile1.setId(1);
		userProfile1.setUserName("Nishant");
		userProfile1.setDesignation("Team Lead");
		userProfile1.setDescription("An aspiring developer with an eye for architecting complex systems");
		userProfile1.setLastName("Singh");
		userProfile1.setEmail("nishantgsingh07@gmail.com");
		userProfile1.setFirstName("Nishant");
		userProfile1.setTheme(1);
		userProfile1.setPhone("9619906323");
		userProfile1.setSummary("An aspiring developer with an eye for architecting complex systems");
		userProfile1.getSkills().clear();
		userProfile1.getSkills().addAll(Arrays.asList("Java","C++","Python"));
		
		List<Job> jobs1 = new ArrayList<Job>();
		userProfile1.setJobs(jobs1);

		Job job11 = new Job();
		job11.setCompany("Fullerton India");
		job11.setDesignation("Team Lead");
		job11.setCurrentJob(true);
		job11.setId(11);
		job11.setStartDate(LocalDate.of(2018, 12, 1));
		job11.setResponsibilities(responsibilities1);
		
		jobs1.add(job11);

		Job job12 = new Job();
		job12.setCompany("Accenture");
		job12.setDesignation("Developer");
		job12.setEndDate(LocalDate.of(2018, 12, 1));
		job12.setId(12);
		job12.setStartDate(LocalDate.of(2014, 12, 1));
		job12.setResponsibilities(responsibilities2);

		jobs1.add(job12);
		
		
		Education edu11 = new Education(); 
		edu11.setCollege("SRMCEM");
		edu11.setId(11);
		edu11.setQualification("B.Tech");
		edu11.setStartDate(LocalDate.of(2010, 6, 1));
		edu11.setEndDate(LocalDate.of(2014, 7, 1));
		edu11.setSummary("B. Tech stands for Bachelor of Technology. "
				+ "It is an undergraduate level programme that is pursued by science stream students after"
				+ " the completion of Class 12 Science");
		
		Education edu12 = new Education(); 
		edu12.setCollege("MLM");
		edu12.setId(12);
		edu12.setQualification("Intermediate");
		edu12.setStartDate(LocalDate.of(2007, 6, 1));
		edu12.setEndDate(LocalDate.of(2009, 7, 1));
		edu12.setSummary("The AISSCE, also called Boards in common language, is an examination "
				+ "conducted every year by the Central Board of Secondary Education on behalf of "
				+ "the Government of India");
		
		userProfile1.getEducations().clear();
		userProfile1.getEducations().add(edu11);
		userProfile1.getEducations().add(edu12);

		UserProfile userProfile2 = new UserProfile();
		userProfile2.setId(2);
		userProfile2.setUserName("pops");
		userProfile2.setDesignation("Manager");
		userProfile2.setDescription("An aspiring developer with an eye for architecting complex systems");
		userProfile2.setLastName("Singh");
		userProfile2.setEmail("dilipsingh01@gmail.com");
		userProfile2.setFirstName("Dilip Kumar");
		userProfile2.setTheme(2);
		userProfile2.setPhone("9415172571");
		userProfile2.setSummary("An aspiring leader with an eye of perfection ");
		userProfile2.getSkills().addAll(Arrays.asList("Java","C++","Python"));
		
		List<Job> jobs2 = new ArrayList<Job>();
		userProfile2.setJobs(jobs2);

		Job job21 = new Job();
		job21.setCompany("Fullerton India");
		job21.setDesignation("Team Lead");
		job21.setCurrentJob(true);
		job21.setEndDate(LocalDate.of(2022, 12, 1));
		job21.setId(21);
		job21.setStartDate(LocalDate.of(2018, 12, 1));
		job21.setResponsibilities(responsibilities1);

		jobs2.add(job21);

		Job job22 = new Job();
		job22.setCompany("Accenture");
		job22.setDesignation("Developer");
		// job22.setEndDate(LocalDate.of(2018,12,1)) ;
		job22.setId(22);
		job22.setStartDate(LocalDate.of(2014, 12, 1));
		job22.setResponsibilities(responsibilities2);

		jobs2.add(job22);

		Education edu21 = new Education(); 
		edu21.setCollege("SRMCEM");
		edu21.setId(21);
		edu21.setQualification("B.Tech");
		edu21.setStartDate(LocalDate.of(2010, 6, 1));
		edu21.setEndDate(LocalDate.of(2014, 7, 1));
		edu21.setSummary("B. Tech stands for Bachelor of Technology. "
				+ "It is an undergraduate level programme that is pursued by science stream students after"
				+ " the completion of Class 12 Science");
		
		Education edu22 = new Education(); 
		edu22.setCollege("MLM");
		edu22.setId(22);
		edu22.setQualification("Intermediate");
		edu22.setStartDate(LocalDate.of(2007, 6, 1));
		edu22.setEndDate(LocalDate.of(2009, 7, 1));
		edu22.setSummary("The AISSCE, also called Boards in common language, is an examination "
				+ "conducted every year by the Central Board of Secondary Education on behalf of "
				+ "the Government of India");
		
		userProfile2.getEducations().clear();
		userProfile2.getEducations().add(edu21);
		userProfile2.getEducations().add(edu22);
		
		// userProfileRepository.save(userProfile2);

		UserProfile userProfile3 = new UserProfile();
		userProfile3.setId(3);
		userProfile3.setUserName("amma");
		userProfile3.setDescription("An aspiring chef with a touch of perfection");
		userProfile3.setLastName("Devi");
		userProfile3.setDesignation("Chef");
		userProfile3.setEmail("geetadevi10@gmail.com");
		userProfile3.setFirstName("Geeta");
		userProfile3.setTheme(3);
		userProfile3.setPhone("9415172571");
		userProfile3.setSummary("An aspiring chef with a touch of perfection");
		userProfile3.getSkills().addAll(Arrays.asList("Java","C++","Python"));
		
		List<Job> jobs3 = new ArrayList<Job>();
		userProfile3.setJobs(jobs3);

		Job job31 = new Job();
		job31.setCompany("Fullerton India");
		job31.setDesignation("Team Lead");
		job31.setCurrentJob(true);
		// job31.setEndDate(LocalDate.of(2022,12,1)) ;
		job31.setId(31);
		job31.setStartDate(LocalDate.of(2018, 12, 1));
		job31.setResponsibilities(responsibilities1);

		jobs3.add(job31);

		Job job32 = new Job();
		job32.setCompany("Accenture");
		job32.setDesignation("Developer");
		job32.setEndDate(LocalDate.of(2018, 12, 1));
		job32.setId(32);
		job32.setStartDate(LocalDate.of(2014, 12, 1));
		job32.setResponsibilities(responsibilities2);

		jobs3.add(job32);

		Education edu31 = new Education(); 
		edu31.setCollege("SRMCEM");
		edu31.setId(31);
		edu31.setQualification("B.Tech");
		edu31.setStartDate(LocalDate.of(2010, 6, 1));
		edu31.setEndDate(LocalDate.of(2014, 7, 1));
		edu31.setSummary("B.Tech stands for Bachelor of Technology. "
				+ "It is an undergraduate level programme that is pursued by science stream students after"
				+ " the completion of Class 12 Science");
		
		Education edu32 = new Education(); 
		edu32.setCollege("MLM");
		edu32.setId(32);
		edu32.setQualification("Intermediate");
		edu32.setStartDate(LocalDate.of(2007, 6, 1));
		edu32.setEndDate(LocalDate.of(2009, 7, 1));
		edu32.setSummary("The AISSCE, also called Boards in common language, is an examination "
				+ "conducted every year by the Central Board of Secondary Education on behalf of "
				+ "the Government of India");
		
		userProfile3.getEducations().clear();
		userProfile3.getEducations().add(edu31);
		userProfile3.getEducations().add(edu32);
		
		

		userProfileRepository.saveAll(Arrays.asList(userProfile1, userProfile2, userProfile3));

		List<UserProfile> profiles = userProfileRepository.findAll();

		profiles.forEach(profile -> System.out.println(profile.getUserName() + " " + profile.getJobs()));

		return "profile";
	}

	/*
	 * The principal is the currently logged in user. However, you retrieve it through the security context which is bound to 
	 * the current thread and as such it's also bound to the current request and its session.
	 */
	@GetMapping("/edit")
	public String edit(Principal principal, Model model) {
		
		/*
		 * SecurityContext sc=SecurityContextHolder.getContext(); Authentication auth
		 * =SecurityContextHolder.getContext().getAuthentication(); Collection<? extends
		 * GrantedAuthority> authorities
		 * =SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		 * Object credentials=
		 * SecurityContextHolder.getContext().getAuthentication().getCredentials();
		 * Object details=
		 * SecurityContextHolder.getContext().getAuthentication().getDetails(); String
		 * principalName =
		 * SecurityContextHolder.getContext().getAuthentication().getName(); Object
		 * principal1 =
		 * SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 * boolean isAuthenticated =
		 * SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
		 */
						
		model.addAttribute("userId",principal.getName());
		return "profile-edit";
	}

	/*
	 * userId is the path variable ex: /view/foo
	 */
	/* @GetMapping("/view/{userId}") */
	@Deprecated
	public String viewOld(@PathVariable("userId") String userId, Model model) {

		
		model.addAttribute("userId", userId);
		return "profile-templates/3/";
	}

	@GetMapping("/all")
	public String getAllUsers() {

		return userProfileRepository.findAll().toString();
	}

	@GetMapping("/view/{userId}")
	public String view(@PathVariable("userId") String userId, Model model) {

		Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userId);
		userProfileOptional.orElseThrow(() -> new RuntimeException("Not found : " + userId));

		UserProfile userProfile = userProfileOptional.get();

		model.addAttribute("userId", userId);
		model.addAttribute("userProfile", userProfile);
		System.out.println(userProfile.getJobs());

		return "profile-templates//" + userProfile.getTheme() + "/index";
	}
}
