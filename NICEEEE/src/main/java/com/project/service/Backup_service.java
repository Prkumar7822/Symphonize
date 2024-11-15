package com.project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.models.Backup;

public interface Backup_service {

	List<Backup> getAllCustomerBackupData();	
	
}
