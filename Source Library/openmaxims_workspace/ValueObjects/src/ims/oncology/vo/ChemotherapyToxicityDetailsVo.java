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

package ims.oncology.vo;

/**
 * Linked to Oncology.ChemotherapyToxicityDetails business object (ID: 1074100022).
 */
public class ChemotherapyToxicityDetailsVo extends ims.oncology.vo.ChemotherapyToxicityDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ChemotherapyToxicityDetailsVo()
	{
	}
	public ChemotherapyToxicityDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public ChemotherapyToxicityDetailsVo(ims.oncology.vo.beans.ChemotherapyToxicityDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.assessmentdate = bean.getAssessmentDate() == null ? null : bean.getAssessmentDate().buildDate();
		this.toxicitydetails = ims.oncology.vo.ChemoTxToxicityTypeVoCollection.buildFromBeanCollection(bean.getToxicityDetails());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.ChemotherapyToxicityDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.assessmentdate = bean.getAssessmentDate() == null ? null : bean.getAssessmentDate().buildDate();
		this.toxicitydetails = ims.oncology.vo.ChemoTxToxicityTypeVoCollection.buildFromBeanCollection(bean.getToxicityDetails());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.ChemotherapyToxicityDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.ChemotherapyToxicityDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.ChemotherapyToxicityDetailsVoBean();
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
		if(fieldName.equals("EPISODEOFCARE"))
			return getEpisodeOfCare();
		if(fieldName.equals("ASSESSMENTDATE"))
			return getAssessmentDate();
		if(fieldName.equals("TOXICITYDETAILS"))
			return getToxicityDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getEpisodeOfCareIsNotNull()
	{
		return this.episodeofcare != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episodeofcare = value;
	}
	public boolean getAssessmentDateIsNotNull()
	{
		return this.assessmentdate != null;
	}
	public ims.framework.utils.Date getAssessmentDate()
	{
		return this.assessmentdate;
	}
	public void setAssessmentDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.assessmentdate = value;
	}
	public boolean getToxicityDetailsIsNotNull()
	{
		return this.toxicitydetails != null;
	}
	public ims.oncology.vo.ChemoTxToxicityTypeVoCollection getToxicityDetails()
	{
		return this.toxicitydetails;
	}
	public void setToxicityDetails(ims.oncology.vo.ChemoTxToxicityTypeVoCollection value)
	{
		this.isValidated = false;
		this.toxicitydetails = value;
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
		if(this.toxicitydetails != null)
		{
			if(!this.toxicitydetails.isValidated())
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
		if(this.episodeofcare == null)
			listOfErrors.add("EpisodeOfCare is mandatory");
		if(this.toxicitydetails != null)
		{
			String[] listOfOtherErrors = this.toxicitydetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
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
	
		ChemotherapyToxicityDetailsVo clone = new ChemotherapyToxicityDetailsVo(this.id, this.version);
		
		clone.episodeofcare = this.episodeofcare;
		if(this.assessmentdate == null)
			clone.assessmentdate = null;
		else
			clone.assessmentdate = (ims.framework.utils.Date)this.assessmentdate.clone();
		if(this.toxicitydetails == null)
			clone.toxicitydetails = null;
		else
			clone.toxicitydetails = (ims.oncology.vo.ChemoTxToxicityTypeVoCollection)this.toxicitydetails.clone();
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
		if (!(ChemotherapyToxicityDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ChemotherapyToxicityDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ChemotherapyToxicityDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ChemotherapyToxicityDetailsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.episodeofcare != null)
			count++;
		if(this.assessmentdate != null)
			count++;
		if(this.toxicitydetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.admin.vo.EpisodeOfCareRefVo episodeofcare;
	protected ims.framework.utils.Date assessmentdate;
	protected ims.oncology.vo.ChemoTxToxicityTypeVoCollection toxicitydetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
