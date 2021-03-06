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

package ims.coe.vo;

/**
 * Linked to coe.assessment.Bladder Skills business object (ID: 1012100007).
 */
public class BladderSkills extends ims.coe.assessment.vo.BladderSkillsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public BladderSkills()
	{
	}
	public BladderSkills(Integer id, int version)
	{
		super(id, version);
	}
	public BladderSkills(ims.coe.vo.beans.BladderSkillsBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.skills = bean.getSkills() == null ? null : ims.coe.vo.lookups.BladderSkills.buildLookup(bean.getSkills());
		this.dependency = bean.getDependency() == null ? null : ims.nursing.vo.lookups.Ability.buildLookup(bean.getDependency());
		this.details = bean.getDetails();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.beans.BladderSkillsBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.skills = bean.getSkills() == null ? null : ims.coe.vo.lookups.BladderSkills.buildLookup(bean.getSkills());
		this.dependency = bean.getDependency() == null ? null : ims.nursing.vo.lookups.Ability.buildLookup(bean.getDependency());
		this.details = bean.getDetails();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.beans.BladderSkillsBean bean = null;
		if(map != null)
			bean = (ims.coe.vo.beans.BladderSkillsBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.coe.vo.beans.BladderSkillsBean();
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
		if(fieldName.equals("SKILLS"))
			return getSkills();
		if(fieldName.equals("DEPENDENCY"))
			return getDependency();
		if(fieldName.equals("DETAILS"))
			return getDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSkillsIsNotNull()
	{
		return this.skills != null;
	}
	public ims.coe.vo.lookups.BladderSkills getSkills()
	{
		return this.skills;
	}
	public void setSkills(ims.coe.vo.lookups.BladderSkills value)
	{
		this.isValidated = false;
		this.skills = value;
	}
	public boolean getDependencyIsNotNull()
	{
		return this.dependency != null;
	}
	public ims.nursing.vo.lookups.Ability getDependency()
	{
		return this.dependency;
	}
	public void setDependency(ims.nursing.vo.lookups.Ability value)
	{
		this.isValidated = false;
		this.dependency = value;
	}
	public boolean getDetailsIsNotNull()
	{
		return this.details != null;
	}
	public String getDetails()
	{
		return this.details;
	}
	public static int getDetailsMaxLength()
	{
		return 255;
	}
	public void setDetails(String value)
	{
		this.isValidated = false;
		this.details = value;
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
	
		BladderSkills clone = new BladderSkills(this.id, this.version);
		
		if(this.skills == null)
			clone.skills = null;
		else
			clone.skills = (ims.coe.vo.lookups.BladderSkills)this.skills.clone();
		if(this.dependency == null)
			clone.dependency = null;
		else
			clone.dependency = (ims.nursing.vo.lookups.Ability)this.dependency.clone();
		clone.details = this.details;
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
		if (!(BladderSkills.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A BladderSkills object cannot be compared an Object of type " + obj.getClass().getName());
		}
		BladderSkills compareObj = (BladderSkills)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_BladderSkills() == null && compareObj.getID_BladderSkills() != null)
				return -1;
			if(this.getID_BladderSkills() != null && compareObj.getID_BladderSkills() == null)
				return 1;
			if(this.getID_BladderSkills() != null && compareObj.getID_BladderSkills() != null)
				retVal = this.getID_BladderSkills().compareTo(compareObj.getID_BladderSkills());
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
		if(this.skills != null)
			count++;
		if(this.dependency != null)
			count++;
		if(this.details != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.coe.vo.lookups.BladderSkills skills;
	protected ims.nursing.vo.lookups.Ability dependency;
	protected String details;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
