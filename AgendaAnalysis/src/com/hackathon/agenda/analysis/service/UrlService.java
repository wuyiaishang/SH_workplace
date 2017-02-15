package com.hackathon.agenda.analysis.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.agenda.analysis.dao.UrlDao;

@Service("urlService")
public class UrlService {
  
	private UrlDao urlDao;
	private String rUrl="http://www.citywindsor.ca/cityhall/City-Council-Meetings/Meetings-This-Week/Pages/Current-Council-Agenda.aspx" ;
	
	@Autowired
	public void setUrlDao(UrlDao urlDao) {
		this.urlDao = urlDao;
	}

	public Map<String, String> getLastInfo(){
		Map<String, String> map = new HashMap<>();
		try {
			map = urlDao.grabUrl(rUrl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
	}
	
}
