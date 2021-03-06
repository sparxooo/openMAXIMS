//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
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
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.ocrr.vo;


public class NonInpSpecCollectionSearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NonInpSpecCollectionSearchCriteriaVo()
	{
	}
	public NonInpSpecCollectionSearchCriteriaVo(ims.ocrr.vo.beans.NonInpSpecCollectionSearchCriteriaVoBean bean)
	{
		this.viewtype = bean.getViewType();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.fromdate = bean.getFromDate() == null ? null : bean.getFromDate().buildDate();
		this.fromtime = bean.getFromTime() == null ? null : bean.getFromTime().buildTime();
		this.todate = bean.getToDate() == null ? null : bean.getToDate().buildDate();
		this.totime = bean.getToTime() == null ? null : bean.getToTime().buildTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.NonInpSpecCollectionSearchCriteriaVoBean bean)
	{
		this.viewtype = bean.getViewType();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.fromdate = bean.getFromDate() == null ? null : bean.getFromDate().buildDate();
		this.fromtime = bean.getFromTime() == null ? null : bean.getFromTime().buildTime();
		this.todate = bean.getToDate() == null ? null : bean.getToDate().buildDate();
		this.totime = bean.getToTime() == null ? null : bean.getToTime().buildTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.NonInpSpecCollectionSearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.NonInpSpecCollectionSearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.NonInpSpecCollectionSearchCriteriaVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getViewTypeIsNotNull()
	{
		return this.viewtype != null;
	}
	public Integer getViewType()
	{
		return this.viewtype;
	}
	public void setViewType(Integer value)
	{
		this.isValidated = false;
		this.viewtype = value;
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
	public boolean getFromDateIsNotNull()
	{
		return this.fromdate != null;
	}
	public ims.framework.utils.Date getFromDate()
	{
		return this.fromdate;
	}
	public void setFromDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.fromdate = value;
	}
	public boolean getFromTimeIsNotNull()
	{
		return this.fromtime != null;
	}
	public ims.framework.utils.Time getFromTime()
	{
		return this.fromtime;
	}
	public void setFromTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.fromtime = value;
	}
	public boolean getToDateIsNotNull()
	{
		return this.todate != null;
	}
	public ims.framework.utils.Date getToDate()
	{
		return this.todate;
	}
	public void setToDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.todate = value;
	}
	public boolean getToTimeIsNotNull()
	{
		return this.totime != null;
	}
	public ims.framework.utils.Time getToTime()
	{
		return this.totime;
	}
	public void setToTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.totime = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		NonInpSpecCollectionSearchCriteriaVo clone = new NonInpSpecCollectionSearchCriteriaVo();
		
		clone.viewtype = this.viewtype;
		clone.patient = this.patient;
		if(this.fromdate == null)
			clone.fromdate = null;
		else
			clone.fromdate = (ims.framework.utils.Date)this.fromdate.clone();
		if(this.fromtime == null)
			clone.fromtime = null;
		else
			clone.fromtime = (ims.framework.utils.Time)this.fromtime.clone();
		if(this.todate == null)
			clone.todate = null;
		else
			clone.todate = (ims.framework.utils.Date)this.todate.clone();
		if(this.totime == null)
			clone.totime = null;
		else
			clone.totime = (ims.framework.utils.Time)this.totime.clone();
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
		if (!(NonInpSpecCollectionSearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NonInpSpecCollectionSearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		NonInpSpecCollectionSearchCriteriaVo compareObj = (NonInpSpecCollectionSearchCriteriaVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getPatient() == null && compareObj.getPatient() != null)
				return -1;
			if(this.getPatient() != null && compareObj.getPatient() == null)
				return 1;
			if(this.getPatient() != null && compareObj.getPatient() != null)
				retVal = this.getPatient().compareTo(compareObj.getPatient());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.viewtype != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.fromdate != null)
			count++;
		if(this.fromtime != null)
			count++;
		if(this.todate != null)
			count++;
		if(this.totime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected Integer viewtype;
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.framework.utils.Date fromdate;
	protected ims.framework.utils.Time fromtime;
	protected ims.framework.utils.Date todate;
	protected ims.framework.utils.Time totime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
