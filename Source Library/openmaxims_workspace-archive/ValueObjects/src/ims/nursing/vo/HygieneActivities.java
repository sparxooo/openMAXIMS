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

/**
 * Linked to nursing.assessment.Personal Hygiene Activities business object (ID: 1012100043).
 */
public class HygieneActivities extends ims.nursing.assessment.vo.PersonalHygieneActivitiesRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public HygieneActivities()
	{
	}
	public HygieneActivities(Integer id, int version)
	{
		super(id, version);
	}
	public HygieneActivities(ims.nursing.vo.beans.HygieneActivitiesBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.activities = bean.getActivities() == null ? null : ims.nursing.vo.lookups.HygieneActivities.buildLookup(bean.getActivities());
		this.ability = bean.getAbility() == null ? null : ims.nursing.vo.lookups.Ability.buildLookup(bean.getAbility());
		this.aidsused = bean.getAidsUsed();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.HygieneActivitiesBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.activities = bean.getActivities() == null ? null : ims.nursing.vo.lookups.HygieneActivities.buildLookup(bean.getActivities());
		this.ability = bean.getAbility() == null ? null : ims.nursing.vo.lookups.Ability.buildLookup(bean.getAbility());
		this.aidsused = bean.getAidsUsed();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.HygieneActivitiesBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.HygieneActivitiesBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.HygieneActivitiesBean();
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
		if(fieldName.equals("ACTIVITIES"))
			return getActivities();
		if(fieldName.equals("ABILITY"))
			return getAbility();
		if(fieldName.equals("AIDSUSED"))
			return getAidsUsed();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getActivitiesIsNotNull()
	{
		return this.activities != null;
	}
	public ims.nursing.vo.lookups.HygieneActivities getActivities()
	{
		return this.activities;
	}
	public void setActivities(ims.nursing.vo.lookups.HygieneActivities value)
	{
		this.isValidated = false;
		this.activities = value;
	}
	public boolean getAbilityIsNotNull()
	{
		return this.ability != null;
	}
	public ims.nursing.vo.lookups.Ability getAbility()
	{
		return this.ability;
	}
	public void setAbility(ims.nursing.vo.lookups.Ability value)
	{
		this.isValidated = false;
		this.ability = value;
	}
	public boolean getAidsUsedIsNotNull()
	{
		return this.aidsused != null;
	}
	public String getAidsUsed()
	{
		return this.aidsused;
	}
	public static int getAidsUsedMaxLength()
	{
		return 255;
	}
	public void setAidsUsed(String value)
	{
		this.isValidated = false;
		this.aidsused = value;
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
	
		HygieneActivities clone = new HygieneActivities(this.id, this.version);
		
		if(this.activities == null)
			clone.activities = null;
		else
			clone.activities = (ims.nursing.vo.lookups.HygieneActivities)this.activities.clone();
		if(this.ability == null)
			clone.ability = null;
		else
			clone.ability = (ims.nursing.vo.lookups.Ability)this.ability.clone();
		clone.aidsused = this.aidsused;
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
		if (!(HygieneActivities.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A HygieneActivities object cannot be compared an Object of type " + obj.getClass().getName());
		}
		HygieneActivities compareObj = (HygieneActivities)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_PersonalHygieneActivities() == null && compareObj.getID_PersonalHygieneActivities() != null)
				return -1;
			if(this.getID_PersonalHygieneActivities() != null && compareObj.getID_PersonalHygieneActivities() == null)
				return 1;
			if(this.getID_PersonalHygieneActivities() != null && compareObj.getID_PersonalHygieneActivities() != null)
				retVal = this.getID_PersonalHygieneActivities().compareTo(compareObj.getID_PersonalHygieneActivities());
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
		if(this.activities != null)
			count++;
		if(this.ability != null)
			count++;
		if(this.aidsused != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.nursing.vo.lookups.HygieneActivities activities;
	protected ims.nursing.vo.lookups.Ability ability;
	protected String aidsused;
	private boolean isValidated = false;
	private boolean isBusy = false;
}