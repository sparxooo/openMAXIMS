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

package ims.core.vo.beans;

public class PDSPatientGPVoBean extends ims.vo.ValueObjectBean
{
	public PDSPatientGPVoBean()
	{
	}
	public PDSPatientGPVoBean(ims.core.vo.PDSPatientGPVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.lkp_provisiontype = vo.getLkp_provisiontype() == null ? null : (ims.vo.LookupInstanceBean)vo.getLkp_provisiontype().getBean();
		this.primarycareidentifier = vo.getPrimaryCareIdentifier();
		this.objectidentifier = vo.getObjectidentifier();
		this.beffdate = vo.getBeffdate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getBeffdate().getBean();
		this.beffdatecnf = vo.getBeffdatecnf();
		this.betdate = vo.getBetdate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getBetdate().getBean();
		this.betdatecnf = vo.getBetdatecnf();
		this.gp = vo.getGp() == null ? null : new ims.vo.RefVoBean(vo.getGp().getBoId(), vo.getGp().getBoVersion());
		this.practice = vo.getPractice() == null ? null : new ims.vo.RefVoBean(vo.getPractice().getBoId(), vo.getPractice().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PDSPatientGPVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.lkp_provisiontype = vo.getLkp_provisiontype() == null ? null : (ims.vo.LookupInstanceBean)vo.getLkp_provisiontype().getBean();
		this.primarycareidentifier = vo.getPrimaryCareIdentifier();
		this.objectidentifier = vo.getObjectidentifier();
		this.beffdate = vo.getBeffdate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getBeffdate().getBean();
		this.beffdatecnf = vo.getBeffdatecnf();
		this.betdate = vo.getBetdate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getBetdate().getBean();
		this.betdatecnf = vo.getBetdatecnf();
		this.gp = vo.getGp() == null ? null : new ims.vo.RefVoBean(vo.getGp().getBoId(), vo.getGp().getBoVersion());
		this.practice = vo.getPractice() == null ? null : new ims.vo.RefVoBean(vo.getPractice().getBoId(), vo.getPractice().getBoVersion());
	}

	public ims.core.vo.PDSPatientGPVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PDSPatientGPVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PDSPatientGPVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PDSPatientGPVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PDSPatientGPVo();
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
	public ims.vo.LookupInstanceBean getLkp_provisiontype()
	{
		return this.lkp_provisiontype;
	}
	public void setLkp_provisiontype(ims.vo.LookupInstanceBean value)
	{
		this.lkp_provisiontype = value;
	}
	public String getPrimaryCareIdentifier()
	{
		return this.primarycareidentifier;
	}
	public void setPrimaryCareIdentifier(String value)
	{
		this.primarycareidentifier = value;
	}
	public String getObjectidentifier()
	{
		return this.objectidentifier;
	}
	public void setObjectidentifier(String value)
	{
		this.objectidentifier = value;
	}
	public ims.framework.utils.beans.DateBean getBeffdate()
	{
		return this.beffdate;
	}
	public void setBeffdate(ims.framework.utils.beans.DateBean value)
	{
		this.beffdate = value;
	}
	public Boolean getBeffdatecnf()
	{
		return this.beffdatecnf;
	}
	public void setBeffdatecnf(Boolean value)
	{
		this.beffdatecnf = value;
	}
	public ims.framework.utils.beans.DateBean getBetdate()
	{
		return this.betdate;
	}
	public void setBetdate(ims.framework.utils.beans.DateBean value)
	{
		this.betdate = value;
	}
	public Boolean getBetdatecnf()
	{
		return this.betdatecnf;
	}
	public void setBetdatecnf(Boolean value)
	{
		this.betdatecnf = value;
	}
	public ims.vo.RefVoBean getGp()
	{
		return this.gp;
	}
	public void setGp(ims.vo.RefVoBean value)
	{
		this.gp = value;
	}
	public ims.vo.RefVoBean getPractice()
	{
		return this.practice;
	}
	public void setPractice(ims.vo.RefVoBean value)
	{
		this.practice = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean lkp_provisiontype;
	private String primarycareidentifier;
	private String objectidentifier;
	private ims.framework.utils.beans.DateBean beffdate;
	private Boolean beffdatecnf;
	private ims.framework.utils.beans.DateBean betdate;
	private Boolean betdatecnf;
	private ims.vo.RefVoBean gp;
	private ims.vo.RefVoBean practice;
}