//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.ocs_if.vo;

/**
 * Linked to core.clinical.PatientNotification business object (ID: 1003100125).
 */
public class OCSPatientNotificationsVo extends ims.core.clinical.vo.PatientNotificationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OCSPatientNotificationsVo()
	{
	}
	public OCSPatientNotificationsVo(Integer id, int version)
	{
		super(id, version);
	}
	public OCSPatientNotificationsVo(ims.ocs_if.vo.beans.OCSPatientNotificationsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.newresults = bean.getNewResults() == null ? null : new ims.core.clinical.vo.PatientOCSNewResultsRefVo(new Integer(bean.getNewResults().getId()), bean.getNewResults().getVersion());
		this.seenresults = bean.getSeenResults() == null ? null : new ims.core.clinical.vo.PatientOCSSeenResultsRefVo(new Integer(bean.getSeenResults().getId()), bean.getSeenResults().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocs_if.vo.beans.OCSPatientNotificationsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.newresults = bean.getNewResults() == null ? null : new ims.core.clinical.vo.PatientOCSNewResultsRefVo(new Integer(bean.getNewResults().getId()), bean.getNewResults().getVersion());
		this.seenresults = bean.getSeenResults() == null ? null : new ims.core.clinical.vo.PatientOCSSeenResultsRefVo(new Integer(bean.getSeenResults().getId()), bean.getSeenResults().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocs_if.vo.beans.OCSPatientNotificationsVoBean bean = null;
		if(map != null)
			bean = (ims.ocs_if.vo.beans.OCSPatientNotificationsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocs_if.vo.beans.OCSPatientNotificationsVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("NEWRESULTS"))
			return getNewResults();
		if(fieldName.equals("SEENRESULTS"))
			return getSeenResults();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getNewResultsIsNotNull()
	{
		return this.newresults != null;
	}
	public ims.core.clinical.vo.PatientOCSNewResultsRefVo getNewResults()
	{
		return this.newresults;
	}
	public void setNewResults(ims.core.clinical.vo.PatientOCSNewResultsRefVo value)
	{
		this.isValidated = false;
		this.newresults = value;
	}
	public boolean getSeenResultsIsNotNull()
	{
		return this.seenresults != null;
	}
	public ims.core.clinical.vo.PatientOCSSeenResultsRefVo getSeenResults()
	{
		return this.seenresults;
	}
	public void setSeenResults(ims.core.clinical.vo.PatientOCSSeenResultsRefVo value)
	{
		this.isValidated = false;
		this.seenresults = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		OCSPatientNotificationsVo clone = new OCSPatientNotificationsVo(this.id, this.version);
		
		clone.patient = this.patient;
		clone.newresults = this.newresults;
		clone.seenresults = this.seenresults;
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(OCSPatientNotificationsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OCSPatientNotificationsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((OCSPatientNotificationsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((OCSPatientNotificationsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.newresults != null)
			count++;
		if(this.seenresults != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.clinical.vo.PatientOCSNewResultsRefVo newresults;
	protected ims.core.clinical.vo.PatientOCSSeenResultsRefVo seenresults;
	private boolean isValidated = false;
	private boolean isBusy = false;
}