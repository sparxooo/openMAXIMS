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

package ims.emergency.vo.beans;

public class EmergencyAttendanceForPartialAdmissionVoBean extends ims.vo.ValueObjectBean
{
	public EmergencyAttendanceForPartialAdmissionVoBean()
	{
	}
	public EmergencyAttendanceForPartialAdmissionVoBean(ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.bedtyperequested = vo.getBedTypeRequested() == null ? null : (ims.vo.LookupInstanceBean)vo.getBedTypeRequested().getBean();
		this.patientattendancestatus = vo.getPatientAttendanceStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientAttendanceStatus().getBean();
		this.conclusiondatetime = vo.getConclusionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getConclusionDateTime().getBean();
		this.accomodationrequestedtype = vo.getAccomodationRequestedType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAccomodationRequestedType().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.bedtyperequested = vo.getBedTypeRequested() == null ? null : (ims.vo.LookupInstanceBean)vo.getBedTypeRequested().getBean();
		this.patientattendancestatus = vo.getPatientAttendanceStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientAttendanceStatus().getBean();
		this.conclusiondatetime = vo.getConclusionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getConclusionDateTime().getBean();
		this.accomodationrequestedtype = vo.getAccomodationRequestedType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAccomodationRequestedType().getBean();
	}

	public ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo();
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
	public ims.vo.LookupInstanceBean getBedTypeRequested()
	{
		return this.bedtyperequested;
	}
	public void setBedTypeRequested(ims.vo.LookupInstanceBean value)
	{
		this.bedtyperequested = value;
	}
	public ims.vo.LookupInstanceBean getPatientAttendanceStatus()
	{
		return this.patientattendancestatus;
	}
	public void setPatientAttendanceStatus(ims.vo.LookupInstanceBean value)
	{
		this.patientattendancestatus = value;
	}
	public ims.framework.utils.beans.DateTimeBean getConclusionDateTime()
	{
		return this.conclusiondatetime;
	}
	public void setConclusionDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.conclusiondatetime = value;
	}
	public ims.vo.LookupInstanceBean getAccomodationRequestedType()
	{
		return this.accomodationrequestedtype;
	}
	public void setAccomodationRequestedType(ims.vo.LookupInstanceBean value)
	{
		this.accomodationrequestedtype = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean bedtyperequested;
	private ims.vo.LookupInstanceBean patientattendancestatus;
	private ims.framework.utils.beans.DateTimeBean conclusiondatetime;
	private ims.vo.LookupInstanceBean accomodationrequestedtype;
}
