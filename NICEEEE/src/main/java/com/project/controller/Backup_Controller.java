package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.models.Backup;
import com.project.service.Backup_service;

@RestController
@RequestMapping("/backup")
public class Backup_Controller {
	
	@Autowired
	private Backup_service backupService;
	
	
	 @GetMapping("/api/backup/customers")
	    public List<Backup> getAllCustomerBackupData() {
	        return backupService.getAllCustomerBackupData();
	    }
}
