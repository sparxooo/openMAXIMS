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
 * Linked to core.clinical.ClinicalAdmission business object (ID: 1009100020).
 */
public class ClinicalAdmissionListVo extends ims.core.clinical.vo.ClinicalAdmissionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClinicalAdmissionListVo()
	{
	}
	public ClinicalAdmissionListVo(Integer id, int version)
	{
		super(id, version);
	}
	public ClinicalAdmissionListVo(ims.nursing.vo.beans.ClinicalAdmissionListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.admittingnurse = bean.getAdmittingNurse() == null ? null : bean.getAdmittingNurse().buildVo();
		this.dischargeddatetime = bean.getDischargedDateTime() == null ? null : bean.getDischargedDateTime().buildDateTime();
		this.dischargedby = bean.getDischargedBy() == null ? null : bean.getDischargedBy().buildVo();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.ClinicalAdmissionListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.admittingnurse = bean.getAdmittingNurse() == null ? null : bean.getAdmittingNurse().buildVo(map);
		this.dischargeddatetime = bean.getDischargedDateTime() == null ? null : bean.getDischargedDateTime().buildDateTime();
		this.dischargedby = bean.getDischargedBy() == null ? null : bean.getDischargedBy().buildVo(map);
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.ClinicalAdmissionListVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.ClinicalAdmissionListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.ClinicalAdmissionListVoBean();
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
		if(fieldName.equals("ADMITTINGNURSE"))
			return getAdmittingNurse();
		if(fieldName.equals("DISCHARGEDDATETIME"))
			return getDischargedDateTime();
		if(fieldName.equals("DISCHARGEDBY"))
			return getDischargedBy();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAdmittingNurseIsNotNull()
	{
		return this.admittingnurse != null;
	}
	public ims.core.vo.NurseVo getAdmittingNurse()
	{
		return this.admittingnurse;
	}
	public void setAdmittingNurse(ims.core.vo.NurseVo value)
	{
		this.isValidated = false;
		this.admittingnurse = value;
	}
	public boolean getDischargedDateTimeIsNotNull()
	{
		return this.dischargeddatetime != null;
	}
	public ims.framework.utils.DateTime getDischargedDateTime()
	{
		return this.dischargeddatetime;
	}
	public void setDischargedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.dischargeddatetime = value;
	}
	public boolean getDischargedByIsNotNull()
	{
		return this.dischargedby != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getDischargedBy()
	{
		return this.dischargedby;
	}
	public void setDischargedBy(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.dischargedby = value;
	}
	public boolean getSysInfoIsNotNull()
	{
		return this.sysinfo != null;
	}
	public ims.vo.SystemInformation getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.sysinfo = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
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
		if(this.admittingnurse != null)
		{
			if(!this.admittingnurse.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.dischargedby != null)
		{
			if(!this.dischargedby.isValidated())
			{
				this.isBusy = false;
				return false;
			}
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
		if(this.admittingnurse == null)
			listOfErrors.add("AdmittingNurse is mandatory");
		if(this.admittingnurse != null)
		{
			String[] listOfOtherErrors = this.admittingnurse.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.dischargedby != null)
		{
			String[] listOfOtherErrors = this.dischargedby.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
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
	
		ClinicalAdmissionListVo clone = new ClinicalAdmissionListVo(this.id, this.version);
		
		if(this.admittingnurse == null)
			clone.admittingnurse = null;
		else
			clone.admittingnurse = (ims.core.vo.NurseVo)this.admittingnurse.clone();
		if(this.dischargeddatetime == null)
			clone.dischargeddatetime = null;
		else
			clone.dischargeddatetime = (ims.framework.utils.DateTime)this.dischargeddatetime.clone();
		if(this.dischargedby == null)
			clone.dischargedby = null;
		else
			clone.dischargedby = (ims.core.vo.MemberOfStaffLiteVo)this.dischargedby.clone();
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		clone.carecontext = this.carecontext;
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
		if (!(ClinicalAdmissionListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClinicalAdmissionListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ClinicalAdmissionListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ClinicalAdmissionListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.admittingnurse != null)
			count++;
		if(this.dischargeddatetime != null)
			count++;
		if(this.dischargedby != null)
			count++;
		if(this.sysinfo != null)
			count++;
		if(this.carecontext != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.NurseVo admittingnurse;
	protected ims.framework.utils.DateTime dischargeddatetime;
	protected ims.core.vo.MemberOfStaffLiteVo dischargedby;
	protected ims.vo.SystemInformation sysinfo;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
