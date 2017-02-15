package com.hackathon.agenda.analysis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.agenda.analysis.dao.AgendaDao;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.webkit.ContextMenu.ShowContext;

import apple.laf.JRSUIConstants.ShowArrows;

@Service("agendaService")
public class AgendaService {
   
	AgendaDao agendaDao = new AgendaDao();

	@Autowired
	public void setAgendaDao(AgendaDao agendaDao) {
		this.agendaDao = agendaDao;
	}
	
	public List<String> showContext(String keyword, String url){
		
		return agendaDao.getContext(keyword,url); 
	}
	
}
