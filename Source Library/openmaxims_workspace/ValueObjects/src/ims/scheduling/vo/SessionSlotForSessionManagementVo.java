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
 * Linked to Scheduling.Session_Slot business object (ID: 1055100016).
 */
public class SessionSlotForSessionManagementVo extends ims.scheduling.vo.Session_SlotRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SessionSlotForSessionManagementVo()
	{
	}
	public SessionSlotForSessionManagementVo(Integer id, int version)
	{
		super(id, version);
	}
	public SessionSlotForSessionManagementVo(ims.scheduling.vo.beans.SessionSlotForSessionManagementVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo();
		this.starttm = bean.getStartTm() == null ? null : bean.getStartTm().buildTime();
		this.duration = bean.getDuration();
		this.isactive = bean.getIsActive();
		this.status = bean.getStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getStatus());
		this.appointment = bean.getAppointment() == null ? null : bean.getAppointment().buildVo();
		this.slotresp = bean.getSlotResp() == null ? null : bean.getSlotResp().buildVo();
		this.directoryofservices = ims.scheduling.vo.DirectoryOfServiceSessionSlotVoCollection.buildFromBeanCollection(bean.getDirectoryOfServices());
		this.priority = bean.getPriority() == null ? null : ims.scheduling.vo.lookups.SchedulingPriority.buildLookup(bean.getPriority());
		this.catsreferral = bean.getCatsReferral() == null ? null : bean.getCatsReferral().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.SessionSlotForSessionManagementVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo(map);
		this.starttm = bean.getStartTm() == null ? null : bean.getStartTm().buildTime();
		this.duration = bean.getDuration();
		this.isactive = bean.getIsActive();
		this.status = bean.getStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getStatus());
		this.appointment = bean.getAppointment() == null ? null : bean.getAppointment().buildVo(map);
		this.slotresp = bean.getSlotResp() == null ? null : bean.getSlotResp().buildVo(map);
		this.directoryofservices = ims.scheduling.vo.DirectoryOfServiceSessionSlotVoCollection.buildFromBeanCollection(bean.getDirectoryOfServices());
		this.priority = bean.getPriority() == null ? null : ims.scheduling.vo.lookups.SchedulingPriority.buildLookup(bean.getPriority());
		this.catsreferral = bean.getCatsReferral() == null ? null : bean.getCatsReferral().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.SessionSlotForSessionManagementVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.SessionSlotForSessionManagementVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.SessionSlotForSessionManagementVoBean();
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
		if(fieldName.equals("ACTIVITY"))
			return getActivity();
		if(fieldName.equals("STARTTM"))
			return getStartTm();
		if(fieldName.equals("DURATION"))
			return getDuration();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("APPOINTMENT"))
			return getAppointment();
		if(fieldName.equals("SLOTRESP"))
			return getSlotResp();
		if(fieldName.equals("DIRECTORYOFSERVICES"))
			return getDirectoryOfServices();
		if(fieldName.equals("PRIORITY"))
			return getPriority();
		if(fieldName.equals("CATSREFERRAL"))
			return getCatsReferral();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getActivityIsNotNull()
	{
		return this.activity != null;
	}
	public ims.core.vo.ActivityLiteVo getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.core.vo.ActivityLiteVo value)
	{
		this.isValidated = false;
		this.activity = value;
	}
	public boolean getStartTmIsNotNull()
	{
		return this.starttm != null;
	}
	public ims.framework.utils.Time getStartTm()
	{
		return this.starttm;
	}
	public void setStartTm(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.starttm = value;
	}
	public boolean getDurationIsNotNull()
	{
		return this.duration != null;
	}
	public Integer getDuration()
	{
		return this.duration;
	}
	public void setDuration(Integer value)
	{
		this.isValidated = false;
		this.duration = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.scheduling.vo.lookups.Status_Reason getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.scheduling.vo.lookups.Status_Reason value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getAppointmentIsNotNull()
	{
		return this.appointment != null;
	}
	public ims.scheduling.vo.BookingAppointmentForSessionManagementVo getAppointment()
	{
		return this.appointment;
	}
	public void setAppointment(ims.scheduling.vo.BookingAppointmentForSessionManagementVo value)
	{
		this.isValidated = false;
		this.appointment = value;
	}
	public boolean getSlotRespIsNotNull()
	{
		return this.slotresp != null;
	}
	public ims.scheduling.vo.SessionListOwnerLiteVo getSlotResp()
	{
		return this.slotresp;
	}
	public void setSlotResp(ims.scheduling.vo.SessionListOwnerLiteVo value)
	{
		this.isValidated = false;
		this.slotresp = value;
	}
	public boolean getDirectoryOfServicesIsNotNull()
	{
		return this.directoryofservices != null;
	}
	public ims.scheduling.vo.DirectoryOfServiceSessionSlotVoCollection getDirectoryOfServices()
	{
		return this.directoryofservices;
	}
	public void setDirectoryOfServices(ims.scheduling.vo.DirectoryOfServiceSessionSlotVoCollection value)
	{
		this.isValidated = false;
		this.directoryofservices = value;
	}
	public boolean getPriorityIsNotNull()
	{
		return this.priority != null;
	}
	public ims.scheduling.vo.lookups.SchedulingPriority getPriority()
	{
		return this.priority;
	}
	public void setPriority(ims.scheduling.vo.lookups.SchedulingPriority value)
	{
		this.isValidated = false;
		this.priority = value;
	}
	public boolean getCatsReferralIsNotNull()
	{
		return this.catsreferral != null;
	}
	public ims.careuk.vo.CatsReferralForSessionManagementVo getCatsReferral()
	{
		return this.catsreferral;
	}
	public void setCatsReferral(ims.careuk.vo.CatsReferralForSessionManagementVo value)
	{
		this.isValidated = false;
		this.catsreferral = value;
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
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
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
	
		SessionSlotForSessionManagementVo clone = new SessionSlotForSessionManagementVo(this.id, this.version);
		
		if(this.activity == null)
			clone.activity = null;
		else
			clone.activity = (ims.core.vo.ActivityLiteVo)this.activity.clone();
		if(this.starttm == null)
			clone.starttm = null;
		else
			clone.starttm = (ims.framework.utils.Time)this.starttm.clone();
		clone.duration = this.duration;
		clone.isactive = this.isactive;
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.scheduling.vo.lookups.Status_Reason)this.status.clone();
		if(this.appointment == null)
			clone.appointment = null;
		else
			clone.appointment = (ims.scheduling.vo.BookingAppointmentForSessionManagementVo)this.appointment.clone();
		if(this.slotresp == null)
			clone.slotresp = null;
		else
			clone.slotresp = (ims.scheduling.vo.SessionListOwnerLiteVo)this.slotresp.clone();
		if(this.directoryofservices == null)
			clone.directoryofservices = null;
		else
			clone.directoryofservices = (ims.scheduling.vo.DirectoryOfServiceSessionSlotVoCollection)this.directoryofservices.clone();
		if(this.priority == null)
			clone.priority = null;
		else
			clone.priority = (ims.scheduling.vo.lookups.SchedulingPriority)this.priority.clone();
		if(this.catsreferral == null)
			clone.catsreferral = null;
		else
			clone.catsreferral = (ims.careuk.vo.CatsReferralForSessionManagementVo)this.catsreferral.clone();
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
		if (!(SessionSlotForSessionManagementVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SessionSlotForSessionManagementVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SessionSlotForSessionManagementVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SessionSlotForSessionManagementVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.activity != null)
			count++;
		if(this.starttm != null)
			count++;
		if(this.duration != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.status != null)
			count++;
		if(this.appointment != null)
			count++;
		if(this.slotresp != null)
			count++;
		if(this.directoryofservices != null)
			count++;
		if(this.priority != null)
			count++;
		if(this.catsreferral != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected ims.core.vo.ActivityLiteVo activity;
	protected ims.framework.utils.Time starttm;
	protected Integer duration;
	protected Boolean isactive;
	protected ims.scheduling.vo.lookups.Status_Reason status;
	protected ims.scheduling.vo.BookingAppointmentForSessionManagementVo appointment;
	protected ims.scheduling.vo.SessionListOwnerLiteVo slotresp;
	protected ims.scheduling.vo.DirectoryOfServiceSessionSlotVoCollection directoryofservices;
	protected ims.scheduling.vo.lookups.SchedulingPriority priority;
	protected ims.careuk.vo.CatsReferralForSessionManagementVo catsreferral;
	private boolean isValidated = false;
	private boolean isBusy = false;
}