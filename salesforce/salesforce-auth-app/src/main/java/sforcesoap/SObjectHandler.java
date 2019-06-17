package sforcesoap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

@Component
public class SObjectHandler {

	@Autowired
	private EnterpriseConnection enterpriseConnection;

	public void deleteById(String id) {
		String[] ids = { id };
		try {
			enterpriseConnection.delete(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String saveNewSObject(SObject sobject) {
		SObject[] sObjects = { sobject };
		try {
			SaveResult sr = enterpriseConnection.create(sObjects)[0];
			if (sr.getSuccess())
				return sr.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public SObject queryOne(String soqlQueryString) throws ConnectionException {
		SObject sobject = null;
		QueryResult qr = enterpriseConnection.query(soqlQueryString);
		SObject[] records = qr.getRecords();
		for (SObject so : records)
			sobject = so;
		return sobject;
	}

	public List<SObject> queryMany(String soqlQueryString) throws ConnectionException {
		List<SObject> listSObject = new ArrayList<SObject>();
		QueryResult qr = enterpriseConnection.query(soqlQueryString);
		SObject[] records = qr.getRecords();
		for (SObject record : records)
			listSObject.add(record);
		return listSObject;
	}

	public String update(SObject sObject) {
		SObject[] sObjects = { sObject };
		try {
			SaveResult sr = enterpriseConnection.update(sObjects)[0];
			if (sr.getSuccess()) {
				return sr.getId();
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		return null;
	}

}
