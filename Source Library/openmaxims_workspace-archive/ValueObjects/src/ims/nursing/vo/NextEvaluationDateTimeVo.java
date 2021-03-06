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

package ims.nursing.vo;


public class NextEvaluationDateTimeVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NextEvaluationDateTimeVo()
	{
	}
	public NextEvaluationDateTimeVo(ims.nursing.vo.beans.NextEvaluationDateTimeVoBean bean)
	{
		this.nextevaluationdate = bean.getNextEvaluationDate() == null ? null : bean.getNextEvaluationDate().buildDate();
		this.nextevaluationtime = bean.getNextEvaluationTime() == null ? null : bean.getNextEvaluationTime().buildTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.NextEvaluationDateTimeVoBean bean)
	{
		this.nextevaluationdate = bean.getNextEvaluationDate() == null ? null : bean.getNextEvaluationDate().buildDate();
		this.nextevaluationtime = bean.getNextEvaluationTime() == null ? null : bean.getNextEvaluationTime().buildTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.NextEvaluationDateTimeVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.NextEvaluationDateTimeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.NextEvaluationDateTimeVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getNextEvaluationDateIsNotNull()
	{
		return this.nextevaluationdate != null;
	}
	public ims.framework.utils.Date getNextEvaluationDate()
	{
		return this.nextevaluationdate;
	}
	public void setNextEvaluationDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.nextevaluationdate = value;
	}
	public boolean getNextEvaluationTimeIsNotNull()
	{
		return this.nextevaluationtime != null;
	}
	public ims.framework.utils.Time getNextEvaluationTime()
	{
		return this.nextevaluationtime;
	}
	public void setNextEvaluationTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.nextevaluationtime = value;
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
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof NextEvaluationDateTimeVo))
			return false;
		NextEvaluationDateTimeVo compareObj = (NextEvaluationDateTimeVo)obj;
		if(this.getNextEvaluationDate() == null && compareObj.getNextEvaluationDate() != null)
			return false;
		if(this.getNextEvaluationDate() != null && compareObj.getNextEvaluationDate() == null)
			return false;
		if(this.getNextEvaluationDate() != null && compareObj.getNextEvaluationDate() != null)
			if(!this.getNextEvaluationDate().equals(compareObj.getNextEvaluationDate()))
				return false;
		if(this.getNextEvaluationTime() == null && compareObj.getNextEvaluationTime() != null)
			return false;
		if(this.getNextEvaluationTime() != null && compareObj.getNextEvaluationTime() == null)
			return false;
		if(this.getNextEvaluationTime() != null && compareObj.getNextEvaluationTime() != null)
			return this.getNextEvaluationTime().equals(compareObj.getNextEvaluationTime());
		return super.equals(obj);
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
	
		NextEvaluationDateTimeVo clone = new NextEvaluationDateTimeVo();
		
		if(this.nextevaluationdate == null)
			clone.nextevaluationdate = null;
		else
			clone.nextevaluationdate = (ims.framework.utils.Date)this.nextevaluationdate.clone();
		if(this.nextevaluationtime == null)
			clone.nextevaluationtime = null;
		else
			clone.nextevaluationtime = (ims.framework.utils.Time)this.nextevaluationtime.clone();
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
		if (!(NextEvaluationDateTimeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NextEvaluationDateTimeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		NextEvaluationDateTimeVo compareObj = (NextEvaluationDateTimeVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getNextEvaluationDate() == null && compareObj.getNextEvaluationDate() != null)
				return -1;
			if(this.getNextEvaluationDate() != null && compareObj.getNextEvaluationDate() == null)
				return 1;
			if(this.getNextEvaluationDate() != null && compareObj.getNextEvaluationDate() != null)
				retVal = this.getNextEvaluationDate().compareTo(compareObj.getNextEvaluationDate());
		}
		if (retVal == 0)
		{
			if(this.getNextEvaluationTime() == null && compareObj.getNextEvaluationTime() != null)
				return -1;
			if(this.getNextEvaluationTime() != null && compareObj.getNextEvaluationTime() == null)
				return 1;
			if(this.getNextEvaluationTime() != null && compareObj.getNextEvaluationTime() != null)
				retVal = this.getNextEvaluationTime().compareTo(compareObj.getNextEvaluationTime());
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
		if(this.nextevaluationdate != null)
			count++;
		if(this.nextevaluationtime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.framework.utils.Date nextevaluationdate;
	protected ims.framework.utils.Time nextevaluationtime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
