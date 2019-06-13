package sforcesoap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

public class SObjectHandler {

	private EnterpriseConnection connection;

	public SObjectHandler() throws ConnectionException, FileNotFoundException, IOException {
		connection = new EnterpriseConnectionHandler().getConnection();
	}

	public void deleteById(String id) {
		String[] ids = { id };
		try {
			connection.delete(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String saveNewSObject(SObject sobject) {
		SObject[] sObjects = { sobject };
		try {
			SaveResult sr = connection.create(sObjects)[0];
			if (sr.getSuccess())
				return sr.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public SObject queryOne(String soqlQueryString) throws ConnectionException {
		SObject sobject = null;
		QueryResult qr = connection.query(soqlQueryString);
		boolean done = false;
		while (qr.getSize() > 0 && !done) {
			SObject[] records = qr.getRecords();
			for (SObject so : records)
				sobject = so;
			done = qr.isDone();
		}
		return sobject;
	}

	public List<SObject> queryMany(String soqlQueryString) throws ConnectionException {
		List<SObject> listSObject = new ArrayList<SObject>();
		QueryResult qr = connection.query(soqlQueryString);
		boolean done = false;
		while (qr.getSize() > 0 && !done) {
			SObject[] records = qr.getRecords();
			for (SObject record : records)
				listSObject.add(record);
			done = qr.isDone();
		}
		return listSObject;
	}

	public String update(SObject sObject) {
		SObject[] sObjects = { sObject };
		try {
			SaveResult sr = connection.update(sObjects)[0];
			if (sr.getSuccess()) {
				return sr.getId();
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		return null;
	}

}
