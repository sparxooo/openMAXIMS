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

package ims.RefMan.vo.beans;

public class CatsReferralClinicListListVoBean extends ims.vo.ValueObjectBean
{
	public CatsReferralClinicListListVoBean()
	{
	}
	public CatsReferralClinicListListVoBean(ims.RefMan.vo.CatsReferralClinicListListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hasinvestigations = vo.getHasInvestigations();
		this.hasappointments = vo.getHasAppointments();
		this.hasreferralletter = vo.getHasReferralLetter();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.RefMan.vo.beans.CatsReferralStatusLiteVoBean)vo.getCurrentStatus().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.iscab = vo.getIsCAB();
		this.hasconsultationdetails = vo.getHasConsultationDetails();
		this.lastapptarriveddate = vo.getLastApptArrivedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getLastApptArrivedDate().getBean();
		this.onwardreferralstatus = vo.getOnwardReferralStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getOnwardReferralStatus().getBean();
		this.referraldetails = vo.getReferralDetails() == null ? null : (ims.RefMan.vo.beans.ReferralLetterDetailsClinicListListVoBean)vo.getReferralDetails().getBean();
		this.providercancellation = vo.getProviderCancellation() == null ? null : new ims.vo.RefVoBean(vo.getProviderCancellation().getBoId(), vo.getProviderCancellation().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.CatsReferralClinicListListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hasinvestigations = vo.getHasInvestigations();
		this.hasappointments = vo.getHasAppointments();
		this.hasreferralletter = vo.getHasReferralLetter();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.RefMan.vo.beans.CatsReferralStatusLiteVoBean)vo.getCurrentStatus().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.iscab = vo.getIsCAB();
		this.hasconsultationdetails = vo.getHasConsultationDetails();
		this.lastapptarriveddate = vo.getLastApptArrivedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getLastApptArrivedDate().getBean();
		this.onwardreferralstatus = vo.getOnwardReferralStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getOnwardReferralStatus().getBean();
		this.referraldetails = vo.getReferralDetails() == null ? null : (ims.RefMan.vo.beans.ReferralLetterDetailsClinicListListVoBean)vo.getReferralDetails().getBean(map);
		this.providercancellation = vo.getProviderCancellation() == null ? null : new ims.vo.RefVoBean(vo.getProviderCancellation().getBoId(), vo.getProviderCancellation().getBoVersion());
	}

	public ims.RefMan.vo.CatsReferralClinicListListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.CatsReferralClinicListListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.CatsReferralClinicListListVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.CatsReferralClinicListListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.CatsReferralClinicListListVo();
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
	public Boolean getHasInvestigations()
	{
		return this.hasinvestigations;
	}
	public void setHasInvestigations(Boolean value)
	{
		this.hasinvestigations = value;
	}
	public Boolean getHasAppointments()
	{
		return this.hasappointments;
	}
	public void setHasAppointments(Boolean value)
	{
		this.hasappointments = value;
	}
	public Boolean getHasReferralLetter()
	{
		return this.hasreferralletter;
	}
	public void setHasReferralLetter(Boolean value)
	{
		this.hasreferralletter = value;
	}
	public ims.RefMan.vo.beans.CatsReferralStatusLiteVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.RefMan.vo.beans.CatsReferralStatusLiteVoBean value)
	{
		this.currentstatus = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public Boolean getIsCAB()
	{
		return this.iscab;
	}
	public void setIsCAB(Boolean value)
	{
		this.iscab = value;
	}
	public Boolean getHasConsultationDetails()
	{
		return this.hasconsultationdetails;
	}
	public void setHasConsultationDetails(Boolean value)
	{
		this.hasconsultationdetails = value;
	}
	public ims.framework.utils.beans.DateBean getLastApptArrivedDate()
	{
		return this.lastapptarriveddate;
	}
	public void setLastApptArrivedDate(ims.framework.utils.beans.DateBean value)
	{
		this.lastapptarriveddate = value;
	}
	public ims.vo.LookupInstanceBean getOnwardReferralStatus()
	{
		return this.onwardreferralstatus;
	}
	public void setOnwardReferralStatus(ims.vo.LookupInstanceBean value)
	{
		this.onwardreferralstatus = value;
	}
	public ims.RefMan.vo.beans.ReferralLetterDetailsClinicListListVoBean getReferralDetails()
	{
		return this.referraldetails;
	}
	public void setReferralDetails(ims.RefMan.vo.beans.ReferralLetterDetailsClinicListListVoBean value)
	{
		this.referraldetails = value;
	}
	public ims.vo.RefVoBean getProviderCancellation()
	{
		return this.providercancellation;
	}
	public void setProviderCancellation(ims.vo.RefVoBean value)
	{
		this.providercancellation = value;
	}

	private Integer id;
	private int version;
	private Boolean hasinvestigations;
	private Boolean hasappointments;
	private Boolean hasreferralletter;
	private ims.RefMan.vo.beans.CatsReferralStatusLiteVoBean currentstatus;
	private ims.vo.RefVoBean carecontext;
	private Boolean iscab;
	private Boolean hasconsultationdetails;
	private ims.framework.utils.beans.DateBean lastapptarriveddate;
	private ims.vo.LookupInstanceBean onwardreferralstatus;
	private ims.RefMan.vo.beans.ReferralLetterDetailsClinicListListVoBean referraldetails;
	private ims.vo.RefVoBean providercancellation;
}
