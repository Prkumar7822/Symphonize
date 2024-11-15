package com.project.serviceimplements;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.models.Backup;
import com.project.repository.Backup_Repository;
import com.project.service.Backup_service;

@Service
public class Backup_serviceimpl implements Backup_service {
	
	
	@Autowired
	private Backup_Repository backupRepository;
	
	@Override
    public List<Backup> getAllCustomerBackupData() {
        // Retrieve all backup data from the database
        return backupRepository.findAll();
    }

}
