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

package ims.emergency.vo.beans;

public class TrackingVoBean extends ims.vo.ValueObjectBean
{
	public TrackingVoBean()
	{
	}
	public TrackingVoBean(ims.emergency.vo.TrackingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.emergency.vo.beans.PatientForTrackingVoBean)vo.getPatient().getBean();
		this.currentarea = vo.getCurrentArea() == null ? null : (ims.emergency.vo.beans.TrackingAreaForTrackingLiteVoBean)vo.getCurrentArea().getBean();
		this.episode = vo.getEpisode() == null ? null : (ims.emergency.vo.beans.EmergencyEpisodeForTrackingVoBean)vo.getEpisode().getBean();
		this.attendance = vo.getAttendance() == null ? null : (ims.emergency.vo.beans.EmergencyAttendanceForTrackingVoBean)vo.getAttendance().getBean();
		this.currentreferral = vo.getCurrentReferral() == null ? null : (ims.emergency.vo.beans.ReferToSpecTeamForTrackingVoBean)vo.getCurrentReferral().getBean();
		this.triagedetails = vo.getTriageDetails() == null ? null : (ims.emergency.vo.beans.TriageForTrackingVoBean)vo.getTriageDetails().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.emergency.vo.beans.TrackingAttendanceStatusForTrackingVoBean)vo.getCurrentStatus().getBean();
		this.edlocation = vo.getEDLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getEDLocation().getBean();
		this.currentcubicle = vo.getCurrentCubicle() == null ? null : (ims.emergency.vo.beans.CubicleAllocationForTrackingVoBean)vo.getCurrentCubicle().getBean();
		this.lastmovementdatetime = vo.getLastMovementDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getLastMovementDateTime().getBean();
		this.bedavailability = vo.getBedAvailability() == null ? null : (ims.emergency.vo.beans.BedAvailabilityForTrackingVoBean)vo.getBedAvailability().getBean();
		this.currentdnw = vo.getCurrentDNW() == null ? null : (ims.emergency.vo.beans.DNWForTrackingVoBean)vo.getCurrentDNW().getBean();
		this.lastmovementdateinminutes = vo.getLastMovementDateInMinutes();
		this.isdischarged = vo.getIsDischarged();
		this.seenby = vo.getSeenBy() == null ? null : (ims.emergency.vo.beans.SeenByHCPVoBean)vo.getSeenBy().getBean();
		this.primarydiagnosis = vo.getPrimaryDiagnosis() == null ? null : (ims.emergency.vo.beans.PatientDiagnosisForTrackingVoBean)vo.getPrimaryDiagnosis().getBean();
		this.currenttransferrecord = vo.getCurrentTransferRecord() == null ? null : (ims.emergency.vo.beans.EDTransferVoBean)vo.getCurrentTransferRecord().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.TrackingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.emergency.vo.beans.PatientForTrackingVoBean)vo.getPatient().getBean(map);
		this.currentarea = vo.getCurrentArea() == null ? null : (ims.emergency.vo.beans.TrackingAreaForTrackingLiteVoBean)vo.getCurrentArea().getBean(map);
		this.episode = vo.getEpisode() == null ? null : (ims.emergency.vo.beans.EmergencyEpisodeForTrackingVoBean)vo.getEpisode().getBean(map);
		this.attendance = vo.getAttendance() == null ? null : (ims.emergency.vo.beans.EmergencyAttendanceForTrackingVoBean)vo.getAttendance().getBean(map);
		this.currentreferral = vo.getCurrentReferral() == null ? null : (ims.emergency.vo.beans.ReferToSpecTeamForTrackingVoBean)vo.getCurrentReferral().getBean(map);
		this.triagedetails = vo.getTriageDetails() == null ? null : (ims.emergency.vo.beans.TriageForTrackingVoBean)vo.getTriageDetails().getBean(map);
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.emergency.vo.beans.TrackingAttendanceStatusForTrackingVoBean)vo.getCurrentStatus().getBean(map);
		this.edlocation = vo.getEDLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getEDLocation().getBean(map);
		this.currentcubicle = vo.getCurrentCubicle() == null ? null : (ims.emergency.vo.beans.CubicleAllocationForTrackingVoBean)vo.getCurrentCubicle().getBean(map);
		this.lastmovementdatetime = vo.getLastMovementDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getLastMovementDateTime().getBean();
		this.bedavailability = vo.getBedAvailability() == null ? null : (ims.emergency.vo.beans.BedAvailabilityForTrackingVoBean)vo.getBedAvailability().getBean(map);
		this.currentdnw = vo.getCurrentDNW() == null ? null : (ims.emergency.vo.beans.DNWForTrackingVoBean)vo.getCurrentDNW().getBean(map);
		this.lastmovementdateinminutes = vo.getLastMovementDateInMinutes();
		this.isdischarged = vo.getIsDischarged();
		this.seenby = vo.getSeenBy() == null ? null : (ims.emergency.vo.beans.SeenByHCPVoBean)vo.getSeenBy().getBean(map);
		this.primarydiagnosis = vo.getPrimaryDiagnosis() == null ? null : (ims.emergency.vo.beans.PatientDiagnosisForTrackingVoBean)vo.getPrimaryDiagnosis().getBean(map);
		this.currenttransferrecord = vo.getCurrentTransferRecord() == null ? null : (ims.emergency.vo.beans.EDTransferVoBean)vo.getCurrentTransferRecord().getBean(map);
	}

	public ims.emergency.vo.TrackingVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.TrackingVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.TrackingVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.TrackingVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.TrackingVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.emergency.vo.beans.PatientForTrackingVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.emergency.vo.beans.PatientForTrackingVoBean value)
	{
		this.patient = value;
	}
	public ims.emergency.vo.beans.TrackingAreaForTrackingLiteVoBean getCurrentArea()
	{
		return this.currentarea;
	}
	public void setCurrentArea(ims.emergency.vo.beans.TrackingAreaForTrackingLiteVoBean value)
	{
		this.currentarea = value;
	}
	public ims.emergency.vo.beans.EmergencyEpisodeForTrackingVoBean getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.emergency.vo.beans.EmergencyEpisodeForTrackingVoBean value)
	{
		this.episode = value;
	}
	public ims.emergency.vo.beans.EmergencyAttendanceForTrackingVoBean getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.emergency.vo.beans.EmergencyAttendanceForTrackingVoBean value)
	{
		this.attendance = value;
	}
	public ims.emergency.vo.beans.ReferToSpecTeamForTrackingVoBean getCurrentReferral()
	{
		return this.currentreferral;
	}
	public void setCurrentReferral(ims.emergency.vo.beans.ReferToSpecTeamForTrackingVoBean value)
	{
		this.currentreferral = value;
	}
	public ims.emergency.vo.beans.TriageForTrackingVoBean getTriageDetails()
	{
		return this.triagedetails;
	}
	public void setTriageDetails(ims.emergency.vo.beans.TriageForTrackingVoBean value)
	{
		this.triagedetails = value;
	}
	public ims.emergency.vo.beans.TrackingAttendanceStatusForTrackingVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.emergency.vo.beans.TrackingAttendanceStatusForTrackingVoBean value)
	{
		this.currentstatus = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getEDLocation()
	{
		return this.edlocation;
	}
	public void setEDLocation(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.edlocation = value;
	}
	public ims.emergency.vo.beans.CubicleAllocationForTrackingVoBean getCurrentCubicle()
	{
		return this.currentcubicle;
	}
	public void setCurrentCubicle(ims.emergency.vo.beans.CubicleAllocationForTrackingVoBean value)
	{
		this.currentcubicle = value;
	}
	public ims.framework.utils.beans.DateTimeBean getLastMovementDateTime()
	{
		return this.lastmovementdatetime;
	}
	public void setLastMovementDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.lastmovementdatetime = value;
	}
	public ims.emergency.vo.beans.BedAvailabilityForTrackingVoBean getBedAvailability()
	{
		return this.bedavailability;
	}
	public void setBedAvailability(ims.emergency.vo.beans.BedAvailabilityForTrackingVoBean value)
	{
		this.bedavailability = value;
	}
	public ims.emergency.vo.beans.DNWForTrackingVoBean getCurrentDNW()
	{
		return this.currentdnw;
	}
	public void setCurrentDNW(ims.emergency.vo.beans.DNWForTrackingVoBean value)
	{
		this.currentdnw = value;
	}
	public Integer getLastMovementDateInMinutes()
	{
		return this.lastmovementdateinminutes;
	}
	public void setLastMovementDateInMinutes(Integer value)
	{
		this.lastmovementdateinminutes = value;
	}
	public Boolean getIsDischarged()
	{
		return this.isdischarged;
	}
	public void setIsDischarged(Boolean value)
	{
		this.isdischarged = value;
	}
	public ims.emergency.vo.beans.SeenByHCPVoBean getSeenBy()
	{
		return this.seenby;
	}
	public void setSeenBy(ims.emergency.vo.beans.SeenByHCPVoBean value)
	{
		this.seenby = value;
	}
	public ims.emergency.vo.beans.PatientDiagnosisForTrackingVoBean getPrimaryDiagnosis()
	{
		return this.primarydiagnosis;
	}
	public void setPrimaryDiagnosis(ims.emergency.vo.beans.PatientDiagnosisForTrackingVoBean value)
	{
		this.primarydiagnosis = value;
	}
	public ims.emergency.vo.beans.EDTransferVoBean getCurrentTransferRecord()
	{
		return this.currenttransferrecord;
	}
	public void setCurrentTransferRecord(ims.emergency.vo.beans.EDTransferVoBean value)
	{
		this.currenttransferrecord = value;
	}

	private Integer id;
	private int version;
	private ims.emergency.vo.beans.PatientForTrackingVoBean patient;
	private ims.emergency.vo.beans.TrackingAreaForTrackingLiteVoBean currentarea;
	private ims.emergency.vo.beans.EmergencyEpisodeForTrackingVoBean episode;
	private ims.emergency.vo.beans.EmergencyAttendanceForTrackingVoBean attendance;
	private ims.emergency.vo.beans.ReferToSpecTeamForTrackingVoBean currentreferral;
	private ims.emergency.vo.beans.TriageForTrackingVoBean triagedetails;
	private ims.emergency.vo.beans.TrackingAttendanceStatusForTrackingVoBean currentstatus;
	private ims.core.vo.beans.LocationLiteVoBean edlocation;
	private ims.emergency.vo.beans.CubicleAllocationForTrackingVoBean currentcubicle;
	private ims.framework.utils.beans.DateTimeBean lastmovementdatetime;
	private ims.emergency.vo.beans.BedAvailabilityForTrackingVoBean bedavailability;
	private ims.emergency.vo.beans.DNWForTrackingVoBean currentdnw;
	private Integer lastmovementdateinminutes;
	private Boolean isdischarged;
	private ims.emergency.vo.beans.SeenByHCPVoBean seenby;
	private ims.emergency.vo.beans.PatientDiagnosisForTrackingVoBean primarydiagnosis;
	private ims.emergency.vo.beans.EDTransferVoBean currenttransferrecord;
}