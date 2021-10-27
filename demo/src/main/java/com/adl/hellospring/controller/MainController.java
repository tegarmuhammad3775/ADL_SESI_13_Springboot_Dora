package com.adl.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adl.hellospring.model.Profile;
import com.adl.hellospring.model.Resume;
import com.adl.hellospring.model.Skill;
import com.adl.hellospring.repository.ProfileRepository;
import com.adl.hellospring.repository.ResumeRepository;
import com.adl.hellospring.repository.SkillRepository;

@Controller
public class MainController {
	
	@Autowired
	private ProfileRepository profileRepo;
	@Autowired
	private SkillRepository skillRepo;
	@Autowired
	private ResumeRepository rp;
	
	@GetMapping("/")
	public String helloWorld(Model model){
		
		Profile profile = profileRepo.findById(1).get();
		model.addAttribute("profile", profile);
		
		List<Skill> listSkill = skillRepo.findAll();
		model.addAttribute("skill", listSkill);
		
//		List<Resume> itemResume = rp.findAll();
//		model.addAttribute("resume", itemResume);
		
		List<Resume> itemResume = rp.findByTipe("education");
		model.addAttribute("resume", itemResume);
		
		List<Resume> itemEmployment = rp.findByTipe("employment");
		model.addAttribute("resume2", itemEmployment);
		
		return "index";
	}
	
	@GetMapping("/dora")
	public String helloDora(){
		return "index0";
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello(){
		return "hello 2";
	}
	
	@GetMapping("/insert")
	public void setData(){
		Resume resume = new Resume();
		resume.setJudul("Full Stack Developer at PT.DII");
		resume.setTahun("2010 - 2012");
		resume.setKeterangan("Karyawan Kontrak");
		resume.setTipe("employment");
		rp.save(resume);
		
	}
}
