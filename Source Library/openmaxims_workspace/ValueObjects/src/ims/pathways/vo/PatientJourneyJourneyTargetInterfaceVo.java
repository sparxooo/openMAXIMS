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

package ims.pathways.vo;

/**
 * Linked to Pathways.PatientJourneyTarget business object (ID: 1088100001).
 */
public class PatientJourneyJourneyTargetInterfaceVo extends ims.pathways.vo.PatientJourneyTargetRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IPatientJourneyTarget
{
	private static final long serialVersionUID = 1L;

	public PatientJourneyJourneyTargetInterfaceVo()
	{
	}
	public PatientJourneyJourneyTargetInterfaceVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientJourneyJourneyTargetInterfaceVo(ims.pathways.vo.beans.PatientJourneyJourneyTargetInterfaceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pathwaytarget = bean.getPathwayTarget() == null ? null : bean.getPathwayTarget().buildVo();
		this.weeknumber = bean.getWeekNumber();
		this.targetdate = bean.getTargetDate() == null ? null : bean.getTargetDate().buildDate();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.cancelleddate = bean.getCancelledDate() == null ? null : bean.getCancelledDate().buildDate();
		this.hascancelledevents = bean.getHasCancelledEvents();
		this.events = ims.pathways.vo.PatientJourneyEventInterfaceVoCollection.buildFromBeanCollection(bean.getEvents());
		this.scheduleddate = bean.getScheduledDate() == null ? null : bean.getScheduledDate().buildDate();
		this.journeyclock = bean.getJourneyClock() == null ? null : bean.getJourneyClock().buildVo();
		this.achieveddate = bean.getAchievedDate() == null ? null : bean.getAchievedDate().buildDateTime();
		this.readjustments = ims.pathways.vo.TargetReadjustmentVoCollection.buildFromBeanCollection(bean.getReadjustments());
		this.hasreadjustments = bean.getHasReadjustments();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.beans.PatientJourneyJourneyTargetInterfaceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pathwaytarget = bean.getPathwayTarget() == null ? null : bean.getPathwayTarget().buildVo(map);
		this.weeknumber = bean.getWeekNumber();
		this.targetdate = bean.getTargetDate() == null ? null : bean.getTargetDate().buildDate();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.cancelleddate = bean.getCancelledDate() == null ? null : bean.getCancelledDate().buildDate();
		this.hascancelledevents = bean.getHasCancelledEvents();
		this.events = ims.pathways.vo.PatientJourneyEventInterfaceVoCollection.buildFromBeanCollection(bean.getEvents());
		this.scheduleddate = bean.getScheduledDate() == null ? null : bean.getScheduledDate().buildDate();
		this.journeyclock = bean.getJourneyClock() == null ? null : bean.getJourneyClock().buildVo(map);
		this.achieveddate = bean.getAchievedDate() == null ? null : bean.getAchievedDate().buildDateTime();
		this.readjustments = ims.pathways.vo.TargetReadjustmentVoCollection.buildFromBeanCollection(bean.getReadjustments());
		this.hasreadjustments = bean.getHasReadjustments();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.beans.PatientJourneyJourneyTargetInterfaceVoBean bean = null;
		if(map != null)
			bean = (ims.pathways.vo.beans.PatientJourneyJourneyTargetInterfaceVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.pathways.vo.beans.PatientJourneyJourneyTargetInterfaceVoBean();
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
		if(fieldName.equals("PATHWAYTARGET"))
			return getPathwayTarget();
		if(fieldName.equals("WEEKNUMBER"))
			return getWeekNumber();
		if(fieldName.equals("TARGETDATE"))
			return getTargetDate();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("CANCELLEDDATE"))
			return getCancelledDate();
		if(fieldName.equals("HASCANCELLEDEVENTS"))
			return getHasCancelledEvents();
		if(fieldName.equals("EVENTS"))
			return getEvents();
		if(fieldName.equals("SCHEDULEDDATE"))
			return getScheduledDate();
		if(fieldName.equals("JOURNEYCLOCK"))
			return getJourneyClock();
		if(fieldName.equals("ACHIEVEDDATE"))
			return getAchievedDate();
		if(fieldName.equals("READJUSTMENTS"))
			return getReadjustments();
		if(fieldName.equals("HASREADJUSTMENTS"))
			return getHasReadjustments();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPathwayTargetIsNotNull()
	{
		return this.pathwaytarget != null;
	}
	public ims.pathways.vo.PathwayTargetShortVo getPathwayTarget()
	{
		return this.pathwaytarget;
	}
	public void setPathwayTarget(ims.pathways.vo.PathwayTargetShortVo value)
	{
		this.isValidated = false;
		this.pathwaytarget = value;
	}
	public boolean getWeekNumberIsNotNull()
	{
		return this.weeknumber != null;
	}
	public Integer getWeekNumber()
	{
		return this.weeknumber;
	}
	public void setWeekNumber(Integer value)
	{
		this.isValidated = false;
		this.weeknumber = value;
	}
	public boolean getTargetDateIsNotNull()
	{
		return this.targetdate != null;
	}
	public ims.framework.utils.Date getTargetDate()
	{
		return this.targetdate;
	}
	public void setTargetDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.targetdate = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.pathways.vo.JourneyTargetStatusVo getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.pathways.vo.JourneyTargetStatusVo value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getCancelledDateIsNotNull()
	{
		return this.cancelleddate != null;
	}
	public ims.framework.utils.Date getCancelledDate()
	{
		return this.cancelleddate;
	}
	public void setCancelledDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.cancelleddate = value;
	}
	public boolean getHasCancelledEventsIsNotNull()
	{
		return this.hascancelledevents != null;
	}
	public Boolean getHasCancelledEvents()
	{
		return this.hascancelledevents;
	}
	public void setHasCancelledEvents(Boolean value)
	{
		this.isValidated = false;
		this.hascancelledevents = value;
	}
	public boolean getEventsIsNotNull()
	{
		return this.events != null;
	}
	public ims.pathways.vo.PatientJourneyEventInterfaceVoCollection getEvents()
	{
		return this.events;
	}
	public void setEvents(ims.pathways.vo.PatientJourneyEventInterfaceVoCollection value)
	{
		this.isValidated = false;
		this.events = value;
	}
	public boolean getScheduledDateIsNotNull()
	{
		return this.scheduleddate != null;
	}
	public ims.framework.utils.Date getScheduledDate()
	{
		return this.scheduleddate;
	}
	public void setScheduledDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.scheduleddate = value;
	}
	public boolean getJourneyClockIsNotNull()
	{
		return this.journeyclock != null;
	}
	public ims.pathways.vo.PatientJourneyClockInterfaceVo getJourneyClock()
	{
		return this.journeyclock;
	}
	public void setJourneyClock(ims.pathways.vo.PatientJourneyClockInterfaceVo value)
	{
		this.isValidated = false;
		this.journeyclock = value;
	}
	public boolean getAchievedDateIsNotNull()
	{
		return this.achieveddate != null;
	}
	public ims.framework.utils.DateTime getAchievedDate()
	{
		return this.achieveddate;
	}
	public void setAchievedDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.achieveddate = value;
	}
	public boolean getReadjustmentsIsNotNull()
	{
		return this.readjustments != null;
	}
	public ims.pathways.vo.TargetReadjustmentVoCollection getReadjustments()
	{
		return this.readjustments;
	}
	public void setReadjustments(ims.pathways.vo.TargetReadjustmentVoCollection value)
	{
		this.isValidated = false;
		this.readjustments = value;
	}
	public boolean getHasReadjustmentsIsNotNull()
	{
		return this.hasreadjustments != null;
	}
	public Boolean getHasReadjustments()
	{
		return this.hasreadjustments;
	}
	public void setHasReadjustments(Boolean value)
	{
		this.isValidated = false;
		this.hasreadjustments = value;
	}
	/**
	* IPatientJourneyTarget
	*/
	public ims.framework.utils.Date getIPatientJourneyTargetDate() 
	{
		return targetdate;
	}
	public ims.framework.utils.Date getIPatientJourneyTargetScheduledDate()
	{
		return scheduleddate;
	}
	public Boolean getIPatientJourneyTargetHasReadjustments()
	{
		return hasreadjustments;
	}
	public String getIPatientJourneyTargetDescription() 
	{
		if(pathwaytarget == null || pathwaytarget.getTarget() == null || pathwaytarget.getTarget().getDescription() == null)
			return "";
		return pathwaytarget.getTarget().getDescription();
	}
	public ims.vo.interfaces.IPatientJourneyEvent[] getIPatientJourneyTargetEvents() 
	{
		if(events == null)
			return new ims.vo.interfaces.IPatientJourneyEvent[0];
			
		ims.vo.interfaces.IPatientJourneyEvent[] result = new ims.vo.interfaces.IPatientJourneyEvent[events.size()];
			
		for(int x = 0; x < events.size(); x++)
		{
			result[x] = events.get(x);			
		}
			
		return result;
	}
	public String getIPatientJourneyTargetName() 
	{
		if(pathwaytarget == null || pathwaytarget.getTarget() == null || pathwaytarget.getTarget().getName() == null)
			return "";
		return pathwaytarget.getTarget().getName();
	}
	public ims.vo.interfaces.IPatientJourneyPathwayTarget getIPatientJourneyTargetPathwayTarget() 
	{
		return null;
	}
	public String getIPatientJourneyTargetStatus() 
	{
		return currentstatus == null ? "Unknown" : currentstatus.getStatus().toString();
	}
	
	
	public ims.pathways.vo.lookups.PatientTargetStatus getIPatientJourneyTargetStatusCode() 
	{
		return currentstatus == null ? null: currentstatus.getStatus();
	}
	
	public Integer getIPatientJourneyTargetWeekNumber() 
	{
		return weeknumber;
	}
	public ims.framework.utils.DateTime getIPatientJourneyTargetAchievedDate() 
	{
		return achieveddate;
	}
	public ims.framework.utils.Date getIPatientJourneyTargetCancelledDate() 
	{
		return cancelleddate;
	}
	public ims.vo.interfaces.IPatientJourneyClock getIPatientJourneyTargetClock() 
	{
		return journeyclock;
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
		if(this.pathwaytarget != null)
		{
			if(!this.pathwaytarget.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currentstatus != null)
		{
			if(!this.currentstatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.events != null)
		{
			if(!this.events.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.journeyclock != null)
		{
			if(!this.journeyclock.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.readjustments != null)
		{
			if(!this.readjustments.isValidated())
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
		if(this.pathwaytarget == null)
			listOfErrors.add("PathwayTarget is mandatory");
		if(this.pathwaytarget != null)
		{
			String[] listOfOtherErrors = this.pathwaytarget.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.weeknumber == null)
			listOfErrors.add("WeekNumber is mandatory");
		if(this.targetdate == null)
			listOfErrors.add("TargetDate is mandatory");
		if(this.currentstatus == null)
			listOfErrors.add("CurrentStatus is mandatory");
		if(this.currentstatus != null)
		{
			String[] listOfOtherErrors = this.currentstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.events != null)
		{
			String[] listOfOtherErrors = this.events.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.journeyclock != null)
		{
			String[] listOfOtherErrors = this.journeyclock.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.readjustments != null)
		{
			String[] listOfOtherErrors = this.readjustments.validate();
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
	
		PatientJourneyJourneyTargetInterfaceVo clone = new PatientJourneyJourneyTargetInterfaceVo(this.id, this.version);
		
		if(this.pathwaytarget == null)
			clone.pathwaytarget = null;
		else
			clone.pathwaytarget = (ims.pathways.vo.PathwayTargetShortVo)this.pathwaytarget.clone();
		clone.weeknumber = this.weeknumber;
		if(this.targetdate == null)
			clone.targetdate = null;
		else
			clone.targetdate = (ims.framework.utils.Date)this.targetdate.clone();
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.pathways.vo.JourneyTargetStatusVo)this.currentstatus.clone();
		if(this.cancelleddate == null)
			clone.cancelleddate = null;
		else
			clone.cancelleddate = (ims.framework.utils.Date)this.cancelleddate.clone();
		clone.hascancelledevents = this.hascancelledevents;
		if(this.events == null)
			clone.events = null;
		else
			clone.events = (ims.pathways.vo.PatientJourneyEventInterfaceVoCollection)this.events.clone();
		if(this.scheduleddate == null)
			clone.scheduleddate = null;
		else
			clone.scheduleddate = (ims.framework.utils.Date)this.scheduleddate.clone();
		if(this.journeyclock == null)
			clone.journeyclock = null;
		else
			clone.journeyclock = (ims.pathways.vo.PatientJourneyClockInterfaceVo)this.journeyclock.clone();
		if(this.achieveddate == null)
			clone.achieveddate = null;
		else
			clone.achieveddate = (ims.framework.utils.DateTime)this.achieveddate.clone();
		if(this.readjustments == null)
			clone.readjustments = null;
		else
			clone.readjustments = (ims.pathways.vo.TargetReadjustmentVoCollection)this.readjustments.clone();
		clone.hasreadjustments = this.hasreadjustments;
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
		if (!(PatientJourneyJourneyTargetInterfaceVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientJourneyJourneyTargetInterfaceVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientJourneyJourneyTargetInterfaceVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientJourneyJourneyTargetInterfaceVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.pathwaytarget != null)
			count++;
		if(this.weeknumber != null)
			count++;
		if(this.targetdate != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.cancelleddate != null)
			count++;
		if(this.hascancelledevents != null)
			count++;
		if(this.events != null)
			count++;
		if(this.scheduleddate != null)
			count++;
		if(this.journeyclock != null)
			count++;
		if(this.achieveddate != null)
			count++;
		if(this.readjustments != null)
			count++;
		if(this.hasreadjustments != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 12;
	}
	protected ims.pathways.vo.PathwayTargetShortVo pathwaytarget;
	protected Integer weeknumber;
	protected ims.framework.utils.Date targetdate;
	protected ims.pathways.vo.JourneyTargetStatusVo currentstatus;
	protected ims.framework.utils.Date cancelleddate;
	protected Boolean hascancelledevents;
	protected ims.pathways.vo.PatientJourneyEventInterfaceVoCollection events;
	protected ims.framework.utils.Date scheduleddate;
	protected ims.pathways.vo.PatientJourneyClockInterfaceVo journeyclock;
	protected ims.framework.utils.DateTime achieveddate;
	protected ims.pathways.vo.TargetReadjustmentVoCollection readjustments;
	protected Boolean hasreadjustments;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
