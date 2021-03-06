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
 * Linked to Oncology.CancerCarePlan business object (ID: 1074100016).
 */
public class CancerCarePlanLiteVo extends ims.oncology.vo.CancerCarePlanRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CancerCarePlanLiteVo()
	{
	}
	public CancerCarePlanLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public CancerCarePlanLiteVo(ims.oncology.vo.beans.CancerCarePlanLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.careplandate = bean.getCarePlanDate() == null ? null : bean.getCarePlanDate().buildDate();
		this.consultantincharge = bean.getConsultantInCharge() == null ? null : bean.getConsultantInCharge().buildVo();
		this.careplanintent = bean.getCarePlanIntent() == null ? null : ims.oncology.vo.lookups.CarePlanIntent.buildLookup(bean.getCarePlanIntent());
		this.recurrenceindicator = bean.getRecurrenceIndicator() == null ? null : ims.oncology.vo.lookups.RecurrenceIndicator.buildLookup(bean.getRecurrenceIndicator());
		this.iscurrent = bean.getIsCurrent();
		this.mdtmeeting = bean.getMdtMeeting() == null ? null : bean.getMdtMeeting().buildVo();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.CancerCarePlanLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.careplandate = bean.getCarePlanDate() == null ? null : bean.getCarePlanDate().buildDate();
		this.consultantincharge = bean.getConsultantInCharge() == null ? null : bean.getConsultantInCharge().buildVo(map);
		this.careplanintent = bean.getCarePlanIntent() == null ? null : ims.oncology.vo.lookups.CarePlanIntent.buildLookup(bean.getCarePlanIntent());
		this.recurrenceindicator = bean.getRecurrenceIndicator() == null ? null : ims.oncology.vo.lookups.RecurrenceIndicator.buildLookup(bean.getRecurrenceIndicator());
		this.iscurrent = bean.getIsCurrent();
		this.mdtmeeting = bean.getMdtMeeting() == null ? null : bean.getMdtMeeting().buildVo(map);
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.CancerCarePlanLiteVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.CancerCarePlanLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.CancerCarePlanLiteVoBean();
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
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("CAREPLANDATE"))
			return getCarePlanDate();
		if(fieldName.equals("CONSULTANTINCHARGE"))
			return getConsultantInCharge();
		if(fieldName.equals("CAREPLANINTENT"))
			return getCarePlanIntent();
		if(fieldName.equals("RECURRENCEINDICATOR"))
			return getRecurrenceIndicator();
		if(fieldName.equals("ISCURRENT"))
			return getIsCurrent();
		if(fieldName.equals("MDTMEETING"))
			return getMdtMeeting();
		if(fieldName.equals("EPISODEOFCARE"))
			return getEpisodeOfCare();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.vo.ClinicalContactShortVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.ClinicalContactShortVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.vo.CareContextShortVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.CareContextShortVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getCarePlanDateIsNotNull()
	{
		return this.careplandate != null;
	}
	public ims.framework.utils.Date getCarePlanDate()
	{
		return this.careplandate;
	}
	public void setCarePlanDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.careplandate = value;
	}
	public boolean getConsultantInChargeIsNotNull()
	{
		return this.consultantincharge != null;
	}
	public ims.core.vo.HcpLiteVo getConsultantInCharge()
	{
		return this.consultantincharge;
	}
	public void setConsultantInCharge(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.consultantincharge = value;
	}
	public boolean getCarePlanIntentIsNotNull()
	{
		return this.careplanintent != null;
	}
	public ims.oncology.vo.lookups.CarePlanIntent getCarePlanIntent()
	{
		return this.careplanintent;
	}
	public void setCarePlanIntent(ims.oncology.vo.lookups.CarePlanIntent value)
	{
		this.isValidated = false;
		this.careplanintent = value;
	}
	public boolean getRecurrenceIndicatorIsNotNull()
	{
		return this.recurrenceindicator != null;
	}
	public ims.oncology.vo.lookups.RecurrenceIndicator getRecurrenceIndicator()
	{
		return this.recurrenceindicator;
	}
	public void setRecurrenceIndicator(ims.oncology.vo.lookups.RecurrenceIndicator value)
	{
		this.isValidated = false;
		this.recurrenceindicator = value;
	}
	public boolean getIsCurrentIsNotNull()
	{
		return this.iscurrent != null;
	}
	public Boolean getIsCurrent()
	{
		return this.iscurrent;
	}
	public void setIsCurrent(Boolean value)
	{
		this.isValidated = false;
		this.iscurrent = value;
	}
	public boolean getMdtMeetingIsNotNull()
	{
		return this.mdtmeeting != null;
	}
	public ims.oncology.vo.CancerMDTMeetingVo getMdtMeeting()
	{
		return this.mdtmeeting;
	}
	public void setMdtMeeting(ims.oncology.vo.CancerMDTMeetingVo value)
	{
		this.isValidated = false;
		this.mdtmeeting = value;
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
		if(this.consultantincharge != null)
		{
			if(!this.consultantincharge.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.mdtmeeting != null)
		{
			if(!this.mdtmeeting.isValidated())
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
		if(this.careplandate == null)
			listOfErrors.add("CarePlanDate is mandatory");
		if(this.consultantincharge != null)
		{
			String[] listOfOtherErrors = this.consultantincharge.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.mdtmeeting != null)
		{
			String[] listOfOtherErrors = this.mdtmeeting.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.episodeofcare == null)
			listOfErrors.add("EpisodeOfCare is mandatory");
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
	
		CancerCarePlanLiteVo clone = new CancerCarePlanLiteVo(this.id, this.version);
		
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactShortVo)this.clinicalcontact.clone();
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.core.vo.CareContextShortVo)this.carecontext.clone();
		if(this.careplandate == null)
			clone.careplandate = null;
		else
			clone.careplandate = (ims.framework.utils.Date)this.careplandate.clone();
		if(this.consultantincharge == null)
			clone.consultantincharge = null;
		else
			clone.consultantincharge = (ims.core.vo.HcpLiteVo)this.consultantincharge.clone();
		if(this.careplanintent == null)
			clone.careplanintent = null;
		else
			clone.careplanintent = (ims.oncology.vo.lookups.CarePlanIntent)this.careplanintent.clone();
		if(this.recurrenceindicator == null)
			clone.recurrenceindicator = null;
		else
			clone.recurrenceindicator = (ims.oncology.vo.lookups.RecurrenceIndicator)this.recurrenceindicator.clone();
		clone.iscurrent = this.iscurrent;
		if(this.mdtmeeting == null)
			clone.mdtmeeting = null;
		else
			clone.mdtmeeting = (ims.oncology.vo.CancerMDTMeetingVo)this.mdtmeeting.clone();
		clone.episodeofcare = this.episodeofcare;
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
		if (!(CancerCarePlanLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CancerCarePlanLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CancerCarePlanLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CancerCarePlanLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.clinicalcontact != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.careplandate != null)
			count++;
		if(this.consultantincharge != null)
			count++;
		if(this.careplanintent != null)
			count++;
		if(this.recurrenceindicator != null)
			count++;
		if(this.iscurrent != null)
			count++;
		if(this.mdtmeeting != null)
			count++;
		if(this.episodeofcare != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.core.vo.ClinicalContactShortVo clinicalcontact;
	protected ims.core.vo.CareContextShortVo carecontext;
	protected ims.framework.utils.Date careplandate;
	protected ims.core.vo.HcpLiteVo consultantincharge;
	protected ims.oncology.vo.lookups.CarePlanIntent careplanintent;
	protected ims.oncology.vo.lookups.RecurrenceIndicator recurrenceindicator;
	protected Boolean iscurrent;
	protected ims.oncology.vo.CancerMDTMeetingVo mdtmeeting;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episodeofcare;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
