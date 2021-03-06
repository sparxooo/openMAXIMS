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

package ims.scheduling.vo;

/**
 * Linked to Scheduling.DirectoryofService business object (ID: 1055100011).
 */
public class DirectoryOfServiceVo extends ims.scheduling.vo.DirectoryOfServiceLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DirectoryOfServiceVo()
	{
	}
	public DirectoryOfServiceVo(Integer id, int version)
	{
		super(id, version);
	}
	public DirectoryOfServiceVo(ims.scheduling.vo.beans.DirectoryOfServiceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.dosname = bean.getDoSName();
		this.dosid = bean.getDoSId();
		this.isactive = bean.getIsActive();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.functions = ims.core.vo.ServiceFunctionVoCollection.buildFromBeanCollection(bean.getFunctions());
		this.location = bean.getLocation() == null ? null : bean.getLocation().buildVo();
		this.contract = bean.getContract() == null ? null : bean.getContract().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.DirectoryOfServiceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.dosname = bean.getDoSName();
		this.dosid = bean.getDoSId();
		this.isactive = bean.getIsActive();
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.functions = ims.core.vo.ServiceFunctionVoCollection.buildFromBeanCollection(bean.getFunctions());
		this.location = bean.getLocation() == null ? null : bean.getLocation().buildVo(map);
		this.contract = bean.getContract() == null ? null : bean.getContract().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.DirectoryOfServiceVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.DirectoryOfServiceVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.DirectoryOfServiceVoBean();
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
		if(fieldName.equals("SERVICE"))
			return getService();
		if(fieldName.equals("FUNCTIONS"))
			return getFunctions();
		if(fieldName.equals("LOCATION"))
			return getLocation();
		if(fieldName.equals("CONTRACT"))
			return getContract();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.core.vo.ServiceShortVo getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.ServiceShortVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getFunctionsIsNotNull()
	{
		return this.functions != null;
	}
	public ims.core.vo.ServiceFunctionVoCollection getFunctions()
	{
		return this.functions;
	}
	public void setFunctions(ims.core.vo.ServiceFunctionVoCollection value)
	{
		this.isValidated = false;
		this.functions = value;
	}
	public boolean getLocationIsNotNull()
	{
		return this.location != null;
	}
	public ims.core.vo.LocationLiteVo getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.location = value;
	}
	public boolean getContractIsNotNull()
	{
		return this.contract != null;
	}
	public ims.RefMan.vo.ContractConfigShortVo getContract()
	{
		return this.contract;
	}
	public void setContract(ims.RefMan.vo.ContractConfigShortVo value)
	{
		this.isValidated = false;
		this.contract = value;
	}
	/**
	* toString
	*/
	public String toString()
	{
		return this.getDoSName();
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
		if(this.service != null)
		{
			if(!this.service.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.functions != null)
		{
			if(!this.functions.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.location != null)
		{
			if(!this.location.isValidated())
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
		if(this.dosname == null || this.dosname.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.dosname.length() > 300)
			listOfErrors.add("The length of the field [dosname] in the value object [ims.scheduling.vo.DirectoryOfServiceVo] is too big. It should be less or equal to 300");
		if(this.dosid == null || this.dosid.length() == 0)
			listOfErrors.add("ID is mandatory");
		else if(this.dosid.length() > 50)
			listOfErrors.add("The length of the field [dosid] in the value object [ims.scheduling.vo.DirectoryOfServiceVo] is too big. It should be less or equal to 50");
		if(this.isactive == null)
			listOfErrors.add("isActive is mandatory");
		if(this.service != null)
		{
			String[] listOfOtherErrors = this.service.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.functions != null)
		{
			String[] listOfOtherErrors = this.functions.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.location == null)
			listOfErrors.add("Location is mandatory");
		if(this.location != null)
		{
			String[] listOfOtherErrors = this.location.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.contract == null)
			listOfErrors.add("Contract is mandatory");
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
	
		DirectoryOfServiceVo clone = new DirectoryOfServiceVo(this.id, this.version);
		
		clone.dosname = this.dosname;
		clone.dosid = this.dosid;
		clone.isactive = this.isactive;
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceShortVo)this.service.clone();
		if(this.functions == null)
			clone.functions = null;
		else
			clone.functions = (ims.core.vo.ServiceFunctionVoCollection)this.functions.clone();
		if(this.location == null)
			clone.location = null;
		else
			clone.location = (ims.core.vo.LocationLiteVo)this.location.clone();
		if(this.contract == null)
			clone.contract = null;
		else
			clone.contract = (ims.RefMan.vo.ContractConfigShortVo)this.contract.clone();
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
		if (!(DirectoryOfServiceVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DirectoryOfServiceVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		DirectoryOfServiceVo compareObj = (DirectoryOfServiceVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_DirectoryofService() == null && compareObj.getID_DirectoryofService() != null)
				return -1;
			if(this.getID_DirectoryofService() != null && compareObj.getID_DirectoryofService() == null)
				return 1;
			if(this.getID_DirectoryofService() != null && compareObj.getID_DirectoryofService() != null)
				retVal = this.getID_DirectoryofService().compareTo(compareObj.getID_DirectoryofService());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.service != null)
			count++;
		if(this.functions != null)
			count++;
		if(this.location != null)
			count++;
		if(this.contract != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 4;
	}
	protected ims.core.vo.ServiceShortVo service;
	protected ims.core.vo.ServiceFunctionVoCollection functions;
	protected ims.core.vo.LocationLiteVo location;
	protected ims.RefMan.vo.ContractConfigShortVo contract;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
